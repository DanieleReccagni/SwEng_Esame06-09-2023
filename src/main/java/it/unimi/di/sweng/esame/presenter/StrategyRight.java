package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.model.Richiesta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StrategyRight implements StrategyDisplay {
    @Override
    public List<Richiesta> getData(@NotNull Observable<Map<String, Richiesta>> subject) {
        List<Richiesta> lista = new ArrayList<>(subject.getState().values());
        lista.sort((o1, o2) -> {
            if (o1.durata() == o2.durata())
                return o1.data().compareTo(o2.data());
            return o1.durata() - o2.durata();
        });
        return lista;
    }

    @Override
    public List<String> stampaInizio(@NotNull List<Richiesta> lista) {
        List<String> ritorna = new ArrayList<>();
        for (Richiesta r : lista)
            ritorna.add(String.valueOf(r.durata()));
        return ritorna;
    }
}
