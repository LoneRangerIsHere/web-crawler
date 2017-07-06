/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartcrawlersolo;

import com.jfoenix.controls.JFXDecorator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;
import javafx.stage.StageStyle;


/**
 *
 * @author solaman
 */
public class SmartCrawlerSolo extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Screen screen = Screen.getPrimary();
//Rectangle2D bounds = screen.getVisualBounds();
Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        setUserAgentStylesheet(STYLESHEET_MODENA);

JFXDecorator decorator = new JFXDecorator(stage, root,false,false,true);
//decorator.setTitle("SmartCrawler");
//decorator.setCustomMaximize(true);
//decorator.customMaximize.setValue(false);

Scene scene = new Scene(decorator);
        
        
        //Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
