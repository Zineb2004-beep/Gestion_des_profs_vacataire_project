/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connexion {

    private static Connexion instance = null;
    private Connection cn = null;

    private Connexion() {
        try {
            FileInputStream f = new FileInputStream("src/config/base.properties");
            Properties p = new Properties();
            p.load(f);
            Class.forName(p.getProperty("jdbc.driver"));
            cn = DriverManager.getConnection(p.getProperty("jdbc.url"), p.getProperty("jdbc.username"), p.getProperty("jdbc.password"));
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver introuvable");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.out.println("Le ficher de configuration est introvable");
        } catch (IOException ex) {
            System.out.println("Probleme de chargement de la configuration");

        }
    }

    public static synchronized Connexion getInstance() {
        if (instance == null) {
            instance = new Connexion();
        }
        return instance;
    }

    public Connection getCn() {
        return cn;
    }
}
