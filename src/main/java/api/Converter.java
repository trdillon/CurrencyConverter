package api;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Currency;
import java.util.Scanner;

public class Converter {

    private static final String API_KEY =
            "API_KEY_GOES_HERE";

    private static final String USER_AGENT =
            "Java/" + System.getProperty("java.version");

    static double rate(Currency from, Currency to) throws IOException {
        //build the query - TODO - don't need to retrieve the API key for every call
        String queryPath
                = "https://free.currconv.com/api/v7/convert?q="
                + from.getCurrencyCode() + "_"
                + to.getCurrencyCode()
                + "&compact=ultra&apiKey=" + API_KEY;
        URL queryURL = new URL(queryPath);

        //create the connection - cast to HttpURLConnection so we can access getResponseCode()
        HttpURLConnection connection
                = (HttpURLConnection) queryURL.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = connection.getResponseCode();

        //if we get OK response then parse the response to get the number
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream stream
                    = (InputStream) connection.getContent();
            Scanner scanner = new Scanner(stream);
            String input = scanner.nextLine();
            //API response is like {"USD_JPY":0.000050799712}
            String number = input.substring(input.indexOf(':') + 1,
                    input.indexOf('}'));
            return Double.parseDouble(number);
        }
        else {
            String errMsg = "Query " + queryPath
                    + " returned status " + responseCode;
            throw new RuntimeException(errMsg);
        }
        //TODO - test converter function
    }
}
