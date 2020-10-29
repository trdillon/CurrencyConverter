package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.HistoryRecord;
import utils.CSVUtil;

import java.net.URL;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;

public class HistoryController implements Initializable {

    @FXML
    private TableView<HistoryRecord> tvHistory;

    @FXML
    private TableColumn<HistoryRecord, String> tcHistoryFrom;

    @FXML
    private TableColumn<HistoryRecord, String> tcHistoryTo;

    @FXML
    private TableColumn<HistoryRecord, String> tcHistoryResults;

    @FXML
    private TableColumn<HistoryRecord, ZonedDateTime> tcHistoryDate;

    private void initTableColumns() {
        tcHistoryFrom.setCellValueFactory(new PropertyValueFactory<>("fromCurrency"));
        tcHistoryTo.setCellValueFactory(new PropertyValueFactory<>("toCurrency"));
        tcHistoryResults.setCellValueFactory(new PropertyValueFactory<>("conversionResult"));
        tcHistoryDate.setCellValueFactory(new PropertyValueFactory<>("dateOfConversion"));
    }

    private void populateRecords() {
        CSVUtil csvUtil = new CSVUtil();
        ObservableList<HistoryRecord> records = csvUtil.loadCSV();
        tvHistory.setItems(records);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTableColumns();
        populateRecords();
    }
}
