package sorgente;/*
Luca Bisognin e Diego Ferventi - inizio 6/2/2025
Classe DatabaseConnector per stabilire la connessione con il database
*/

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;

public class DatabaseConnection {
    private Connection con;
    private static DatabaseConnection dc;
    public static DatabaseConnection getInstance() {
        if(dc==null) {
            dc=new DatabaseConnection();
        }
        return dc;
    }

    public Connection getConnection() throws SQLException {
        if (con==null){
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setDatabaseName("rubrica");
            dataSource.setPortNumber(3306);
            dataSource.setServerName("127.0.0.1");
            dataSource.setUser("root");
            dataSource.setPassword("root");
            con = dataSource.getConnection();
        }
        return con;
    }

    public int aggiungiStudente(Student s) throws SQLException {
        String sql = "INSERT INTO studenti(nome,cognome,numTelefono,email,dataDiNascita,codiceFiscale) VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,s.getNome());
        ps.setString(2,s.getCognome());
        ps.setString(3,s.getTelefono());
        ps.setString(4,s.getEmail());
        ps.setString(5,s.getDataNascita().toString());
        ps.setString(6,s.getCodiceFiscale());
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    public Student ricercaStudente(String codiceFiscale) throws SQLException {
        String sql="SELECT nome,cognome,numTelefono,email,dataDiNascita FROM studenti WHERE codiceFiscale=?";
        PreparedStatement ps=getConnection().prepareStatement(sql);
        ps.setString(1,codiceFiscale);
        ResultSet rs= ps.executeQuery();
        Student s = new Student();
        rs.next();
        s.setNome(rs.getString(1));
        s.setCognome(rs.getString(2));
        s.setTelefono(rs.getString(3));
        s.setEmail(rs.getString(4));
        s.setDataNascita(Date.valueOf(rs.getString(5)));
        s.setCodiceFiscale(codiceFiscale);
        return s;
    }

    public void modificaStudente(Student s) throws SQLException {
        String sql = "UPDATE studenti SET nome=?,cognome=?,numTelefono=?,email=?,dataDiNascita=? WHERE codiceFiscale=?";
        String nome = s.getNome();
        String cognome = s.getCognome();
        String telefono=s.getTelefono();
        String email= s.getEmail();
        Date data = (Date) s.getDataNascita();
        String codiceFiscale=s.getCodiceFiscale();
        PreparedStatement ps = getConnection().prepareStatement(sql);
        ps.setString(1,s.getNome());
        ps.setString(2,s.getCognome());
        ps.setString(3,s.getTelefono());
        ps.setString(4,s.getEmail());
        ps.setString(5,s.getDataNascita().toString());
        ps.setString(6,s.getCodiceFiscale());
        ps.executeUpdate();
    }
}
