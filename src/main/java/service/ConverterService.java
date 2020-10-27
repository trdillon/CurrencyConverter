package service;

import api.CurrencyConverter;
import api.CurrencyLayer;
import api.OpenExchangeRates;
import config.APIConfig;
import enums.Currency;
import exception.ConverterException;
import exception.ErrorMessages;

import java.util.logging.Logger;

public class ConverterService {
    static Logger log = Logger.getLogger(ConverterService.class.getName());
    public Double rate(APIConfig config, Currency from, Currency to) {

        if (config.getApiKeyCurrencyConverter() != null) {
            CurrencyConverter currencyConverter = new CurrencyConverter();
            try {
                return currencyConverter.rate(config.getApiKeyCurrencyConverter(), from, to);
            }
            catch (ConverterException e) {
                e.printStackTrace();
            }
            catch (Exception e) {
                log.warning(ErrorMessages.getServiceOutageMsg(CurrencyConverter.SERVICE_NAME));
                e.printStackTrace();
            }
        }

        if (config.getApiKeyCurrencyLayer() != null) {
            CurrencyLayer currencyLayer = new CurrencyLayer();
            try {
                return currencyLayer.rate(config.getApiKeyCurrencyLayer(), from, to);
            }
            catch (ConverterException e) {
                e.printStackTrace();
            }
            catch (Exception e) {
                log.warning(ErrorMessages.getServiceOutageMsg(CurrencyLayer.SERVICE_NAME));
                e.printStackTrace();
            }
        }

        if (config.getApiKeyOpenExchangeRates() != null) {
            OpenExchangeRates openExchangeRates = new OpenExchangeRates();
            try {
                return openExchangeRates.rate(config.getApiKeyOpenExchangeRates(), from, to);
            }
            catch (ConverterException e) {
                e.printStackTrace();
            }
            catch (Exception e) {
                log.warning(ErrorMessages.getServiceOutageMsg(OpenExchangeRates.SERVICE_NAME));
                e.printStackTrace();
            }
        }
        //TODO - test service, expand logging
        throw new ConverterException(ErrorMessages.SERVICE_OUTAGE);
    }
}
