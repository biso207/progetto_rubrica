/*
Luca Bisognin e Diego Ferventi - 6/2/2025
Classe DatabaseConnector per stabilire la connessione con il database
*/

// package appartenenza
package sorgente.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import sorgente.Student;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {
    private Connection con;
    private static DatabaseConnection dc;

    // metodo per creare un'istanza della classe
    public static DatabaseConnection getInstance() {
        if(dc==null) {
            dc=new DatabaseConnection();
        }
        return dc;
    }

    // metodo per stabilire la connessione con il database
    public Connection getConnection() throws SQLException {
        if (con==null){
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setDatabaseName("rubrica");
            dataSource.setPortNumber(3306);
            dataSource.setServerName("127.0.0.1");
            dataSource.setUser("root");
            dataSource.setPassword("root"); // ps da Luca e non Diego
            con = dataSource.getConnection();
        }
        return con;
    }

}
