import javafx.application.Application;
import javafx.stage.Stage;
import pages.SceneManager; 

public class App extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage){
        SceneManager manager = new SceneManager(stage);
    }
}
