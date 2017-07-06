/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import java.sql.Connection;
import java.sql.*;

/**
 *
 * @author solaman
 */
public class store {
    
     
  Connection co =null;
  PreparedStatement preparedStmt = null;
  String query;
  ResultSet rs = null;
    
  //for storing the extracted urls into the database  
  public  void collect(String lnk){
    try{
            
        Class.forName("com.mysql.jdbc.Driver"); 
        co=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","root","root");
        query = " insert into frontier (site)" + "values (?)";
        preparedStmt = co.prepareStatement(query);
        System.out.println("preparing success");
        preparedStmt.setString (1, lnk);
        System.out.println("sub success");
        preparedStmt.execute();
        System.out.println("execute success");
        co.close();
        preparedStmt.close();
    }
     
    catch(Exception e){
           
       System.out.println("error");
       System.err.println(e.getMessage());
    }
        
    finally{
        
        //for closing the connection
        
        try{preparedStmt.close();} catch(Exception e){}
            
        try{co.close(); }catch(Exception e){}

        }
    }
    
    //for adding tag to the urls if a match is found
    public  void addTag(String kw,String add){
        
        try{
        
            System.out.println(" tag success");
            Class.forName("com.mysql.jdbc.Driver"); 
            co=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","root","root");
            query = " update frontier set tag = ? where site = ? ";
            preparedStmt = co.prepareStatement(query);
            preparedStmt.setString(1,kw);
            preparedStmt.setString(2,add);
            preparedStmt.execute();
            co.close();
            preparedStmt.close();
        }
        
        catch(Exception e){System.err.println(e.getMessage());}
        
        finally{
           try{preparedStmt.close();} catch(Exception e){}
            
           try{co.close();}catch(Exception e){}
        }
    }
    
    public String[] checking(String kw)
    {String [] k = new String[10]  ;
        try{
            
        
        int i=0;
            
            Class.forName("com.mysql.jdbc.Driver"); 
            co=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","root","root");
            //query = "select * from frontier where tag LIKE kw";
            preparedStmt = co.prepareStatement("SELECT * FROM frontier WHERE tag LIKE ? order by hits desc");
            String chng = "%"+kw+"%";       //for matching even if the keyword is a substring of the tag
            preparedStmt.setString(1,chng);
            
            rs = preparedStmt.executeQuery();
            
           //rs.next();
          if(!rs.next()){
              System.out.println("GO to Google");
              ReverseSearch r = new ReverseSearch();
              r.getDataFromGoogle(kw);
              k = r.getDataFromDatabase(kw);
              return k;
          }
            while(rs.next()){
                if(rs.getString("site").isEmpty()==false)
                    k[i++]= rs.getString("site");
                
            }
            
            co.close();
            preparedStmt.close();
        
             
        }
        
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        finally{
           try{preparedStmt.close();} catch(Exception e){}
            
           try{co.close();}catch(Exception e){}
        }
       return k;
    }
    
     public String autoCrawling(String kw)
    {String [] k = new String[10]  ;
        try{
            
        
        int i=0;
            
            Class.forName("com.mysql.jdbc.Driver"); 
            co=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","root","root");
            //query = "select * from frontier where tag LIKE kw";
            preparedStmt = co.prepareStatement("SELECT * FROM frontier WHERE tag LIKE ? order by hits desc");
            String chng = "%"+kw+"%";       //for matching even if the keyword is a substring of the tag
            preparedStmt.setString(1,chng);
            
            rs = preparedStmt.executeQuery();
            
            if(rs==null){
                System.out.println("Empty");
            }
            
           //rs.next();
          
            while(rs.next()){
                if(rs.getString("site")!=null)
                    return rs.getString("site");
                
            }
            
            co.close();
            preparedStmt.close();
        
             
        }
        
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        finally{
           try{preparedStmt.close();} catch(Exception e){}
            
           try{co.close();}catch(Exception e){}
        }
       return null;
    }
    
     
     //to insert the link into the database when a match for the keyword is found (using google search)
     public void InsertLink(String url,String kw){
         
         try{
        
            System.out.println(" tag success");
            Class.forName("com.mysql.jdbc.Driver"); 
            co=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","root","root");
            query = "insert into frontier values(?,?,?)";
            preparedStmt = co.prepareStatement(query);
           preparedStmt.setString(1,url);
            preparedStmt.setString(2,kw);
            preparedStmt.setInt(3,0);
            preparedStmt.execute();
            co.close();
            preparedStmt.close();
        }
        
        catch(Exception e){System.err.println(e.getMessage());}
        
        finally{
           try{preparedStmt.close();} catch(Exception e){}
            
           try{co.close();}catch(Exception e){}
        }
         
     }
     
     //to increment the hits of a webpage when it is visted 
     public void incrementCount(String url){
         
          try{
            
        
        int i=0;
            System.out.println("CHeck");
            Class.forName("com.mysql.jdbc.Driver"); 
            co=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","root","root");
            //query = "select * from frontier where tag LIKE kw";
            preparedStmt = co.prepareStatement("SELECT hits FROM frontier WHERE site = ?");
            //String chng = "%"+kw+"%";       //for matching even if the keyword is a substring of the tag
            preparedStmt.setString(1,url);
            
            rs = preparedStmt.executeQuery();
            
            rs.next();
            i = rs.getInt("hits");
            i++;
            preparedStmt = co.prepareStatement("UPDATE frontier SET hits = ? WHERE site = ?");
            preparedStmt.setInt(1,i);
            preparedStmt.setString(2, url);
            preparedStmt.execute();
            System.out.println("exec Success");
            
            co.close();
            preparedStmt.close();
        
             
        }
        
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        finally{
           try{preparedStmt.close();} catch(Exception e){}
            
           try{co.close();}catch(Exception e){}
        }
         
     }
     
     public ResultSet fillTable(){
         ResultSet rs=null;
         
         try{
        
            System.out.println(" tag success");
            Class.forName("com.mysql.jdbc.Driver"); 
            co=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","root","root");
            query = "select * from frontier";
            preparedStmt = co.prepareStatement(query);
           
            rs = preparedStmt.executeQuery();
            co.close();
            preparedStmt.close();
        }
        
        catch(Exception e){System.err.println(e.getMessage());}
        
        finally{
           try{preparedStmt.close();} catch(Exception e){}
            
           try{co.close();}catch(Exception e){}
        }
         
        return rs; 
     }
     
     //for deleting table
    public  void deleteTable(){
        
        try{
        
            //System.out.println(" tag success");
            Class.forName("com.mysql.jdbc.Driver"); 
            co=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","root","root");
            query = " delete from frontier ";
            preparedStmt = co.prepareStatement(query);
           
            preparedStmt.execute();
            co.close();
            preparedStmt.close();
        }
        
        catch(Exception e){System.err.println(e.getMessage());}
        
        finally{
           try{preparedStmt.close();} catch(Exception e){}
            
           try{co.close();}catch(Exception e){}
        }
    }
         
}
