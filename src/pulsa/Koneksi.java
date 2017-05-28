/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pulsa;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Otz
 */
public class Koneksi {

    String url, usr, pwd, dbn;

    public Koneksi(String host, String user, String pass, String dbn) {
    this.url = "jdbc:mysql://" + host + "/" + dbn;
        this.usr = user;
        this.pwd = pass;
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.usr, this.pwd);
        } catch (ClassNotFoundException e) {
            System.out.println("Error #1 : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error #2 : " + e.getMessage());
        }
        return con;
    }
}
