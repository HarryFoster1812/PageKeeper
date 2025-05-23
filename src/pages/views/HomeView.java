package pages.views;

import javafx.scene.Scene;
import pages.controllers.HomeController;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

public class HomeView {

    public Scene scene;
    private HomeController controller;

    public HomeView(HomeController controller) {
        this.controller = controller;

        VBox root = new VBox();
        this.scene = new Scene(root, 1920, 1080);
        root.setBackground(new Background(
                new BackgroundFill(Color.web("#121212"), null, null)));
        root.setSpacing(141);
    }
}
