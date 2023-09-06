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
        String[] split = splittata[3].split("/");
        model.aggiungi(new Richiesta(splittata[0], Integer.parseInt(splittata[1]), splittata[2],
                LocalDate.of(Integer.parseInt(split[2]), Integer.parseInt(split[1]), Integer.parseInt(split[0]))));
        view.showSuccess();
    }
}
