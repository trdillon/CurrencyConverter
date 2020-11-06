import config.Config;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * SettingsConfig Tester.
 *
 * @author Tim
 * @since Nov 6, 2020
 * @version 1.0
 */

public class TestSettingsConfig {

    private static final String DEFAULT_KEY = "key";

    private static final String NEW_KEY = "key2";

    @BeforeEach
    void setDefaultConfigForTesting() throws Exception {
        Config.setDefault();
    }

    @Test
    void testReadConfigFromPropertiesFile() throws Exception {
        String keyCurrencyConverter = Config.getCurrencyConverterKey();
        String keyCurrencyLayer = Config.getCurrencyLayerKey();
        String keyOpenExchangeRates = Config.getOpenExchangeKey();

        assertEquals(keyCurrencyConverter, DEFAULT_KEY);
        assertEquals(keyCurrencyLayer, DEFAULT_KEY);
        assertEquals(keyOpenExchangeRates, DEFAULT_KEY);
    }

    @Test
    void testChangeAPIKeysConfig() throws Exception {
        Config.setCurrencyConverterKey(NEW_KEY);
        Config.setCurrencyLayerKey(NEW_KEY);
        Config.setOpenExchangeRatesKey(NEW_KEY);

        String keyCurrencyConverter = Config.getCurrencyConverterKey();
        String keyCurrencyLayer = Config.getCurrencyLayerKey();
        String keyOpenExchangeRates = Config.getOpenExchangeKey();

        assertEquals(keyCurrencyConverter, NEW_KEY);
        assertEquals(keyCurrencyLayer, NEW_KEY);
        assertEquals(keyOpenExchangeRates, NEW_KEY);
    }

    @Test
    void testReadTheme() throws Exception {
        String theme = "Dark";

        assertEquals(theme, Config.getTheme());
    }

    @Test
    void testChangeTheme() throws Exception {
        String theme = "Light";
        Config.setTheme(theme);

        assertEquals(theme, Config.getTheme());
    }
}
