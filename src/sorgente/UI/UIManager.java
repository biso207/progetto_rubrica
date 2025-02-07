/*
Luca Bisognin e Diego Ferventi - 6/2/2025
Classe UIManager per gestire la grafica della rubrica
*/

package sorgente.UI;

import javax.swing.*;

public class UIManager {
    public JFrame frame;

    public UIManager() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 920, 555);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 10, 864, 480);
        frame.getContentPane().add(tabbedPane);

        // Aggiunta delle classi per ogni funzionalità
        tabbedPane.addTab("Inserisci Studente", new InsertStudentPanel());
        tabbedPane.addTab("Modifica Studente", new ModifyStudentPanel());
        tabbedPane.addTab("Cerca Studente", new SearchStudentPanel());
    }
}

