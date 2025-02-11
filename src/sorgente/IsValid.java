/*
Luca Bisognin e Diego Ferventi - 7/2/2025
Classe isValid per controllare la validità dei campi di testo riempiti delle schermate Insert e Modify (student)
*/

// package di appartenenza
package sorgente;

// import librerie
import java.sql.Date;
import java.util.Calendar;

public class IsValid {
    /* ogni validazione è effettuata tramite delle regex */

    // validazione nome e cognome
    public static boolean nome(String s){
        return !s.matches("^[A-Za-z]+$");
    }

    // validazione mail
    public static boolean email(String s){
        return s.matches("^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})$");
    }

    // validazione numero di telefono
    public static boolean telefono(String s){
        return s.matches("^[0-9]*$");
    }

    // validazione data di nascita
    public static boolean data(Date d) {
        if (d == null) {
            return false;  // nessuna data inserita
        }

        // VALIDAZIONE DATA //
        // oggetto Calendar
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);

        // recupero anno, mese e giorno dalla data passata
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        // verifica validità giorno per il mese
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);

        // return della validità della data
        return cal.get(Calendar.DAY_OF_MONTH) == day;
    }


    // validazione codice fiscale
    public static boolean codiceFiscale(String s){
        return s.matches("^[A-Z0-9]+$");
    }

    // metodo per costruire la stringa contenente i campi di testo errati
    public static String student(Student s) {
        StringBuilder sb = new StringBuilder();
        if (!nome(s.getNome())) sb.append("\n- Nome");
        if (!nome(s.getCognome())) sb.append("\n- Cognome");
        if (!telefono(s.getTelefono())) sb.append("\n- Telefono");
        if (!email(s.getEmail())) sb.append("\n- Email");
        if (!data(s.getDataNascita())) sb.append("\n- Data Di Nascita");
        if (!codiceFiscale(s.getCodiceFiscale())) sb.append("\n- Codice Fiscale");

        return sb.toString();
    }
}
