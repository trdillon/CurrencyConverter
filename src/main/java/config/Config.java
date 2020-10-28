package config;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

public class Config {

    public static String keyCurrencyConverter;
    public static String keyCurrencyLayer;
    public static String keyOpenExchangeRates;

    public static void loadConfig() {
        Parameters params = new Parameters();
        File propertiesFile = new File("config.properties");

        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                .configure(params.fileBased()
                .setFile(propertiesFile));

        try {
            Configuration config = builder.getConfiguration();
            keyCurrencyConverter = config.getProperty("api.currencyconverter").toString();
            keyCurrencyLayer = config.getProperty("api.currencylayer").toString();
            keyOpenExchangeRates = config.getProperty("api.openexchangerates").toString();
        }
        catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }
}
