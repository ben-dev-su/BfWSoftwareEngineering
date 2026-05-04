package bfw.mvc.controller;

import bfw.mvc.model.CurrencyConverter;
import bfw.mvc.views.CurrencyView;

public class CurrencyController {
  private final CurrencyConverter converter;
  private final CurrencyView view;

  public CurrencyController(CurrencyConverter converter, CurrencyView view) {
    this.converter = converter;
    this.view = view;
  }

  public void run() {
    view.showGreeting();
    view.showCurrencies(converter.getRates().keySet());

    do {

      String from = view.readCurrency("Bitte Währung eingeben: ");
      String to = view.readCurrency("Konvertieren zu Währung: ");

      if (converter.getRates().get(from) == null || converter.getRates().get(to) == null) {
        view.showUnknownCurrencyError(from, to);
        continue;
      }

      String amountAsString = view.readAmount("Bitte Anzahl eingeben: ");
      double amount = Double.parseDouble(amountAsString);

      double result = converter.convert(from, to, amount);
      view.showResult(result);

    } while (view.continueConverting());
  }
}
