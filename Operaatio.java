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
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
/**
 * Operaatio luokka, joka sisältää laskutoimituksen suorittavan metodin, sekä
 * tiedostoon kirjoittamisen ja sieltä lukemisen mahdollistavat metodit
 * @author JANI
 */
public class Operaatio {
    /**
     * Metodi laskee ja palauttaa operaattori muutujan mukaisen laskutoimituksen
     * switch case lauseella ja annetuilla double luku parametreilla.
     * @param num1
     * @param num2
     * @param operaattori
     * @return 
     */
    public double laske(double num1, double num2, String operaattori) {
        switch (operaattori) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0)
                    return 0;

                return num1 / num2;
        }

        
        return 0;
}
    /**
     * Metodi kirjoittaa laskutoimitus.txt tiedostoon parametrina annetun
     * laskutoimituksen tuloksen.
     * @param tulos
     * @throws Exception 
     */
     public void kirjoita(String tulos) throws Exception{
        String tiedosto = "laskutoimitus.txt";
        PrintWriter kirjoittaja = null;
        FileWriter fw = new FileWriter(tiedosto, true);
        kirjoittaja = new PrintWriter(fw);
        kirjoittaja.println(tulos);
        kirjoittaja.close();
        }
     /**
      * Metodi palauttaa viimeisimpänä laskutoimitus.txt tiedostoon kirjoitetun
      * rivin String muodossa.
      * @return
      * @throws FileNotFoundException 
      */
      public String lue()throws FileNotFoundException{
        String tiedosto = "laskutoimitus.txt";
        String rivi = "";
        File luettava = new File(tiedosto);
        Scanner lukija = new Scanner(luettava);
        while (lukija.hasNext()){
            rivi = lukija.nextLine();
        }
        lukija.close();
        return rivi;
    }
    
}
