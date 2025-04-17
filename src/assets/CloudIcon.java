package assets;

import javafx.scene.shape.SVGPath;

public class CloudIcon extends SVGPath {
    private String svgString = "M13.633 23.776h97.649s-.471-3.878-11.321-6.981c-10.85-3.104-18.634 4.848-30.9 0C56.798 11.947 50.293 4.99 34.49 8.87c-15.802 3.878-20.856 14.906-20.856 14.906ZM1.501 70.212h71.03s-.343-3.432-8.234-6.178c-7.892-2.744-13.555 4.29-22.476 0-8.922-4.288-13.654-10.443-25.15-7.008a23.962 23.962 0 0 0-15.17 13.185Zm118.667-54.667h71.03s-.343-3.431-8.234-6.177c-7.892-2.745-13.555 4.29-22.477 0-8.921-4.289-13.653-10.443-25.149-7.008a23.962 23.962 0 0 0-15.17 13.185Z";

    public CloudIcon(double targetHeight, double targetWidth) {
        this.setContent(svgString);
        double originalWidth = this.getLayoutBounds().getWidth();
        this.setScaleX(targetWidth / originalWidth);
        double originalHeight = this.getLayoutBounds().getHeight();
        this.setScaleY(targetHeight / originalHeight);
    }
}
