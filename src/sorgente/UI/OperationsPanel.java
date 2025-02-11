/*
Luca Bisognin e Diego Ferventi - 11/2/2025
Classe OperationsPanel per gestire le operazioni di commit o rollback
*/

// package appartenenza
package sorgente.UI;

import sorgente.Main;
import sorgente.Service;

import javax.swing.*;

public class OperationsPanel extends JPanel {

    // costruttore
    public OperationsPanel() {
        Service s = new Service();
        setLayout(null);

        // BUTTONS //
        // button per il commit
        JButton btnCommit = new JButton("Commit");
        btnCommit.setBounds(10, 10, 85, 19);
        add(btnCommit);

        // button per il rollback
        JButton btnRollback = new JButton("Rollback");
        btnRollback.setBounds(110, 10, 85, 19);
        add(btnRollback);

        // blocco/sblocco buttons
        //btnCommit.setEnabled(UIManager.getChanged());
        //btnRollback.setEnabled(UIManager.getChanged());

        // EVENTS BUTTONS //
        // esecuzione del commit
        btnCommit.addActionListener(_ -> {
            // richiamo del commit
            s.transactions(1);
        });

        // esecuzione del rollback
        btnRollback.addActionListener(_ -> {
            // richiamo del rollback
            s.transactions(2);
        });

    }
}
