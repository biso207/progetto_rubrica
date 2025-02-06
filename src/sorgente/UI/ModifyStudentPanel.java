package sorgente.UI;

import sorgente.Student;

import javax.swing.*;
import java.sql.Date;

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

        lblNotFound = new JLabel("");
        lblNotFound.setBounds(10, 40, 200, 20);
        add(lblNotFound);

        // Campi inizialmente nascosti
        txtNome = createTextField(128, 70);
        txtCognome = createTextField(128, 96);
        txtTelefono = createTextField(128, 128);
        txtEmail = createTextField(128, 154);
        txtDataNascita = createTextField(128, 185);

        add(createLabel("Nome", 10, 70));
        add(createLabel("Cognome", 10, 96));
        add(createLabel("Telefono", 10, 128));
        add(createLabel("Email", 10, 154));
        add(createLabel("Data di Nascita", 10, 185));

        btnConfirm = new JButton("Conferma");
        btnConfirm.setBounds(10, 220, 85, 21);
        btnConfirm.setEnabled(false);
        add(btnConfirm);

        btnCancel = new JButton("Annulla");
        btnCancel.setBounds(139, 220, 85, 21);
        add(btnCancel);
    }

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

    // Metodo per abilitare i campi dopo la ricerca
    public void showStudentData(Student s) {
        txtNome.setText(s.getNome());
        txtCognome.setText(s.getCognome());
        txtTelefono.setText(s.getTelefono());
        txtEmail.setText(s.getEmail());
        txtDataNascita.setText(String.valueOf(s.getDataNascita()));
        btnConfirm.setEnabled(true);
    }
}
