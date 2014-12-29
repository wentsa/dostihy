/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hra;

import gui.Kostka;
import pomocne.DataHraci;
import pomocne.Barva;
import gui.plocha.HerniPlochaController;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import karty.*;
import karty.finance.*;
import karty.nahoda.*;
import kolekce.*;
import pomocne.LoudCall;
import pomocne.Staj;
import audio.SoundHandler;

/**
 *
 * @author wentsa
 */
public final class Hra implements Serializable {

    private Kostka kostka;
    private final List<Hrac> hraci;
    private final List<Policko> policka;
    private KolekceKaret<Nahoda> nahodaNove, nahodaStare;
    private KolekceKaret<Finance> financeNove, financeStare;
    private Hrac aktualniHrac; // 0...pocet-1
    private int pocetHracu;
    private final JTextPane statusBox;
    private List<Hrac> vyherci;
    private long cas;
    private int pocetTahu = 0, aktivnichHracu;
    private final LoudCall<Void, String> caller;

    private static Hra instance = null;

    public static Hra getInstance() {
        if (instance == null) {
            instance = new Hra();
        }
        return instance;
    }
    
    public static void smazInstance() {
        instance=null;
    }

    public static void changeInstance(Hra other) {
        instance = other;
    }

    private Hra() {
        System.out.println("vytvarim hru na vlakne " + Thread.currentThread().toString());
        this.policka = new ArrayList<>(40);
        this.financeNove = new KolekceKaretImplementace<>(14);
        this.financeStare = new KolekceKaretImplementace<>(14);
        this.nahodaNove = new KolekceKaretImplementace<>(14);
        this.nahodaStare = new KolekceKaretImplementace<>(14);
        this.hraci = new ArrayList<>();
        this.kostka = new Kostka();
        this.aktualniHrac = null;
        this.vyherci = new ArrayList<>();
        this.statusBox = new JTextPane() {
            @Override
            public void paintComponent(Graphics g) {
                BufferedImage statusP = HerniPlochaController.getInstance().getBoxPozadi();
                g.drawImage(statusP, 0, 0, statusP.getWidth(null), statusP.getHeight(null), null);
                super.paintComponent(g);
            }
        };
        this.caller = new LoudCall<Void, String>() {

            @Override
            public Void call() throws Exception {
                while (true) {
                    HerniPlochaController.getInstance().setUkoncenTah(false);
                    System.out.println("A");
                    if (zacatekTahu()) {
                        vyradHrace();
                        break;
                    }
                    System.out.println("B");
                    if (!zvolHrace()) {
                        continue;
                    }
                    shoutOut("aktualizujSlider");
                    Thread.sleep(100);
                    System.out.println("C");
                    status("Hraje " + aktualniHrac.getJmeno());
                    System.out.println("D");
                    int kolik = kostka.hazej();
                    if (kolik == -1) {
                        vyradHrace();
                        continue;
                    }
                    System.out.println("E");
                    int x=vyhodnotHod(kolik);
                    if (x==1) {
                        shoutOut("zapni");
                        Thread.sleep(200);
                        while (!HerniPlochaController.getInstance().isUkoncenTah()) {
                            if (!aktualniHrac.isAktivni()) {
                                break;
                            }
                            Thread.sleep(100);
                            System.out.print("a-");
                        }
                        shoutOut("vypni");
                        Thread.sleep(1000);
                        if (!aktualniHrac.isAktivni()) {
                            vyradHrace();
                            continue;
                        }
                        dalsiHrac();
                        continue;
                    }
                    if(x==0) kolik-=6;
                    System.out.println("F");
                    aktualniHrac.popojdi(kolik);
                    System.out.println("G");
                    int aktualniPozice = aktualniHrac.getFigurka().getPozice();
                    vyhodnotPozici(aktualniPozice, kolik);
                    System.out.println("H");
                    Policko p = policka.get(aktualniPozice);
                    vyhodnotPolicko(p, kolik);
                    System.out.println("I");
                    shoutOut("zapni");
                    Thread.sleep(200);
                    while (!HerniPlochaController.getInstance().isUkoncenTah()) {
                        if (!aktualniHrac.isAktivni()) {
                            break;
                        }
                        Thread.sleep(100);
                        System.out.print("a-");
                    }
                    shoutOut("vypni");
                    Thread.sleep(1000);
                    if (!aktualniHrac.isAktivni()) {
                        vyradHrace();
                        continue;
                    }
                    dalsiHrac();
                    System.out.println("\nJ");
                }
                return null;
            }

        };
        inicializovatPolicka();
        inicializovatNahodu();
        inicializovatFinance();
    }

