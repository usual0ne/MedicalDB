package clinic.classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;

public class StatsWin
{
    @FXML
    private PieChart doctorPieChart;
    @FXML
    private Button therapistButton;
    @FXML
    private Button oculistButton;
    @FXML
    private Button surgeonButton;
    @FXML
    private Button labButton;
    @FXML
    private Button exitButton;

    @FXML
    void initialize()
    {
        therapistButton.setOnAction(event ->
        {
            loadDocData("therapist", "hypertension", "chickenpox", "pneumonia", "gastritis", "no diseases");
        });
        oculistButton.setOnAction(event ->
        {
            loadDocData("oculist", "conjunctivitis", "cataract", "myopia", "keratoconus", "healthy eyes");
        });
        surgeonButton.setOnAction(event ->
        {
            loadDocData("surgeon", "right leg is broken", "appendicitis", "deep rib cage injury", "tailbone is broken", "no serious injuries");
        });
        labButton.setOnAction(event->
        {
            loadLabData();
        });
        exitButton.setOnAction(event->
        {
            SceneHandler.close();
        });
    }

    private void loadDocData(String doctor, String dia1, String dia2, String dia3, String dia4, String dia5)
    {
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
        list.add(new PieChart.Data(dia1, DatabaseHandler.countDiagnosis(doctor + "_diagnosis", dia1)));
        list.add(new PieChart.Data(dia2, DatabaseHandler.countDiagnosis(doctor + "_diagnosis", dia2)));
        list.add(new PieChart.Data(dia3, DatabaseHandler.countDiagnosis(doctor + "_diagnosis", dia3)));
        list.add(new PieChart.Data(dia4, DatabaseHandler.countDiagnosis(doctor + "_diagnosis", dia4)));
        list.add(new PieChart.Data(dia5, DatabaseHandler.countDiagnosis(doctor + "_diagnosis", dia5)));
        doctorPieChart.setData(list);
    }

    private void loadLabData()
    {
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
        list.add(new PieChart.Data("normal hemoglobin", DatabaseHandler.countDiagnosis("lab_diagnosis", "hemoglobin level is normal")));
        list.add(new PieChart.Data("high hemoglobin", DatabaseHandler.countDiagnosis("lab_diagnosis", "hemoglobin level is too high")));
        list.add(new PieChart.Data("low hemoglobin", DatabaseHandler.countDiagnosis("lab_diagnosis", "hemoglobin level is too low")));
        doctorPieChart.setData(list);
    }
}

