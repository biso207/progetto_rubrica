/*
Luca Bisognin e Diego Ferventi - 6/2/2025
Classe InsertStudentPanel per gestire la grafica della pagina di inserimento studente
*/

// package appartenenza
package sorgente.UI;

import sorgente.IsValid;
import sorgente.Service;
import sorgente.database.BackendException;
import sorgente.database.DatabaseConnection;
import sorgente.Student;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class InsertStudentPanel extends JPanel implements PanelStandard {
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
        btnConfirm.setBounds(10, 220, 85, 21);
        add(btnConfirm);

        // annullamento operazione
        btnCancel = new JButton("Annulla");
        btnCancel.setBounds(139, 220, 85, 21);
        add(btnCancel);

        // EVENTS BUTTONS //
        // conferma
        btnConfirm.addActionListener(e -> {
            try {
                // creazione istanza studente
                Student s = new Student();

                // setting attributi studente
                s.setNome(txtNome.getText());
                s.setCognome(txtCognome.getText());
                s.setTelefono(txtTelefono.getText());
                s.setEmail(txtEmail.getText());
                s.setDateString(txtDataNascita.getText());
                s.setCodiceFiscale(txtCdf.getText());

                // operazione per aggiungere lo studente con istanza di service
                Service service = new Service();
                service.addStudent(s);

                // messaggio di successo
                JOptionPane.showMessageDialog(null,"STUDENTE CREATO CON SUCCESSO");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                ex.printStackTrace();
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
        add(createLabel("Nome", 10));
        add(createLabel("Cognome", 42));
        add(createLabel("Telefono", 74));
        add(createLabel("Email", 106));
        add(createLabel("Data di Nascita", 138));
        add(createLabel("Codice Fiscale", 170));
    }

    // metodo per creare i textFields
    public void createTextFields() {
        // campi di testo per mostrare il risultato della ricerca
        txtNome = createTextField(10);
        txtCognome = createTextField(42);
        txtTelefono = createTextField(74);
        txtEmail = createTextField(106);
        txtDataNascita = createTextField(138);
        txtCdf = createTextField(170);
    }
}

