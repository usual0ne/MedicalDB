package clinic.classes;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.sql.SQLException;

public class LogInWin
{
    @FXML
    private Button loginButton;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField loginField;
    @FXML
    private ImageView redCross;
    @FXML
    void initialize()
    {
        imageTwinkle();
        loginButton.setOnAction(event ->
        {

            String loginText = loginField.getText().trim();
            String passwordText = passwordField.getText().trim();
            boolean connected = false;

            try
            { connected = DatabaseHandler.getDbConnection(loginText, passwordText); }
            catch (SQLException e)
            { e.printStackTrace(); }

            if(connected)
            {
                SceneHandler.loadScreen("MenuWin");
            }
        });
    }

    private void imageTwinkle()
    {
        FadeTransition fadeOut =  new FadeTransition(Duration.millis(1300), redCross);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setCycleCount(Timeline.INDEFINITE);
        fadeOut.setAutoReverse(true);
        fadeOut.play();
    }
}


