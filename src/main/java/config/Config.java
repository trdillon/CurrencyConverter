package config;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

public class Config {

    private static String keyCurrencyConverter;
    private static String keyCurrencyLayer;
    private static String keyOpenExchangeRates;

    public static void loadConfig() {
        Parameters params = new Parameters();
        File propertiesFile = new File("config.properties");

        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                .configure(params.fileBased()
                .setFile(propertiesFile));

        try {
            Configuration config = builder.getConfiguration();
            setKeyCurrencyConverter(config.getProperty("api.currencyconverter").toString());
            setKeyCurrencyLayer(config.getProperty("api.currencylayer").toString());
            setKeyOpenExchangeRates(config.getProperty("api.openexchangerates").toString());
        }
        catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static String getKeyCurrencyConverter() {
        return keyCurrencyConverter;
    }

    public static void setKeyCurrencyConverter(String keyCurrencyConverter) {
        Config.keyCurrencyConverter = keyCurrencyConverter;
    }

    public static String getKeyCurrencyLayer() {
        return keyCurrencyLayer;
    }

    public static void setKeyCurrencyLayer(String keyCurrencyLayer) {
        Config.keyCurrencyLayer = keyCurrencyLayer;
    }

    public static String getKeyOpenExchangeRates() {
        return keyOpenExchangeRates;
    }

    public static void setKeyOpenExchangeRates(String keyOpenExchangeRates) {
        Config.keyOpenExchangeRates = keyOpenExchangeRates;
    }
}
