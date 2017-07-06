/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;


/**
 *
 * @author solaman
 */
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.sql.*;

/*<applet code="Factorial" width=500 height=200></applet>*/

public class front extends Applet implements ActionListener
{
            TextField input,output;
            Button compute;
            int fact=0;
            ResultSet r = null;
            String res;
            public void init()
            {
                        compute=new Button("search");
                        Label inp=new Label("Enter any number :",Label.RIGHT);
                        
                        input=new TextField(10);
                       
                        input.setBackground(Color.pink);
                        output = new TextField(20);
                        
                        add(inp);
                        add(input);
                        
                        add(output);
                        add(compute);
                        
                        input.addActionListener(this);
                        output.addActionListener(this);
                        
                        compute.addActionListener(this);
            }
            public void actionPerformed(ActionEvent ae)
            {         
                        String str=ae.getActionCommand();
                        String KeyWord = input.getText();
                        String SiteAdd = "http://www.wordstream.com/seo-keyword" ;
                        
                        // Spider spider = new Spider();
       //spider.search(SiteAdd,KeyWord);
       store s = new store();
       /*String [] str1 = new String[5];
       str1 =s.checking(KeyWord);
       try{
       for(String sto :str1){
           
          if(sto!=null){
         // System.out.println(sto);
           //output.setText(sto);
          }
       }
      
       }
       catch(Exception e){System.err.println(e.getMessage());}*/
       
         s.InsertLink("www.yahoo.com","yahoo");
                        
                                   
            } }
                        //repaint();
                                               
            
            

