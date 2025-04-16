package pages.controllers;

import model.UserSettings;
import pages.SceneManager;
import pages.controllers.HomeController;
import pages.views.HomeView;

public class NewUserController {
    SceneManager manager;

    public NewUserController(SceneManager manager){
        this.manager = manager;
    }

    public void onNameEntered(String name) {
        
        if(name.strip() == ""){
            return;
        }

        System.out.println("User entered name: " + name);

        // create a config file and store the users name

        UserSettings settings = UserSettings.getInstance();
        settings.setName(name);
        settings.saveSettings();
        
        manager.setHomeView();
    }
}
