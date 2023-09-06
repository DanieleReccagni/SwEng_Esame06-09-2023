package it.unimi.di.sweng.esame.model;

import it.unimi.di.sweng.esame.Observable;
import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Modello implements Observable<Map<String, Richiesta>> {

  private final @NotNull Map<String,Richiesta> richieste = new HashMap<>();

  public void readFile() {
    InputStream is = Modello.class.getResourceAsStream("/reports.csv");
    assert is != null;
    Scanner s = new Scanner(is);

    while (s.hasNextLine()) {
      String linea = s.nextLine();
      String[] el = linea.split(":");

      // memorizzare quanto letto

      System.err.println(linea);
    }
  }

  @Override
  public @NotNull Map<String, Richiesta> getState() {
    Map<String,Richiesta> ritorna = new HashMap<>();
    ritorna.put("A", new Richiesta("A", 23, "B", LocalDate.of(2023, 6, 4)));
    return ritorna;
  }
}
