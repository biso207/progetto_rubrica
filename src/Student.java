/*
Luca Bisognin e Diego Ferventi - inizio 6/2/2025
Classe Student per creare gli oggetti che rappresentano gli studenti della rubrica
*/

import java.util.Date;

public class Student {
    // attributi
    private String nome, cognome, telefono, email, citta, codiceFiscale;
    private Date dataNascita;

    // costruttore
    public Student(String nome, String cognome, String telefono, String email, String citta, String codiceFiscale, Date dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.email = email;
        this.citta = citta;
        this.codiceFiscale = codiceFiscale;
        this.dataNascita = dataNascita;
    }

    // SETTER //
    // nome
    public void setNome(String nome) { this.nome = nome; }

    // cognome
    public void setCognome(String cognome) { this.cognome = cognome; }

    // numero di telefono
    public void setTelefono(String telefono) { this.telefono = telefono; }

    // email
    public void setEmail(String email) { this.email = email; }

    // città di residenza
    public void setCitta(String citta) { this.citta = citta; }

    // codice fiscale
    public void setCodiceFiscale(String codiceFiscale) { this.codiceFiscale = codiceFiscale; }

    // data di nascita
    public void setDataNascita(Date dataNascita) { this.dataNascita = dataNascita; }

    // GETTER //
    // nome
    public String getNome() { return nome; }

    // cognome
    public String getCognome() { return cognome; }

    // numero di telefono
    public String getTelefono() { return telefono; }

    // email
    public String getEmail() { return email; }

    // città di residenza
    public String getCitta() { return citta; }

    // codice fiscale
    public String getCodiceFiscale() { return codiceFiscale; }

    // data di nascita
    public Date getDataNascita() { return dataNascita; }

    // metodo toString
    @Override
    public String toString() {
        return nome + " " + cognome + " " + " " + telefono + " " + email +
                " " + citta + " " + codiceFiscale + " " + dataNascita;
    }
}
