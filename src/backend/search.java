/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.IOException;
import org.jsoup.Connection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class search {
private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
boolean stat=false;
    public   boolean find(String KW,String lnk)  {
        
            
            
            String MKeyword = null;
            String MDescription = null;
            
        try{
                
            String ToSearch = KW.toLowerCase(); //the keyword to be searched
            String SearchString=null;
            System.out.println("searching"+ToSearch);
            
            //getting connection via Jsoup library
            Connection connection = Jsoup.connect(lnk).userAgent(USER_AGENT);
           
            //parse the html document
            Document doc = connection.get();
            System.out.println("connection success");
            
            //get the Meta Keyword if present
            try{
             MKeyword = doc.select("meta[name = keywords]").first().attr("content").toLowerCase(); //meta keyword
            }
            catch(Exception e){System.err.print(e.getMessage());}
            
            System.out.println(MKeyword);
            
            //get the meta description if present
            try{
            
            MDescription = doc.select("meta[name=description]").get(0) .attr("content"); }
            catch(Exception e){System.err.print(e.getMessage());}
            
            
            //Title Tag
            System.out.println("Title success");
            String Title = doc.title();
            Title.toLowerCase();
            System.out.println(Title);
            
            //getting all the header tags
            Elements authors = doc.select("h0,h1,h2,h3,h4,h5,h6"); //selector combination
                
            System.out.println("selecting success");
		
            //checking if the keyword is present in any of the header tags
            for(Element author : authors){
                    
                //gets only the elements between the h tags
                SearchString = author.text();
                //System.out.println(SearchString);
               // System.out.println("Success is here");
                if(SearchString.toLowerCase().contains(ToSearch)){
                    stat = true;
                    System.out.println("Success is here");
                    break;
                }
                        
            }
            
           
            
            
            System.out.println("Desc success"); 
            System.out.println(MKeyword);
              
            System.out.println(MDescription);
		
          
            //checking if meta keyword,description or title contain the keyword to be searched
            if(MKeyword.contains(ToSearch)||Title.contains(ToSearch)||MDescription.contains(ToSearch)){
                 System.out.println("Success is here");
               stat = true;
            }
            
            
            
               
        }
                        
        catch(Exception e){ System.err.println("in Sh"+e.getMessage());}
	
        return stat;	
    }
    
   /* public static void main(String[] args){
        
        String site = "https://en.wikipedia.org/wiki/Computer";
        String key = "computer";
        boolean flag =find(key,site);
        
    }*/
    
   
}
