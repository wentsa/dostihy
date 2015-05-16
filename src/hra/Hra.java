/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hra;

import audio.SoundHandler;
import grafika.GraphicsHandler;
import grafika.RozmeryPlochy;
import gui.Kostka;
import gui.plocha.HerniPlochaController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import karty.Karta;
import karty.finance.Finance;
import karty.finance.FinanceDarek;
import karty.finance.FinanceKlasika;
import karty.finance.FinanceRenovace;
import karty.nahoda.Nahoda;
import karty.nahoda.NahodaDistanc;
import karty.nahoda.NahodaPopojdi;
import karty.nahoda.NahodaZdrzeni;
import karty.vlastnicke.Kun;
import karty.vlastnicke.PrepravaStaje;
import karty.vlastnicke.Trener;
import karty.vlastnicke.VlastnickaKarta;
import kolekce.KolekceKaret;
import kolekce.KolekceKaretImplementace;
import pomocne.Barva;
import pomocne.DataHraci;
import pomocne.Konstanty;
import pomocne.LoudCall;
import pomocne.Staj;

/**
 *
 * @author wentsa
 */
public class Hra implements Serializable {

    private static final long serialVersionUID = 1L;

    private Kostka kostka;
    private final List<Hrac> hraci;
    private final List<Policko> policka;
    private KolekceKaret<Nahoda> nahodaNove, nahodaStare;
    private KolekceKaret<Finance> financeNove, financeStare;
    private Hrac aktualniHrac; // 0...pocet-1
    private int pocetHracu;
    private transient JTextPane statusBox;
    private List<Hrac> vyherci;
    private long cas;
    private int pocetTahu = 0, aktivnichHracu;
    private final LoudCall<Void, String> caller;
    private boolean predHazenim;
    private boolean ulozilPoHazeni;

    private static Hra instance = null;
    private static final ResourceBundle bundle = ResourceBundle.getBundle("languages/game/Game", Konstanty.DEFAULT_LOCALE);
    private static final ResourceBundle bundleColors = ResourceBundle.getBundle("languages/complementary/Complementary", Konstanty.DEFAULT_LOCALE);

    public static Hra getInstance() {
        if (instance == null) {
            instance = new Hra();
        }
        return instance;
    }

    public static void smazInstance() {
        instance = null;
    }

    public static void changeInstance(Hra other) {
        instance = other;
    }

    private Hra() {
        Konstanty.DEFAULT_LOCALE = new Locale("cs", "CZ");
        this.policka = new ArrayList<>(40);
        this.financeNove = new KolekceKaretImplementace<>(14);
        this.financeStare = new KolekceKaretImplementace<>(14);
        this.nahodaNove = new KolekceKaretImplementace<>(14);
        this.nahodaStare = new KolekceKaretImplementace<>(14);
        this.hraci = new ArrayList<>(7);
        this.kostka = new Kostka();
        this.aktualniHrac = null;
        this.vyherci = new ArrayList<>(7);
        System.out.println("Statusbox");
        nastavStatusBox();
        System.out.println("Herní příběh");
        this.caller = new LoudCall<Void, String>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Void call() throws Exception {
                while (true) {
                    shoutOut(Konstanty.Shout.DISABLE_BUTTON);
                    HerniPlochaController.getInstance().setUkoncenTah(false);
                    if (zacatekTahu()) {
                        vyradHrace();
                        break;
                    }
                    shoutOut(Konstanty.Shout.SLIDER_ACTUALIZATION);
                    if (!zvolHrace()) {
                        continue;
                    }
                    status(bundle.getString("PLAYING_PLAYER") + " " + aktualniHrac.getJmeno());
                    if (aktualniHrac.isDistanc() && aktualniHrac.isNahodaDistanc()) {
                        Object[] volby = {bundle.getString("YES"), bundle.getString("NO")};
                        int odpoved = JOptionPane.showOptionDialog(null, (bundle.getString("USE_DISTANC_CARD")), bundle.getString("DISTANC_CARD_TITLE"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, volby, volby[0]);
                        if (odpoved == JOptionPane.YES_OPTION) {
                            aktualniHrac.setDistanc(false);
                            aktualniHrac.setNahodaDistanc(false);
                        }
                    }
                    nastavMoznostSazeni();
                    predHazenim = true;
                    int kolik = kostka.hazej();
                    predHazenim = false;
                    zrusSazeni();
                    if (kolik == -1) {
                        vyradHrace();
                        continue;
                    }
                    int x = vyhodnotHod(kolik);
                    if (x == 1) {
                        vyhodnotSazky(aktualniHrac.getFigurka().getPozice());
                        shoutOut(Konstanty.Shout.ENABLE_BUTTON);
                        while (!HerniPlochaController.getInstance().isUkoncenTah()) {
                            if (!aktualniHrac.isAktivni()) {
                                break;
                            }
                            Thread.sleep(100);
                        }
                        shoutOut(Konstanty.Shout.DISABLE_BUTTON);
                        if (!aktualniHrac.isAktivni()) {
                            vyradHrace();
                            continue;
                        }
                        dalsiHrac();
                        continue;
                    }
                    if (x == 0) {
                        kolik -= 6;
                    }
                    aktualniHrac.popojdi(kolik);
                    int aktualniPozice = aktualniHrac.getFigurka().getPozice();
                    vyhodnotPozici(aktualniPozice, kolik);
                    Policko p = policka.get(aktualniPozice);
                    vyhodnotPolicko(p, kolik);
                    shoutOut(Konstanty.Shout.ENABLE_BUTTON);
                    while (!HerniPlochaController.getInstance().isUkoncenTah()) {
                        if (!aktualniHrac.isAktivni()) {
                            break;
                        }
                        Thread.sleep(100);
                    }
                    shoutOut(Konstanty.Shout.DISABLE_BUTTON);
                    if (!aktualniHrac.isAktivni()) {
                        vyradHrace();
                        continue;
                    }
                    dalsiHrac();
                }

                return null;
            }

        };
        System.out.println(
                "Políčka");
        inicializovatPolicka();

        System.out.println(
                "Karty");
        inicializovatNahodu();

        inicializovatFinance();

    }

