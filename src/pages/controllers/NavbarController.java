package pages.controllers;

import pages.SceneManager;

public class NavbarController {
    private SceneManager manager;

    public NavbarController(SceneManager manager) {
        this.manager = manager;

    }

    public void buttonClicked(String buttonName) {
        manager.setViewByName(buttonName);
    }
}
