/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
/**
 * Ohjelman kontrolleri
 * @author JANI
 */
public class Kontrolleri {
    /**
     * Laskimen näyttöön tulostuva teksti
     */
    @FXML
    private Text tulos;
    
    private double numero1 = 0;
    private String operaattori = "";
    /**
     * Totuusarvo uuden laskutoimituksen 
     * alkamisen määrittämiseen
     */
    private boolean aloita = true;
    

    /**
     * Operaatio luokan olio
     */
    private Operaatio operaatio = new Operaatio();
   
    /**
     * Metodi käsittelee laskimen numeronäppäimiä,
     * kopioimalla näppäimen tekstin laskimen näytölle
     * @param e 
     */
    @FXML
    private void numerot(ActionEvent e) {
        if (aloita) {
            tulos.setText("");
            aloita = false;
        }

        String arvo = ((Button)e.getSource()).getText();
        tulos.setText(tulos.getText() + arvo);
    }

    /**
     * Metodi käsittelee laskimen operaattorinäppäimiä.
     * Painikkeen teksti määrittää halutun laskutoimituksen, joka
     * saadaan Operaatio luokan metodin laske() avulla. Jos käyttäjä
     * painaa '=' näppäintä, metodi tallentaa laskimen näytöllä olevan tekstin
     * laskutoimitus.txt tiedostoon, Operaatio luokan kirjoita() metodin avulla.
     * @param e 
     */
    @FXML
    private void operaattorit(ActionEvent e) {
        String arvo = ((Button)e.getSource()).getText();

        if (!"=".equals(arvo)) {
            if (!operaattori.isEmpty())
                return;

            operaattori = arvo;
            numero1 = Double.parseDouble(tulos.getText());
            tulos.setText("");
        }
       
        else {
            if (operaattori.isEmpty())
                return;

            /**
             * Ohjelma asettaa tulos muuttujan arvoksi laske() metodin antaman
             * palautteen, sekä tallentaa tuloksen tiedostoon kirjoita() metodilla.
             */
            tulos.setText(String.valueOf(operaatio.laske(numero1, Double.parseDouble(tulos.getText()), operaattori)));
            try {
                operaatio.kirjoita(tulos.getText());
            } catch (Exception ex) {
                Logger.getLogger(Kontrolleri.class.getName()).log(Level.SEVERE, null, ex);
            }
            operaattori = "";
            aloita = true;
        }      
}
    /**
     * Jos käyttäjä paina tyhjennä painiketta ('CE'), tulos muuttuja asettuu
     * tyhjäksi.
     * @param e 
     */
    @FXML
    public void tyhjenna(ActionEvent e){
        String arvo = ((Button)e.getSource()).getText();
        if("CE".equals(arvo)){
            tulos.setText("");
        }
        
    }
    /**
     * Metodi 'ANS' näppäimelle, joka kutsuu Operaatio luokan lue() metodia ja
     * asettaa tulos muuttujan arvoksi viimeisimpänä laskutoimitus.txt 
     * tiedostoon tallennetun rivin.
     * 
     */
    @FXML
    public void palauta(){
        try {
            tulos.setText(operaatio.lue());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Kontrolleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
     
    
       
}
     
     
         
      
         
     
    

