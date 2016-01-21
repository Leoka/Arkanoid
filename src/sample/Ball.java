package sample;

import javafx.scene.canvas.GraphicsContext;
import java.lang.Object;


/**
 * Created by Maja on 21.01.2016.
 */
public class Ball {

    private double rx, ry;         // position
    private double vx, vy;         // velocity
    private final double radius;   // radius

    // constructor
    public Ball(){
        rx = 0.0;
        ry = 0.0;
        vx = 0.015 - Math.random() * 0.03;
        vy = 0.015 - Math.random() * 0.03;
        radius = 0.025 + Math.random() * 0.05;
    }

    // bounce of vertical wall by reflecting x-velocity
    private void bounceOffVerticalWall() {

    }
}
