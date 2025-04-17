package assets;

import javafx.scene.shape.SVGPath;

public class GroupIcon extends SVGPath {
    private String svgString = "M21 0.872a5.35 5.35 0 1 1 0 10.7 5.35 5.35 0 0 1 0-10.7ZM21 15.872a5.35 5.35 0 1 1 0 10.7 5.35 5.35 0 0 1 0-10.7ZM6 0.872a5.35 5.35 0 1 1 0 10.7 5.35 5.35 0 0 1 0-10.7ZM6 15.872a5.35 5.35 0 1 1 0 10.7 5.35 5.35 0 0 1 0-10.7Z";

    public GroupIcon(double targetHeight, double targetWidth) {
        this.setContent(svgString);

        double originalWidth = this.getLayoutBounds().getWidth();
        this.setScaleX(targetWidth / originalWidth);

        double originalHeight = this.getLayoutBounds().getHeight();
        this.setScaleY(targetHeight / originalHeight);
    }

}
