/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Laskimen pääohjelma, joka käynnistää ohjelman ja asettaa
 * näkymäksi ui.fxml tiedoston.
 * @author JANI
 */
public class Sovellus extends Application {
    
    /**
     * Start metodi, joka asettaa ohjelman näkymäksi ui.fxml tiedoston.
     * @param primaryStage
     * @throws Exception 
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
     Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));

        primaryStage.setScene(new Scene(root)); 
        primaryStage.show();
    }
    

    /**
     * Main metodi, käynnistää ohjelman
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
