/*
Luca Bisognin e Diego Ferventi - 6/2/2025
Classe DatabaseConnector per stabilire la connessione con il database
*/

// package appartenenza
package sorgente.database;

// import librerie
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.swing.*;
import java.sql.*;

public class DatabaseConnection {
    private static Connection con;
    private static DatabaseConnection dc;

    // metodo per creare un'istanza della classe
    public static DatabaseConnection getInstance() {
        if(dc == null) {
            dc = new DatabaseConnection();
        }
        return dc;
    }

    // metodo per stabilire la connessione con il database
    public Connection getConnection() throws SQLException {
        if (con==null || con.isClosed()) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setDatabaseName("rubrica");
            dataSource.setPortNumber(3306);
            dataSource.setServerName("127.0.0.1");
            dataSource.setUser("root");
            dataSource.setPassword("root"); // psw da Luca e non Diego
            con = dataSource.getConnection();

            // auto commit disattivato
            con.setAutoCommit(false);
        }
        return con;
    }

    // metodo per eseguire il commit delle modifiche
    public void exeCommit() throws SQLException {
        if (con != null) {
            con.commit();
            JOptionPane.showMessageDialog(null,"MODIFICHE SALVATE CORRETTAMENTE");
        }
    }

    // metodo per eseguire il rollback delle modifiche
    public void exeRollback() throws SQLException {
        if (con != null) {
            con.rollback();
            JOptionPane.showMessageDialog(null,"MODIFICHE ANNULLATE");
        }
    }

}
