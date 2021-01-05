package api;

import enums.Currency;

import java.io.IOException;

public interface ConverterInterface {
    Double rate(String apiKey, Currency from, Currency to) throws IOException;
}
