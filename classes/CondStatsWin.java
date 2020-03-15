package clinic.classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;

public class CondStatsWin
{
    @FXML
    private Button exitButton;
    @FXML
    private Button pneumoniaButton;
    @FXML
    private PieChart sexPieChart;
    @FXML
    private Button cataractButton;
    @FXML
    private Button hemoglobinButton;
    @FXML
    void initialize()
    {
        exitButton.setOnAction(event->
        {
            SceneHandler.close();
        });
        pneumoniaButton.setOnAction(event->
        {
            loadData("therapist", "pneumonia");
        });
        cataractButton.setOnAction(event->
        {
            loadData("oculist", "cataract");
        });
        hemoglobinButton.setOnAction(event->
        {
            loadData("lab", "hemoglobin level is normal");
        });
    }

    private void loadData(String doctor, String diagnosis)
    {
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
        list.add(new PieChart.Data("men", DatabaseHandler.countCondStats(doctor + "_diagnosis",diagnosis,"M")));
        list.add(new PieChart.Data("women", DatabaseHandler.countCondStats(doctor + "_diagnosis",diagnosis,"F")));
        sexPieChart.setData(list);
    }
}

