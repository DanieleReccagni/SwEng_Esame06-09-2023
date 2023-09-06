import it.unimi.di.sweng.esame.Observer;
import it.unimi.di.sweng.esame.model.Modello;
import it.unimi.di.sweng.esame.model.Richiesta;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class TestModello {

    @Test
    public void testGetStateAfterReadFile() {
        Modello SUT = new Modello();
        SUT.readFile();

        assertThat(SUT.getState().get("MI202 03/09/2023")).isEqualTo(new Richiesta("MI202", 3, "Milano", LocalDate.of(2023, 9, 3)));
        assertThat(SUT.getState().get("PV004 03/09/2023")).isEqualTo(new Richiesta("PV004", 5, "Pavia", LocalDate.of(2023, 9, 3)));
    }

    @Test
    public void testNotifyObserversWithAddObserver() {
        Observer<Map<String,Richiesta>> obs = mock(Observer.class);
        Observer<Map<String,Richiesta>> obs1 = mock(Observer.class);

        Modello SUT = new Modello();

        SUT.addObserver(obs);
        SUT.addObserver(obs1);

        SUT.readFile();

        verify(obs).update(eq(SUT));
        verify(obs1).update(eq(SUT));
    }

    @Test
    public void testAggiungi() {
        Modello SUT = new Modello();

        SUT.aggiungi(new Richiesta("RO123", 2, "Roma", LocalDate.of(2023, 4, 21)));

        assertThat(SUT.getState().get("RO123 21/04/2023")).isEqualTo(new Richiesta("RO123", 2, "Roma", LocalDate.of(2023, 4, 21)));
    }
}
