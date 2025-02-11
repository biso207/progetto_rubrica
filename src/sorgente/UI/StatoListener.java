/*
Luca Bisognin e Diego Ferventi - 11/2/2025
Interfaccia StatoListener per il metodo che notifica l'utente di un cambio di stato
*/

// package di appartenenza
package sorgente.UI;

// interfaccia per i listener della variabile di stato
interface StatoListener {
    void statoCambiato(boolean nuovoStato);
}
