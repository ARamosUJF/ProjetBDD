/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ramosad
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class ConnexionSGBD {

    private static final String configurationFile = "BD.properties";

    public static void main(String args[]) {
        try {
            String jdbcDriver, dbUrl, username, password;
            int num;
            String nom;
            String maDate;
            DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
            jdbcDriver = dap.getJdbcDriver();
            dbUrl = dap.getDatabaseUrl();
            username = dap.getUsername();
            password = dap.getPassword();

            // Load the database driver  
            Class.forName(jdbcDriver);

            // Get a connection to the database 
            Connection conn = DriverManager.getConnection(dbUrl, username, password);

            
        
            SQLWarningsExceptions.printWarnings(conn);
            conn.close();
          
            
        } catch (SQLException se) {

            // Print information about SQL exceptions  
            SQLWarningsExceptions.printExceptions(se);

            return;
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return;
        }
    }
}
