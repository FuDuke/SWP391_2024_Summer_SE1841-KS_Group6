package dal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {

    public Connection connection;

    public DBContext() {
        try {
            //Change the username password and url to connect your own database
            String username = "sa";
            String password = "12345";
            String url = "jdbc:sqlserver://ATUANHU\\atuanhu:1433;databaseName=TravelService;encrypt=true;trustServerCertificate=true;useUnicode=true;characterEncoding=UTF-8;";

            //Truoức khi thi phải thêm vào
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);

            // mấy cái này import được
        }
    }

   

    public static void main(String[] args) {
        DBContext c = new DBContext();
        System.out.println(c.connection);
    }

   

}
