package pl.parkin9;

import javax.swing.*;

public class MainFrame extends JFrame {

    private static final Integer WIDTH = 500;
    private static final Integer HEIGHT = 500;

    public MainFrame() {

        super("FlappyBird");

        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addKeyListener(Keyboard.getInstance());

        add(new GamePanel());
    }

    public static Integer getWIDTH() {
        return WIDTH;
    }

    public static Integer getHEIGHT() {
        return HEIGHT;
    }
}