    // <editor-fold defaultstate="collapsed" desc="POLICKA">
    public void inicializovatPolicka() {
        getPolicka().add(new Policko(1, "Start"));
        getPolicka().add(new Policko(2, "Fantome", new Kun(2, "Fantome", 1200, Staj.ORANZOVA, 40, 200, 600, 1800, 3200, 5000, 1000, 1000)));
        getPolicka().add(new Policko(3, "Finance"));
        getPolicka().add(new Policko(4, "Gavora", new Kun(4, "Gavora", 1200, Staj.ORANZOVA, 40, 200, 600, 1800, 3200, 5000, 1000, 1000)));
        getPolicka().add(new Policko(5, "Veterinární vyšetření"));
        getPolicka().add(new Policko(6, "Trenér", new Trener(6, 1)));
        getPolicka().add(new Policko(7, "Lady Anne", new Kun(7, "Lady Anne", 2000, Staj.HNEDA, 120, 600, 1800, 5400, 8000, 11000, 1000, 1000)));
        getPolicka().add(new Policko(8, "Náhoda"));
        getPolicka().add(new Policko(9, "Pasek", new Kun(9, "Pasek", 2000, Staj.HNEDA, 120, 600, 1800, 5400, 8000, 11000, 1000, 1000)));
        getPolicka().add(new Policko(10, "Koran", new Kun(10, "Koran", 2400, Staj.HNEDA, 160, 800, 2000, 6000, 9000, 12000, 1000, 1000)));
        getPolicka().add(new Policko(11, "Distanc"));
        getPolicka().add(new Policko(12, "Neklan", new Kun(12, "Neklan", 2800, Staj.SV_MODRA, 200, 1000, 3000, 9000, 12500, 15000, 2000, 2000)));
        getPolicka().add(new Policko(13, "Přeprava", new PrepravaStaje(13, 3000, "Přeprava")));
        getPolicka().add(new Policko(14, "Portlancl", new Kun(14, "Portlancl", 2800, Staj.SV_MODRA, 200, 1000, 3000, 9000, 12500, 15000, 2000, 2000)));
        getPolicka().add(new Policko(15, "Japan", new Kun(15, "Japan", 2800, Staj.SV_MODRA, 240, 1200, 3600, 10000, 14000, 18000, 2000, 2000)));
        getPolicka().add(new Policko(16, "Trenér", new Trener(16, 2)));
        getPolicka().add(new Policko(17, "Kostrava", new Kun(17, "Kostrava", 3600, Staj.SV_ZELENA, 280, 1400, 4000, 11000, 15000, 19000, 2000, 2000)));
        getPolicka().add(new Policko(18, "Finance"));
        getPolicka().add(new Policko(19, "Lukava", new Kun(19, "Lukava", 3600, Staj.SV_ZELENA, 280, 1400, 4000, 11000, 15000, 19000, 2000, 2000)));
        getPolicka().add(new Policko(20, "Melák", new Kun(20, "Melák", 4000, Staj.SV_ZELENA, 320, 1600, 4400, 12000, 16000, 20000, 2000, 2000)));
        getPolicka().add(new Policko(21, "Parkoviště"));
        getPolicka().add(new Policko(22, "Grifel", new Kun(22, "Grifel", 4400, Staj.CERVENA, 360, 1800, 5000, 14000, 17000, 21000, 3000, 3000)));
        getPolicka().add(new Policko(23, "Náhoda"));
        getPolicka().add(new Policko(24, "Mohyla", new Kun(24, "Mohyla", 4400, Staj.CERVENA, 360, 1800, 5000, 14000, 17000, 21000, 3000, 3000)));
        getPolicka().add(new Policko(25, "Metál", new Kun(25, "Metál", 4800, Staj.CERVENA, 400, 2000, 6000, 15000, 18000, 22000, 3000, 3000)));
        getPolicka().add(new Policko(26, "Trenér", new Trener(26, 3)));
        getPolicka().add(new Policko(27, "Tara", new Kun(27, "Tara", 5200, Staj.ZLUTA, 440, 2200, 6600, 16000, 19500, 23000, 3000, 3000)));
        getPolicka().add(new Policko(28, "Furioso", new Kun(28, "Furioso", 5200, Staj.ZLUTA, 440, 2200, 6600, 16000, 19500, 23000, 3000, 3000)));
        getPolicka().add(new Policko(29, "Stáje", new PrepravaStaje(29, 3000, "Stáje")));
        getPolicka().add(new Policko(30, "Genius", new Kun(30, "Genius", 5600, Staj.ZLUTA, 580, 2400, 7200, 17000, 20500, 24000, 3000, 3000)));
        getPolicka().add(new Policko(31, "Podezření z dopingu"));
        getPolicka().add(new Policko(32, "Shagga", new Kun(32, "Shagga", 6000, Staj.ZELENA, 500, 2600, 7800, 18000, 22000, 25500, 4000, 4000)));
        getPolicka().add(new Policko(33, "Dahoman", new Kun(33, "Dahoman", 6000, Staj.ZELENA, 500, 2600, 7800, 18000, 22000, 25500, 4000, 4000)));
        getPolicka().add(new Policko(34, "Finance"));
        getPolicka().add(new Policko(35, "Gira", new Kun(35, "Gira", 6400, Staj.ZELENA, 560, 3000, 9000, 20000, 24000, 28000, 4000, 4000)));
        getPolicka().add(new Policko(36, "Trenér", new Trener(36, 4)));
        getPolicka().add(new Policko(37, "Náhoda"));
        getPolicka().add(new Policko(38, "Narcius", new Kun(38, "Narcius", 7000, Staj.MODRA, 700, 3500, 10000, 22000, 26000, 30000, 4000, 4000)));
        getPolicka().add(new Policko(39, "Veterinární vyšetření"));
        getPolicka().add(new Policko(40, "Napoli", new Kun(40, "Napoli", 8000, Staj.MODRA, 1000, 4000, 12000, 28000, 34000, 40000, 4000, 4000)));

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="NAHODA">
    void inicializovatNahodu() {
        getNahodaNove().vloz(new NahodaPopojdi("Jdi o 3 pole zpět.", false, false, 3));
        getNahodaNove().vloz(new NahodaDistanc("Zrušen distanc."));
        getNahodaNove().vloz(new NahodaPopojdi("Jedeš se zúčastnit trenérského kurzu. Postoupíš na nejbližší pole Trenér. Dostaneš 4.000, pokud jedeš dopředu přes Start.", true, true, "Trenér"));
        getNahodaNove().vloz(new NahodaZdrzeni("Zdržíš se na 2 kola.", 2));
        getNahodaNove().vloz(new NahodaPopojdi("Distanc (bez 4.000).", false, true, "Distanc"));
        getNahodaNove().vloz(new NahodaPopojdi("Zpět na nejbližší pole Finance.", false, false, "Finance"));
        getNahodaNove().vloz(new NahodaPopojdi("Zpět na poslední pole ve hře (kůň Napoli), hráč obdrží 4.000.", true, false, "Napoli"));
        getNahodaNove().vloz(new NahodaPopojdi("Zpět na pole Distanc. Obdržíš 4.000, pokud jsi cestou zpět prošel Start.", true, false, "Distanc"));
        getNahodaNove().vloz(new NahodaPopojdi("Zpět na nejbližší pole Finance.", false, false, "Finance"));
        getNahodaNove().vloz(new NahodaPopojdi("Zpět na start (hráč obdrží 4.000).", true, false, "Start"));
        getNahodaNove().vloz(new NahodaPopojdi("Zpět na start (bez 4.000).", false, false, "Start"));
        getNahodaNove().vloz(new NahodaZdrzeni("Zdržíš se na 2 kola.", 2));
        getNahodaNove().vloz(new NahodaZdrzeni("Zdržíš se na 1 kolo.", 1));
        getNahodaNove().vloz(new NahodaPopojdi("Zpět na pole Parkoviště. Dostaneš 4.000, pokud jsi cestou zpět prošel start.", true, false, "Parkoviště"));
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="FINANCE">
    void inicializovatFinance() {
        getFinanceNove().vloz(new FinanceKlasika("Zaplať pojistku 1000.", 1000, true));
        getFinanceNove().vloz(new FinanceKlasika("Pokuta za nedodržení předpisů 400.", 400, true));
        getFinanceNove().vloz(new FinanceRenovace("Renovuješ všechny stáje. Za každý svůj obsazený dostih zaplať 500.", 500));
        getFinanceNove().vloz(new FinanceKlasika("Mimořádný zisk z dostihů obdržíš 2.000.", 2000, false));
        getFinanceNove().vloz(new FinanceDarek("Jako dárek k narozeninám obdržíš od každého 200.", 200));
        getFinanceNove().vloz(new FinanceKlasika("Mimořádná prémie 500.", 500, false));
        getFinanceNove().vloz(new FinanceKlasika("Obdržíš dotaci 4.000.", 4000, false));
        getFinanceNove().vloz(new FinanceKlasika("Zaplať dluh 3.000.", 3000, true));
        getFinanceNove().vloz(new FinanceRenovace("Za každý svůj obsazený dostih zaplať 800, za každý svůj obsazený hlavní dostih sezóny zaplať 2.300.", 800));
        getFinanceNove().vloz(new FinanceKlasika("Zaplať příspěvek 2.000.", 2000, true));
        getFinanceNove().vloz(new FinanceKlasika("Nákup materiálu na opravu 100.", 100, true));
        getFinanceNove().vloz(new FinanceKlasika("Výhra v loterii 1.000.", 1000, false));
        getFinanceNove().vloz(new FinanceKlasika("Obdržíš dotaci 2.000.", 2000, false));
        getFinanceNove().vloz(new FinanceKlasika("Z banky obdržíš přeplatek 3.000.", 3000, false));
    }
    // </editor-fold>

    @Override
    public String toString() {
        String tmp = new String();
        Integer i = 1;
        for (Policko pol : getPolicka()) {
            tmp = tmp.concat("\n" + i.toString() + ": \n" + pol);
            i++;
        }
        return tmp;
    }

    public void zalozHrace(DataHraci data) {
        int i = 0;
        for (String jmeno : data.jmena) {
            hraci.add(new Hrac(jmeno, parseColor(data.barvy.get(i)), i + 1));
            i++;
        }
        aktivnichHracu = pocetHracu = hraci.size();
        System.out.println("AKTIVNICH HRACU " + aktivnichHracu);
        aktualniHrac = hraci.get(0);
    }

    private Barva parseColor(String barva) {
        switch (barva) {
            case "Cerna":
                return Barva.BLACK;
            case "Modra":
                return Barva.BLUE;
            case "Tyrkysova":
                return Barva.CYAN;
            case "Zelena":
                return Barva.GREEN;
            case "Fialova":
                return Barva.MAGENTA;
            case "Oranzova":
                return Barva.ORANGE;
            case "Cervena":
                return Barva.RED;
            case "Bila":
                return Barva.WHITE;
            case "Zluta":
                return Barva.YELLOW;
        }
        return null;
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
    public KolekceKaret getNahodaNove() {
        return nahodaNove;
    }

    /**
     * @param nahodaNove the nahodaNove to set
     */
    public void setNahodaNove(KolekceKaret nahodaNove) {
        this.nahodaNove = nahodaNove;
    }

    /**
     * @return the nahodaStare
     */
    public KolekceKaret getNahodaStare() {
        return nahodaStare;
    }

    /**
     * @param nahodaStare the nahodaStare to set
     */
    public void setNahodaStare(KolekceKaret nahodaStare) {
        this.nahodaStare = nahodaStare;
    }

    /**
     * @return the financeNove
     */
    public KolekceKaret getFinanceNove() {
        return financeNove;
    }

    /**
     * @param financeNove the financeNove to set
     */
    public void setFinanceNove(KolekceKaret financeNove) {
        this.financeNove = financeNove;
    }

    /**
     * @return the financeStare
     */
    public KolekceKaret getFinanceStare() {
        return financeStare;
    }

    /**
     * @param financeStare the financeStare to set
     */
    public void setFinanceStare(KolekceKaret financeStare) {
        this.financeStare = financeStare;
    }

    /**
     * @return the kostka
     */
    public Kostka getKostka() {
        return kostka;
    }

    public void status(String message) {
        caller.shoutOut("msg" + message);
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hra.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        status("Hrac \"" + aktualniHrac.getJmeno() + "\" se jiz nezucastni dalsiho herniho kola");
        System.out.println("+++ vyrazen " + aktualniHrac.getJmeno());
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
        System.out.println("aktivnich hracu=" + aktivnichHracu);
        if (aktivnichHracu == 1) {
            return true;
        }
        return false;
    }

    private boolean zvolHrace() {
        if (!aktualniHrac.isAktivni()) {
            dalsiHrac();
            return false;
        }
        while (aktualniHrac.getRozpocet() < 0 && aktualniHrac.isAktivni()) {
            status("Nejprve musis neco prodat");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hra.class.getName()).log(Level.SEVERE, null, ex);
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
        System.out.print("-----dalsi hrac " + aktualniHrac.getJmeno() + " => ");
        aktualniHrac = hraci.get((hraci.indexOf(aktualniHrac) + 1) % pocetHracu);
        System.out.println(aktualniHrac.getJmeno());
    }

    private int vyhodnotHod(int kolik) {
        if (aktualniHrac.isDistanc()) {
            if (kolik > 6) {
                aktualniHrac.setDistanc(false);
                status("Muzes hrat, hazej znovu");
                return 0;
            } else {
                status("Tak priste");
                return 1;
            }
        }
        if (kolik == 12) {
            status("Hodil jsi 2x 6 - musis na distanc");
            aktualniHrac.setDistanc(true);
            return 1;
        }
        return 2;
    }

    private void vyhodnotPozici(int aktualniPozice, int kolik) {
        if (aktualniPozice == 10) {
            status("DISTANC");
            aktualniHrac.setDistanc(true);
        }
        if (aktualniPozice < kolik) {
            status("Za pruchod startem jsi obdrzel 4000,-");
            aktualniHrac.pricti(4000);
        }
        if (aktualniPozice == 4) {
            status("Vysetreni, zaplat 500,-");
            aktualniHrac.pricti(-500);
        } else if (aktualniPozice == 38) {
            status("Vysetreni, zaplat 1000,-");
            aktualniHrac.pricti(-1000);
        } else if (aktualniPozice == 30) {
            status("Podezreni z dopingu, zdrsis se 1 kolo");
            aktualniHrac.setZdrzeni(1);
        }
    }

    private void vyhodnotPolicko(Policko p, int kolik) throws InterruptedException {
        System.out.println("policko " + p.getNazev());
        if ("Finance".equals(p.getNazev())) {
            try {
                vyhodnotFinance();
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Hra.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("Náhoda".equals(p.getNazev())) {
            try {
                vyhodnotNahodu();

            } catch (IllegalAccessException ex) {
                Logger.getLogger(Hra.class.getName()).log(Level.SEVERE, null, ex);
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
        System.out.println("FINANCE");
        if (financeNove.pocet() == 0) {
            KolekceKaret tmp = financeNove;
            financeNove = financeStare;
            financeStare = tmp;
        }
        Finance f = (Finance) financeNove.vratNahodny();
        status(f.getPopis());
        f.zobraz();
        f.proved(aktualniHrac);
        financeStare.vloz(f);
    }

    private void vyhodnotNahodu() throws IllegalAccessException, InterruptedException {
        System.out.println("NAHODA");
        if (nahodaNove.pocet() == 0) {
            KolekceKaret tmp = nahodaNove;
            nahodaNove = nahodaStare;
            nahodaStare = tmp;
        }
        Nahoda n = (Nahoda) nahodaNove.vratNahodny();
        status(n.getPopis());
        n.zobraz();
        n.proved(aktualniHrac);
        if (policka.get(aktualniHrac.getFigurka().getPozice()).getNazev().equals("Finance")) {
            vyhodnotFinance();
        }
        nahodaStare.vloz(n);
    }

    private void nabidkaNakupu(Policko p) {
        if (aktualniHrac.getRozpocet() >= p.getKarta().getPorizovaciCena()) {
            JDialog.setDefaultLookAndFeelDecorated(true);
            Object[] volby = {"Ano", "Ne"};
            int odpoved = JOptionPane.showOptionDialog(null, ("Chces koupit \"" + p.getNazev() + "\" za " + p.getKarta().getPorizovaciCena() + ",-?"), "Nakup", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, volby, volby[0]);
            if (odpoved == JOptionPane.YES_OPTION) {
                if(p.getKarta() instanceof Kun) {
                    SoundHandler.horse();
                }
                else if (p.getKarta() instanceof PrepravaStaje) {
                    if(p.getNazev().equals("Přeprava")) {
                        SoundHandler.transport();
                    }
                    else {
                        SoundHandler.stables();
                    }
                }
                aktualniHrac.pricti(-p.getKarta().getPorizovaciCena());
                aktualniHrac.pridejKartu(p.getKarta());
                //p.getObsazFigurka().zmenBarvu(hrac.getFigurka().getBarva());
                //p.getObsazFigurka().setObsazeno(true);
                System.out.println("nakupuji");
                p.setMajitel(aktualniHrac);
                System.out.println("majitel nastaven  posilam:\"p-" + p.getCislo() + "\"");
                this.caller.shoutOut("p-"+p.getCislo());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hra.class.getName()).log(Level.SEVERE, null, ex);
                }
                //p.setObsazeno(true);
                System.out.println("obsazeno nastaveno");
                System.out.println(Thread.currentThread());
                Hra.getInstance().status("Zakoupil jsi \"" + p.getNazev() + "\"");
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
            status("Zaplatil jsi hraci \"" + p.getMajitel().getJmeno() + "\" " + navsteva + ",- za prohlidku staje");
        } else if (k instanceof Trener) {
            int castka = p.getMajitel().getPocetTreneru() * 1000;
            aktualniHrac.pricti(-castka);
            p.getMajitel().pricti(castka);
            status("Zaplatil jsi hraci \"" + p.getMajitel().getJmeno() + "\" " + castka + ",- za vyuziti sluzeb trenera");
        } else if (k instanceof PrepravaStaje) {
            int castka = (p.getMajitel().getPocetPrepravaStaje() == 1 ? 80 * kolik : 200 * kolik);
            aktualniHrac.pricti(-castka);
            p.getMajitel().pricti(castka);
            status("Zaplatil jsi hraci \"" + p.getMajitel().getJmeno() + "\" " + castka + ",- za " + p.getNazev().toLowerCase());
        }
    }

    private void dokoupitDostih(Policko p) {
        Kun kun = (Kun) p.getKarta();
        if (maCelouStaj(aktualniHrac, kun.getStaj())) {
            if (kun.getPocetDostihu() < 5) {
                if (aktualniHrac.getRozpocet() >= (kun.getPocetDostihu() < 4 ? kun.getPripravaDostihu() : kun.getPripravaHlavnihoDostihu())) {
                    Object[] volby = {"Ano", "Ne"};
                    int odpoved = JOptionPane.showOptionDialog(null, ("Chces koupit dalsi dostih za " + (kun.getPocetDostihu() < 4 ? kun.getPripravaDostihu() : kun.getPripravaHlavnihoDostihu()) + ",- ?"), "Nakup dostihu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, volby, volby[0]);
                    if (odpoved == JOptionPane.YES_OPTION) {
                        aktualniHrac.pricti(-(kun.getPocetDostihu() < 4 ? kun.getPripravaDostihu() : kun.getPripravaHlavnihoDostihu()));
                        kun.pridejDostih();
                    }
                }
            }
        }
    }

    public LoudCall<Void, String> getTah() {
        return caller;
    }

    public List<Hrac> getVyherci() {
        return vyherci;
    }

}