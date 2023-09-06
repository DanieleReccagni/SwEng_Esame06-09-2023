package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.Observer;
import it.unimi.di.sweng.esame.model.Richiesta;
import it.unimi.di.sweng.esame.views.DisplayView;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class DisplayPresenter implements Observer<Map<String, Richiesta>> {
    private final @NotNull DisplayView view;
    private final @NotNull StrategyDisplay strategy;

    public DisplayPresenter(@NotNull DisplayView view, @NotNull StrategyDisplay strategy) {
        this.strategy = strategy;
        this.view = view;
    }
    @Override
    public void update(@NotNull Observable<Map<String, Richiesta>> subject) {

    }
}
