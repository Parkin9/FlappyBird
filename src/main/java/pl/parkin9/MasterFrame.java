package pl.parkin9;

import javax.swing.*;

class MasterFrame extends JFrame {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    MasterFrame() {

        super("FlappyBird");

        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addKeyListener(Keyboard.getInstance());

        add(new GamePanel());
    }

    static int getWIDTH() {
        return WIDTH;
    }

    static int getHEIGHT() {
        return HEIGHT;
    }
}
