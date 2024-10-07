/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pc
 */
public class Dev {
    public static void save(DevData d){
       String user="root";
        String password="";
        String url = "jdbc:mysql://localhost/data";
        Connection cn=null;
        Statement st =null;
        try{
            //Etape1:chargement du driver 
            Class.forName("com.mysql.jdbc.Driver");
            //Etape2:recupération de la connexion
            cn=DriverManager.getConnection(url,user,password);
            //Etape3:création d'un statement
            st=cn.createStatement();

                        String req = "INSERT INTO DevData VALUES( '" +d.getDeveloppeur()+ "','" +d.getJour()+"',"+d.getNbrscripts()+ ")";
//Etape4:
            st.executeUpdate(req);
        }catch(SQLException e){
            System.out.println("Erreur SQL");    
        }catch(ClassNotFoundException ex){
            System.out.println("Impossible de charger le drive");
        }finally{
            try{
                //Etape5:
               st.close();
                cn.close();
            }catch(SQLException ex){
                System.out.println("Impossible de liberer les ressources");
            }
        }
    }
    public static void main (String[] args){
        //insertion des donnees
        save(new DevData("ALAMI","Lundi" ,1));
        save(new DevData("WAFI","Lundi",2));
        save(new DevData("SALAMI","Mardi",9)); 
         save(new DevData("SAFI","Mardi",2));
        save(new DevData("ALAMI","Mardi",2));
        save(new DevData("SEBIHI","Mercredi",2)); 
         save(new DevData("WAFI","jeudi",3));
        save(new DevData("ALAOUI","Vendredi",9));
        save(new DevData("WAFI","Vendredi",3)); 
         save(new DevData("SEBIHI","Vendredi",4));
    }
        
}