    public final void nastavStatusBox() {
        this.statusBox = new JTextPane() {
            private static final long serialVersionUID = 1L;

            @Override
            public void paintComponent(Graphics g) {
                BufferedImage statusP = HerniPlochaController.getInstance().getStatusP();
                g.drawImage(statusP, 0, 0, statusP.getWidth(null), statusP.getHeight(null), null);
                super.paintComponent(g);
            }
        };
        statusBox.setEditable(false);
        statusBox.setBackground(new Color(0, 0, 0, 0));
        statusBox.setForeground(GraphicsHandler.getBarvaFontu());
        statusBox.setOpaque(false);
    }

    // <editor-fold defaultstate="collapsed" desc="POLICKA">
    private void inicializovatPolicka() {
        getPolicka().add(new Policko(1, bundle.getString("START")));
        getPolicka().add(new Policko(2, "Fantome", new Kun(2, "Fantome", 1200, Staj.ORANZOVA, 40, 200, 600, 1800, 3200, 5000, 1000, 1000)));
        getPolicka().add(new Policko(3, bundle.getString("FINANCES")));
        getPolicka().add(new Policko(4, "Gavora", new Kun(4, "Gavora", 1200, Staj.ORANZOVA, 40, 200, 600, 1800, 3200, 5000, 1000, 1000)));
        getPolicka().add(new Policko(5, bundle.getString("VETERINARY_INSPECTION")));
        getPolicka().add(new Policko(6, bundle.getString("TRAINER"), new Trener(6, 1)));
        getPolicka().add(new Policko(7, "Lady Anne", new Kun(7, "Lady Anne", 2000, Staj.HNEDA, 120, 600, 1800, 5400, 8000, 11000, 1000, 1000)));
        getPolicka().add(new Policko(8, bundle.getString("LUCK")));
        getPolicka().add(new Policko(9, "Pasek", new Kun(9, "Pasek", 2000, Staj.HNEDA, 120, 600, 1800, 5400, 8000, 11000, 1000, 1000)));
        getPolicka().add(new Policko(10, "Koran", new Kun(10, "Koran", 2400, Staj.HNEDA, 160, 800, 2000, 6000, 9000, 12000, 1000, 1000)));
        getPolicka().add(new Policko(11, bundle.getString("DISTANC")));
        getPolicka().add(new Policko(12, "Neklan", new Kun(12, "Neklan", 2800, Staj.SV_MODRA, 200, 1000, 3000, 9000, 12500, 15000, 2000, 2000)));
        getPolicka().add(new Policko(13, bundle.getString("TRANSPORT"), new PrepravaStaje(13, 3000, bundle.getString("TRANSPORT"))));
        getPolicka().add(new Policko(14, "Portlancl", new Kun(14, "Portlancl", 2800, Staj.SV_MODRA, 200, 1000, 3000, 9000, 12500, 15000, 2000, 2000)));
        getPolicka().add(new Policko(15, "Japan", new Kun(15, "Japan", 2800, Staj.SV_MODRA, 240, 1200, 3600, 10000, 14000, 18000, 2000, 2000)));
        getPolicka().add(new Policko(16, bundle.getString("TRAINER"), new Trener(16, 2)));
        getPolicka().add(new Policko(17, "Kostrava", new Kun(17, "Kostrava", 3600, Staj.SV_ZELENA, 280, 1400, 4000, 11000, 15000, 19000, 2000, 2000)));
        getPolicka().add(new Policko(18, bundle.getString("FINANCES")));
        getPolicka().add(new Policko(19, "Lukava", new Kun(19, "Lukava", 3600, Staj.SV_ZELENA, 280, 1400, 4000, 11000, 15000, 19000, 2000, 2000)));
        getPolicka().add(new Policko(20, "Melák", new Kun(20, "Melák", 4000, Staj.SV_ZELENA, 320, 1600, 4400, 12000, 16000, 20000, 2000, 2000)));
        getPolicka().add(new Policko(21, bundle.getString("PARKING_LOT")));
        getPolicka().add(new Policko(22, "Grifel", new Kun(22, "Grifel", 4400, Staj.CERVENA, 360, 1800, 5000, 14000, 17000, 21000, 3000, 3000)));
        getPolicka().add(new Policko(23, bundle.getString("LUCK")));
        getPolicka().add(new Policko(24, "Mohyla", new Kun(24, "Mohyla", 4400, Staj.CERVENA, 360, 1800, 5000, 14000, 17000, 21000, 3000, 3000)));
        getPolicka().add(new Policko(25, "Metál", new Kun(25, "Metál", 4800, Staj.CERVENA, 400, 2000, 6000, 15000, 18000, 22000, 3000, 3000)));
        getPolicka().add(new Policko(26, bundle.getString("TRAINER"), new Trener(26, 3)));
        getPolicka().add(new Policko(27, "Tara", new Kun(27, "Tara", 5200, Staj.ZLUTA, 440, 2200, 6600, 16000, 19500, 23000, 3000, 3000)));
        getPolicka().add(new Policko(28, "Furioso", new Kun(28, "Furioso", 5200, Staj.ZLUTA, 440, 2200, 6600, 16000, 19500, 23000, 3000, 3000)));
        getPolicka().add(new Policko(29, bundle.getString("STABLES"), new PrepravaStaje(29, 3000, bundle.getString("STABLES"))));
        getPolicka().add(new Policko(30, "Genius", new Kun(30, "Genius", 5600, Staj.ZLUTA, 580, 2400, 7200, 17000, 20500, 24000, 3000, 3000)));
        getPolicka().add(new Policko(31, bundle.getString("DOPING_SUSPECTION")));
        getPolicka().add(new Policko(32, "Shagga", new Kun(32, "Shagga", 6000, Staj.ZELENA, 500, 2600, 7800, 18000, 22000, 25500, 4000, 4000)));
        getPolicka().add(new Policko(33, "Dahoman", new Kun(33, "Dahoman", 6000, Staj.ZELENA, 500, 2600, 7800, 18000, 22000, 25500, 4000, 4000)));
        getPolicka().add(new Policko(34, bundle.getString("FINANCES")));
        getPolicka().add(new Policko(35, "Gira", new Kun(35, "Gira", 6400, Staj.ZELENA, 560, 3000, 9000, 20000, 24000, 28000, 4000, 4000)));
        getPolicka().add(new Policko(36, bundle.getString("TRAINER"), new Trener(36, 4)));
        getPolicka().add(new Policko(37, bundle.getString("LUCK")));
        getPolicka().add(new Policko(38, "Narcius", new Kun(38, "Narcius", 7000, Staj.MODRA, 700, 3500, 10000, 22000, 26000, 30000, 4000, 4000)));
        getPolicka().add(new Policko(39, bundle.getString("VETERINARY_INSPECTION")));
        getPolicka().add(new Policko(40, "Napoli", new Kun(40, "Napoli", 8000, Staj.MODRA, 1000, 4000, 12000, 28000, 34000, 40000, 4000, 4000)));

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="NAHODA">
    @SuppressWarnings("unchecked")
    private void inicializovatNahodu() {
        getNahodaNove().vloz(new NahodaPopojdi(bundle.getString("3_FIELDS_BACKWARDS"), false, false, 3));
        getNahodaNove().vloz(new NahodaDistanc(bundle.getString("DISTANCE_CANCELLED")));
        getNahodaNove().vloz(new NahodaPopojdi(bundle.getString("FORWARD_TO_TRAINER"), true, true, bundle.getString("TRAINER")));
        getNahodaNove().vloz(new NahodaZdrzeni(bundle.getString("2_ROUNDS_DELAYED"), 2));
        getNahodaNove().vloz(new NahodaPopojdi(bundle.getString("DISTANCE_WITHOUT_CASH"), false, true, bundle.getString("DISTANC")));
        getNahodaNove().vloz(new NahodaPopojdi(bundle.getString("BACK_TO_FINANCES"), false, false, bundle.getString("FINANCES")));
        getNahodaNove().vloz(new NahodaPopojdi(bundle.getString("BACK_TO_NAPOLI"), true, false, "Napoli"));
        getNahodaNove().vloz(new NahodaPopojdi(bundle.getString("BACK_TO_DISTANCE_WITH_CASH"), true, false, bundle.getString("DISTANC")));
        getNahodaNove().vloz(new NahodaPopojdi(bundle.getString("BACK_TO_FINANCES"), false, false, bundle.getString("FINANCES")));
        getNahodaNove().vloz(new NahodaPopojdi(bundle.getString("BACK_TO_START_WITH_CASH"), true, false, bundle.getString("START")));
        getNahodaNove().vloz(new NahodaPopojdi(bundle.getString("BACK_TO_START_WITHOUT_CASH"), false, false, bundle.getString("START")));
        getNahodaNove().vloz(new NahodaZdrzeni(bundle.getString("2_ROUNDS_DELAYED"), 2));
        getNahodaNove().vloz(new NahodaZdrzeni(bundle.getString("1_ROUND_DELAYED"), 1));
        getNahodaNove().vloz(new NahodaPopojdi(bundle.getString("BACK_TO_PARKING_LOT_WITH_CASH"), true, false, bundle.getString("PARKING_LOT")));
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="FINANCE">
    @SuppressWarnings("unchecked")
    private void inicializovatFinance() {
        getFinanceNove().vloz(new FinanceKlasika(bundle.getString("PAY_1000"), 1000, true));
        getFinanceNove().vloz(new FinanceKlasika(bundle.getString("TICKET_400"), 400, true));
        getFinanceNove().vloz(new FinanceRenovace(bundle.getString("STABLES_RENOVATION_500"), 500));
        getFinanceNove().vloz(new FinanceKlasika(bundle.getString("2000_REWARD"), 2000, false));
        getFinanceNove().vloz(new FinanceDarek(bundle.getString("BIRTHDAY_GIFT"), 200));
        getFinanceNove().vloz(new FinanceKlasika(bundle.getString("500_PREMIUM_CASH"), 500, false));
        getFinanceNove().vloz(new FinanceKlasika(bundle.getString("4000_DOTATION"), 4000, false));
        getFinanceNove().vloz(new FinanceKlasika(bundle.getString("3000_DEBT"), 3000, true));
        getFinanceNove().vloz(new FinanceRenovace(bundle.getString("STABLES_RENOVATION_800"), 800));
        getFinanceNove().vloz(new FinanceKlasika(bundle.getString("PAY_2000"), 2000, true));
        getFinanceNove().vloz(new FinanceKlasika(bundle.getString("100_MATERIAL"), 100, true));
        getFinanceNove().vloz(new FinanceKlasika(bundle.getString("1000_LOTTERY"), 1000, false));
        getFinanceNove().vloz(new FinanceKlasika(bundle.getString("2000_DOTATION"), 2000, false));
        getFinanceNove().vloz(new FinanceKlasika(bundle.getString("3000_OVERPAY_FROM_BANK"), 3000, false));
    }
    // </editor-fold>

    public void zalozHrace(DataHraci data) {
        int i = 0;
        for (String jmeno : data.jmena) {
            hraci.add(new Hrac(jmeno, parseColor(data.barvy.get(i)), i + 1));
            i++;
        }
        aktivnichHracu = pocetHracu = hraci.size();
        aktualniHrac = hraci.get(0);
    }

    private Barva parseColor(String barva) {
        if (bundleColors.getString("BLACK").equals(barva)) {
            return Barva.BLACK;
        } else if (bundleColors.getString("BLUE").equals(barva)) {
            return Barva.BLUE;
        } else if (bundleColors.getString("CYAN").equals(barva)) {
            return Barva.CYAN;
        } else if (bundleColors.getString("GREEN").equals(barva)) {
            return Barva.GREEN;
        } else if (bundleColors.getString("PURPLE").equals(barva)) {
            return Barva.MAGENTA;
        } else if (bundleColors.getString("ORANGE").equals(barva)) {
            return Barva.ORANGE;
        } else if (bundleColors.getString("RED").equals(barva)) {
            return Barva.RED;
        } else if (bundleColors.getString("WHITE").equals(barva)) {
            return Barva.WHITE;
        } else if (bundleColors.getString("YELLOW").equals(barva)) {
            return Barva.YELLOW;
        } else {
            return null;
        }

    }

    /**
     * @return the hraci
     */
    public List<Hrac> getHraci() {
        return hraci;
    }

    /**
     * @return the policka
     */
    public List<Policko> getPolicka() {
        return policka;
    }

    /**
     * @return the nahodaNove
     */
    public KolekceKaret<Nahoda> getNahodaNove() {
        return nahodaNove;
    }

    /**
     * @param nahodaNove the nahodaNove to set
     */
    public void setNahodaNove(KolekceKaret<Nahoda> nahodaNove) {
        this.nahodaNove = nahodaNove;
    }

    /**
     * @return the nahodaStare
     */
    public KolekceKaret<Nahoda> getNahodaStare() {
        return nahodaStare;
    }

    /**
     * @param nahodaStare the nahodaStare to set
     */
    public void setNahodaStare(KolekceKaret<Nahoda> nahodaStare) {
        this.nahodaStare = nahodaStare;
    }

    /**
     * @return the financeNove
     */
    public KolekceKaret<Finance> getFinanceNove() {
        return financeNove;
    }

    /**
     * @param financeNove the financeNove to set
     */
    public void setFinanceNove(KolekceKaret<Finance> financeNove) {
        this.financeNove = financeNove;
    }

    /**
     * @return the financeStare
     */
    public KolekceKaret<Finance> getFinanceStare() {
        return financeStare;
    }

    /**
     * @param financeStare the financeStare to set
     */
    public void setFinanceStare(KolekceKaret<Finance> financeStare) {
        this.financeStare = financeStare;
    }

    /**
     * @return the kostka
     */
    public Kostka getKostka() {
        return kostka;
    }

    public void status(String message) {
        getCaller().shoutOut(Konstanty.Shout.MESSAGE_PREFIX + message);

    }

    /**
     * @return the statusBox
     */
    public JTextPane getStatusBox() {
        return statusBox;
    }

    public void popojdiNa(Hrac hrac, String pole, boolean dopredu) {
        int aktPozice = hrac.getFigurka().getPozice();
        for (int i = aktPozice;;) {
            if (policka.get(i).getNazev().equals(pole)) {
                if (dopredu) {
                    hrac.popojdi(i < aktPozice ? 40 - aktPozice + i : i - aktPozice);
                    break;
                } else {
                    hrac.popojdi(i < aktPozice ? i - aktPozice : -aktPozice + i - 40);
                    break;
                }
            }
            i = (dopredu ? ((i + 1) % 40) : (i > 0 ? i - 1 : 39));
            if (i == aktPozice) {
                break;
            }
        }
    }

    private boolean maCelouStaj(Hrac h, Staj s) {
        for (Policko p : policka) {
            if (p.isVlastnicka()) {
                if (p.getKarta() instanceof Kun) {
                    if (((Kun) p.getKarta()).getStaj() == s) {
                        if (!h.getKarty().contains(p.getKarta())) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * @param kostka the kostka to set
     */
    public void setKostka(Kostka kostka) {
        this.kostka = kostka;
    }

    /**
     * @return the aktualniHrac
     */
    public Hrac getAktualniHrac() {
        return aktualniHrac;
    }

    public void vyradHrace() {
        aktualniHrac.vyrad(pocetHracu - getVyherci().size());
        try {
            if (vyherci.contains(aktualniHrac)) {
                throw new ArrayStoreException("uz tam je " + aktualniHrac.getJmeno());
            }
        } catch (ArrayStoreException e) {
            System.out.println(e.getMessage());
        }
        getVyherci().add(aktualniHrac);
        for (Policko p : policka) {
            if (p.isVlastnicka() && p.isObsazeno() && p.getMajitel().equals(aktualniHrac)) {
                p.setObsazeno(false);
                p.setMajitel(null);
            }
        }
        aktivnichHracu--;
        status(java.text.MessageFormat.format(bundle.getString("PLAYER_WILL_NOT_BE_PLAYING_ANYMORE"), new Object[]{aktualniHrac.getJmeno()}));
        dalsiHrac();
    }

    public boolean jeAktualniHracAktivni() {
        return aktualniHrac.isAktivni();
    }

    public String getCelkovyCas() {
        long tmp = cas;
        tmp = System.currentTimeMillis() - tmp;
        tmp /= 1000;
        String res = ":" + (((tmp % 60) < 10) ? "0" : "") + tmp % 60;
        tmp /= 60;
        res = ":" + (((tmp % 60) < 10) ? "0" : "") + tmp % 60 + res;
        tmp /= 60;
        res = tmp + res;
        return res;
    }

    private boolean zacatekTahu() {
        if (pocetTahu++ == 0) {
            cas = System.currentTimeMillis();
        }
        return aktivnichHracu == 1;
    }

    private boolean zvolHrace() {
        if (!aktualniHrac.isAktivni()) {
            dalsiHrac();
            return false;
        }
        while (aktualniHrac.getRozpocet() < 0 && aktualniHrac.isAktivni()) {
            status(bundle.getString("YOU_HAVE_TO_SELL_STH"));
            try {
                Thread.sleep(500);

            } catch (InterruptedException ex) {
                Logger.getLogger(Hra.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!aktualniHrac.isAktivni()) {
            vyradHrace();
            return false;
        }

        if (aktualniHrac.getZdrzeni() > 0) {
            aktualniHrac.snizZdrzeni();
            dalsiHrac();
            return false;
        }
        return true;
    }

    private void dalsiHrac() {
        System.out.print("dalsi " + aktualniHrac.getJmeno());
        aktualniHrac = hraci.get((hraci.indexOf(aktualniHrac) + 1) % pocetHracu);
        System.out.println(" " + aktualniHrac.getJmeno());
    }

    private void predchoziHrac() {
        System.out.print("predchozi " + aktualniHrac.getJmeno());
        aktualniHrac = hraci.get((hraci.indexOf(aktualniHrac) - 1 + pocetHracu) % pocetHracu);
        System.out.println(" " + aktualniHrac.getJmeno());
    }

    private int vyhodnotHod(int kolik) {
        if (aktualniHrac.isDistanc()) {
            if (kolik > 6) {
                aktualniHrac.setDistanc(false);
                status(bundle.getString("RELEASE_FROM_DISTANC"));
                return 0;
            } else {
                status(bundle.getString("MAYBE_LATER"));
                return 1;
            }
        }
        if (kolik == 12) {
            status(bundle.getString("GO_ON_DISTANC"));
            aktualniHrac.setDistanc(true);
            return 1;
        }
        return 2;
    }

    private void vyhodnotPozici(int aktualniPozice, int kolik) {
        if (aktualniPozice == 10) {
            status(bundle.getString("DISTANC"));
            aktualniHrac.setDistanc(true);
        }
        if (aktualniPozice < kolik) {
            status(bundle.getString("YOU_GOT_4000_FOR_PASSING_START"));
            aktualniHrac.pricti(4000);
        }
        if (aktualniPozice == 4) {
            status(bundle.getString("PAY_500"));
            aktualniHrac.pricti(-500);
        } else if (aktualniPozice == 38) {
            status(bundle.getString("PAY_1000"));
            aktualniHrac.pricti(-1000);
        } else if (aktualniPozice == 30) {
            status(bundle.getString("1_ROUND_DELAY_DOPING"));
            aktualniHrac.setZdrzeni(1);
        }
        vyhodnotSazky(aktualniPozice);
    }

    private void vyhodnotPolicko(Policko p, int kolik) throws InterruptedException {
        if (bundle.getString("FINANCES").equals(p.getNazev())) {
            try {
                vyhodnotFinance();

            } catch (IllegalAccessException ex) {
                Logger.getLogger(Hra.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if (bundle.getString("LUCK").equals(p.getNazev())) {
            try {
                vyhodnotNahodu();

            } catch (IllegalAccessException ex) {
                Logger.getLogger(Hra.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if (p.isVlastnicka()) {
            if (!p.isObsazeno()) {
                nabidkaNakupu(p);

            } else {
                if (!p.getMajitel().equals(aktualniHrac)) {
                    zaplat(p, kolik);
                } else if (p.getKarta() instanceof Kun) {
                    dokoupitDostih(p);

                }
            }

        }
    }

    private void vyhodnotFinance() throws InterruptedException, IllegalAccessException {
        if (financeNove.pocet() == 0) {
            KolekceKaret<Finance> tmp = financeNove;
            financeNove = financeStare;
            financeStare = tmp;
        }
        Finance f = financeNove.vratNahodny();
        status(f.getPopis());
        f.zobraz();
        f.proved(aktualniHrac);
        financeStare.vloz(f);
    }

    private void vyhodnotNahodu() throws IllegalAccessException, InterruptedException {
        if (nahodaNove.pocet() == 0) {
            KolekceKaret<Nahoda> tmp = nahodaNove;
            nahodaNove = nahodaStare;
            nahodaStare = tmp;
        }
        Nahoda n = nahodaNove.vratNahodny();
        status(n.getPopis());
        n.zobraz();
        int pozice = aktualniHrac.getFigurka().getPozice();
        n.proved(aktualniHrac);
        nahodaStare.vloz(n);
        if (n instanceof NahodaPopojdi) {
            vyhodnotPozici(aktualniHrac.getFigurka().getPozice(), 0);
            int aktualniPozice = aktualniHrac.getFigurka().getPozice();
            Policko p = policka.get(aktualniPozice);
            vyhodnotPolicko(p, (aktualniPozice - pozice) % 40);
        }
    }

    private void nabidkaNakupu(Policko p) {
        if (aktualniHrac.getRozpocet() >= p.getKarta().getPorizovaciCena()) {
            JDialog.setDefaultLookAndFeelDecorated(true);
            Object[] volby = {bundle.getString("YES"), bundle.getString("NO")};

            String otazka = MessageFormat.format(bundle.getString("WANT_TO_BUY_CARD"), new Object[]{p.getNazev(), p.getKarta().getPorizovaciCena()});
            int odpoved = JOptionPane.showOptionDialog(null, otazka, bundle.getString("BUYING"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, volby, volby[0]);

            if (odpoved == JOptionPane.YES_OPTION) {
                if (p.getKarta() instanceof Kun) {
                    SoundHandler.play(Konstanty.Sound.HORSE);
                } else if (p.getKarta() instanceof PrepravaStaje) {
                    if (p.getNazev().equals(bundle.getString("TRANSPORT"))) {
                        SoundHandler.play(Konstanty.Sound.TRANSPORT);
                    } else {
                        SoundHandler.play(Konstanty.Sound.STABLES);
                    }
                }
                aktualniHrac.pridejKartu(p.getKarta());
                aktualniHrac.pricti(-p.getKarta().getPorizovaciCena());
                p.setMajitel(aktualniHrac);
                this.getCaller().shoutOut(Konstanty.Shout.MARK_FIELD_PREFIX + p.getPozice());
                Hra.getInstance().status(java.text.MessageFormat.format(bundle.getString("YOU_BOUGHT"), new Object[]{p.getNazev()}));
            }
        }
    }

    private void zaplat(Policko p, int kolik) {
        Karta k = p.getKarta();
        if (k instanceof Kun) {
            Kun kun = (Kun) k;
            int dostihu = kun.getPocetDostihu();
            int navsteva = 0;
            switch (dostihu) {
                case 0: {
                    navsteva = kun.getProhlidkaStaje();
                }
                break;
                case 1: {
                    navsteva = kun.getDostih1();
                }
                break;
                case 2: {
                    navsteva = kun.getDostih2();
                }
                break;
                case 3: {
                    navsteva = kun.getDostih3();
                }
                break;
                case 4: {
                    navsteva = kun.getDostih4();
                }
                break;
                case 5: {
                    navsteva = kun.getHlDostih();
                }
                break;
            }
            aktualniHrac.pricti(-navsteva);
            p.getMajitel().pricti(navsteva);
            status(java.text.MessageFormat.format(bundle.getString("YOU_PAID_FOR_VISITING_STABLE"), new Object[]{p.getMajitel().getJmeno(), navsteva}));
        } else if (k instanceof Trener) {
            int castka = p.getMajitel().getPocetTreneru() * 1000;
            aktualniHrac.pricti(-castka);
            p.getMajitel().pricti(castka);
            status(java.text.MessageFormat.format(bundle.getString("YOU_PAID_FOR_USING_TRAINER"), new Object[]{p.getMajitel().getJmeno(), castka}));
        } else if (k instanceof PrepravaStaje) {
            int castka = (p.getMajitel().getPocetPrepravaStaje() == 1 ? 80 * kolik : 200 * kolik);
            aktualniHrac.pricti(-castka);
            p.getMajitel().pricti(castka);
            status(MessageFormat.format(bundle.getString("YOU_PAID_FOR_TRANSPORT"), new Object[]{p.getMajitel().getJmeno(), castka, p.getNazev().toLowerCase()}));
        }
    }

    private void dokoupitDostih(Policko p) {
        Kun kun = (Kun) p.getKarta();
        if (maCelouStaj(aktualniHrac, kun.getStaj())) {
            if (kun.getPocetDostihu() < 5) {
                if (aktualniHrac.getRozpocet() >= (kun.getPocetDostihu() < 4 ? kun.getPripravaDostihu() : kun.getPripravaHlavnihoDostihu())) {
                    Object[] volby = {bundle.getString("YES"), bundle.getString("NO")};
                    int odpoved = JOptionPane.showOptionDialog(
                            null,
                            (java.text.MessageFormat.format(bundle.getString("YOU_WANT_BUY_ANOTHER_RACE"), new Object[]{(kun.getPocetDostihu() < 4 ? kun.getPripravaDostihu() : kun.getPripravaHlavnihoDostihu())})),
                            bundle.getString("RACE_BUY"),
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, volby, volby[0]);
                    if (odpoved == JOptionPane.YES_OPTION) {
                        aktualniHrac.pricti(-(kun.getPocetDostihu() < 4 ? kun.getPripravaDostihu() : kun.getPripravaHlavnihoDostihu()));
                        kun.pridejDostih();
                    }
                }
            }
        }
    }

    public LoudCall<Void, String> getTah() {
        return getCaller();
    }

    public List<Hrac> getVyherci() {
        return vyherci;
    }

    public LoudCall<Void, String> getCaller() {
        return caller;
    }

    public void pripravUlozeni() {
        ulozilPoHazeni = false;
        if (!predHazenim) {
            caller.shoutOut(Konstanty.Shout.DISABLE_BUTTON);
            HerniPlochaController.getInstance().setUkoncenTah(true);
            dalsiHrac();
            ulozilPoHazeni = true;
        }
    }

    public void vratPredUlozeni() {
        if (ulozilPoHazeni) {
            predchoziHrac();
            caller.shoutOut(Konstanty.Shout.DISABLE_BUTTON);
            status(bundle.getString("PLAYING_PLAYER") + " " + aktualniHrac.getJmeno());
            caller.shoutOut(Konstanty.Shout.SLIDER_ACTUALIZATION);
        }
    }

    public void nastavMoznostSazeni() {
        boolean muzeSazet = false;
        for (VlastnickaKarta k : aktualniHrac.getKarty()) {
            if (k instanceof Kun) {
                Kun kun = (Kun) k;
                if (kun.getPocetDostihu() >= 3) {
                    muzeSazet = true;
                    break;
                }
            }
        }
        for (Policko p : policka) {
            p.setMuzeVsadit(false);
            if (muzeSazet
                    && p.isVlastnicka()
                    && p.isObsazeno()
                    && !p.getMajitel().equals(aktualniHrac)
                    && p.getKarta() instanceof Kun) {
                Kun kun = (Kun) p.getKarta();
                if (kun.getPocetDostihu() >= 3) {
                    p.setMuzeVsadit(true);
                }
            }
        }
    }

    public void zrusSazeni() {
        for (Policko p : policka) {
            p.setMuzeVsadit(false);
        }
    }

    private void vyhodnotSazky(int aktualniPozice) {
        for (Policko p : policka) {
            if (p.getKarta() instanceof Kun) {
                Kun kun = (Kun) p.getKarta();
                if (kun.getSazka() > 0) {
                    if (aktualniPozice == p.getPozice()) {
                        kun.vyplatSazku(aktualniHrac);
                    } else {
                        kun.stornujSazku();
                    }
                }
            }
        }
    }

    public void nastavTextStatusBoxu(String chunk) {
        if (chunk.length() > 67) {
            statusBox.setFont(new Font("Ubuntu", 1, (int) (15 * RozmeryPlochy.getScalingFactor())));
            if (chunk.length() > 80) {
                statusBox.setBorder(BorderFactory.createEmptyBorder((int) (7 * RozmeryPlochy.getScalingFactor()),
                        (int) (20 * RozmeryPlochy.getScalingFactor()),
                        (int) (10 * RozmeryPlochy.getScalingFactor()),
                        (int) (20 * RozmeryPlochy.getScalingFactor())));
            } else {
                statusBox.setBorder(BorderFactory.createEmptyBorder((int) (17 * RozmeryPlochy.getScalingFactor()),
                        (int) (20 * RozmeryPlochy.getScalingFactor()),
                        (int) (10 * RozmeryPlochy.getScalingFactor()),
                        (int) (20 * RozmeryPlochy.getScalingFactor())));
            }
        } else {
            statusBox.setFont(new Font("Ubuntu", 1, (int) (18 * RozmeryPlochy.getScalingFactor())));
            statusBox.setBorder(BorderFactory.createEmptyBorder((int) (15 * RozmeryPlochy.getScalingFactor()),
                    (int) (20 * RozmeryPlochy.getScalingFactor()),
                    (int) (10 * RozmeryPlochy.getScalingFactor()),
                    (int) (20 * RozmeryPlochy.getScalingFactor())));
        }
        statusBox.setText(chunk);
    }

}
