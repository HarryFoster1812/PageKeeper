package assets;

import javafx.scene.shape.SVGPath;

public class ListIcon extends SVGPath {
    private String svgString = "M4.52.25H.528v3.992H4.52V.25Zm0 7.984H.528v3.992H4.52V8.234ZM.528 16.218H4.52v3.992H.528v-3.992Zm3.992 7.985H.528v3.992H4.52v-3.992ZM28.472.25H8.512v3.992h19.96V.25Zm0 7.984H8.512v3.992h19.96V8.234Zm-19.96 7.984h19.96v3.992H8.512v-3.992Zm19.96 7.985H8.512v3.992h19.96v-3.992Z";

    public ListIcon(double targetHeight, double targetWidth) {
        this.setContent(svgString);

        double originalWidth = this.getLayoutBounds().getWidth();
        this.setScaleX(targetWidth / originalWidth);

        double originalHeight = this.getLayoutBounds().getHeight();
        this.setScaleY(targetHeight / originalHeight);
    }

}
