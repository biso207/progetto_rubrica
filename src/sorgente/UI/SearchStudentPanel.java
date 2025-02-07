/*
Luca Bisognin e Diego Ferventi - 6/2/2025
Classe SearchStudentPanel per gestire la grafica della pagina di ricerca studente
*/

// package appartenenza
package sorgente.UI;

import sorgente.Service;
import sorgente.database.BackendException;
import sorgente.database.DatabaseConnection;
import sorgente.Student;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SearchStudentPanel extends JPanel  implements PanelStandard {
    private JTextField txtCdfSearch, txtNome, txtCognome, txtTelefono, txtEmail, txtDataNascita;
    private JButton btnSearch;

    // costruttore
    public SearchStudentPanel() {
        setLayout(null);

        // creazione labels
        createLabels();

        // creazione text fields
        createTextFields();

        // CODICE FISCALE //
        // label di riferimento
        JLabel lblCdfCer = new JLabel("Codice Fiscale");
        lblCdfCer.setBounds(10, 12, 100, 13);
        add(lblCdfCer);

        // campo di testo per la digitazione del codice fiscale
        txtCdfSearch = new JTextField();
        txtCdfSearch.setColumns(10);
        txtCdfSearch.setBounds(130, 10, 100, 20);
        add(txtCdfSearch);

        // textFields non editabili
        txtNome.setEditable(false);
        txtCognome.setEditable(false);
        txtTelefono.setEditable(false);
        txtEmail.setEditable(false);
        txtDataNascita.setEditable(false);

        // BUTTON //
        // pulsante per avviare la ricerca
        btnSearch = new JButton("Cerca");
        btnSearch.setBounds(250, 10, 85, 19);
        add(btnSearch);

        // EVENT BUTTON //
        // evento di ricerca associato al pulsante di ricerca
        btnSearch.addActionListener(e -> {
            if (!txtCdfSearch.getText().isEmpty()) {
                try {
                    // istanza di Service
                    Service s = new Service();

                    // creazione oggetto studente
                    Student student = s.searchStudente(txtCdfSearch.getText());

                    // mostrati dati utente
                    showStudentData(student);

                    // campo codice fiscale non editabile
                    txtCdfSearch.setEditable(false);
                }
                catch (BackendException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    // metodo per creare un campo di testo
    public JTextField createTextField(int y) {
        JTextField textField = new JTextField();
        textField.setBounds(130, y, 100, 20);
        add(textField);
        return textField;
    }

    // metodo per creare una label
    public JLabel createLabel(String text, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(10, y, 100, 13);
        return label;
    }

    // metodo per creare i labels
    public void createLabels() {
        // creazione label
        add(createLabel("Nome", 42));
        add(createLabel("Cognome", 74));
        add(createLabel("Telefono", 106));
        add(createLabel("Email", 138));
        add(createLabel("Data di Nascita", 170));
    }

    // metodo per creare i textFields
    public void createTextFields() {
        // campi di testo per mostrare il risultato della ricerca
        txtNome = createTextField(42);
        txtCognome = createTextField(74);
        txtTelefono = createTextField(106);
        txtEmail = createTextField(138);
        txtDataNascita = createTextField(170);
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
