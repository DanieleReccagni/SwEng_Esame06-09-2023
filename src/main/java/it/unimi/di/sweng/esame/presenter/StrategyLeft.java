package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.model.Richiesta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StrategyLeft implements StrategyDisplay {
    @Override
    public List<Richiesta> getData(@NotNull Observable<Map<String,Richiesta>> subject) {
        List<Richiesta> lista = new ArrayList<>(subject.getState().values());
        lista.sort((o1, o2) -> {
            if (o1.comune().compareTo(o2.comune()) == 0)
                return o1.data().compareTo(o2.data());
            return o1.comune().compareTo(o2.comune());
        });
        return lista;
    }
}
