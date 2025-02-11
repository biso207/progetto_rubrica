/*
Luca Bisognin e Diego Ferventi - 11/2/2025
Classe CommitRollbackPanel per gestire la grafica delle operazioni di commit o rollback
*/

// package appartenenza
package sorgente.UI;

import sorgente.Service;

import javax.swing.*;

public class CommitRollbackPanel extends JPanel implements StatoListener {
    private final JButton btnCommit, btnRollback;

    // costruttore
    public CommitRollbackPanel() {
        Service s = new Service();
        setLayout(null);

        // classe registrata come listener
        StatoModifiche.getInstance().addListener(this);

        // BUTTONS //
        // button per il commit
        btnCommit = new JButton("Commit");
        btnCommit.setBounds(10, 10, 85, 19);

        // button per il rollback
        btnRollback = new JButton("Rollback");
        btnRollback.setBounds(110, 10, 85, 19);

        // blocco/sblocco buttons
        btnCommit.setEnabled(StatoModifiche.getInstance().getState());
        btnRollback.setEnabled(StatoModifiche.getInstance().getState());

        // aggiunta buttons
        add(btnCommit);
        add(btnRollback);

        // EVENTS BUTTONS //
        // esecuzione del commit
        btnCommit.addActionListener(_ -> {
            // richiamo del commit
            s.transactions(1);

            // cambio stato modifiche
            boolean stato = !StatoModifiche.getInstance().getState();
            StatoModifiche.getInstance().setState(stato);
        });

        // esecuzione del rollback
        btnRollback.addActionListener(_ -> {
            // richiamo del rollback
            s.transactions(2);

            // cambio stato modifiche
            boolean stato = !StatoModifiche.getInstance().getState();
            StatoModifiche.getInstance().setState(stato);
        });

    }

    @Override
    public void statoCambiato(boolean nuovoStato) {
        // blocco/sblocco buttons
        btnCommit.setEnabled(nuovoStato);
        btnRollback.setEnabled(nuovoStato);
    }
}
