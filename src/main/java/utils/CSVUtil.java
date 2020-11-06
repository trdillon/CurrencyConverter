package utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.HistoryRecord;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CSVUtil {

    private static final String FILE_NAME = "/history.csv";

    public ObservableList<HistoryRecord> loadCSV() {
        ObservableList<HistoryRecord> records = FXCollections.observableArrayList();
        try {
            // Read basic csv file with header into stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    this.getClass().getResourceAsStream(FILE_NAME)));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim());

            // Add records from stream into observableList and return it
            for (CSVRecord record : csvParser) {
                HistoryRecord newRecord = new HistoryRecord(record.get("from"), record.get("to"),
                        record.get("results"));
                records.add(newRecord);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }

    public static void addRecord(HistoryRecord record) {
        String from = record.getFromCurrency();
        String to = record.getToCurrency();
        String results = record.getConversionResult();
        String time = record.getDateOfConversion();

        try {
            // Create a writer and get the CSV file to append
            BufferedWriter writer = Files.newBufferedWriter(
                    Paths.get(CSVUtil.class.getResource(FILE_NAME).toURI()),
                    StandardOpenOption.APPEND);
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

            csvPrinter.printRecord(from, to, results, time);
            csvPrinter.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}