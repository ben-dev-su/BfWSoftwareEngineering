package bfw.mvc;

import bfw.mvc.controller.CurrencyController;
import bfw.mvc.model.CurrencyConverter;
import bfw.mvc.views.CurrencyView;

public class Main {

  public static void main(String[] args) {
    CurrencyConverter converter = new CurrencyConverter();
    CurrencyView view = new CurrencyView();
    CurrencyController controller = new CurrencyController(converter, view);

    controller.run();
  }
}
