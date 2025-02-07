package sorgente;

import java.sql.Connection;
import java.sql.SQLException;

public interface Database<T extends Throwable>{
    Connection getConnection() throws T;
    int aggiungiStudente(Student s) throws T;
    Student ricercaStudente(String codiceFiscale) throws T;
    void modificaStudente(Student s) throws T;

}
