//package pl.parkin9;
//
//import java.awt.*;
//
//public class PlayboardImage {
//
//    private Render render;
//    private Image image;
//
//    public Render renderBackground() {
//
//        render.setX(0);
//        render.setY(0);
//
//        if (image == null) {
//            image = render.loadImage("lib/background.png");
//        }
//        render.setImage(image);
//
//        return this.render;
//    }
//
//    public Render renderForeground() {
//
//        render.setX(0);
//        render.setY(0);
//
//        if (image == null) {
//            image = render.loadImage("lib/foreground.png");
//        }
//        render.setImage(image);
//
//        return this.render;
//    }
//
/////////////////////////////////////////////////////////////////////////
//
//    public Render getRender() {
//        return render;
//    }
//
//    public void setRender(Render render) {
//        this.render = render;
//    }
//
//    public Image getImage() {
//        return image;
//    }
//
//    public void setImage(Image image) {
//        this.image = image;
//    }
//}
