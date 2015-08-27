/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.htec.cmsrest.cms.news;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marko
 */
public class DBBroker {
    Connection connection;

    public DBBroker() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
        
    public void openConnection() throws SQLException{
        
        String url = "jdbc:mysql://localhost:3306/news";
        String user = "root";
        String password = "root";
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Successsful connection!");
    }

    public void closeConnectoion() throws SQLException {
        connection.close();
    }
    
    public void insert(News n) throws SQLException{
        String query = "Insert into news (title, description) values (?,?)";
        
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, n.getTitle());
        ps.setString(2, n.getDescription());
        ps.executeUpdate();
    }
}
