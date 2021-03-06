/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import javax.swing.SwingUtilities;

/**
 *
 * @author wentsa
 */
public class Pravidla extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    /**
     * Creates new form Pravidla
     * @param sTlacitkem
     */
    public Pravidla(boolean sTlacitkem) {
        initComponents();
        if(!sTlacitkem) {
            remove(jButton1);
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setMinimumSize(new java.awt.Dimension(600, 300));
        setLayout(new java.awt.BorderLayout());

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("------------------------------------------------------Cíl hry--------------------------------------------------------\n\nKupovat koně, stavět je do dostihů, vyhrávat dostihy, poskytovat služby spojené s dostihovým sportem a dosáhnout co největšího zisku.\n\n-------------------------------------------------------Hra----------------------------------------------------------\n\nHráči se v tazích pravidelně střídají.\n\nHráči postupují po hrací desce ve směru hodinových ručiček o tolik polí, kolik jim padlo na kostce, stále dokola.\n\nPadne-li hráči číslo 6, má právo na hod navíc, hody se sčítají.\n\nKaždé pole má určitý význam a hráč musí ihned provést to, co z tohoto pole vyplývá.\n\nNa startovním poli před prvním tahem a později v průběhu hry pokaždé, když se tu kámen zastaví nebo přes startovní pole přejde, hráč obdrží od bankéře 4.000.\n\nKdyž se kámen zastaví na poli s koněm a tento kůň je dosud volný, hráč má právo ho koupit od banky za cenu, která je na poli uvedená. Zůstane-li kámen stát na poli s dosud volnou přepravou, stájemi nebo trenéry, může hráč tento druh podniku převzít od banky za vyznačenou cenu. Bankéř po zaplacení příslušné částky vydá vlastnickou kartičku a nový majitel si ji položí na stůl před sebe lícem vzhůru.\n\nHráč, jehož kámen se zastaví na poli koně, který patří některému ze soupeřů, musí zaplatit prohlídku stáje za cenu uvedenou na vlastnické kartě. Je-li tento kůň obsazen do jednoho nebo více dostihů, či hlavního dostihu sezóny, cena se zvyšuje (taxy jsou uvedeny na každé kartičce).\n\nHráč, který se zastavil na poli Stáje nebo Přeprava, které patří některému ze soupeřů, zaplatí majiteli 80tinásobek hodu kostkou. Jestliže majitel vlastní obě karty, cena se zvyšuje na 200násobek.\n\nHráč, který se zastavil na poli Trenér, zaplatí jeho majiteli poplatek podle následujících sazeb:\n\tVlastní-li majitel pouze tuto jednu trenérskou licenci, hráč mu zaplatí 1.000.\n\tVlastní-li majitel celkem 2 trenérské licence, hráč mu zaplatí 2.000.\n\tVlastní-li majitel celkem 3 trenérské licence, hráč mu zaplatí 3.000.\n\tVlastní-li majitel všechny 4 trenérské licence, hráč mu zaplatí 4.000.\n\nKdyž se kámen zastaví na polích Obecní fond a Náhoda, musí hráč odebrat ze stejně pojmenované hromádky horní kartu a vykonat, co je na ní napsáno.\n\nPři zastavení na poli Veterinární vyšetření zaplatí hráč uvedený obnos.\n\nKdyž se kámen zastaví na poli Podezření z dopingu, hráč jednou nehází a v tomto vynechaném hodu se neúčastní žádného dostihu, tj. soupeři mu neplatí žádné poplatky za dostihy, vyjma poplatku za prohlídku stáje.\n\nKámen, který se zastaví na poli Distanc nebo se na něj dostal použitím katy Náhoda, nebo hodí-li hráč v průběhu hry dvakrát po sobě 6, se po dobu distance nezúčastňuje dostihů. Nikdo za spoluhráčů mu po dobu distance neplatí žádné poplatky za dostihy, pouze za prohlídku stájí. Distancovaný hráč se účastní házení kostkou ve svém pořadí. Po hození čísla 6 distanc končí a hráč hází ještě jednou. Teprve po druhém hodu postupuje na další pole.\n\nNa poli Parkoviště se neplatí žádné poplatky.\n\nVlastní-li hráč všechny koně jedné stáje (tj. jedné barvy) a zastaví-li při opětném postupu po hrací desce na kterémkoli koni této stáje, smí si koupit od banky podle své finanční situace 1 až 4 žluté žetony představující dostihy. Zakoupené žetony položí na pole koně, pro kterého dostih koupil. Zastaví-li protihráč na poli s položenými žetony, platí jejich majiteli částku, která je uvedena na kartičce.\n\nHráč, který získal všechny koně jedné stáje a má postaveného některého z těchto koní již do 4 dostihů, smí ho postavit do hlavního dostihu sezóny zakoupením červeného žetonu a vrácením žlutých. Každý kůň smí být postaven jen do jednoho hlavního dostihu sezóny.\n\nNákupy a obchodní jednání mohou probíhat i mezi jednotlivými hráči, nejen mezi hráčem a bankou. Rozhoduje pouze nabídka a poptávka. Obchodní jednání uzavírá hráč po hodu kostkou a po postoupení o odpovídající počet polí. Do jeho skončení žádný další hráč nehází, i když není účastníkem jednání.\n\nKaždý vlastník služeb nebo koně je povinen se sám přihlásit o své nároky vůči ostatním hráčům i vůči bance. V případě, že tak neučiní, dalším následujícím hodem jiného hráče jeho nároky zanikají.\n\nRiziko, které pro hráče vyplývá ze soupeřových koní postavených do dostihů nebo do hlavního dostihu, lze snížit sázením. \n\nPřed hodem položí hráč libovolné množství peněz na jednoho či více soupeřových koní, ovšem pouze na ta pole, která jsou obsazena minimálně třemi dostihy nebo hlavním dostihem. Sázky platí jen pro jeden hod. V případě, že po tomto hodu hráč skutečně zastaví na některém z koní na něhož vsadil, vyplatí mu majitel koně desetinásobek vsazené částky. I když hráč sázku vyhraje, musí zaplatit majiteli koně zisk z počtu dostihů. Nevstoupí-li na sázkou označené pole, získává sázku majitel koně. \n\nSázek na koně se smí účastnit pouze ten hráč, který sám vlastní aspoň 1 koně s minimálně třemi dostihy.\n\nNemá-li hráč dostatek financí na plnění finančních závazků, je povinen odprodat část svého majetku na jejich uhrazení. \t\t\nSlužby (stáje, přepravu, trenérské licence) může podle své úvahy odprodat buď bance za pořizovací cenu nebo ostatním hráčům za cenu libovolnou. Prodej koní probíhá následovně:\n\nJestliže vlastní celou stáj s aspoň jedním obsazeným dostihem, prodá jednomu soupeři tuto celou stáj i s dostihy za libovolnou cenu. Nelze prodávat část stáje, pokud je obsazen aspoň 1 dostih.\n\nVrátí bance libovolný počet dostihů. Banka vyplatí hráči za vrácené dostihy poloviční pořizovací cenu.\n\nNení-li žádný kůň ze stáje obsazen do žádného dostihu, může prodat soupeřům koně za libovolnou cenu nebo bance za pořizovací cenu.\n\n-------------------------------------------------------------Konec hry----------------------------------------------------\n\nVítězem se stává hráč, který zůstane jako poslední ve hře.\n\nHra pro hráče končí, nemá-li další prostředky na vyrovnání dluhů. Končí-li hru s dluhem i po odprodání veškerého majetku, dorovná jeho dluh banka.");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jButton1.setText("Zpět");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ((HlavniOkno)SwingUtilities.getWindowAncestor(this)).nastavMenu();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
