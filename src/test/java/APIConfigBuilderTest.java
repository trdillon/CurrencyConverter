import config.APIConfig;
import config.APIConfigBuilder;
import exception.ConverterException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * APIConfigBuilder Tester.
 *
 * @author Tim
 * @since Oct 28, 2020
 * @version 1.0
 */
public class APIConfigBuilderTest {

    private static final String CURRENCY_CONVERTER_API_KEY = "API_KEY";
    private static final String CURRENCY_LAYER_API_KEY = "API_KEY";
    private static final String OPEN_EXCHANGE_API_KEY = "API_KEY";

    private static final String CURRENCY_CONVERTER_NEW_KEY = "NEW_KEY";
    private static final String CURRENCY_LAYER_NEW_KEY = "NEW_KEY";
    private static final String OPEN_EXCHANGE_NEW_KEY = "NEW_KEY";

    @Test
    void shouldThrowExceptionForNullAPIKeys() {
        assertThrows(ConverterException.class, () -> {
            new APIConfigBuilder()
                    .build();
        });
    }

    @Test
    void shouldBuildOneAPIKey() {
        final APIConfig config = new APIConfigBuilder()
                .buildCurrencyLayer(CURRENCY_LAYER_API_KEY)
                .build();

        assertNull(config.getApiKeyCurrencyConverter());
        assertEquals(CURRENCY_LAYER_API_KEY, config.getApiKeyCurrencyLayer());
        assertNull(config.getApiKeyOpenExchangeRates());
    }

    @Test
    void shouldBuildAllAPIKeys() {
        final APIConfig config = new APIConfigBuilder()
                .buildCurrencyConverter(CURRENCY_CONVERTER_API_KEY)
                .buildCurrencyLayer(CURRENCY_LAYER_API_KEY)
                .buildOpenExchange(OPEN_EXCHANGE_API_KEY)
                .build();

        assertEquals(CURRENCY_CONVERTER_API_KEY, config.getApiKeyCurrencyConverter());
        assertEquals(CURRENCY_LAYER_API_KEY, config.getApiKeyCurrencyLayer());
        assertEquals(OPEN_EXCHANGE_API_KEY, config.getApiKeyOpenExchangeRates());
    }

    @Test
    void shouldChangeAllAPIKeys() {
        APIConfig config = new APIConfigBuilder()
                .buildCurrencyConverter(CURRENCY_CONVERTER_API_KEY)
                .buildCurrencyLayer(CURRENCY_LAYER_API_KEY)
                .buildOpenExchange(OPEN_EXCHANGE_API_KEY)
                .build();

        config.setApiKeyCurrencyConverter(CURRENCY_CONVERTER_NEW_KEY);
        config.setApiKeyCurrencyLayer(CURRENCY_LAYER_NEW_KEY);
        config.setApiKeyOpenExchangeRates(OPEN_EXCHANGE_NEW_KEY);

        assertEquals(CURRENCY_CONVERTER_NEW_KEY, config.getApiKeyCurrencyConverter());
        assertEquals(CURRENCY_LAYER_NEW_KEY, config.getApiKeyCurrencyLayer());
        assertEquals(OPEN_EXCHANGE_NEW_KEY, config.getApiKeyOpenExchangeRates());
    }

    @Test
    void shouldChangeOneAPIKeyOnly() {
        APIConfig config = new APIConfigBuilder()
                .buildCurrencyConverter(CURRENCY_CONVERTER_API_KEY)
                .buildCurrencyLayer(CURRENCY_LAYER_API_KEY)
                .buildOpenExchange(OPEN_EXCHANGE_API_KEY)
                .build();

        config.setApiKeyCurrencyLayer(CURRENCY_LAYER_NEW_KEY);

        assertEquals(CURRENCY_CONVERTER_API_KEY, config.getApiKeyCurrencyConverter());
        assertEquals(CURRENCY_LAYER_NEW_KEY, config.getApiKeyCurrencyLayer());
        assertEquals(OPEN_EXCHANGE_API_KEY, config.getApiKeyOpenExchangeRates());
    }
}
