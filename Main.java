package clinic;

import clinic.classes.DatabaseHandler;
import clinic.classes.SceneHandler;
import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        SceneHandler.setPrimaryStage(primaryStage);
        SceneHandler.loadScreen("LogInWin");
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
        try
        {
            DatabaseHandler.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
