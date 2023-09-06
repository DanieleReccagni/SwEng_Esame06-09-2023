package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.model.Richiesta;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class StrategyLeft implements StrategyDisplay {
    @Override
    public List<Richiesta> getData(@NotNull Observable<Map<String,Richiesta>> subject) {
        return null;
    }
}
