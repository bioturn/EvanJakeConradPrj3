package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.awt.event.ActionEvent;

public class Controller {

    @FXML
    private NumberTextField tempInput;

    @FXML
    private Button outsideTemp;

    @FXML
    private Label currentTempLabel;

    @FXML
    private Label desiredTempLabel;

    @FXML
    private Label currentDeviceLabel;

    @FXML
    private Label outsideTempLabel;

    @FXML
    private Button desiredTemp;

    @FXML
    private Button currentTemp;

    @FXML
    private Button heat;

    @FXML
    private Button ac;

    @FXML
    private Button fan;

    @FXML
    private Button none;

    @FXML
    void initialize() {
        currentTemp.setOnAction((event) -> {
            currentTempLabel.setText(tempInput.getText());
        });
        desiredTemp.setOnAction((event) ->  {
            desiredTempLabel.setText(tempInput.getText());
        });
        outsideTemp.setOnAction((event) ->  {
            outsideTempLabel.setText(tempInput.getText());
        });
    }

}
