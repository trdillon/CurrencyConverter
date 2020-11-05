package service;

import api.CurrencyConverter;
import api.CurrencyLayer;
import config.Config;
import enums.Currency;
import exception.ConverterException;
import exception.ErrorMessages;

public class ConverterService {
    //TODO - create rate() with currency array param for OpenExchangesRates call
    public Double rate(String serviceName, Currency from, Currency to) {
        if (serviceName.equals("CurrencyConverter")) {
            CurrencyConverter currencyConverter = new CurrencyConverter();
            try {
                return currencyConverter.rate(Config.getCurrencyConverterKey(), from, to);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (serviceName.equals("CurrencyLayer")) {
            CurrencyLayer currencyLayer = new CurrencyLayer();
            try {
                return currencyLayer.rate(Config.getCurrencyLayerKey(), from, to);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        throw new ConverterException(ErrorMessages.SERVICE_OUTAGE);
    }
}
