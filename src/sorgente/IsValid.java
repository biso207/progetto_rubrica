package sorgente;

import java.sql.Date;

public class IsValid {
    public static boolean email(String s){
        return s.matches("^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})$");
    }
    public static boolean nome(String s){
        return s.matches("^[A-Za-z]+$");
    }
    public static boolean telefono(String s){
        return s.matches("^[0-9]*$");
    }
    public static boolean codiceFiscale(String s){
        return s.matches("^[A-Z0-9]+$");
    }
    public static boolean data(Date d){
        if(d==null){
            return false;
        }
        else{
            return true;
        }
    }
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
