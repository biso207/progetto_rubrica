/*
Luca Bisognin e Diego Ferventi - 6/2/2025
Classe TableStudentPanel per creare la tabella degli studenti nel database
*/

// package appartenenza
package sorgente.UI;

// import codici
import sorgente.Service;
import sorgente.Student;
import sorgente.database.BackendException;

// import librerie
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TableStudentPanel extends JPanel {
    private DefaultTableModel tableModel;

    // costruttore
    public TableStudentPanel() {
        setLayout(new BorderLayout());

        // BUTTONS //
        // button refresh pagina
        JButton btnRefresh = new JButton("Aggiorna");
        btnRefresh.setBounds(10, 10, 85, 21);
        btnRefresh.addActionListener(_ -> refreshTable());
        btnRefresh.setForeground(Color.BLACK);

        // aggiunto pulsante refresh
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(btnRefresh);
        add(topPanel, BorderLayout.NORTH);

        // creazione tabella
        createTable();
    }

    // metodo per la creazione della tabella
    private void createTable() {
        // colonne tabella
        String[] columnNames = {"Nome", "Cognome", "Telefono", "Email", "Data di Nascita", "Codice Fiscale"};

        // tabella
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        table.setFillsViewportHeight(true);

        // inserimento della table in un scrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // recupero studenti dal database
        refreshTable();
    }

    // metodo per aggiornare i dati della tabella senza ricrearla
    private void refreshTable() {
        try {
            Service service = new Service();
            // eliminazione righe
            tableModel.setRowCount(0);

            // recupero studenti dal database e popolamento arraylist con tutti gli studenti
            ArrayList<Student> students = service.getAll();

            // aggiunta studenti alla tabella tramite for-each
            for (Student s : students) {
                tableModel.addRow(new Object[]{
                        s.getNome(), s.getCognome(), s.getTelefono(),
                        s.getEmail(), s.getDataNascita(), s.getCodiceFiscale()
                });
            }
        } catch (BackendException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}
