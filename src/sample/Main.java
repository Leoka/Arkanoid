package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Main extends Application {
    public static Circle circle;
    public static Pane canvas;

    @Override
    public void start(Stage theStage) throws Exception{
        canvas = new Pane();
        final Scene scene = new Scene(canvas, 800, 600);

        theStage.setTitle("Arkanoid");
        theStage.setScene(scene);

        circle = new Circle( 15, Color.RED );
        circle.relocate( 100, 100 );

        canvas.getChildren().addAll( circle );

        theStage.show();
    }
    final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

        double deltaX = 3;
        double deltaY = 3;

        @Override
        public void handle(final ActionEvent t) {
            circle.setLayoutX(circle.getLayoutX() + deltaX);
            circle.setLayoutY(circle.getLayoutY() + deltaY);

            final Bounds bounds = canvas.getBoundsInLocal();
            final boolean atRightBorder = circle.getLayoutX() >= (bounds.getMaxX() - circle.getRadius());
            final boolean atLeftBorder = circle.getLayoutX() <= (bounds.getMinX() + circle.getRadius());
            final boolean atBottomBorder = circle.getLayoutY() >= (bounds.getMaxY() - circle.getRadius());
            final boolean atTopBorder = circle.getLayoutY() <= (bounds.getMinY() + circle.getRadius());

            if (atRightBorder || atLeftBorder) {
                deltaX *= -1;
            }
            if (atBottomBorder || atTopBorder) {
                deltaY *= -1;
            }
        }
    }));

    //loop.setCycleCount(Timeline.INDEFINITE);
    loop.play();
}

    public static void main(String[] args) {
        launch(args);
    }
}
