//package pl.parkin9.Bird;
//
//import pl.parkin9.Keyboard;
//import pl.parkin9.Render;
//
//import java.awt.event.KeyEvent;
//import java.awt.geom.AffineTransform;
//
//public class BirdServiceImpl implements BirdService {
//
//    private Bird bird;
//
//    public BirdServiceImpl(Bird bird) {
//        this.bird = bird;
//    }
//
//    public void updateBird() {
//
//        Double yVelocity = bird.getyVelocity();
//        Integer jumpDelay = bird.getJumpDelay();
//        Boolean dead = bird.getDead();
//        Keyboard keyboard = bird.getKeyboard();
//        Integer y = bird.getY();
//
//        yVelocity += bird.getGravity();
//
//        if (bird.getJumpDelay() > 0)
//            bird.setJumpDelay(jumpDelay--);
//
//        if (!dead && keyboard.isDown(KeyEvent.VK_SPACE) && jumpDelay <= 0) {
//            yVelocity = -10.0;
//            jumpDelay = 10;
//        }
//
//        y += yVelocity.intValue();
//    }
//
////    public Render renderBird() {
////
////        Render render = new Render();
////
////        render.setX(x);
////        render.setY(y);
////
////        if (render.getImage() == null) {
////            render.setImage(render.loadImage("lib/bird.png"));
////        }
////
////        rotation = (90 * (yVelocity + 20) / 20) - 90;
////        rotation = rotation * Math.PI / 180;
////
////        if (rotation > Math.PI / 2)
////            rotation = Math.PI / 2;
////
////        render.setTransform(new AffineTransform());
////        render.getTransform().translate(x + width / 2, y + height / 2);
////        render.getTransform().rotate(rotation);
////        render.getTransform().translate(-width / 2, -height / 2);
////
////        return render;
////    }
//}
