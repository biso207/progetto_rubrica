package sorgente.UI;

import javax.swing.*;

public class InsertStudentPanel extends JPanel {
    private JTextField txtNome, txtCognome, txtTelefono, txtEmail, txtDataNascita, txtCdf;
    private JButton btnConfirm, btnCancel;

    public InsertStudentPanel() {
        setLayout(null);

        // Creazione dei campi di testo
        txtNome = createTextField(128, 10);
        txtCognome = createTextField(128, 36);
        txtTelefono = createTextField(128, 65);
        txtEmail = createTextField(128, 94);
        txtDataNascita = createTextField(128, 122);
        txtCdf = createTextField(128, 151);

        // Creazione delle labels
        add(createLabel("Nome", 10, 10));
        add(createLabel("Cognome", 10, 36));
        add(createLabel("Telefono", 10, 68));
        add(createLabel("Email", 10, 94));
        add(createLabel("Data di Nascita", 10, 125));
        add(createLabel("Codice Fiscale", 10, 157));

        // Pulsanti
        btnConfirm = new JButton("Conferma");
        btnConfirm.setBounds(10, 204, 85, 21);
        add(btnConfirm);

        btnCancel = new JButton("Annulla");
        btnCancel.setBounds(139, 204, 85, 21);
        add(btnCancel);
    }

    // Metodi utili per creare i componenti
    private JTextField createTextField(int x, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 96, 19);
        add(textField);
        return textField;
    }

    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 100, 13);
        return label;
    }

    // Metodo per ottenere i dati inseriti
    public String[] getStudentData() {
        return new String[] {
                txtNome.getText(), txtCognome.getText(), txtTelefono.getText(),
                txtEmail.getText(), txtDataNascita.getText(), txtCdf.getText()
        };
    }
}

