package UI;

import javax.swing.*;

public class SearchStudentPanel extends JPanel {
    private JTextField txtCdfSearch;
    private JButton btnSearch;
    private JLabel lblNotFound, lblResult;

    public SearchStudentPanel() {
        setLayout(null);

        txtCdfSearch = new JTextField();
        txtCdfSearch.setBounds(10, 10, 120, 19);
        add(txtCdfSearch);

        btnSearch = new JButton("Cerca");
        btnSearch.setBounds(140, 10, 85, 21);
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
}
