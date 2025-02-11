/*
Luca Bisognin e Diego Ferventi - 6/2/2025
Classe DAOStudent per gestire le operazioni di CRUD del database
*/

// package di appartenenza
package sorgente.database;

// import codici
import sorgente.Student;

// import librerie
import java.sql.*;
import java.util.ArrayList;

public class DAOStudent implements Database<SQLException> {
    private final DatabaseConnection db;

    // costruttore
    public DAOStudent() {
        // istanza di database connection => stabilisce la connessione con il database
        db = new DatabaseConnection();
    }

    // OPERAZIONI CRUD //
    // aggiunta studente al database
    @Override
    public int aggiungiStudente(Student s) throws SQLException {
        String sql = "INSERT INTO studenti(nome,cognome,numTelefono,email,dataDiNascita,codiceFiscale) VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        setPreparedStatement(ps, s);
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    // ricerca dello studente nel database
    @Override
    public Student ricercaStudente(String codiceFiscale) throws SQLException {
        String sql="SELECT nome,cognome,numTelefono,email,dataDiNascita FROM studenti WHERE codiceFiscale=?";
        PreparedStatement ps = db.getConnection().prepareStatement(sql);
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

    // modifica di uno studente nel database
    @Override
    public void modificaStudente(Student s) throws SQLException {
        String sql = "UPDATE studenti SET nome=?,cognome=?,numTelefono=?,email=?,dataDiNascita=? WHERE codiceFiscale=?";
        PreparedStatement ps = db.getConnection().prepareStatement(sql);
        setPreparedStatement(ps, s);
        ps.executeUpdate();
    }

    // metodo per selezionare tutti gli studenti dal database
    public ArrayList<Student> selezionaTutti() throws SQLException {
        ArrayList<Student> students = new ArrayList<>();

        String sql="SELECT nome,cognome,numTelefono,email,dataDiNascita,codiceFiscale FROM studenti";
        PreparedStatement ps = db.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            Student s = new Student();

            // setting degli attributi
            s.setNome(rs.getString(1));
            s.setCognome(rs.getString(2));
            s.setTelefono(rs.getString(3));
            s.setEmail(rs.getString(4));
            s.setDataNascita(Date.valueOf(rs.getString(5)));
            s.setCodiceFiscale(rs.getString(6));

            students.add(s);
        }

        return students;
    }

    // metodo per settare gli attributi dello studente
    public void setPreparedStatement(PreparedStatement ps, Student s) throws SQLException {
        ps.setString(1,s.getNome());
        ps.setString(2,s.getCognome());
        ps.setString(3,s.getTelefono());
        ps.setString(4,s.getEmail());
        ps.setString(5,s.getDataNascita().toString());
        ps.setString(6,s.getCodiceFiscale());
    }

    public Connection getConnection() throws SQLException {
        return db.getConnection();
    }
}
