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
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ReverseSearch {

  private static Pattern patternDomainName;
  private Matcher matcher;
  
  private static final String DOMAIN_NAME_PATTERN
	= "([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,6}";
  static {
	patternDomainName = Pattern.compile(DOMAIN_NAME_PATTERN);
  }

 /* public static void chk(String[] args) {
String k="";
	ReverseSearch obj = new ReverseSearch();
	Set<String> result = obj.getDataFromGoogle("computer");
	for(String temp : result){
		System.out.println(temp);
                k = temp;
	}
        System.out.println(k);
	
  }*/

  public String getDomainName(String url){

	String domainName = "";
	matcher = patternDomainName.matcher(url);
	if (matcher.find()) {
		domainName = matcher.group(0).toLowerCase().trim();
	}
	return domainName;

  }
 
  //truncates the url into the rquired url of the webpage
  public String trunc(String lnk){
     
      Pattern pattern = Pattern.compile("http.*");
      Matcher matcher = pattern.matcher(lnk);
      String k="";
      int i =0;
      while (matcher.find())
      {
    
            k= matcher.group();
            i++;
        }

        String [] j = k.split("&");
        System.out.println(j[0]);
        return(j[0]);
    }

  public void getDataFromGoogle(String query) {

	Set<String> result = new HashSet<String>();
	String request = "http://www.google.com/search?q=" + query + "&num=11";
	//System.out.println("Sending request..." + request);
        String pg [] = new String[11];
        store s = new store();

	try {

		// need http protocol, set this as a Google bot agent :)
		Document doc = Jsoup
			.connect(request)
			.userAgent(
			  "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)").timeout(5000).get();

		// get all links
		Elements tag = doc.getElementsByTag("h3");
                Elements links = tag.select("a[href]");
                
                int count = 0;
		for (Element link : links) {
                    
                       //calls function to return the link of the desired webpage
                      //System.out.println(trunc(link.toString()));
                           pg[count++] = trunc(link.toString());
                           s.InsertLink(pg[count-1],query);
			
                      //gets the homepage of those urls
                      String temp = link.attr("href");
			if(temp.startsWith("/url?q=")){
                                //use regex to get domain name
//System.out.println(getDomainName(temp));
                                //if(count>2)
                                   //break;
			}
                        

		}

	} 
        catch (Exception e) {
		System.err.println(e.getMessage());}
       for(String m:pg){
           System.out.println(m);
       }
	//return pg;
  }
 
  public String[] getDataFromDatabase(String url){
      store s = new store();
      String [] str1 = new String[5];
       
        //empty the array
        for(int i=0; i<str1.length; i++){
            str1[i] = null;
        }
       
        //checking if present in database
        str1 =s.checking(url);
       
      
        //to check if array is empty,ie if data is not present in DB array will be empty then we will go with the google search
        boolean empty = true;                                                                    
        for (int i=0; i<str1.length; i++) {
            if (str1[i] != null) {
                empty = false;
                break;
             }
        }
            
       
        //if it is not present in DB ,search in google and get links
       if (empty == true){
           getDataFromGoogle(url);
           str1 = getDataFromDatabase(url);
       }     
      
       
       return str1;
  }

}
