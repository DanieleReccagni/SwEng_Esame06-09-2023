package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.Main;
import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.Observer;
import it.unimi.di.sweng.esame.model.Richiesta;
import it.unimi.di.sweng.esame.views.DisplayView;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class DisplayPresenter implements Observer<Map<String, Richiesta>> {
    private final @NotNull DisplayView view;
    private final @NotNull StrategyDisplay strategy;

    public DisplayPresenter(@NotNull DisplayView view, @NotNull StrategyDisplay strategy) {
        this.strategy = strategy;
        this.view = view;
    }
    @Override
    public void update(@NotNull Observable<Map<String,Richiesta>> subject) {
        int i=0;
        List<String> inizio = strategy.stampaInizio(strategy.getData(subject));
        for (Richiesta r : strategy.getData(subject)) {
            StringBuilder s = new StringBuilder();
            s.append(inizio.get(i));
            s.append(" : dal ");
            if (r.data().getDayOfMonth() < 10)
                s.append("0");
            s.append(r.data().getDayOfMonth());
            s.append("/");
            if (r.data().getMonth().getValue() < 10)
                s.append("0");
            s.append(r.data().getMonth().getValue());
            s.append("/");
            s.append(r.data().getYear());
            s.append(" - ");
            s.append(r.codice());
            view.set(i, s.toString());
            i++;
        }
        while (i < Main.NUMVOCIELENCO) {
            view.set(i, "");
            i++;
        }
    }
}
