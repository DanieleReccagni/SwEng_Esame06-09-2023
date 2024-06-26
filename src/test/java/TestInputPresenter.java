import it.unimi.di.sweng.esame.model.Modello;
import it.unimi.di.sweng.esame.model.Richiesta;
import it.unimi.di.sweng.esame.presenter.InputPresenter;
import it.unimi.di.sweng.esame.presenter.Presenter;
import it.unimi.di.sweng.esame.views.USRView;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.Mockito.*;

public class TestInputPresenter {
    @Test
    public void testActionInserisci() {
        Modello model = mock(Modello.class);
        USRView view = mock(USRView.class);
        Presenter SUT = new InputPresenter(model, view);

        assertThatIllegalArgumentException().isThrownBy(() -> SUT.action("", "ehi"));
        assertThatIllegalArgumentException().isThrownBy(() -> SUT.action("button", ""));

        SUT.action("Inserisci", "LC169:8:Lecco:11/09/2023");
        verify(model).aggiungi(new Richiesta("LC169", 8, "Lecco", LocalDate.of(2023, 9, 11)));

        verify(view).showSuccess();
    }

    @Test
    public void testCodiceNonValido() {
        Modello model = mock(Modello.class);
        USRView view = mock(USRView.class);
        Presenter SUT = new InputPresenter(model, view);

        SUT.action("Inserisci", "PP02:1:1:1");
        SUT.action("Inserisci", "P002P:1:1:1");
        SUT.action("Inserisci", "00002:1:1:1");
        verify(view, times(3)).showError("Codice istituto non valido");
    }

    @Test
    public void testDataErrata() {
        Modello model = mock(Modello.class);
        USRView view = mock(USRView.class);
        Presenter SUT = new InputPresenter(model, view);

        SUT.action("Inserisci", "LC169:8:Lecco:11-09-2023");
        verify(view).showError("Data inizio non corretta");
    }
}
