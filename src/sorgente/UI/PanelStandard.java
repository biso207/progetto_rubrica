/*
Luca Bisognin e Diego Ferventi - 7/2/2025
Interfaccia PanelStandard per i metodi utili alle classi che gestiscono le schermate grafiche
*/

// package appartenenza
package sorgente.UI;

import javax.swing.*;

public interface PanelStandard {
    JTextField createTextField(int y);
    JLabel createLabel(String text, int y);
    void createLabels();
    void createTextFields();
}
