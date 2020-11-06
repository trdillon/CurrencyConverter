import api.OpenExchangeRates;
import enums.Currency;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * OpenExchangeRates Tester.
 *
 * @author Tim
 * @since Oct 28, 2020
 * @version 1.1
 */

public class TestOpenExchangeRates {

    private static final String APIKEY
            = "API_KEY_GOES_HERE";

    private static final Currency USD
            = Currency.USD;

    private static final Currency HKD
            = Currency.HKD;

    private static final Currency JPY
            = Currency.JPY;

    private static final double TEST_DELTA = 0.001;

    OpenExchangeRates openExchangeRates = new OpenExchangeRates();

    /**
     *
     * Method: rate(String apiKey, Currency from, Currency to)
     *
     */
    @Test
    void shouldReturnRateEqualToExpected() throws IOException {
        double expected = 7.75;
        double actual = openExchangeRates.rate(APIKEY, USD, HKD);
        assertEquals(expected, actual, TEST_DELTA);
    }

    @Test
    void shouldReturnRateNotEqualToExpected() throws IOException {
        double expected = 7.77;
        double actual = openExchangeRates.rate(APIKEY, USD, HKD);
        assertNotEquals(expected, actual, TEST_DELTA);
    }

    //TODO - edit rate() to account for base from always being USD
    @Test
    void testRate() throws IOException {
        double USDtoJPY = openExchangeRates.rate(APIKEY, USD, JPY);
        double JPYtoUSD = openExchangeRates.rate(APIKEY, JPY, USD);
        System.out.println("US Dollars to Japanese Yen is: " + USDtoJPY);
        System.out.println("Japanese Yen to US Dollars is: " + JPYtoUSD);

        double expected = 1.0;
        double actual = USDtoJPY * JPYtoUSD;
        assertEquals(expected, actual, TEST_DELTA);
    }
}
