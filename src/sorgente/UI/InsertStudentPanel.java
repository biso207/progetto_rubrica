/*
Luca Bisognin e Diego Ferventi - inizio 6/2/2025
Classe InsertStudentPanel per gestire la grafica della pagina di inserimento studente
*/

// package appartenenza
package sorgente.UI;

import sorgente.DatabaseConnection;
import sorgente.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class InsertStudentPanel extends JPanel {
    private JTextField txtNome, txtCognome, txtTelefono, txtEmail, txtDataNascita, txtCdf;
    private JButton btnConfirm, btnCancel;

    // costruttore
    public InsertStudentPanel() {
        setLayout(null);

        // creazione labels
        createLabels();

        // creazione text fields
        createTextFields();

        // BUTTONS //
        // conferma operazione
        btnConfirm = new JButton("Conferma");
        btnConfirm.setBounds(10, 204, 85, 21);
        add(btnConfirm);

        // annullamento operazione
        btnCancel = new JButton("Annulla");
        btnCancel.setBounds(139, 204, 85, 21);
        add(btnCancel);

        // EVENTS BUTTONS //
        // conferma
        btnConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // creazione istanza studente
                    Student s = new Student();

                    // setting attributi studente
                    s.setNome(txtNome.getText());
                    s.setCognome(txtCognome.getText());
                    s.setTelefono(txtTelefono.getText());
                    s.setEmail(txtEmail.getText());
                    s.setDataNascita(Date.valueOf(txtDataNascita.getText()));
                    s.setCodiceFiscale(txtCdf.getText());

                    // operazione per aggiungere lo studente
                    DatabaseConnection.getInstance().aggiungiStudente(s);
                    JOptionPane.showMessageDialog(null,"STUDENTE CREATO CON SUCCESSO");
                } catch (SQLException | IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null,"PROBLEMA NELLA CREAZIONE STUDENTE");
                }
                ;
            }
        });

        // annullamento operazione
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // svuotamento text field
                txtNome.setText("");
                txtCognome.setText("");
                txtTelefono.setText("");
                txtEmail.setText("");
                txtDataNascita.setText("");
                txtCdf.setText("");
            }
        });
    }

    // Metodi utili per creare i componenti
    private JTextField createTextField(int y) {
        JTextField textField = new JTextField();
        textField.setBounds(128, y, 96, 19);
        add(textField);
        return textField;
    }

    private JLabel createLabel(String text, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(10, y, 100, 13);
        return label;
    }

    // metodo per creare i labels
    public void createLabels() {
        // creazione label
        add(createLabel("Nome", 10));
        add(createLabel("Cognome", 42));
        add(createLabel("Telefono", 74));
        add(createLabel("Email", 106));
        add(createLabel("Data di Nascita", 138));
    }

    // metodo per creare i textFields
    public void createTextFields() {
        // campi di testo per mostrare il risultato della ricerca
        txtNome = createTextField(10);
        txtCognome = createTextField(42);
        txtTelefono = createTextField(74);
        txtEmail = createTextField(106);
        txtDataNascita = createTextField(138);
    }
}

