/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartcrawlersolo;

/**
 * Sample Skeleton for 'HomePage.fxml' Controller Class
 */

//package smartcrawlersolo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class HomePageController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="HomeBtn"
    private Button HomeBtn; // Value injected by FXMLLoader

    @FXML // fx:id="AdminBtn"
    private Button AdminBtn; // Value injected by FXMLLoader
    
      @FXML // fx:id="Main"
    private Pane Changing; // Value injected by FXMLLoader


    @FXML // fx:id="AboutBtn"
    private Button AboutBtn; // Value injected by FXMLLoader

    @FXML // fx:id="Status"
    private Label Status; // Value injected by FXMLLoader

    @FXML // fx:id="QueryField"
    private TextField QueryField; // Value injected by FXMLLoader

    @FXML // fx:id="SearchBtn"
    private Button SearchBtn; // Value injected by FXMLLoader

    @FXML // fx:id="ResultList"
    private ListView<?> ResultList; // Value injected by FXMLLoader

    @FXML // fx:id="Browser"
    private WebView Browser; // Value injected by FXMLLoader
    
    @FXML
    void homePage(ActionEvent event) {

         try{
        Changing.getChildren().clear();
        Changing.getChildren().add(FXMLLoader.load(getClass().getResource("HomePagePart.fxml")));
     }
      catch(Exception e){
         System.err.print(e.getMessage());
     }
     
    }

    @FXML
    void adminBtn(ActionEvent event) {
        
     try{
        Changing.getChildren().clear();
        Changing.getChildren().add(FXMLLoader.load(getClass().getResource("LogInPart.fxml")));
     }
      catch(Exception e){
         System.err.print(e.getMessage());
     }
     
     
    }
      @FXML
    void searchPageBtn(ActionEvent event) {
        
         try{
        Changing.getChildren().clear();
        Changing.getChildren().add(FXMLLoader.load(getClass().getResource("Search.fxml")));
     }
      catch(Exception e){
         System.err.print(e.getMessage());
     }

    }
    
     @FXML
    void aboutPage(ActionEvent event) {
        
        try{
          Changing.getChildren().clear();
          Changing.getChildren().add(FXMLLoader.load(getClass().getResource("About.fxml")));
     }
      catch(Exception e){
         System.err.print(e.getMessage());
     }

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert HomeBtn != null : "fx:id=\"HomeBtn\" was not injected: check your FXML file 'HomePage.fxml'.";
        assert AdminBtn != null : "fx:id=\"AdminBtn\" was not injected: check your FXML file 'HomePage.fxml'.";
        assert AboutBtn != null : "fx:id=\"AboutBtn\" was not injected: check your FXML file 'HomePage.fxml'.";
        assert Status != null : "fx:id=\"Status\" was not injected: check your FXML file 'HomePage.fxml'.";
        assert QueryField != null : "fx:id=\"QueryField\" was not injected: check your FXML file 'HomePage.fxml'.";
        assert SearchBtn != null : "fx:id=\"SearchBtn\" was not injected: check your FXML file 'HomePage.fxml'.";
        assert ResultList != null : "fx:id=\"ResultList\" was not injected: check your FXML file 'HomePage.fxml'.";
        assert Browser != null : "fx:id=\"Browser\" was not injected: check your FXML file 'HomePage.fxml'.";

    }
}
