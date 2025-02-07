package sorgente.UI;

import sorgente.DatabaseConnection;
import sorgente.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class ModifyStudentPanel extends JPanel {
    private JTextField txtCdfSearch, txtNome, txtCognome, txtTelefono, txtEmail, txtDataNascita;
    private JButton btnSearch, btnConfirm, btnCancel;

    public ModifyStudentPanel() {
        setLayout(null);

        // creazione labels
        createLabels();

        // creazione text fields
        createTextFields();


        // CODICE FISCALE //
        // label di riferimento
        JLabel lblCdfCer = new JLabel("Codice Fiscale");
        lblCdfCer.setBounds(10, 12, 90, 13);
        add(lblCdfCer);

        // campo di testo per la digitazione del codice fiscale
        txtCdfSearch = new JTextField();
        txtCdfSearch.setColumns(10);
        txtCdfSearch.setBounds(110, 10, 90, 20);
        add(txtCdfSearch);

        // BUTTONS //
        // conferma operazione modifica
        btnConfirm = new JButton("Conferma");
        btnConfirm.setBounds(10, 220, 85, 21);
        btnConfirm.setEnabled(false);
        add(btnConfirm);

        // pulsante per avviare la ricerca
        btnSearch = new JButton("Cerca");
        btnSearch.setBounds(210, 10, 85, 19);
        add(btnSearch);

        // annullamento operazione
        btnCancel = new JButton("Annulla");
        btnCancel.setBounds(139, 220, 85, 21);
        add(btnCancel);

        // EVENTS BUTTONS //
        // ricerca studente
        btnSearch.addActionListener(e -> {
            // cliccabile solo se si scrive del testo nella casella del codice fiscale
            if (!txtCdfSearch.getText().isEmpty()) {
                try {
                    // creazione oggetto studente studente
                    Student s = DatabaseConnection.getInstance().ricercaStudente(txtCdfSearch.getText());

                    // mostrati dati utente
                    showStudentData(s);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "STUDENTE NON TROVATO");
                }
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
                txtCdfSearch.setText("");

                // blocco button conferma
                btnConfirm.setEnabled(false);
            }
        });

        // conferma modifica studente
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

    // metodo per creare i labels
    public void createLabels() {
        // creazione label
        add(createLabel("Nome", 70));
        add(createLabel("Cognome", 96));
        add(createLabel("Telefono", 128));
        add(createLabel("Email", 154));
        add(createLabel("Data di Nascita", 185));
    }

    // metodo per creare i textFields
    public void createTextFields() {
        // campi di testo per mostrare il risultato della ricerca
        txtNome = createTextField(70);
        txtCognome = createTextField(96);
        txtTelefono = createTextField(128);
        txtEmail = createTextField(154);
        txtDataNascita = createTextField(185);
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
