package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.model.Modello;
import it.unimi.di.sweng.esame.model.Richiesta;
import it.unimi.di.sweng.esame.views.USRView;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class InputPresenter implements Presenter {
    private final @NotNull Modello model;
    private final @NotNull USRView view;

    public InputPresenter(@NotNull Modello model, @NotNull USRView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void action(String text1, String text2) {
        if (text1.equals("") || text2.equals("")) throw new IllegalArgumentException();

        String[] splittata = text2.split(":");

        if (splittata[0].length() != 5 ||
                splittata[0].charAt(0) < 65 || splittata[0].charAt(0) > 90 ||
                splittata[0].charAt(1) < 65 || splittata[0].charAt(1) > 90 ||
                splittata[0].charAt(2) < 48 || splittata[0].charAt(2) > 57 ||
                splittata[0].charAt(3) < 48 || splittata[0].charAt(3) > 57 ||
                splittata[0].charAt(4) < 48 || splittata[0].charAt(4) > 57) {
            view.showError("Codice istituto non valido");
            return;
        }

        String[] split = splittata[3].split("/");
        if (split.length != 3) {
            view.showError("Data inizio non corretta");
            return;
        }

        model.aggiungi(new Richiesta(splittata[0], Integer.parseInt(splittata[1]), splittata[2],
                LocalDate.of(Integer.parseInt(split[2]), Integer.parseInt(split[1]), Integer.parseInt(split[0]))));
        view.showSuccess();
    }
}
