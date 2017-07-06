/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Sample Skeleton for 'CrawlPage.fxml' Controller Class
 */

package smartcrawlersolo;
import backend.Spider;
import backend.store;

import backend.WebsiteList;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

public class CrawlPageController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="AdminPanelContainer"
    private Pane AdminContainer; // Value injected by FXMLLoader

    @FXML // fx:id="AutoKey"
    private JFXTextField AutoKey; // Value injected by FXMLLoader

    @FXML // fx:id="AutoCrawlBtn"
    private JFXButton AutoCrawlBtn; // Value injected by FXMLLoader

    @FXML // fx:id="ManualSeed"
    private JFXTextField ManualSeed; // Value injected by FXMLLoader

    @FXML // fx:id="ManualKey"
    private JFXTextField ManualKey; // Value injected by FXMLLoader

    @FXML // fx:id="ManualCrawlBtn"
    private JFXButton ManualCrawlBtn; // Value injected by FXMLLoader

    @FXML // fx:id="SIteTable"
    private TableView<CrawlData> SIteTable; // Value injected by FXMLLoader

    @FXML // fx:id="SiteColumn"
    private TableColumn<CrawlData, String> SiteColumn; // Value injected by FXMLLoader

    @FXML // fx:id="BackBtn"
    private JFXButton BackBtn; // Value injected by FXMLLoader

    @FXML
    void autoCrawl(ActionEvent event) {
            
        String [] res = new String[10];
        String SearchTermAuto = AutoKey.getText().toString();
        store s = new store();
        //res = s.checking(SearchTermAuto);
        
       // String SiteAddAuto = s.autoCrawling(SearchTermAuto);
        res = s.checking(SearchTermAuto);
        
        
        
        
        final ObservableList<CrawlData> data = FXCollections.observableArrayList();
       // String [] cont = new String[10];
        /*Spider SL = new Spider();
        try{
            for(String sub:res){
                System.out.println("searching in"+sub);
        cont = SL.search(sub,SearchTermAuto);
       // SL.search(SiteAddAuto,SearchTermAuto);
        for(String c:cont){
            
        data.add(new CrawlData(c));
        }
        SIteTable.setItems(data);
            }
        }
        catch(Exception e){
            System.out.println("error in cont");
            System.out.print(e.getMessage());
        System.out.println("error in cont confirm");}
        */
        
        for(String sub:res){
            System.out.println(sub);
            Spider S = new Spider();
            String cont []=S.search(sub,SearchTermAuto);
            //System.out.println(cont[0]);
            data.add(new CrawlData(cont[0]));
            System.out.println("end of a loop");
            if(data.size()>5)
                break;
            
        }
        
        for(CrawlData add: data)
            System.out.println(add.getSite());
        SIteTable.setItems(data);
        
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

    @FXML
    void manualCrawl(ActionEvent event) {
        
        String SiteAdd = ManualSeed.getText().toString();
        String SearchTerm = ManualKey.getText().toString();
        String [] cont = new String[10];
        final ObservableList<CrawlData> data = FXCollections.observableArrayList();
        Spider SL = new Spider();
        try{
        cont = SL.search(SiteAdd,SearchTerm);
        //SL.search(SiteAdd,SearchTerm);
        for(String c:cont){
            
        data.add(new CrawlData(c));
        SIteTable.setItems(data);
        }
        //SIteTable.setItems(data);
        }
        catch(Exception e){
            System.out.println("error in cont");
            System.out.print(e.getMessage());
        System.out.println("error in cont confirm");}
        

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        
        SiteColumn.setCellValueFactory(cellData -> cellData.getValue().SiteProperty());
        assert AdminContainer != null : "fx:id=\"AdminPanelContainer\" was not injected: check your FXML file 'CrawlPage.fxml'.";
        assert AutoKey != null : "fx:id=\"AutoKey\" was not injected: check your FXML file 'CrawlPage.fxml'.";
        assert AutoCrawlBtn != null : "fx:id=\"AutoCrawlBtn\" was not injected: check your FXML file 'CrawlPage.fxml'.";
        assert ManualSeed != null : "fx:id=\"ManualSeed\" was not injected: check your FXML file 'CrawlPage.fxml'.";
        assert ManualKey != null : "fx:id=\"ManualKey\" was not injected: check your FXML file 'CrawlPage.fxml'.";
        assert ManualCrawlBtn != null : "fx:id=\"ManualCrawlBtn\" was not injected: check your FXML file 'CrawlPage.fxml'.";
        assert SIteTable != null : "fx:id=\"SIteTable\" was not injected: check your FXML file 'CrawlPage.fxml'.";
        assert SiteColumn != null : "fx:id=\"SiteColumn\" was not injected: check your FXML file 'CrawlPage.fxml'.";
        assert BackBtn != null : "fx:id=\"BackBtn\" was not injected: check your FXML file 'CrawlPage.fxml'.";

    }
}

