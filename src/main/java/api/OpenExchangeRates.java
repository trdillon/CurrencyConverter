package api;

import enums.Currency;
import exception.ConverterException;
import exception.ErrorMessages;
import utils.NetworkUtil;

import java.io.IOException;

public class OpenExchangeRates implements ConverterInterface {

    public static final String SERVICE_NAME = "OpenExchangeRates.com";

    @Override
    public Double rate(String apiKey, Currency from, Currency to) throws IOException {
        String results = NetworkUtil.getResultsByUrl(getQueryString(apiKey, from, to), true);

        /* expected response is like the following:
            {
                disclaimer: "https://openexchangerates.org/terms/",
                license: "https://openexchangerates.org/license/",
                timestamp: 1449877801,
                base: "USD",
                rates: {
                    AED: 3.672538,
                    AFN: 66.809999,
                    ALL: 125.716501,
                    AMD: 484.902502,
                    ANG: 1.788575,
                    AOA: 135.295998,
                    ARS: 9.750101,
                    AUD: 1.390866,
                     }
                }
                so we split at 'rates:' to parse the results
         */
        final String[] parseResults = results.split("rates\":");
        // if the API response changes or doesn't return an expected response then throw service exception
        if (parseResults.length != 2) {
            throw new ConverterException(ErrorMessages.getServiceUnavailableMsg(SERVICE_NAME));
        }

        // further parse the results to isolate the numbers we want
        final String[] parseResultsMore = parseResults[1].split(",");
        if (parseResultsMore.length != 2) {
            throw new ConverterException(ErrorMessages.getServiceUnavailableMsg(SERVICE_NAME));
        }

        try {
            final String toRate = parseResultsMore[0]
                    .replaceAll(" ", "")
                    .replaceAll("\"", "")
                    .replace("{", "")
                    .split(":")[1];
            final String fromRate = parseResultsMore[1]
                    .replaceAll(" ", "")
                    .replaceAll("\"", "")
                    .replaceAll("}", "")
                    .split(":")[1];

            return Double.parseDouble(toRate) / Double.parseDouble(fromRate);
        }
        catch (Exception e) {
            throw new ConverterException(ErrorMessages.getServiceUnavailableMsg(SERVICE_NAME));
        }
    }

    private String getQueryString (String apiKey, Currency from, Currency to) {
        return "https://openexchangerates.org/api/latest.json?app_id=" + apiKey +
                "&symbols=" + from + "," + to;
    }
}
