package sorgente.UI;

import sorgente.Student;

import javax.swing.*;

public interface PanelStandard {
    JTextField createTextField(int y);
    JLabel createLabel(String text, int y);
    void createLabels();
    void createTextFields();
}
