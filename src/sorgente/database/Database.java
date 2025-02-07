/*
Luca Bisognin e Diego Ferventi - 7/2/2025
Interfaccia Database per i metodi utili alle classi che si interfacciano con il database
*/

// package appartenenza
package sorgente.database;

import sorgente.Student;
import java.sql.Connection;
import java.util.ArrayList;

public interface Database<T extends Throwable>{
    Connection getConnection() throws T;
    int aggiungiStudente(Student s) throws T;
    Student ricercaStudente(String codiceFiscale) throws T;
    void modificaStudente(Student s) throws T;
    ArrayList<Student> selezionaTutti() throws T;

}
