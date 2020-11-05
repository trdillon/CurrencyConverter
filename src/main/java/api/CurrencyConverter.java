package api;

import enums.Currency;
import exception.ConverterException;
import exception.ErrorMessages;
import utils.NetworkUtil;

import java.io.IOException;

public class CurrencyConverter implements ConverterInterface {

    public static final String SERVICE_NAME = "CurrencyConverterAPI.com";

    public Double rate(String apiKey, Currency from, Currency to) throws IOException {
        String results = NetworkUtil.getResultsByUrl(getQueryString(apiKey, from, to), true);

        // Expected responses are like {"USD_JPY":0.0000999} so we split at the ":" to parse the results
        String[] parseResults = results.split(":");
        // If the API response changes or doesn't return an expected response then throw service exception
        if (parseResults.length != 2) {
            throw new ConverterException(ErrorMessages.getServiceUnavailableMsg(SERVICE_NAME));
        }

        return Double.parseDouble(parseResults[1].replace("}", ""));
    }

    // Build the URL query for API call
    private String getQueryString(String apiKey, Currency from, Currency to) {
        return "https://free.currconv.com/api/v7/convert?q=" + from + "_" + to +
               "&compact=ultra&apiKey=" + apiKey;
    }
}
