package utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.HistoryRecord;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CSVUtil {

    public ObservableList<HistoryRecord> loadCSV() {
        ObservableList<HistoryRecord> records = FXCollections.observableArrayList();
        String FILE_NAME = "/history.csv";
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
}