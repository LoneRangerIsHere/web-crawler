/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Sample Skeleton for 'Search.fxml' Controller Class
 */

package smartcrawlersolo;
import backend.*;

import javafx.scene.control.TextField;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class SearchController {
    
    String [] kw = new String [5];
    public Scene scene,AdminMenu;
    Stage stg1;
    String url;
   // String [] kw = new String [5];
     ObservableList<Hyperlink> links = FXCollections.observableArrayList();
    //final WebView browser = new WebView();
        // final  WebEngine webEngine = Browser.getEngine();
    final ListView listView = new ListView();
    

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="QueryBox"
    private TextField QueryBox; // Value injected by FXMLLoader

    @FXML // fx:id="QuerySearchBtn"
    private JFXButton QuerySearchBtn; // Value injected by FXMLLoader

    @FXML // fx:id="ResultField"
    private JFXListView<Hyperlink> ResultField; // Value injected by FXMLLoader

    @FXML // fx:id="Browser"
    private WebView Browser; // Value injected by FXMLLoader
    
    
    @FXML   //for searching
    void Search(ActionEvent event) {
        
                    
                    links.clear();
                    ResultField.getItems().clear();
                    
                    String url = QueryBox.getText();
       
         

                        ReverseSearch rs = new ReverseSearch();
                        //kw=rs.getDataFromGoogle(url);         //for fetting link from google
                        kw = rs.getDataFromDatabase(url);       //for getting links from database
                        //l.setText(kw);
                       //// kw[0] = url;
                        for(String j:kw){
                         System.out.println("visiting"+j);
                         //ResultField.getItems().add(j);
                        addLink(j);
                       //// }
                        //webEngine.load(kw);
                        }
                        
                        
       
                    
        
    }
    
    private void addLink(final String url) {
        final Hyperlink link = new Hyperlink(url);
        links.add(link);
        link.setOnAction(new EventHandler<ActionEvent>() {

           @Override
            public void handle(ActionEvent t) {
                store s = new store();
                    s.incrementCount(link.getText());
                     final WebEngine  webEngine = Browser.getEngine();
               webEngine.load(link.getText());
               // getHostServices().showDocument(link.getText());
                //openBrowser(link.getText());
            }

        });
        ResultField.setItems(FXCollections.observableArrayList(links));
    }

    
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert QueryBox != null : "fx:id=\"QueryBox\" was not injected: check your FXML file 'Search.fxml'.";
        assert QuerySearchBtn != null : "fx:id=\"QuerySearchBtn\" was not injected: check your FXML file 'Search.fxml'.";
        assert ResultField != null : "fx:id=\"ResultField\" was not injected: check your FXML file 'Search.fxml'.";
        assert Browser != null : "fx:id=\"Browser\" was not injected: check your FXML file 'Search.fxml'.";

    }
    
    

}

 
