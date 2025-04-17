package assets;

import javafx.scene.shape.SVGPath;

public class HomeIcon extends SVGPath {
    private String svgString = "M30.467 11.375 16.349 1.04a.774.774 0 0 0-.914 0L1.317 11.375a.774.774 0 1 0 .914 1.25l13.66-10.003 13.662 10.002a.77.77 0 0 0 1.081-.167.774.774 0 0 0-.167-1.082Z M26.726 12.8a.774.774 0 0 0-.774.773v12.318h-6.19v-6.724a3.874 3.874 0 0 0-3.87-3.87 3.874 3.874 0 0 0-3.87 3.87v6.724h-6.19V13.573a.774.774 0 0 0-1.548 0v13.092c0 .427.346.774.774.774h7.738a.774.774 0 0 0 .774-.774v-7.498a2.324 2.324 0 0 1 2.322-2.322 2.324 2.324 0 0 1 2.322 2.322v7.498a.774.774 0 0 0 .774.774h7.738a.774.774 0 0 0 .774-.774V13.573a.774.774 0 0 0-.774-.774Z";

    public HomeIcon(double targetHeight, double targetWidth) {
        this.setContent(svgString);

        double originalWidth = this.getLayoutBounds().getWidth();
        this.setScaleX(targetWidth / originalWidth);

        double originalHeight = this.getLayoutBounds().getHeight();
        this.setScaleY(targetHeight / originalHeight);
    }

}
