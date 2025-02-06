package UI;

import javax.swing.*;

public interface GeneralUI {
    // metodo per definire i campi di inserimento testo
    void createTextFields(JPanel panel, boolean isSearchMode);
    // metodo per creare i labels con il testo che fa riferimento al campo di inserimento a lato
    void createLabels(JPanel panel, boolean isSearchMode);
}
