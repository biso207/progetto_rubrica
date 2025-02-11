/*
Luca Bisognin e Diego Ferventi - 7/2/2025
Classe Service che fa da ponte tra le parte UI e la parte di gestione del database del progetto
*/

// package di appartenenza
package sorgente;

// import dei codici
import sorgente.database.BackendException;
import sorgente.database.DAOStudent;
import sorgente.database.DatabaseConnection;

// import librerie
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Service {
    private final DAOStudent dao;

    // costruttore
    public Service() {
        // istanza del DAO => permette le operazioni di CRUD
        dao = new DAOStudent();
    }

    // metodo per aggiungere uno studente al database
    public void addStudent(Student s) {
        String errors = IsValid.student(s);

        // aggiunta studente con controllo validità
        if (errors.isEmpty()) {
            try {
                dao.aggiungiStudente(s);
            } catch (SQLException e) {
                throw new BackendException("Qualcosa è andato storto :(");
            }
        } else {
            throw new BackendException("Campi Invalidi: " + errors);
        }
    }

    // metodo per ricercare uno studente
    public Student searchStudente(String s) {
        try {
            return dao.ricercaStudente(s);
        }
        catch (SQLException e) {
            throw new BackendException("STUDENTE NON TROVATO");
        }
    }

    // metodo per modificare uno studente
    public void modifyStudent(Student s) {
        String errors = IsValid.student(s);

        // aggiunta studente con controllo validità
        if (errors.isEmpty()) {
            try {
                dao.modificaStudente(s);
            } catch (SQLException e) {
                throw new BackendException("Qualcosa è andato storto :(");
            }
        } else {
            throw new IllegalArgumentException("Campi Invalidi: " + errors);
        }
    }

    // metodo per recuperare tutti gli studenti dal database
    public ArrayList<Student> getAll() {
        try {
            return dao.selezionaTutti();
        } catch (SQLException e) {
            throw new BackendException("ERRORE CREAZIONE TABELLA");
        }
    }

    // metodo per le operazioni di Commit e Rollback sul database
    public void transactions(int service) {
        // recupero oggetto Connection
        try {
            if (service == 1) DatabaseConnection.commit();
            else DatabaseConnection.rollback();
        } catch (SQLException e) {
            throw new BackendException("ERRORE CONNESSIONE AL SERVER");
        }
    }
}
