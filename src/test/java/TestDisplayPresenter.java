import it.unimi.di.sweng.esame.Main;
import it.unimi.di.sweng.esame.model.Modello;
import it.unimi.di.sweng.esame.model.Richiesta;
import it.unimi.di.sweng.esame.presenter.DisplayPresenter;
import it.unimi.di.sweng.esame.presenter.StrategyDisplay;
import it.unimi.di.sweng.esame.views.DisplayView;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class TestDisplayPresenter {
    @Test
    public void testUpdate() {
        Modello model = mock(Modello.class);
        DisplayView view = mock(DisplayView.class);
        StrategyDisplay strategy = mock(StrategyDisplay.class);
        DisplayPresenter SUT = new DisplayPresenter(view, strategy);

        List<Richiesta> lista = new ArrayList<>();
        lista.add(new Richiesta("MI202", 3, "Milano", LocalDate.of(2023, 9, 3)));
        lista.add(new Richiesta("PV004", 5, "Pavia", LocalDate.of(2023, 9, 3)));
        when(strategy.getData(model)).thenReturn(lista);

        List<String> stringhe = new ArrayList<>();
        stringhe.add("Milano");
        stringhe.add("Pavia");
        when(strategy.stampaInizio(lista)).thenReturn(stringhe);

        SUT.update(model);

        verify(view).set(0, "Milano : dal 03/09/2023 - MI202");
        verify(view).set(1, "Pavia : dal 03/09/2023 - PV004");
        for (int i=2; i<Main.NUMVOCIELENCO; i++)
            verify(view).set(i, "");
    }

}
