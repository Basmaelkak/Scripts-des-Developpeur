
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;


/**
 *
 * @author pc
 */
public class ExoJdbc {
    public static void main(String[] args) {
        String user ="root";
        String password="";
        String url ="jdbc:mysql://localhost/data";
        Connection cn= null;
        Statement st = null;
        ResultSet rs = null;
        ResultSet rs1=null;
        ResultSet rs2=null;
        try{
            //Etape1:chargement du driver 
            Class.forName("com.mysql.jdbc.Driver");
            //Etape2:recupération de la connexion
            cn=DriverManager.getConnection(url,user,password);
            //Etape3:création d'un statement
            st=cn.createStatement();
            String req = "select developpeur,jour,MAX(nbrscripts)AS max_scripts from devdata GROUP BY jour;";
            //Etape4
            rs=st.executeQuery(req);
            //Etape5
            while (rs.next())
           {
                System.out.println("le maximum des scripts est" +rs.getInt("max_scripts")); 
            }
           rs.close();
            String requ = "select developpeur ,sum(nbrscripts) AS c from devdata GROUP BY developpeur order by c desc;";
             rs1=st.executeQuery(requ);
          while(rs1.next()){
              System.out.println("la somme des scripts par developpeur est" +rs1.getInt("c"));
            }
           rs1.close();
           String re= "select jour,count(*) AS total_scripts from devdata group by jour;";
           rs2=st.executeQuery(re);
           while(rs2.next()){
              System.out.println("le nombre total des scripts par semaine est:"+rs2.getInt("total_scripts"));
          }
          Scanner sc=new Scanner(System.in);
          System.out.println("entrer votre requete SQL ");
          String requete= sc.nextLine();
          
         try{
             ResultSet rss= st.executeQuery(requete);
                       
           ResultSetMetaData rsmd=rss.getMetaData();
            System.out.println("nombre de colonne est :"+rsmd.getColumnCount());
                
           for(int i=1;i<=rsmd.getColumnCount();i++){
               System.out.println("colonne"+i+": "+rsmd.getColumnName(i)+" type "+rsmd.getColumnType(i));
          }
            while(rss.next()){
               for(int i=1;i<=rsmd.getColumnCount();i++)
                System.out.println("le contenu :"+rss.getString(i));
            }
            
           }catch(SQLException e){
              System.out.println("erreur SQL");
           }
           
        
    }catch(SQLException e) {
        System.out.println(e.getMessage());
        
    }catch(ClassNotFoundException ex){
        System.out.println("Impossible de charger le driver");
    }finally{
            try{
                //Etape6
                st.close();
                cn.close();
            }catch(SQLException ex){
              System.out.println("Impossible de liberer les ressources");   
            }
        }
    }

   
}
    




