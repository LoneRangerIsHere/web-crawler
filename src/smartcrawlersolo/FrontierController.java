/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Sample Skeleton for 'Frontier.fxml' Controller Class
 */

package smartcrawlersolo;
import backend.WebsiteList;
import backend.store;
//import backend.store;
import java.sql.Connection;
import java.sql.*;
/**
 * Sample Skeleton for 'Frontier.fxml' Controller Class
 */



import com.jfoenix.controls.JFXButton;
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

public class FrontierController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="AdminContainer"
    private Pane AdminContainer; // Value injected by FXMLLoader

    

    @FXML // fx:id="FrontierTable"
    private TableView<WebsiteList> FrontierTable; // Value injected by FXMLLoader

    @FXML // fx:id="site"
    private TableColumn<WebsiteList, String> site; // Value injected by FXMLLoader

    @FXML // fx:id="hits"
    private TableColumn<WebsiteList, Number> hits; // Value injected by FXMLLoader
    
    @FXML
    private JFXButton BackBtn;
    
      @FXML
    private JFXButton ClearBtn;
      
      @FXML
    void clearTable(ActionEvent event) {
        
        store s1 = new store();
        s1.deleteTable();
        try{
        AdminContainer.getChildren().clear();
        AdminContainer.getChildren().add(FXMLLoader.load(getClass().getResource("Frontier.fxml")));
     }
      catch(Exception e){
         System.err.print(e.getMessage());
     }
        

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
        
        site.setCellValueFactory(cellData -> cellData.getValue().WebSiteProperty());
        hits.setCellValueFactory(cellData -> cellData.getValue().SiteHitsProperty());
        
        //for filling the table
        Connection co =null;
        PreparedStatement preparedStmt = null;
        String query;
        ResultSet rs = null;
         
         try{
        
            System.out.println(" tag success");
            Class.forName("com.mysql.jdbc.Driver"); 
            co=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","root","root");
            query = "select * from frontier";
            preparedStmt = co.prepareStatement(query);
             rs = preparedStmt.executeQuery();
            final ObservableList<WebsiteList> data = FXCollections.observableArrayList();
        
            while(rs.next()){
            System.out.println(rs.getString("Site"));
            
            data.add(new WebsiteList(rs.getString("site"),rs.getInt("hits")));
           
            }
            
             FrontierTable.setItems(data);
           
            co.close();
            preparedStmt.close();
           
            
        }
        
        catch(Exception e){System.err.println(e.getMessage());}
        
        finally{
           try{preparedStmt.close();} catch(Exception e){}
            
           try{co.close();}catch(Exception e){}
        }

        
        assert AdminContainer != null : "fx:id=\"AdminContainer\" was not injected: check your FXML file 'Frontier.fxml'.";
        
        assert FrontierTable != null : "fx:id=\"FrontierTable\" was not injected: check your FXML file 'Frontier.fxml'.";
        assert site != null : "fx:id=\"site\" was not injected: check your FXML file 'Frontier.fxml'.";
        assert hits != null : "fx:id=\"hits\" was not injected: check your FXML file 'Frontier.fxml'.";

    }
}
