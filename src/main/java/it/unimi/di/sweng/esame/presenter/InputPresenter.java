package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.model.Modello;
import it.unimi.di.sweng.esame.views.USRView;
import org.jetbrains.annotations.NotNull;

public class InputPresenter implements Presenter {
    private final @NotNull Modello model;
    private final @NotNull USRView view;

    public InputPresenter(@NotNull Modello model, @NotNull USRView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void action(String text1, String text2) {

    }
}
