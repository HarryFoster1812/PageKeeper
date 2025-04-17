package pages.views;

import javafx.scene.Scene;

import java.util.ArrayList;

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.geometry.Pos;
import javafx.event.*;
import pages.controllers.NavbarController;

import model.UserSettings;
import assets.*;

public class NavbarView extends VBox {

    private NavbarController controller;

    private ArrayList<HBox> buttons = new ArrayList<HBox>();

    public NavbarView(NavbarController controller) {
        this.controller = controller;

        setSize();

        // add logo
        HBox logoContainer = new HBox();
        logoContainer.setAlignment(Pos.CENTER);
        VBox logo = createLogo();
        logoContainer.getChildren().add(logo);
        this.getChildren().add(logoContainer);

        HBox buttonContainerAlign = new HBox();
        buttonContainerAlign.setAlignment(Pos.CENTER);
        VBox buttonContainer = new VBox();
        buttonContainer.setSpacing(66);

        Object[][] buttonParameters = { {
                HomeIcon.class, "Home" },
                { SearchIcon.class, "Discover" },
                { GroupIcon.class, "Reccomendations" },
                { ListIcon.class, "Lists" },
                { SettingsIcon.class, "Settings" }
        };

        for (Object[] buttonData : buttonParameters) {
            HBox tmpbutton = createButton((Class) buttonData[0], (String) buttonData[1]);
            buttonContainer.getChildren().add(tmpbutton);
            buttons.add(tmpbutton);
        }

        buttonContainer.setAlignment(Pos.CENTER);

        buttonContainerAlign.getChildren().add(buttonContainer);
        buttonContainerAlign.setTranslateY(66);

        setSelected(buttons.get(0));

        this.getChildren().add(buttonContainerAlign);

    }

    private void setSize() {
        this.setPrefWidth(275);
        this.setPrefHeight(1080);
    }

    private HBox createButton(Class<? extends SVGPath> iconClass, String labelContent) {
        HBox container = new HBox();
        container.setSpacing(20);
        SVGPath icon = new SVGPath();
        try {
            icon = (SVGPath) iconClass.getConstructor(double.class, double.class).newInstance(30, 30);
            icon.setFill(Color.web("#d4d4d4"));
        } catch (Exception e) {
            // pass
        }
        Label label = new Label(labelContent);
        label.setTextFill(Color.WHITE);
        label.setFont(new Font("Inter", 18));
        container.getChildren().addAll(icon, label);

        container.setCursor(Cursor.HAND);
        container.setOnMouseClicked(e -> {
            setSelected(container);
            this.controller.buttonClicked(labelContent);
        });

        return container;

    }

    private VBox createLogo() {
        VBox logoBox = new VBox();
        logoBox.setAlignment(Pos.CENTER);
        logoBox.setSpacing(20);

        LogoIcon logo = new LogoIcon(85, 85);
        logo.setFill(Color.web("#d4d4d4"));
        logo.setTranslateY(20);

        Label logoName = new Label("PageKeeper");
        logoName.setTextFill(Color.WHITE);
        logoName.setFont(new Font("Inter", 40));
        logoBox.getChildren().addAll(logo, logoName);

        return logoBox;
    }

    public void setSelected(HBox pressedButton) {
        UserSettings settings = UserSettings.getInstance();
        System.out.println("SETTING BUTTON COLOR");
        for (HBox button : buttons) {
            if (button == pressedButton) {
                // set color ot primary color
                SVGPath icon = (SVGPath) button.getChildren().get(0);
                icon.setFill(settings.primaryColourPalette[2]);
                Label text = (Label) button.getChildren().get(1);
                text.setTextFill(settings.primaryColourPalette[2]);
            } else {
                SVGPath icon = (SVGPath) button.getChildren().get(0);
                icon.setFill(Color.web("#d4d4d4"));
                Label text = (Label) button.getChildren().get(1);
                text.setTextFill(Color.WHITE);
            }
        }
    }
}
