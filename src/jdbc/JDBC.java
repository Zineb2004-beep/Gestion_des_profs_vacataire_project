/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class JDBC {

        public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/gestiondesprofsvacataires";
        String login = "root";
        String password = "";
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(url, login, password);
            System.out.println("Connexion réussie !");
        } catch (SQLException ex) {
            System.out.println("Erreur de connexion : " + ex.getMessage());
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, login, password);
        
            String req = "select * from cours";
       
            Statement st = cn.createStatement();
            ResultSet rs =  st.executeQuery(req);
            
            while (rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString("intitule")+" "+rs.getString("salle"));
            }
           
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver introvable");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}


