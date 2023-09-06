package it.unimi.di.sweng.esame.model;

import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.Observer;
import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.*;


public class Modello implements Observable<Map<String, Richiesta>> {

  private final @NotNull Map<String,Richiesta> richieste = new LinkedHashMap<>();
  private final @NotNull List<Observer<Map<String,Richiesta>>> observers = new ArrayList<>();

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

    notifyObservers();
  }

  @Override
  public @NotNull Map<String, Richiesta> getState() {
    return new HashMap<>(richieste);
  }

  @Override
  public void addObserver(@NotNull Observer<Map<String, Richiesta>> obs) {
    observers.add(obs);
  }

  @Override
  public void notifyObservers() {
    for (Observer<Map<String,Richiesta>> obs : observers)
      obs.update(this);
  }
}
