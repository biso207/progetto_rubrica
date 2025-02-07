/*
Luca Bisognin e Diego Ferventi - 6/2/2025
Classe sorgente.Student per creare gli oggetti che rappresentano gli studenti della rubrica
*/

// package appartenenza
package sorgente;

import java.sql.Date;

public class Student {
    // attributi
    private String nome, cognome, telefono, email, codiceFiscale;
    private Date dataNascita;

    // costruttore
    public Student(){
    }

    // costruttore
    public Student(String nome, String cognome, String telefono, String email, String codiceFiscale, Date dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.email = email;
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

    // codice fiscale
    public void setCodiceFiscale(String codiceFiscale) { this.codiceFiscale = codiceFiscale; }

    // data di nascita
    public void setDataNascita(Date dataNascita) { this.dataNascita = dataNascita; }
    public void setDateString(String dateString){
        try{
            setDataNascita(java.sql.Date.valueOf(dateString));
        }catch (IllegalArgumentException e){
            dataNascita = null;
        }
    }
    // GETTER //
    // nome
    public String getNome() { return nome; }

    // cognome
    public String getCognome() { return cognome; }

    // numero di telefono
    public String getTelefono() { return telefono; }

    // email
    public String getEmail() { return email; }

    // codice fiscale
    public String getCodiceFiscale() { return codiceFiscale; }

    // data di nascita
    public Date getDataNascita() { return dataNascita; }

    // metodo toString
    @Override
    public String toString() {
        return nome + " " + cognome + " " + " " + telefono + " " + email +
                " " + codiceFiscale + " " + dataNascita;
    }
}
