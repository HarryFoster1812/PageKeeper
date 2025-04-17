package pages;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.Stage;
import pages.views.*;
import pages.controllers.*;
import java.io.File;
import model.UserSettings;

public class SceneManager {
    private Stage stage;
    private Scene scene;

    public SceneManager(Stage stage) {

        this.stage = stage;

        File configFile = new File("./config/user.conf");
        System.out.println(configFile.exists());

        if (configFile.exists()) {
            // create home scene and load
            UserSettings settings = UserSettings.getInstance();
            settings.importSettings();
            setHomeView();

        } else {
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
        // root.getWidth() / 400, root.widthProperty()));
        // scaleTransform.yProperty().bind(Bindings.createDoubleBinding(() ->
        // root.getHeight() / 300, root.heightProperty()));
        //
        // Scene scene = new Scene(root, 800, 600);

        stage.setTitle("PageKeeper");
        stage.sizeToScene();
        stage.centerOnScreen();
        stage.show();
    }

    private void createRootScene() {
        // content
        HBox root = new HBox();
        root.setBackground(new Background(
                new BackgroundFill(Color.web("#121212"), null, null)));

        NavbarController navcontroller = new NavbarController(this);
        NavbarView navbar = new NavbarView(navcontroller);
        root.getChildren().add(navbar);

        this.scene = new Scene(root, 1920, 1080);
        this.stage.setScene(this.scene);
    }

    public void setHomeView() {
        // Create next controller and view
        if (this.scene == null) {
            createRootScene();
        }
        HomeController mainController = new HomeController(this);
        HomeView mainView = new HomeView(mainController);
    }

    private void removePageView() {
        HBox parent = (HBox) this.scene.getRoot();
        parent.getChildren().remove(1);
    }

    public void setViewByName(String viewName) {
        switch (viewName) {
            case "Home":
                setHomeView();
                break;
            case "Settings":
                break;
            default:
                break;
        }
    }
}
