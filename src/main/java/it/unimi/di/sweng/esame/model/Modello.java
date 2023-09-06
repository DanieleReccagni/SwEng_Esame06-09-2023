package it.unimi.di.sweng.esame.model;

import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.Observer;
import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.*;


public class Modello implements Observable<Map<String, Richiesta>> {

  private final @NotNull Map<String,Richiesta> richieste = new HashMap<>();

  public void readFile() {
    InputStream is = Modello.class.getResourceAsStream("/reports.csv");
    assert is != null;
    Scanner s = new Scanner(is);

    while (s.hasNextLine()) {
      String linea = s.nextLine();
      String[] el = linea.split(":");
      String[] split = el[3].split("/");
      richieste.put(el[0] + " " + el[3], new Richiesta(el[0], Integer.parseInt(el[1]), el[2],
              LocalDate.of(Integer.parseInt(split[2]), Integer.parseInt(split[1]), Integer.parseInt(split[0]))));
    }
  }

  @Override
  public @NotNull Map<String, Richiesta> getState() {
    return new HashMap<>(richieste);
  }

  @Override
  public void addObserver(@NotNull Observer<Map<String, Richiesta>> obs) {

  }

  @Override
  public void notifyObservers() {

  }
}
