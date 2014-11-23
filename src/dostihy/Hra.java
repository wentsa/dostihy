/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dostihy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import karty.*;
import karty.finance.*;
import karty.nahoda.*;
import kolekce.*;

/**
 *
 * @author wentsa
 */
public final class Hra implements Serializable {

    private Kostka kostka;
    private List<Hrac> hraci;
    private final List<Policko> policka;
    private KolekceKaret nahodaNove;
    private KolekceKaret nahodaStare;
    private KolekceKaret financeNove;
    private KolekceKaret financeStare;
    private int aktualniHrac; // 0...pocet-1
    private int pocetHracu;
    private final JTextPane statusBox;

    public Hra() {
        this.policka = new ArrayList<>(40);
        this.financeNove = new KolekceKaretImplementace(14);
        this.financeStare = new KolekceKaretImplementace(14);
        this.nahodaNove = new KolekceKaretImplementace(14);
        this.nahodaStare = new KolekceKaretImplementace(14);
        this.kostka = new Kostka();
        this.aktualniHrac = 0;
        this.statusBox = new JTextPane();
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
        getPolicka().add(new Policko(5, "Veterinarni vysetreni"));
        getPolicka().add(new Policko(6, "Trener", new Trener(6, 1)));
        getPolicka().add(new Policko(7, "Lady Anne", new Kun(7, "Lady Anne", 2000, Staj.HNEDA, 120, 600, 1800, 5400, 8000, 11000, 1000, 1000)));
        getPolicka().add(new Policko(8, "Nahoda"));
        getPolicka().add(new Policko(9, "Pasek", new Kun(9, "Pasek", 2000, Staj.HNEDA, 120, 600, 1800, 5400, 8000, 11000, 1000, 1000)));
        getPolicka().add(new Policko(10, "Koran", new Kun(10, "Koran", 2400, Staj.HNEDA, 160, 800, 2000, 6000, 9000, 12000, 1000, 1000)));
        getPolicka().add(new Policko(11, "Distanc"));
        getPolicka().add(new Policko(12, "Neklan", new Kun(12, "Neklan", 2800, Staj.SV_MODRA, 200, 1000, 3000, 9000, 12500, 15000, 2000, 2000)));
        getPolicka().add(new Policko(13, "Preprava", new PrepravaStaje(13, 3000, "Preprava")));
        getPolicka().add(new Policko(14, "Portlancl", new Kun(14, "Portlancl", 2800, Staj.SV_MODRA, 200, 1000, 3000, 9000, 12500, 15000, 2000, 2000)));
        getPolicka().add(new Policko(15, "Japan", new Kun(15, "Japan", 2800, Staj.SV_MODRA, 240, 1200, 3600, 10000, 14000, 18000, 2000, 2000)));
        getPolicka().add(new Policko(16, "Trener", new Trener(16, 2)));
        getPolicka().add(new Policko(17, "Kostrava", new Kun(17, "Kostrava", 3600, Staj.SV_ZELENA, 280, 1400, 4000, 11000, 15000, 19000, 2000, 2000)));
        getPolicka().add(new Policko(18, "Finance"));
        getPolicka().add(new Policko(19, "Lukava", new Kun(19, "Lukava", 3600, Staj.SV_ZELENA, 280, 1400, 4000, 11000, 15000, 19000, 2000, 2000)));
        getPolicka().add(new Policko(20, "Melak", new Kun(20, "Melak", 4000, Staj.SV_ZELENA, 320, 1600, 4400, 12000, 16000, 20000, 2000, 2000)));
        getPolicka().add(new Policko(21, "Parkoviste"));
        getPolicka().add(new Policko(22, "Grifel", new Kun(22, "Grifel", 4400, Staj.CERVENA, 360, 1800, 5000, 14000, 17000, 21000, 3000, 3000)));
        getPolicka().add(new Policko(23, "Nahoda"));
        getPolicka().add(new Policko(24, "Mohyla", new Kun(24, "Mohyla", 4400, Staj.CERVENA, 360, 1800, 5000, 14000, 17000, 21000, 3000, 3000)));
        getPolicka().add(new Policko(25, "Metal", new Kun(25, "Metal", 4800, Staj.CERVENA, 400, 2000, 6000, 15000, 18000, 22000, 3000, 3000)));
        getPolicka().add(new Policko(26, "Trener", new Trener(26, 3)));
        getPolicka().add(new Policko(27, "Tara", new Kun(27, "Tara", 5200, Staj.ZLUTA, 440, 2200, 6600, 16000, 19500, 23000, 3000, 3000)));
        getPolicka().add(new Policko(28, "Furioso", new Kun(28, "Furioso", 5200, Staj.ZLUTA, 440, 2200, 6600, 16000, 19500, 23000, 3000, 3000)));
        getPolicka().add(new Policko(29, "Staje", new PrepravaStaje(29, 3000, "Staje")));
        getPolicka().add(new Policko(30, "Genius", new Kun(30, "Genius", 5600, Staj.ZLUTA, 580, 2400, 7200, 17000, 20500, 24000, 3000, 3000)));
        getPolicka().add(new Policko(31, "Podezreni z dopingu"));
        getPolicka().add(new Policko(32, "Shagga", new Kun(32, "Shagga", 6000, Staj.ZELENA, 500, 2600, 7800, 18000, 22000, 25500, 4000, 4000)));
        getPolicka().add(new Policko(33, "Dahoman", new Kun(33, "Dahoman", 6000, Staj.ZELENA, 500, 2600, 7800, 18000, 22000, 25500, 4000, 4000)));
        getPolicka().add(new Policko(34, "Finance"));
        getPolicka().add(new Policko(35, "Gira", new Kun(35, "Gira", 6400, Staj.ZELENA, 560, 3000, 9000, 20000, 24000, 28000, 4000, 4000)));
        getPolicka().add(new Policko(36, "Trener", new Trener(36, 4)));
        getPolicka().add(new Policko(37, "Nahoda"));
        getPolicka().add(new Policko(38, "Narcius", new Kun(38, "Narcius", 7000, Staj.MODRA, 700, 3500, 10000, 22000, 26000, 30000, 4000, 4000)));
        getPolicka().add(new Policko(39, "Veterinarni vysetreni"));
        getPolicka().add(new Policko(40, "Napoli", new Kun(40, "Napoli", 8000, Staj.MODRA, 1000, 4000, 12000, 28000, 34000, 40000, 4000, 4000)));

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="NAHODA">
    void inicializovatNahodu() {
        getNahodaNove().vloz(new NahodaPopojdi("Jdi o 3 pole zpět.", false, false, 3));
        getNahodaNove().vloz(new NahodaDistanc("Zrušen distanc."));
        getNahodaNove().vloz(new NahodaPopojdi("Jedeš se zúčastnit trenérského kurzu. Postoupíš na nejbližší pole Trenér. Dostaneš 4.000, pokud jedeš dopředu přes Start.", true, true, "Trener"));
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
        getNahodaNove().vloz(new NahodaPopojdi("Zpět na pole Parkoviště. Dostaneš 4.000, pokud jsi cestou zpět prošel start.", true, false, "Parkoviste"));
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

    public boolean tahni() throws InterruptedException {
        //-------------TAH S FIGURKOU---------------------------
System.out.println("aaa");
        Hrac hrac = hraci.get(aktualniHrac);
        aktualniHrac = (aktualniHrac + 1) % pocetHracu;

        while (hrac.getRozpocet() < 0) {
            hrac.prodej();
        }

        if (hrac.getZdrzeni() > 0) {
            hrac.snizZdrzeni();
            return false;
        }
        statusBox.setText("Hraje " + hrac.getJmeno());
        int kolik = kostka.hazej(statusBox);
        if (hrac.isDistanc()) {
            if (kolik > 6) {
                hrac.setDistanc(false);
                kolik -= 6;
                status("Muzes hrat, hazej znovu");
            } else {
                status("Tak priste");
                return false;
            }
        }
        if (kolik == 12) {
            status("Musis na distanc");
            hrac.setDistanc(true);
            return false;
        }
        hrac.popojdi(kolik);
        int aktualniPozice = hrac.getFigurka().getPozice();
        if (aktualniPozice == 10) {
            status("DISTANC");
            hrac.setDistanc(true);
        }
        if (aktualniPozice < kolik) {
            status("Za pruchod startem jsi obdrzel 4000");
            hrac.pricti(4000);
        }
        if (aktualniPozice == 4) {
            status("Vysetreni, zaplat 500");
            hrac.pricti(-500);
        } else if (aktualniPozice == 38) {
            status("Vysetreni, zaplat 1000");
            hrac.pricti(-1000);
        } else if (aktualniPozice == 30) {
            status("Podezreni z dopingu, zdrsis se jedno kolo");
            hrac.setZdrzeni(1);
        }
        //----------------------------------------------------
        int pozice = hrac.getFigurka().getPozice();
        Policko p = policka.get(pozice);
        if ("Finance".equals(p.getNazev())) {
            try {
                if (financeNove.pocet() == 0) {
                    KolekceKaret tmp = financeNove;
                    financeNove = financeStare;
                    financeStare = tmp;
                }
                Finance f = (Finance) financeNove.vratNahodny();
                status(f.getPopis());
                f.zobraz();
                f.proved(hrac);
                financeStare.vloz(f);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Hra.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("Nahoda".equals(p.getNazev())) {
            try {
                if (nahodaNove.pocet() == 0) {
                    KolekceKaret tmp = nahodaNove;
                    nahodaNove = nahodaStare;
                    nahodaStare = tmp;
                }
                Nahoda n = (Nahoda) nahodaNove.vratNahodny();
                status(n.getPopis());
                n.zobraz();
                n.proved(hrac);
                if (policka.get(hrac.getFigurka().getPozice()).getNazev().equals("Finance")) {
                    if (financeNove.pocet() == 0) {
                        KolekceKaret tmp = financeNove;
                        financeNove = financeStare;
                        financeStare = tmp;
                    }
                    Finance f = (Finance) financeNove.vratNahodny();
                    status(f.getPopis());
                    f.zobraz();
                    f.proved(hrac);
                    financeStare.vloz(f);
                }
                nahodaStare.vloz(n);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Hra.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (p.isVlastnicka()) {
            if (!p.isObsazeno()) {
                if (hrac.getRozpocet() >= p.getKarta().getPorizovaciCena()) {
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    Object[] volby = {"Ano", "Ne"};
                    int odpoved = JOptionPane.showOptionDialog(null, ("Chces koupit " + p.getNazev() + " za " + p.getKarta().getPorizovaciCena() + "?"), "Nakup", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, volby, volby[0]);
                    if (odpoved == JOptionPane.YES_OPTION) {
                        hrac.pricti(-p.getKarta().getPorizovaciCena());
                        hrac.pridejKartu(p.getKarta());
                        p.getObsazFigurka().zmenBarvu(hrac.getFigurka().getBarva());
                        p.getObsazFigurka().setObsazeno(true);
                        p.setObsazeno(true);
                        p.setMajitel(hrac);
                        status("Zakoupil jsi " + p.getNazev());
                    }
                }

            } else {
                if (!p.getMajitel().equals(hrac)) {
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
                        hrac.pricti(-navsteva);
                        p.getMajitel().pricti(navsteva);
                        status("Zaplatil jsi hraci " + p.getMajitel().getJmeno() + " " + navsteva + " za prohlidku staje");
                    } else if (k instanceof Trener) {
                        int castka = p.getMajitel().getPocetTreneru() * 1000;
                        hrac.pricti(-castka);
                        p.getMajitel().pricti(castka);
                        status("Zaplatil jsi hraci " + p.getMajitel().getJmeno() + " " + castka + " za vyuziti sluzeb trenera");
                    } else if (k instanceof PrepravaStaje) {
                        int castka = (p.getMajitel().getPocetPrepravaStaje() == 1 ? 80 * kolik : 200 * kolik);
                        hrac.pricti(-castka);
                        p.getMajitel().pricti(castka);
                        status("Zaplatil jsi hraci " + p.getMajitel().getJmeno() + " " + castka + " za " + p.getNazev().toLowerCase());
                    }
                } else if (p.getKarta() instanceof Kun) {
                    Kun kun = (Kun) p.getKarta();
                    if (maCelouStaj(hrac, kun.getStaj())) {
                        if (kun.getPocetDostihu() < 5) {
                            if (hrac.getRozpocet() >= (kun.getPocetDostihu() < 4 ? kun.getPripravaDostihu() : kun.getPripravaHlavnihoDostihu())) {
                                Object[] volby = {"Ano", "Ne"};
                                int odpoved = JOptionPane.showOptionDialog(null, ("Chces koupit dalsi dostih za " + (kun.getPocetDostihu() < 4 ? kun.getPripravaDostihu() : kun.getPripravaHlavnihoDostihu()) + ",- ?"), "Nakup dostihu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, volby, volby[0]);
                                if (odpoved == JOptionPane.YES_OPTION) {
                                    hrac.pricti(-(kun.getPocetDostihu() < 4 ? kun.getPripravaDostihu() : kun.getPripravaHlavnihoDostihu()));
                                    kun.pridejDostih();
                                }
                            }
                        }
                    }
                }
            }

        }

        Thread.sleep(
                1000);

        return false;
    }

    void zalozHrace(List<Hrac> hraci) {
        this.hraci = hraci;
        this.pocetHracu = hraci.size();
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

    private void status(String message) {
        statusBox.setText(message);
        statusBox.repaint();
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

}
