package pl.parkin9;

import pl.parkin9.Bird.Bird;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final Integer PIPE_DELAY = 100;

    private Boolean paused;
    private Integer pauseDelay;
    private Integer restartDelay;
    private Integer pipeDelay;
    private Keyboard keyboard;
    private Integer score;
    private Boolean gameover;
    private Boolean started;

    private List<Pipe> pipes;
    private Bird bird;
    private PlayboardImages playboardImages = new PlayboardImages();

    public Game() {
        keyboard = Keyboard.getInstance();
        restart();
    }

    public void restart() {
        paused = false;
        started = false;
        gameover = false;

        score = 0;
        pauseDelay = 0;
        restartDelay = 0;
        pipeDelay = 0;

        bird = new Bird();
        pipes = new ArrayList<>();
    }

    public void update() {
        watchForStart();

        if (!started)
            return;

        watchForPause();
        watchForReset();

        if (paused)
            return;

        bird.updateBird();

        if (gameover)
            return;

        movePipes();
        checkForCollisions();
    }

    public List<Render> renderGame() {

        List<Render> renders = new ArrayList<>();

        renders.add(playboardImages.renderBackground());
        for (Pipe pipe : pipes)
            renders.add(pipe.renderPipe());
        renders.add(playboardImages.renderGround());
        renders.add(bird.renderBird());

        // Without this line, the game has big lags on Unix's systems
        Toolkit.getDefaultToolkit().sync();

        return renders;
    }

    private void watchForStart() {
        if (!started && keyboard.isDown(KeyEvent.VK_SPACE)) {
            started = true;
        }
    }

    private void watchForPause() {
        if (pauseDelay > 0)
            pauseDelay--;

        if (keyboard.isDown(KeyEvent.VK_P) && pauseDelay <= 0) {
            paused = !paused;
            pauseDelay = 10;
        }
    }

    private void watchForReset() {
        if (restartDelay > 0)
            restartDelay--;

        if (keyboard.isDown(KeyEvent.VK_R) && restartDelay <= 0) {
            restart();
            restartDelay = 10;
        }
    }

    private void movePipes() {
        pipeDelay--;

        if (pipeDelay < 0) {
            pipeDelay = PIPE_DELAY;
            Pipe northPipe = null;
            Pipe southPipe = null;

            // Look for pipes off the screen
            for (Pipe pipe : pipes) {
                if (pipe.getX() - pipe.getWidth() < 0) {
                    if (northPipe == null) {
                        northPipe = pipe;
                    } else {
                        southPipe = pipe;
                        break;
                    }
                }
            }

            if (northPipe == null) {
                Pipe pipe = new Pipe("north");
                pipes.add(pipe);
                northPipe = pipe;
            } else {
                northPipe.reset();
            }

            if (southPipe == null) {
                Pipe pipe = new Pipe("south");
                pipes.add(pipe);
                southPipe = pipe;
            } else {
                southPipe.reset();
            }

            northPipe.setY(southPipe.getY() + southPipe.getHeight() + 175);
        }

        for (Pipe pipe : pipes) {
            pipe.updatePipe();
        }
    }

    private void checkForCollisions() {

        for (Pipe pipe : pipes) {
            if (pipe.collision(bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight())) {
                gameover = true;
                bird.setDead(true);
            } else if (pipe.getX().equals(bird.getX()) && pipe.getOrientation().equalsIgnoreCase("south")) {
                score++;
            }
        }

        // Collision the Bird with the ground
        if (bird.getY() + bird.getHeight() > MainFrame.getHEIGHT() - 80) {
            gameover = true;
            bird.setY(MainFrame.getHEIGHT() - 80 - bird.getHeight());
        }
    }

///////////////////////////////////////////////////////////////////////////////////

    public Integer getScore() {
        return score;
    }

    public Boolean getGameover() {
        return gameover;
    }

    public Boolean getStarted() {
        return started;
    }
}
