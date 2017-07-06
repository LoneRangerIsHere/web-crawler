/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartcrawlersolo;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class AdminPanelController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    
    @FXML // fx:id="AdminPanelContainer"
    private Pane AdminPanelContainer; // Value injected by FXMLLoader
    
    @FXML
    private JFXButton InsertDataBtn;

    @FXML
    private JFXButton ViewTableBtn;
    
     @FXML
    private JFXButton CrawlBtn;

    @FXML
    void frontierPage(ActionEvent event) {
        
         try{
        AdminPanelContainer.getChildren().clear();
        AdminPanelContainer.getChildren().add(FXMLLoader.load(getClass().getResource("Frontier.fxml")));
     }
      catch(Exception e){
         System.err.print(e.getMessage());
     }

    }
    
      @FXML
    void crawlPage(ActionEvent event) {
        
        try{
        AdminPanelContainer.getChildren().clear();
        AdminPanelContainer.getChildren().add(FXMLLoader.load(getClass().getResource("CrawlPage.fxml")));
     }
      catch(Exception e){
         System.err.print(e.getMessage());
     }

    }


    @FXML
    void insertDataPage(ActionEvent event) {
        
        try{
        AdminPanelContainer.getChildren().clear();
        AdminPanelContainer.getChildren().add(FXMLLoader.load(getClass().getResource("InsertSite.fxml")));
     }
      catch(Exception e){
         System.err.print(e.getMessage());
     }

    }

    @FXML
    void initialize() {
        assert InsertDataBtn != null : "fx:id=\"InsertDataBtn\" was not injected: check your FXML file 'AdminPanel.fxml'.";
         assert CrawlBtn != null : "fx:id=\"CrawlBtn\" was not injected: check your FXML file 'AdminPanel.fxml'.";
        assert ViewTableBtn != null : "fx:id=\"ViewTableBtn\" was not injected: check your FXML file 'AdminPanel.fxml'.";

    }
}
