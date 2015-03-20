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
import java.sql.ResultSet;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.*;

/* 
 * To change this license header, choose License Headers in 
 Project Properties. 
 * To change this template file, choose Tools | Templates 
 * and open the template in the editor. 
 */
/**
 *
 * @author catherineberrut
 */
public class requetesbd {

    /**
     * Afficher toutes les informations sur tous les spectacles.
     *
     * @param conn connexion � la ba se de donn�es
     * @throws SQLException en cas d'erreur d'acc�s � la base de donn�es
     */
    public static void lesSpectacles(Connection conn) throws SQLException {

        // Get a statement from the connection 
        Statement stmt = conn.createStatement();

        // Execute the query  
        ResultSet rs = stmt.executeQuery("SELECT NumSpec as ID, NomSpec as nom FROM LesSpectacles");
        while (rs.next()) {
            System.out.print("IdSpectacle : " + rs.getInt(1) + " ");
            System.out.println("nom : " + rs.getString(2) + " ");
        }
        // Close the result set, statement and the connection
        rs.close();
        stmt.close();
    }
}
