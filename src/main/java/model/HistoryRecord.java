package model;

import java.time.ZonedDateTime;

public class HistoryRecord {

    private String fromCurrency;
    private String toCurrency;
    private String conversionResult;
    private ZonedDateTime dateOfConversion;

    public HistoryRecord(String fromCurrency, String toCurrency, String conversionResult) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.conversionResult = conversionResult;
        this.dateOfConversion = ZonedDateTime.now();
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public String getConversionResult() {
        return conversionResult;
    }

    public void setConversionResult(String conversionResult) {
        this.conversionResult = conversionResult;
    }

    public ZonedDateTime getDateOfConversion() {
        return dateOfConversion;
    }

    public void setDateOfConversion(ZonedDateTime dateOfConversion) {
        this.dateOfConversion = dateOfConversion;
    }
}
