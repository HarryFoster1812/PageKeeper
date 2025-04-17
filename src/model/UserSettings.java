package model;

import javafx.scene.paint.Color;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class UserSettings {
    private static UserSettings instance; // singleton

    private String userName;
    private Color bgColour;
    private Color primaryColour;

    public Color[] bgColourPalette = new Color[6];
    public Color[] primaryColourPalette = new Color[6];
    public Color[] tonalColourPalette = new Color[6];

    private UserSettings() {
        userName = "Guest";
        bgColour = Color.web("#121212");
        primaryColour = Color.web("#da072c");
        generateColours(6);
    }

    private Color generateShade(Color color, double factor) {
        return color.interpolate(Color.WHITE, factor); // Lighter shades
    }

    private void generateColours(int numShades) {
        for (int i = 0; i < numShades; i++) {
            double shadeFactor = i * 0.15; // 0.0, 0.15, 0.30, 0.45, 0.60 for subtler transitions
            primaryColourPalette[i] = generateShade(primaryColour, shadeFactor);
            bgColourPalette[i] = generateShade(bgColour, shadeFactor);
            double blendFactor = i * 0.2;
            tonalColourPalette[i] = bgColour.interpolate(primaryColour, blendFactor);
        }
    }

    public static UserSettings getInstance() {
        if (instance == null) {
            instance = new UserSettings();
        }
        return instance;
    }

    public void saveSettings() {
        try {
            File config = new File("./config/user.conf");
            if (!config.exists()) {
                config.getParentFile().mkdirs();
                config.createNewFile();
            }

            FileWriter fw = new FileWriter(config.getAbsoluteFile());
            String myStr = "name=%s\nbg=%s\nprimary=%s";
            String fileContents = String.format(myStr, userName, toRGBCode(bgColour), toRGBCode(primaryColour));

            fw.write(fileContents);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void importSettings() {
        try {
            File config = new File("./config/user.conf");
            if (config.exists()) {
                List<String> lines = Files.readAllLines(Paths.get(config.getPath()), StandardCharsets.UTF_8);
                System.out.println(lines.toString());
            } else {
                throw new FileNotFoundException("File does not exist");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String toRGBCode(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }

    public void setName(String newName) {
        userName = newName;
    }
}
