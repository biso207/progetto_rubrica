/*
Luca Bisognin e Diego Ferventi - 7/2/2025
Eccezione personalizzata per mostrare un determinato errore all'utente
*/

// package di appartenenza
package sorgente.database;

public class BackendException extends RuntimeException {
    public BackendException(String message) {
        super(message);
    }
}
