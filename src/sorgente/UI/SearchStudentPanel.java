package sorgente.UI;

import javax.swing.*;

public class SearchStudentPanel extends JPanel {
    private JTextField txtCdfSearch;
    private JButton btnSearch;
    private JLabel lblNotFound, lblResult, lblCdf;

    public SearchStudentPanel() {
        setLayout(null);

        // creazione label
        add(createLabel("Nome", 36));
        add(createLabel("Cognome", 68));
        add(createLabel("Telefono", 100));
        add(createLabel("Email", 132));
        add(createLabel("Data di Nascita", 164));
        add(createLabel("Codice Fiscale", 196));

        lblCdf = new JLabel("Codice Fiscale");
        lblCdf.setBounds(10, 8, 200, 20);
        add(lblCdf);

        txtCdfSearch = new JTextField();
        txtCdfSearch.setBounds(100, 10, 120, 20);
        add(txtCdfSearch);

        btnSearch = new JButton("Cerca");
        btnSearch.setBounds(230, 10, 85, 19);
        add(btnSearch);

        lblNotFound = new JLabel("");
        lblNotFound.setBounds(10, 40, 200, 20);
        add(lblNotFound);

        lblResult = new JLabel("");
        lblResult.setBounds(10, 70, 400, 20);
        add(lblResult);
    }

    public void showStudentData(String data) {
        lblResult.setText(data);
    }

    public void showNotFound() {
        lblNotFound.setText("Studente NON trovato");
    }

    // metodo per creare una label
    private JLabel createLabel(String text, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(10, y, 100, 13);
        return label;
    }

}
