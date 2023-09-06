package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.model.Richiesta;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public interface StrategyDisplay {
    List<Richiesta> getData(@NotNull Observable<Map<String,Richiesta>> subject);
    List<String> stampaInizio(@NotNull List<Richiesta> lista);
}
