package clinic.classes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneHandler
{
    private static final String pathToScreens = "/clinic/fxmlDocs/";
    private static Stage primaryStage;

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    private static void createScreen(Parent root)
    {
        Scene scene = new Scene(root);
        setScene(scene);
    }

    public static void loadScreen(String screen)
    {
        try
        {
            Parent root = FXMLLoader.load(SceneHandler.class.getResource(pathToScreens + screen + ".fxml"));
            createScreen(root);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void setScene(Scene scene)
    {
        primaryStage.setScene(scene);
    }

    public static void close()
    {
        primaryStage.close();
    }
}
