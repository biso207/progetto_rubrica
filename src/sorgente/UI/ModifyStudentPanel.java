/*
Luca Bisognin e Diego Ferventi - 6/2/2025
Classe ModifyStudentPanel per gestire la grafica della pagina di modifica studente
*/

// package appartenenza
package sorgente.UI;

import sorgente.IsValid;
import sorgente.database.DatabaseConnection;
import sorgente.Student;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class ModifyStudentPanel extends JPanel implements PanelStandard {
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
        lblCdfCer.setBounds(10, 12, 100, 13);
        add(lblCdfCer);

        // campo di testo per la digitazione del codice fiscale
        txtCdfSearch = new JTextField();
        txtCdfSearch.setColumns(10);
        txtCdfSearch.setBounds(130, 10, 100, 20);
        add(txtCdfSearch);

        // BUTTONS //
        // conferma operazione modifica
        btnConfirm = new JButton("Conferma");
        btnConfirm.setBounds(10, 220, 85, 21);
        btnConfirm.setEnabled(false);
        add(btnConfirm);

        // annullamento operazione
        btnCancel = new JButton("Annulla");
        btnCancel.setBounds(139, 220, 85, 21);
        add(btnCancel);

        // pulsante per avviare la ricerca
        btnSearch = new JButton("Cerca");
        btnSearch.setBounds(250, 10, 85, 19);
        add(btnSearch);

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
                    txtCdfSearch.setEditable(false);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "STUDENTE NON TROVATO");
                }
            }
        });

        // annullamento operazione
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // svuotamento text field
                clearTextFields();

                // blocco button conferma
                btnConfirm.setEnabled(false);
                txtCdfSearch.setEditable(true);
            }
        });

        // conferma modifica studente
        btnConfirm.addActionListener(e -> {
            // try-catch per stampare il risultato dell'operazione
            try {
                Student s = new Student();

                // setting degli attributi
                s.setNome(txtNome.getText());
                s.setCognome(txtCognome.getText());
                s.setTelefono(txtTelefono.getText());
                s.setEmail(txtEmail.getText());
                s.setCodiceFiscale(txtCdfSearch.getText());
                s.setDataNascita(Date.valueOf(txtDataNascita.getText()));

                if(IsValid.student(s)) {
                    DatabaseConnection.getInstance().modificaStudente(s);
                    JOptionPane.showMessageDialog(null, "STUDENTE MODIFICATO CORRETTAMENTE");
                    txtCdfSearch.setEditable(true);
                    clearTextFields();
                }
                else{
                    throw new IllegalArgumentException();
                }
            } catch (SQLException ex ) {
                JOptionPane.showMessageDialog(null, "C'E' STATO UN PROBLEMA NELLA MODIFICA STUDENTE");
            }catch (IllegalArgumentException ex ){
                JOptionPane.showMessageDialog(null, "UNO O PIU' CAMPI NON VALIDI");
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

    // Metodo per abilitare stampare i testi dopo la ricerca
    public void showStudentData(Student s) {
        txtNome.setText(s.getNome());
        txtCognome.setText(s.getCognome());
        txtTelefono.setText(s.getTelefono());
        txtEmail.setText(s.getEmail());
        txtDataNascita.setText(String.valueOf(s.getDataNascita()));
        btnConfirm.setEnabled(true);
    }

    public void clearTextFields(){
        txtNome.setText("");
        txtCognome.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        txtDataNascita.setText("");
        txtCdfSearch.setText("");
    }
}
