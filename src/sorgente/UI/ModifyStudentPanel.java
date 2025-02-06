package sorgente.UI;

import sorgente.DatabaseConnection;
import sorgente.Student;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;

public class ModifyStudentPanel extends JPanel {
    private JTextField txtCdfSearch, txtNome, txtCognome, txtTelefono, txtEmail, txtDataNascita;
    private JButton btnSearch, btnConfirm, btnCancel;
    private JLabel lblNotFound;

    public ModifyStudentPanel() {
        setLayout(null);

        // Campo per il codice fiscale e ricerca
        txtCdfSearch = new JTextField();
        txtCdfSearch.setBounds(10, 10, 120, 19);
        add(txtCdfSearch);

        btnSearch = new JButton("Cerca");
        btnSearch.setBounds(140, 10, 85, 21);
        add(btnSearch);

        // evento di ricerca associato al pulsante
        btnSearch.addActionListener(e -> {
            // cliccabile solo se si scrive del testo nella casella del codice fiscale
            if (!txtCdfSearch.getText().isEmpty()) {
                DatabaseConnection db = new DatabaseConnection();
                try {
                    Student s = db.ricercaStudente(txtCdfSearch.getText());
                    showStudentData(s);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "STUDENTE NON TROVATO");
                }
            }
        });

        lblNotFound = new JLabel("");
        lblNotFound.setBounds(10, 40, 200, 20);
        add(lblNotFound);

        // Campi inizialmente nascosti
        txtNome = createTextField(70);
        txtCognome = createTextField(96);
        txtTelefono = createTextField(128);
        txtEmail = createTextField(154);
        txtDataNascita = createTextField(185);

        add(createLabel("Nome", 70));
        add(createLabel("Cognome", 96));
        add(createLabel("Telefono", 128));
        add(createLabel("Email", 154));
        add(createLabel("Data di Nascita", 185));

        btnConfirm = new JButton("Conferma");
        btnConfirm.setBounds(10, 220, 85, 21);
        btnConfirm.setEnabled(false);
        add(btnConfirm);

        // evento associato al pulsante di conferma
        btnConfirm.addActionListener(e -> {
            DatabaseConnection db = new DatabaseConnection();

            Student s = new Student();
            // setting dei valori
            s.setNome(txtNome.getText());
            s.setCognome(txtCognome.getText());
            s.setTelefono(txtTelefono.getText());
            s.setEmail(txtEmail.getText());
            s.setDataNascita(Date.valueOf(txtDataNascita.getText()));
            s.setCodiceFiscale(txtCdfSearch.getText());

            // try-catch per stampare il risultato dell'operazione
            try {
                db.modificaStudente(s);
                JOptionPane.showMessageDialog(null, "STUDENTE MODIFICATO CORRETTAMENTE");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        btnCancel = new JButton("Annulla");
        btnCancel.setBounds(139, 220, 85, 21);
        add(btnCancel);
    }

    // metodo per creare un campo di testo
    private JTextField createTextField(int y) {
        JTextField textField = new JTextField();
        textField.setBounds(128, y, 96, 19);
        add(textField);
        return textField;
    }

    // metodo per creare una label
    private JLabel createLabel(String text, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(10, y, 100, 13);
        return label;
    }

    // Metodo per abilitare stampare i testi dopo la ricerca
    public void showStudentData(Student s) {
        txtNome.setText(s.getNome());
        txtCognome.setText(s.getCognome());
        txtTelefono.setText(s.getTelefono());
        txtEmail.setText(s.getEmail());
        txtDataNascita.setText(String.valueOf(s.getDataNascita()));
        btnConfirm.setEnabled(true);
    }
}
