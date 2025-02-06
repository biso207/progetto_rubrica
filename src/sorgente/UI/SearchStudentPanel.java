package sorgente.UI;

import sorgente.DatabaseConnection;
import sorgente.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SearchStudentPanel extends JPanel {
    private JTextField txtCdfSearch, txtNome, txtCognome, txtTelefono, txtEmail, txtDataNascita;
    private JButton btnSearch;

    // costruttore
    public SearchStudentPanel() {
        setLayout(null);

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

        // pulsante per avviare la ricerca
        btnSearch = new JButton("Cerca");
        btnSearch.setBounds(210, 10, 85, 19);
        add(btnSearch);

        // evento di ricerca associato al pulsante di ricerca
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Student s = DatabaseConnection.getInstance().ricercaStudente(txtCdfSearch.getText());

                    showStudentData(s);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"STUDENTE NON TROVATO");
                }
                ;
            }
        });

        // campi di testo per mostrare il risultato della ricerca
        txtNome = createTextField(70);
        txtCognome = createTextField(96);
        txtTelefono = createTextField(128);
        txtEmail = createTextField(154);
        txtDataNascita = createTextField(185);

        // blocco edit
        txtNome.setEditable(false);
        txtCognome.setEditable(false);
        txtTelefono.setEditable(false);
        txtEmail.setEditable(false);
        txtDataNascita.setEditable(false);

        // creazione label
        add(createLabel("Nome", 70));
        add(createLabel("Cognome", 96));
        add(createLabel("Telefono", 128));
        add(createLabel("Email", 154));
        add(createLabel("Data di Nascita", 185));
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

    // metodo per mostrare i risultati del testo nei campi di testo
    public void showStudentData(Student s) {
        txtNome.setText(s.getNome());
        txtCognome.setText(s.getCognome());
        txtTelefono.setText(s.getTelefono());
        txtEmail.setText(s.getEmail());
        txtDataNascita.setText(String.valueOf(s.getDataNascita()));
    }
}
