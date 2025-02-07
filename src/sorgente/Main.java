/*
Luca Bisognin e Diego Ferventi - 6/2/2025
Classe sorgente.Main del progetto Rubrica
*/

// package appartenenza
package sorgente;

import sorgente.UI.UIManager;

import java.awt.*;

public class Main {
    // metodo main principale -> entrata del programma
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
