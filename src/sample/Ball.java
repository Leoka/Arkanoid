package sample;


import javafx.application.Application;
import javafx.scene.shape.Circle;

/**
 * Created by Maja on 21.01.2016.
 */
public class Ball extends Application {
    public static Circle circle;
    public double radius;

    public void Ball() {
        radius = 15;
        circle = new Circle(radius, Color.RED);
        circle.relocate(100,100);



    }



}
