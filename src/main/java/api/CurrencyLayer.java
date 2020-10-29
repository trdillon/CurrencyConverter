package api;

import enums.Currency;
import exception.ConverterException;
import exception.ErrorMessages;
import utils.NetworkUtil;

import java.io.IOException;

public class CurrencyLayer implements ConverterInterface {

    public static final String SERVICE_NAME = "CurrencyLayer.com";

    @Override
    public Double rate(String apiKey, Currency from, Currency to) throws IOException {
        String results = NetworkUtil.getResultsByUrl(getQueryString(apiKey, from, to), false);
        /* expected response is like the following:
            {
                "success": true,
                "terms": "https://currencylayer.com/terms",
                "privacy": "https://currencylayer.com/privacy",
                "timestamp": 1432400348,
                "source": "USD",
                "quotes": {
                "USDAUD": 1.278342,
                "USDEUR": 1.278342,
                "USDGBP": 0.908019,
                "USDPLN": 3.731504
                }
            }
            so we split at 'quotes":' to parse the results
         */
        final String[] parseResults = results.split("quotes\":");
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
            final String fromRate = parseResultsMore[0]
                    .replaceAll("\"", "")
                    .replace("{", "")
                    .split(":")[1];
            final String toRate = parseResultsMore[1]
                    .replaceAll("\"", "")
                    .replace("}", "")
                    .split(":")[1];

            return Double.parseDouble(toRate) / Double.parseDouble(fromRate);
        }
        catch (Exception e) {
            throw new ConverterException(ErrorMessages.getServiceUnavailableMsg(SERVICE_NAME));
        }
    }

    private String getQueryString(String apiKey, Currency from, Currency to) {
        return "http://api.currencylayer.com/live?access_key=" + apiKey +
                "&currencies=" + from + "," + to;
    }
}
