package pl.parkin9;

public class PlayboardImages {

    private Render render;

    public Render renderBackground() {

        render = new Render();
        render.setX(0);
        render.setY(0);

        if (render.getImage() == null) {
            render.setImage(render.loadImage("lib/background.png"));
        }

        return render;
    }

    public Render renderGround() {

        render = new Render();
        render.setX(0);
        render.setY(0);

        if (render.getImage() == null) {
            render.setImage(render.loadImage("lib/foreground.png"));
        }

        return render;
    }
}
