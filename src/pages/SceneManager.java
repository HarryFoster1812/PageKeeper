package pages;

import javafx.scene.Scene;
import javafx.stage.Stage;
import pages.views.*;
import pages.controllers.*;
import java.io.File;
import model.UserSettings;

public class SceneManager {
    private Stage stage;
    private Scene scene;

    public SceneManager(Stage stage){
        File configFile = new File("../config/user.conf");
        System.out.println(configFile.exists());

        if(configFile.exists()){
            // create home scene and load
            UserSettings settings = UserSettings.getInstance();
            settings.importSettings();
        }
        else{
            NewUserController controller = new NewUserController(this);
            NewUserView newUser = new NewUserView(controller);
            stage.setScene(newUser.scene);
        }

        // Group contentGroup = new Group();
        // Rectangle rect = new Rectangle(0, 0, 400, 300);
        // contentGroup.getChildren().add(rect);
        //
        // // Wrap it in a StackPane
        // StackPane root = new StackPane(contentGroup);
        //
        // // Set up scaling
        // Scale scaleTransform = new Scale();
        // contentGroup.getTransforms().add(scaleTransform);
        //
        // // Bind scale to StackPane size
        // scaleTransform.xProperty().bind(Bindings.createDoubleBinding(() ->
        //         root.getWidth() / 400, root.widthProperty()));
        // scaleTransform.yProperty().bind(Bindings.createDoubleBinding(() ->
        //         root.getHeight() / 300, root.heightProperty()));
        //
        // Scene scene = new Scene(root, 800, 600);


        stage.setTitle("PageKeeper");
        stage.sizeToScene(); 
        stage.centerOnScreen();
        stage.show();
    }

    public void setHomeView(){
        // Create next controller and view
        HomeController mainController = new HomeController(this);
        HomeView mainView = new HomeView(mainController);
        stage.setScene(mainView.scene);
    }
}
