package model;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class HistoryRecord {

    private String fromCurrency;
    private String toCurrency;
    private String conversionResult;
    private String dateOfConversion;

    public HistoryRecord(String fromCurrency, String toCurrency, String conversionResult) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.conversionResult = conversionResult;
        this.dateOfConversion = formattedDate();
    }

    // Format ZDT.now so its a little more readable
    public String formattedDate() {
        ZonedDateTime timeNow = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss Z");
        return timeNow.format(formatter);
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

    public String getDateOfConversion() {
        return dateOfConversion;
    }

    public void setDateOfConversion(String dateOfConversion) {
        this.dateOfConversion = dateOfConversion;
    }
}
