import it.unimi.di.sweng.esame.model.Modello;
import it.unimi.di.sweng.esame.model.Richiesta;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestModello {

    @Test
    public void testGetStateAfterReadFile() {
        Modello SUT = new Modello();
        SUT.readFile();

        assertThat(SUT.getState().get("MI202 03/09/2023")).isEqualTo(new Richiesta("MI202", 3, "Milano", LocalDate.of(2023, 9, 3)));
        assertThat(SUT.getState().get("PV004 03/09/2023")).isEqualTo(new Richiesta("PV004", 5, "Pavia", LocalDate.of(2023, 9, 3)));
    }

}
