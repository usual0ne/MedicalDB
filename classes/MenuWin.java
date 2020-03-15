package clinic.classes;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class MenuWin
{
    @FXML
    private MenuItem showStatsButton;
    @FXML
    private MenuItem showCondStatsButton;
    @FXML
    private MenuButton menuButton;
    @FXML
    private MenuItem addPatientButton;
    @FXML
    void initialize()
    {
        addPatientButton.setOnAction(event ->{
            SceneHandler.loadScreen("AddPatientWin");
        });
        showStatsButton.setOnAction(event ->{
            SceneHandler.loadScreen("StatsWin");
        });
        showCondStatsButton.setOnAction(event->{
            SceneHandler.loadScreen("CondStatsWin");
        });
    }
}


