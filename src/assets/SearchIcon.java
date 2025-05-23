package assets;

import javafx.scene.shape.SVGPath;

public class SearchIcon extends SVGPath {
    private String svgString = "m26.109 25.264-6.157-6.157a10.758 10.758 0 0 0 2.651-7.083c0-5.96-4.847-10.802-10.801-10.802C5.842 1.222 1 6.07 1 12.024s4.848 10.802 10.802 10.802c2.707 0 5.184-1 7.083-2.651l6.156 6.156a.764.764 0 0 0 .534.225.76.76 0 0 0 .534-1.292ZM2.51 12.024c0-5.123 4.168-9.285 9.285-9.285 5.123 0 9.285 4.168 9.285 9.285s-4.162 9.29-9.285 9.29c-5.117 0-9.285-4.167-9.285-9.29Z";

    public SearchIcon(double targetHeight, double targetWidth) {
        this.setContent(svgString);

        double originalWidth = this.getLayoutBounds().getWidth();
        this.setScaleX(targetWidth / originalWidth);

        double originalHeight = this.getLayoutBounds().getHeight();
        this.setScaleY(targetHeight / originalHeight);
    }

}
