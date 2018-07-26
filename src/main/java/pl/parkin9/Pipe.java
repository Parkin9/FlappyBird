package pl.parkin9;

public class Pipe {

    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;
    private String orientation;

    public Pipe(String orientation) {
        this.orientation = orientation;
        reset();
    }

    public void reset() {
        width = 66;
        height = 400;
        x = MainFrame.getWIDTH() + 2;

        if (orientation.equals("south")) {
            y = -(int)(Math.random() * 120) - height / 2;
        }
    }

    public void updatePipe() {
        Integer speed = 3;
        x -= speed;
    }

    public boolean collision(int x, int y, int width, int height) {

        Integer margin = 2;

        if (x + width - margin > this.x && x + margin < this.x + this.width) {

            if (orientation.equals("south") && y < this.y + this.height) {
                return true;
            } else return orientation.equals("north") && y + height > this.y;
        }

        return false;
    }

    public Render renderPipe() {

        Render render = new Render();

        render.setX(x);
        render.setY(y);

        if (render.getImage() == null) {
            render.setImage(render.loadImage("lib/pipe-" + orientation + ".png"));
        }

        return render;
    }

///////////////////////////////////////////////////////////////////////////////////////

    public Integer getX() {
        return x;
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

    public Integer getHeight() {
        return height;
    }

    public String getOrientation() {
        return orientation;
    }
}
