package sorgente;

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

    public static boolean student(Student s){
        return nome(s.getNome())&&nome(s.getCognome())&&telefono(s.getTelefono())&&codiceFiscale(s.getCodiceFiscale())&&email(s.getEmail());
    }
}
