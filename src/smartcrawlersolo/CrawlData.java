/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartcrawlersolo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author solaman
 */

//for Crawling table ->data model
public class CrawlData {
    
    private final StringProperty Site;
    
    public CrawlData(){
        this.Site = null;
    }
    
    public CrawlData(String st){
        this.Site = new SimpleStringProperty(st);
    }
    
    public String getSite(){
        return this.Site.get();
    }
    
    public void setSite(String site){
        this.Site.set(site);
    }
    
    public StringProperty SiteProperty(){
        return Site;
    }
}
