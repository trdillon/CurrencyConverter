import api.Converter;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Currency;

/** 
* Converter Tester. 
* 
* @author Tim
* @since Oct 22, 2020
* @version 1.0 
*/ 
public class ConverterTest { 

    private static final Currency USD
            = Currency.getInstance("USD");

    private static final Currency HKD
            = Currency.getInstance("HKD");

    private static final Currency JPY
            = Currency.getInstance("JPY");

    private static final double TEST_DELTA = 0.001;

@Test
public void testUSDtoHKD() throws IOException {
    double expected = 7.75;
    double actual = Converter.rate(USD, HKD);
    assertEquals(expected, actual, TEST_DELTA);
}

@Test
public void testHKDtoUSD() throws IOException {
    double expected = 0.13;
    double actual = Converter.rate(HKD, USD);
    assertEquals(expected, actual, TEST_DELTA);
}

@Test
public void testRate() throws IOException {
    System.out.println("Rate: ");
    double USDtoJPY = Converter.rate(USD, JPY);
    double JPYtoUSD = Converter.rate(JPY, USD);

    System.out.println("US Dollars to Japanese Yen is: " + USDtoJPY);
    System.out.println("Japanese Yen to US Dollars is: " + JPYtoUSD);

    double expected = 1.0;
    double actual = USDtoJPY * JPYtoUSD;
    assertEquals(expected, actual, TEST_DELTA);
}

}
