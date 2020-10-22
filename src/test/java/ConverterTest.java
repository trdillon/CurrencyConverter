import org.junit.Test;

import java.util.Currency;

/** 
* Converter Tester. 
* 
* @author Tim
* @since <pre>Oct 22, 2020</pre> 
* @version 1.0 
*/ 
public class ConverterTest { 

    private static final Currency USD
            = Currency.getInstance("USD");

    private static final Currency HKD
            = Currency.getInstance("HKD");

    private static final double TEST_DELTA = 0.001;
/**
*
* Method: rate(Currency from, Currency to)
*
*/
@Test
public void testUSDtoHKD() {
    double expected = 7.8;
    //double actual = Converter.rate();
}

@Test
public void testRate() throws Exception {
//TODO: Test goes here... 
}


}
