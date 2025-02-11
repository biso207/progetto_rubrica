/*
Luca Bisognin e Diego Ferventi - 6/2/2025
Classe UIManager per gestire la grafica della rubrica
*/

// package di appartenenza
package sorgente.UI;

// import librerie
import javax.swing.*;

public class UIManager {
    public JFrame frame;
    // variabile per controllare se sono stati effettuati cambiamenti per il database
    public static boolean isChanged;

    // costruttore
    public UIManager() {
        initialize();
        isChanged = false;
    }

    private void initialize() {
        // setting del frame
        frame = new JFrame();
        frame.setBounds(100, 100, 900, 540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 10, 864, 480);
        frame.getContentPane().add(tabbedPane);

        // aggiunta classi per ogni funzionalità
        tabbedPane.addTab("Inserisci Studente", new InsertStudentPanel());
        tabbedPane.addTab("Modifica Studente", new ModifyStudentPanel());
        tabbedPane.addTab("Cerca Studente", new SearchStudentPanel());
        tabbedPane.addTab("Tabella Studente", new TableStudentPanel());
        tabbedPane.addTab("Commit/Rollback", new OperationsPanel());
    }

    public static void setChanged() {
        isChanged = !isChanged;
    }

    // getter dello stato modifiche
    public static boolean getChanged() {
        return isChanged;
    }
}

