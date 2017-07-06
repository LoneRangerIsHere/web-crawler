/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.applet.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class SpiderTest 
{
    /**
     * This is our test. It creates a spider (which creates spider legs) and crawls the web.
     * 
     * @param args
     *            - not used
     */     public static void main(String[] args)
    {
        try{
        
           // NewJApplet j = new NewJApplet();
        //the address and the keyword to be searched(later need to introduce interface
        String SiteAdd = "http://androidcentral.com/contests?utm_medium=burger&utm_campaign=navigation&utm_source=ac" ;
        String KeyWord = "KeYwOrd" ; 
        
        //calling the search function
        //search spider = new search();
        //spider.find(KeyWord,SiteAdd);
        ReverseSearch r = new ReverseSearch();
        
        String add =r.getDomainName(SiteAdd);
        System.out.println(add);
        System.out.println(getTitle(add));
        
        }
        
        catch(Exception e){
            System.out.println("main error");
        }
        
        
        
     }
     
     static String getTitle(String url){
         String
                 Title=null;
         try{
         
         final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
         String crc = "http://"+url+"/";
         System.out.println(crc);
         //Document htmlDocument;
         org.jsoup.Connection connection = Jsoup.connect(crc).userAgent(USER_AGENT);
         Document doc = connection.get();
         Title = doc.title();
         System.out.println(doc.title());
         }
         catch(Exception e){
             System.err.print(e.getMessage());}
         return Title;
         }
         
     }
