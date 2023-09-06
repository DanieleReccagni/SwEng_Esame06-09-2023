package it.unimi.di.sweng.esame.model;

import java.io.InputStream;
import java.util.Scanner;


public class Modello  {


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

}
