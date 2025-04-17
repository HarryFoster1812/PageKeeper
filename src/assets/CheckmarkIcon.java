package assets;

import javafx.scene.shape.SVGPath;

public class CheckmarkIcon extends SVGPath {
    private String svgString = "M59.962 30.099C59.962 46.646 46.547 60.06 30 60.06S.038 46.646.038 30.1C.038 13.552 13.453.137 30 .137S59.962 13.552 59.962 30.1ZM45.093 18.75a2.81 2.81 0 0 0-4.045.082L28.041 35.406l-7.838-7.843a2.809 2.809 0 0 0-3.97 3.97l9.91 9.914a2.809 2.809 0 0 0 4.04-.075l14.951-18.689a2.809 2.809 0 0 0-.037-3.932h-.004Z";

    public CheckmarkIcon(double targetHeight, double targetWidth) {
        this.setContent(svgString);
        double originalWidth = this.getLayoutBounds().getWidth();
        this.setScaleX(targetWidth / originalWidth);
        double originalHeight = this.getLayoutBounds().getHeight();
        this.setScaleY(targetHeight / originalHeight);
    }
}
