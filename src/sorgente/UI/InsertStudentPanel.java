package sorgente.UI;

import sorgente.Student;

import javax.swing.*;
import java.sql.Date;

public class InsertStudentPanel extends JPanel {
    private JTextField txtNome, txtCognome, txtTelefono, txtEmail, txtDataNascita, txtCdf;
    private JButton btnConfirm, btnCancel;

    public InsertStudentPanel() {
        setLayout(null);

        // Creazione dei campi di testo
        txtNome = createTextField(10);
        txtCognome = createTextField(36);
        txtTelefono = createTextField(65);
        txtEmail = createTextField(94);
        txtDataNascita = createTextField(122);
        txtCdf = createTextField(151);

        // creazione label
        add(createLabel("Nome", 10));
        add(createLabel("Cognome", 36));
        add(createLabel("Telefono", 68));
        add(createLabel("Email", 94));
        add(createLabel("Data di Nascita", 125));
        add(createLabel("Codice Fiscale", 157));

        // Pulsanti
        btnConfirm = new JButton("Conferma");
        btnConfirm.setBounds(10, 204, 85, 21);
        add(btnConfirm);
        btnConfirm.addActionListener(e -> {
            Student s = getStudentData();

            // Ora hai i dati salvati in un array, pronto per l'inserimento nel database
            System.out.println("Dati studente salvati: " + s);
        });

        btnCancel = new JButton("Annulla");
        btnCancel.setBounds(139, 204, 85, 21);
        add(btnCancel);
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

    // Metodo per ottenere i dati inseriti
    public Student getStudentData() {
        return new Student(txtNome.getText(), txtCognome.getText(), txtTelefono.getText(),
                txtEmail.getText(), txtCdf.getText(), Date.valueOf(txtDataNascita.getText()));
    }
}

