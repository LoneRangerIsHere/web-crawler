/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author solaman
 */
public class WebsiteList {
    
     private final StringProperty WebSite;
     private final IntegerProperty SiteHits;
    
    public WebsiteList(){
        
       this.WebSite = null;
       this.SiteHits = null;
    }
    
    public WebsiteList (String Site,int Hit){
        this.WebSite = new SimpleStringProperty(Site);
        this.SiteHits = new SimpleIntegerProperty(Hit);
    }
    
    public String getWebSite(){
        return this.WebSite.get();
    }
    
    public void setWebSite(String site){
        this.WebSite.set(site);
    }
    
    public StringProperty WebSiteProperty(){
        return WebSite;
    }
    
    public int getSiteHits(){
        return SiteHits.get();
    }
    
    public void setSiteHits(int hit){
        this.SiteHits.set(hit);
    }
    
    public IntegerProperty SiteHitsProperty(){
        return SiteHits;
    }
    
}
