package bfw.mvc.views;

import java.util.Set;

public class CurrencyView {

  public void showGreeting() {
    IO.println("=====Währungsrechner=====");
  }

  public void showCurrencies(Set<String> currencies) {
    IO.println("Verfügbare Währungen: " + currencies);
  }

  public String readCurrency(String label) {
    return IO.readln(label);
  }

  public void showUnknownCurrencyError(String from, String to) {
    IO.println("Unbekannte Währung");
    IO.println("Von: " + from);
    IO.println("Zu: " + to);
  }

  public String readAmount(String label) {
    return IO.readln(label);
  }

  public void showResult(double result) {
    IO.println("Das Ergebnis: " + result);
  }

  public boolean continueConverting() {
    String res = IO.readln("Nochmal (j/N): ");
    return res.equals("j");
  }
}
