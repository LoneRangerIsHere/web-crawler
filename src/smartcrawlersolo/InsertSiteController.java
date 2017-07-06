/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Sample Skeleton for 'InsertSite.fxml' Controller Class
 */


package smartcrawlersolo;
import backend.store; 

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class InsertSiteController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="AdminContainer"
    private Pane AdminContainer; // Value injected by FXMLLoader

    @FXML // fx:id="SiteAdd"
    private JFXTextField SiteAdd; // Value injected by FXMLLoader

    @FXML // fx:id="AddBtn"
    private JFXButton AddBtn; // Value injected by FXMLLoader

    @FXML // fx:id="Status"
    private Label Status; // Value injected by FXMLLoader

    @FXML // fx:id="Keyword"
    private JFXTextField Keyword; // Value injected by FXMLLoader
    
    @FXML
    private JFXButton BackBtn;

    @FXML // fx:id="InsertStatus"
    private Label InsertStatus; // Value injected by FXMLLoader

    @FXML
    void addSite(ActionEvent event) {
        
        store s = new store();
        
        String site = SiteAdd.getText();
        String key = Keyword.getText();
        s.InsertLink(site, key);
        InsertStatus.setText("Site Inserted Successfully");
        SiteAdd.clear();
        Keyword.clear();
       // InsertStatus.setText("");

    }
    
    @FXML
    void goBack(ActionEvent event) {
            try{
        AdminContainer.getChildren().clear();
        AdminContainer.getChildren().add(FXMLLoader.load(getClass().getResource("AdminPanel.fxml")));
     }
      catch(Exception e){
         System.err.print(e.getMessage());
     }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert AdminContainer != null : "fx:id=\"AdminContainer\" was not injected: check your FXML file 'InsertSite.fxml'.";
        assert SiteAdd != null : "fx:id=\"SiteAdd\" was not injected: check your FXML file 'InsertSite.fxml'.";
        assert AddBtn != null : "fx:id=\"AddBtn\" was not injected: check your FXML file 'InsertSite.fxml'.";
        assert Status != null : "fx:id=\"Status\" was not injected: check your FXML file 'InsertSite.fxml'.";
        assert Keyword != null : "fx:id=\"Keyword\" was not injected: check your FXML file 'InsertSite.fxml'.";
        assert InsertStatus != null : "fx:id=\"InsertStatus\" was not injected: check your FXML file 'InsertSite.fxml'.";

    }
}

