package assets;

import javafx.scene.shape.SVGPath;

public class BookmarkIcon extends SVGPath {
    private String svgString = "M32.604.178H5.396A4.83 4.83 0 0 0 .581 4.994V47.01c0 1.143.662 2.227 1.685 2.709 1.083.481 2.287.36 3.19-.362l.06-.06L19 37.92l13.484 11.377.06.06a3.07 3.07 0 0 0 1.866.663c.421 0 .903-.12 1.324-.362 1.023-.481 1.686-1.565 1.686-2.708V4.994A4.83 4.83 0 0 0 32.604.178Z";

    public BookmarkIcon(double targetHeight, double targetWidth) {
        this.setContent(svgString);

        double originalWidth = this.getLayoutBounds().getWidth();
        this.setScaleX(targetWidth / originalWidth);

        double originalHeight = this.getLayoutBounds().getHeight();
        this.setScaleY(targetHeight / originalHeight);
    }
}
