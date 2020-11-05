package config;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

public class Config {

    private static final File CONFIG_FILE = new File("config.properties");

    // Create configBuilder object which will handle access/manipulation of all config properties
    private static final FileBasedConfigurationBuilder<FileBasedConfiguration> configBuilder =
            new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
            .configure(new Parameters().fileBased().setFile(CONFIG_FILE));

    public static String getCurrencyConverterKey() throws ConfigurationException {
        return configBuilder.getConfiguration().getProperty("api.currencyconverter").toString();
    }

    public static String getCurrencyLayerKey() throws ConfigurationException {
        return configBuilder.getConfiguration().getProperty("api.currencylayer").toString();
    }

    public static String getOpenExchangeKey() throws ConfigurationException {
        return configBuilder.getConfiguration().getProperty("api.openexchangerates").toString();
    }

    public static void setCurrencyConverterKey(String key) throws ConfigurationException {
        Configuration config = configBuilder.getConfiguration();
        config.setProperty("api.currencyconverter", key);
        configBuilder.save();
    }

    public static void setCurrencyLayerKey(String key) throws ConfigurationException {
        Configuration config = configBuilder.getConfiguration();
        config.setProperty("api.currencylayer", key);
        configBuilder.save();
    }

    public static void setOpenExchangeRatesKey(String key) throws ConfigurationException {
        Configuration config = configBuilder.getConfiguration();
        config.setProperty("api.openexchangerates", key);
        configBuilder.save();
    }

    public static String getTheme() throws ConfigurationException {
        return configBuilder.getConfiguration().getProperty("theme").toString();
    }

    public static void setTheme(String theme) throws ConfigurationException {
        Configuration config = configBuilder.getConfiguration();
        config.setProperty("theme", theme);
        configBuilder.save();
    }
}
