import it.unimi.di.sweng.esame.model.Modello;
import it.unimi.di.sweng.esame.model.Richiesta;
import it.unimi.di.sweng.esame.presenter.StrategyDisplay;
import it.unimi.di.sweng.esame.presenter.StrategyRight;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestStrategyRight {

    @Test
    public void testGetData() {
        StrategyDisplay SUT = new StrategyRight();
        Modello model = mock(Modello.class);

        Map<String, Richiesta> mappa = new HashMap<>();
        mappa.put("MI202 03/09/2023", new Richiesta("MI202", 3, "Milano", LocalDate.of(2023, 9, 3)));
        mappa.put("PV004 03/09/2023", new Richiesta("PV004", 5, "Pavia", LocalDate.of(2023, 9, 3)));
        when(model.getState()).thenReturn(mappa);

        List<Richiesta> lista = new ArrayList<>();
        lista.add(new Richiesta("PV004", 5, "Pavia", LocalDate.of(2023, 9, 3)));
        lista.add(new Richiesta("MI202", 3, "Milano", LocalDate.of(2023, 9, 3)));

        assertThat(SUT.getData(model)).isEqualTo(lista);
    }

    @Test
    public void testStampaInizio() {
        StrategyDisplay SUT = new StrategyRight();

        List<Richiesta> richieste = new ArrayList<>();
        richieste.add(new Richiesta("MI202", 3, "Milano", LocalDate.of(2023, 9, 3)));
        richieste.add(new Richiesta("PV004", 5, "Pavia", LocalDate.of(2023, 9, 3)));

        List<String> lista = new ArrayList<>();
        lista.add(String.valueOf(3));
        lista.add(String.valueOf(5));

        assertThat(SUT.stampaInizio(richieste)).isEqualTo(lista);
    }
}
