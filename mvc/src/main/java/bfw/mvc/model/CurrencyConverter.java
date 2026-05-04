package bfw.mvc.model;

import java.util.Map;
import java.util.HashMap;

public class CurrencyConverter {
  private final Map<String, Double> rates = new HashMap<>();

  // | Währung | Kurs |
  // |---------|------|
  // | USD | 1,1706 |
  // | GBP | 0,8664 |
  // | JPY | 187,05 |
  // | CHF | 0,9168 |
  // | CAD | 1,6138 |
  // | AUD | 1,6814 |

  public CurrencyConverter() {
    rates.put("EUR", 1.0000);
    rates.put("USD", 1.1706);
    rates.put("GBP", 0.8664);
    rates.put("JPY", 187.05);
    rates.put("CHF", 0.9168);
    rates.put("CAD", 1.6138);
    rates.put("AUD", 1.6814);
  }

  public double convert(String from, String to, double amount) {
    if (from == null)
      throw new IllegalArgumentException("'From' can't be null");

    if (to == null)
      throw new IllegalArgumentException("'To' can't be null.");

    if (amount < 0.0)
      throw new IllegalArgumentException("Amount must be a positive number: " + amount);

    double inEuro = amount / rates.get(from);
    return inEuro * rates.get(to);
  }

  public Map<String, Double> getRates() {
    return rates;
  }
}
