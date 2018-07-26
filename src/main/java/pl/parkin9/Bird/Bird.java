package pl.parkin9.Bird;

import pl.parkin9.Keyboard;
import pl.parkin9.Render;

import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

public class Bird {

    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;
    private Boolean dead;
    private Double yVelocity;
    private Double gravity;
    private Integer jumpDelay;
    private Double rotation;

    private Keyboard keyboard;

    public Bird() {
        x = 100;
        y = 150;
        yVelocity = 0.0;
        width = 45;
        height = 32;
        gravity = 0.5;
        jumpDelay = 0;
        rotation = 0.0;
        dead = false;
        keyboard = Keyboard.getInstance();
    }

    public void updateBird() {
        yVelocity += gravity;

        if (jumpDelay > 0)
            jumpDelay--;

        if (!dead && keyboard.isDown(KeyEvent.VK_SPACE) && jumpDelay <= 0) {
            yVelocity = -10.0;
            jumpDelay = 10;
        }

        y += yVelocity.intValue();
    }

    public Render renderBird() {

        Render render = new Render();

        render.setX(x);
        render.setY(y);

        if (render.getImage() == null) {
            render.setImage(render.loadImage("lib/bird.png"));
        }

        rotation = (90 * (yVelocity + 20) / 20) - 90;
        rotation = rotation * Math.PI / 180;

        if (rotation > Math.PI / 2)
            rotation = Math.PI / 2;

        render.setTransform(new AffineTransform());
        render.getTransform().translate(x + width / 2, y + height / 2);
        render.getTransform().rotate(rotation);
        render.getTransform().translate(-width / 2, -height / 2);

        return render;
    }

///////////////////////////////////////////////////////////////////////////////////////

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Boolean getDead() {
        return dead;
    }

    public void setDead(Boolean dead) {
        this.dead = dead;
    }

    public Double getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(Double yVelocity) {
        this.yVelocity = yVelocity;
    }

    public Double getGravity() {
        return gravity;
    }

    public void setGravity(Double gravity) {
        this.gravity = gravity;
    }

    public Integer getJumpDelay() {
        return jumpDelay;
    }

    public void setJumpDelay(Integer jumpDelay) {
        this.jumpDelay = jumpDelay;
    }

    public Double getRotation() {
        return rotation;
    }

    public void setRotation(Double rotation) {
        this.rotation = rotation;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }
}
