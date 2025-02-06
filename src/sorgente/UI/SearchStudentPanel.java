package sorgente.UI;

import sorgente.DatabaseConnection;
import sorgente.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SearchStudentPanel extends JPanel {
    private JTextField txtCdfCer;
    private JButton btnSearch;
    private JLabel lblNomeOut,lblCognomeOut,lblTelefonoOut,lblEmailOut,lblDataOut;
    public SearchStudentPanel() {
        setLayout(null);

        txtCdfCer = new JTextField();
        txtCdfCer.setColumns(10);
        txtCdfCer.setBounds(128, 10, 96, 19);
        add(txtCdfCer);

        JLabel lblCdfCer = new JLabel("Codice Fiscale");
        lblCdfCer.setBounds(10, 16, 96, 13);
        add(lblCdfCer);

        JButton btnCerca = new JButton("Cerca");
        btnCerca.setBounds(10, 39, 85, 21);
        add(btnCerca);
        btnCerca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Student s = DatabaseConnection.getInstance().ricercaStudente(txtCdfCer.getText());
                    lblNomeOut.setText(s.getNome());
                    lblCognomeOut.setText(s.getCognome());
                    lblTelefonoOut.setText(s.getTelefono());
                    lblEmailOut.setText(s.getEmail());
                    lblDataOut.setText(s.getDataNascita().toString());
                } catch (SQLException ex) {
                    showNotFound();
                }
                ;
            }
        });

        JLabel lblNomeCer = new JLabel("Nome");
        lblNomeCer.setBounds(10, 70, 69, 13);
        add(lblNomeCer);

        JLabel lblCognomeCer = new JLabel("Cognome");
        lblCognomeCer.setBounds(10, 96, 85, 13);
        add(lblCognomeCer);

        JLabel lblTelefonoCer = new JLabel("Telefono");
        lblTelefonoCer.setBounds(10, 128, 69, 13);
        add(lblTelefonoCer);

        JLabel lblEmailCer = new JLabel("Email");
        lblEmailCer.setBounds(10, 154, 69, 13);
        add(lblEmailCer);

        JLabel lblDataCer = new JLabel("Data Di Nascita");
        lblDataCer.setBounds(10, 185, 110, 13);
        add(lblDataCer);

        lblNomeOut = new JLabel("");
        lblNomeOut.setBounds(128, 70, 139, 13);
        add(lblNomeOut);

        lblCognomeOut = new JLabel("");
        lblCognomeOut.setBounds(128, 96, 96, 13);
        add(lblCognomeOut);

        lblTelefonoOut = new JLabel("");
        lblTelefonoOut.setBounds(128, 128, 96, 13);
        add(lblTelefonoOut);

        lblEmailOut = new JLabel("");
        lblEmailOut.setBounds(128, 154, 96, 13);
        add(lblEmailOut);

        lblDataOut = new JLabel("");
        lblDataOut.setBounds(128, 185, 96, 13);
        add(lblDataOut);
    }

    public void showNotFound() {
        JOptionPane.showMessageDialog(null,"Studente NON trovato");
    }
}
