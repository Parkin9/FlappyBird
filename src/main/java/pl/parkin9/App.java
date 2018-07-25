package pl.parkin9;

import javax.swing.*;

public class App {

    static final int WIDTH = 500;
    static final int HEIGHT = 500;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);

        Keyboard keyboard = Keyboard.getInstance();
        frame.addKeyListener(keyboard);

        GamePanel panel = new GamePanel();
        frame.add(panel);
    }
}
