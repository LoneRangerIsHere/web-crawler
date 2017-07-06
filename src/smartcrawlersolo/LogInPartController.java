/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Sample Skeleton for 'LogInPart.fxml' Controller Class
 */

package smartcrawlersolo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class LogInPartController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
         @FXML // fx:id="AdminContainer"
    private Pane AdminContainer; // Value injected by FXMLLoader

    @FXML // fx:id="UNameField"
    private JFXTextField UNameField; // Value injected by FXMLLoader

    @FXML // fx:id="LogInBtn"
    private JFXButton LogInBtn; // Value injected by FXMLLoader

    @FXML // fx:id="PWordField"
    private JFXPasswordField PWordField; // Value injected by FXMLLoader
    
    @FXML // fx:id="Status"
    private Label Status; // Value injected by FXMLLoader

    @FXML
    void logIn(ActionEvent event) {
        String User = UNameField.getText();
                 String Password = PWordField.getText();
                 System.out.println(User);
                 System.out.println(Password);
                 if(User.equals("admin")&&Password.equals("admin")){
                     UNameField.clear();
                     PWordField.clear();
                     System.out.println("hi");
                     try{
        AdminContainer.getChildren().clear();
        AdminContainer.getChildren().add(FXMLLoader.load(getClass().getResource("AdminPanel.fxml")));
     }
      catch(Exception e){
         System.err.print(e.getMessage());
     }
     
                 }
                 else{
                     UNameField.clear();
                     PWordField.clear();
                     Status.setText("Invalid Credentials");
                  
                 }

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert UNameField != null : "fx:id=\"UNameField\" was not injected: check your FXML file 'LogInPart.fxml'.";
        assert LogInBtn != null : "fx:id=\"LogInBtn\" was not injected: check your FXML file 'LogInPart.fxml'.";
        assert PWordField != null : "fx:id=\"PWordField\" was not injected: check your FXML file 'LogInPart.fxml'.";

    }
}

