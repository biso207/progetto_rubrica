/*
Luca Bisognin e Diego Ferventi - 11/2/2025
Classe StatoModifiche per la variabile di controllo modifiche
*/

// package di appartenenza
package sorgente.UI;

// import librerie
import java.util.ArrayList;
import java.util.List;

public class StatoModifiche  {
    private static StatoModifiche instance;
    private boolean stato = false;
    private final List<StatoListener> listeners = new ArrayList<>();

    private StatoModifiche() {}

    public static StatoModifiche getInstance() {
        if (instance == null) {
            instance = new StatoModifiche();
        }
        return instance;
    }

    public boolean getState() {
        return stato;
    }

    public void setState(boolean stato) {
        this.stato = stato;
        notifyListeners();
    }

    public void addListener(StatoListener listener) {
        listeners.add(listener);
    }

    private void notifyListeners() {
        for (StatoListener listener : listeners) {
            listener.statoCambiato(stato);
        }
    }
}

