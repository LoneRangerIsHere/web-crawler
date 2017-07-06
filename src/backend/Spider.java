/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Spider
{
  private  final int MAX_PAGES_TO_SEARCH = 10;
  private  Set<String> pagesVisited = new HashSet<String>();
  private  List<String> pagesToVisit = new LinkedList<String>(new HashSet<String>());
 
  private  Set<String> pagesTagged = new HashSet<String>();
  List<String> temp = new LinkedList<String>(new HashSet<String>()); 

    store soo = new store();
  /**
   * Our main launching point for the Spider's functionality. Internally it creates spider legs
   * that make an HTTP request and parse the response (the web page).
   * 
   * @param url
   *            - The starting point of the spider
   * @param searchWord
   *            - The word or string that you are searching for
   */
    
  public   String[] search(String url, String searchWord)
  {
     
      search s1 = new search();
      int flag=0;
      boolean success =false;
      String currentUrl;
      SpiderLeg leg = new SpiderLeg();
      String [] ret = new String[10];       //set of websites returned
      
      try{
      System.out.println("searching for "+searchWord);
      while(this.pagesVisited.size() < MAX_PAGES_TO_SEARCH)
      {
          
          
          
          //running for the first time or pagestovisit is empty
          if(this.pagesToVisit.isEmpty())
          {
               flag = 0; // for not executing the comparison for the first time 
              currentUrl = url;
              this.pagesVisited.add(url);
              
          }
          else
          {
              
              currentUrl = this.nextUrl();      //moves to the next url in the pagesToVisit list
          }
         
        
         
         //CHECK AND ADD ALL LINKS INTO paegsToVisit WITHOUT DUPLICATE  
         
         temp.addAll(leg.crawl(currentUrl,searchWord));     //extracts all the links in the current url which has keyword in it
               
        if(temp.size()==0)
        {
            System.out.println("No url has keyword in it...further search not possible breaking");      
            break;
        }
         

        //executed if its not the first time crawls is called...since for the first time we will have no value in pagesToVisit and cannot compare
        if(flag!=0){      
          for(String chkTemp:temp){
              for(String chkMain:pagesToVisit)
                  if(chkTemp.equals(chkMain)==false)
                      this.pagesToVisit.add(chkTemp);
                }
            }
        else
             this.pagesToVisit.addAll(temp);
             
         
         temp.clear();
          
         
          
          
       
          success = s1.find(searchWord,currentUrl);     //Insite Exploration - searching the selected webpages for keyword
       
          if(success)
          {
             System.out.println("**Success** Word %s found at %s"+ searchWord+currentUrl);
             soo.collect(currentUrl);
             pagesTagged.add(currentUrl);
             soo.addTag(searchWord,currentUrl);
             
              //break;
          } 
         
              
        
        }
      
      System.out.println("\n**Done** Visited " + this.pagesVisited.size() + " web page(s)");
      
      
      int nav=0;// for returning the last elemnt of pagesTagged
     
      // pages tagged all the pages with matching keyword to return
      for(String k : pagesTagged)
          {
              
              ret[nav]=k;
              nav++;
          }
       
       /*for(String n:ret){
           System.out.println(n);
       }*/
      
       
       }
      catch(Exception e){System.out.print("defininte erro"+e.getMessage());}
      
      return ret;
  }
  

 

  /**
   * Returns the next URL to visit (in the order that they were found). We also do a check to make
   * sure this method doesn't return a URL that has already been visited.
   * 
   * @return
   */
  private String nextUrl()
  {
      String nextUrl;
      do
      {
          nextUrl = this.pagesToVisit.remove(0);
      } while(this.pagesVisited.contains(nextUrl));
      this.pagesVisited.add(nextUrl);
      return nextUrl;
  }
  
 /* public static void main(String[] args){
    search("https://en.wikipedia.org/wiki/Computer","computer");
}*/
  
}
