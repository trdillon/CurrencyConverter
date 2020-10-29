package utils;

import exception.ConverterException;
import exception.ErrorMessages;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class NetworkUtil {

    public static String getResultsByUrl(String urlString, boolean isHttps) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection =
                isHttps ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        if (connection.getResponseCode() != 200) {
            int responseCode = connection.getResponseCode();
            String errorMessage = connection.getResponseMessage();
            throw new ConverterException(ErrorMessages.getNetworkErrorMsg(errorMessage, responseCode));
        }

        String results = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()))
                .lines()
                .collect(Collectors.joining());

        connection.disconnect();

        return results;
    }
}
