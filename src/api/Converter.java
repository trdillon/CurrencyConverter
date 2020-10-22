package api;

import java.util.Currency;

public class Converter {

    private static final String API_KEY =
            "API_KEY_GOES_HERE";

    private static final String USER_AGENT =
            "Java/" + System.getProperty("java.version");

    static double rate(Currency from, Currency to) {
        return 0.0; //TODO - implement rate function
    }

}
