package sorgente;/*
Luca Bisognin e Diego Ferventi - inizio 6/2/2025
Classe sorgente.Main del progetto Rubrica
*/

import sorgente.UI.UIManager;

import java.awt.*;

public class Main {
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager window = new UIManager();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
