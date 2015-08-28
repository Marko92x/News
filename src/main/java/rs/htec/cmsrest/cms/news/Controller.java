/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.htec.cmsrest.cms.news;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marko
 */
public class Controller {
    
    private static Controller instance;
    public List<News> news = new ArrayList<>();

    DBBroker db;
    
    private Controller() {
        db = new DBBroker();
    }
    
    public static Controller getInstance(){
        if (instance == null){
            instance = new Controller();
        }
        return instance;
    }
    
    public void uspostaviKonekciju(){
        try {
            db.openConnection();
            System.out.println("Fack yeahhhhh");
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("buuuuuuuu");
        }
    }
    
    public void insertNews(News n) {
        try {
            db.openConnection();
            db.insert(n);
            db.closeConnectoion();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<News> readNews() {
        try {
            db.openConnection();
            news = db.readNews();
            db.closeConnectoion();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return news;
    }
}
