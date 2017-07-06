/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SpiderLeg
{
    // We'll use a fake USER_AGENT so the web server thinks the robot is a normal web browser.
    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    
    private Document htmlDocument;
    
    public String arr = new String();
    int i=0;
    store so = new store();


    /**
     * This performs all the work. It makes an HTTP request, checks the response, and then gathers
     * up all the links on the page. Perform a searchForWord after the successful crawl
     * 
     * @param url
     *            - The URL to visit
     * @return whether or not the crawl was successful
     */
    public Set crawl(String url,String kw)
    {
        //List<String> links = new LinkedList<String>(new HashSet<String>());
        Set<String> links = new HashSet<>();
        //links.clear();
        try
        {
             
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            Document htmlDocument = connection.get();
            this.htmlDocument = htmlDocument;
            if(connection.response().statusCode() == 200) // 200 is the HTTP OK status code
                                                          // indicating that everything is great.
            {
                System.out.println("\n**Visiting** Received web page at " + url);
               // so.collect(url);
            }
            if(!connection.response().contentType().contains("text/html"))
            {
                System.out.println("**Failure** Retrieved something other than HTML");
                return null;
            }
            Elements linksOnPage = htmlDocument.select("a[href]");
            System.out.println("Found (" + linksOnPage.size() + ") links");
            int c =0;
            for(Element link : linksOnPage)
            {
                
                if(link.absUrl("href").toString().contains(kw)){
                
               // System.out.println(link.attr("href").toString());
                links.add(link.absUrl("href"));}
                
               else
                    c++;
                  //  System.out.println("fail");
                //so.collect(link.absUrl("href"));
            }
           System.out.println(c);
            
        }
        catch(IOException ioe)
        {
            // We were not successful in our HTTP request
            //return false;
            System.out.println("error");
        }
        System.out.println("End in crawl");
        return links;
    }


    /**
     * Performs a search on the body of on the HTML document that is retrieved. This method should
     * only be called after a successful crawl.
     * 
     * @param searchWord
     *            - The word or string to look for
     * @return whether or not the word was found
     */
    public boolean searchForWord(String searchWord)
    {
        // Defensive coding. This method should only be used after a successful crawl.
        if(this.htmlDocument == null)
        {
            System.out.println("ERROR! Call crawl() before performing analysis on the document");
            return false;
        }
        System.out.println("Searching for the word " + searchWord + "...");
        String bodyText = this.htmlDocument.body().text();
        System.out.println(bodyText);
        return bodyText.toLowerCase().contains(searchWord.toLowerCase());
    }


  /*  public List<String> getLinks()
    {
        return this.links;
    }*/

}
