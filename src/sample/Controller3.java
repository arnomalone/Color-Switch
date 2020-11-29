package sample;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.scene.control.Label;

import javax.swing.text.Element;
//import javax.swing.text.html.ImageView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Controller3 {
    @FXML
    private Button button;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Ball ball;
    @FXML
    private Label label;
    int count = 0;
    private double time = 0;
    boolean notStart = true;
    List<Color> colorList = Arrays.asList(Color.AQUA, Color.DEEPPINK, Color.PURPLE, Color.YELLOW);
    Random random = new Random();
    double starRadius=5.0;
    Color starColor=Color.WHITESMOKE;
    Star star1 = new Star(starRadius, starColor);
    Star star2 = new Star(starRadius, starColor);
    Star star3 = new Star(starRadius, starColor);
    ImageView obstacle1;
    ImageView obstacle2;
    ImageView obstacle3;
    TranslateTransition trans;
    Boolean change;

    @FXML
    void initialize() throws FileNotFoundException {

        //
        FileInputStream circle = new FileInputStream("src/model/resources/circle.png");
        FileInputStream square = new FileInputStream("src/model/resources/square.png");
        FileInputStream line = new FileInputStream("src/model/resources/line.png");
        Image circleImage = new Image(circle);
        Image squareImage = new Image(square);
        Image lineImage = new Image(line);
        obstacle1 = new ImageView(circleImage);
        obstacle1.setFitHeight(160);
        obstacle1.setFitWidth(160);
        obstacle1.setTranslateX(200-(obstacle1.getFitWidth()/2));
        obstacle1.setTranslateY(0-obstacle1.getFitHeight());
        anchorPane.getChildren().add(obstacle1);
        obstacle2 = new ImageView(squareImage);
        obstacle2.setFitHeight(110);
        obstacle2.setFitWidth(110);
        obstacle2.setTranslateX(200-(obstacle2.getFitWidth()/2));
        obstacle2.setTranslateY(obstacle1.getTranslateY()-250);
        anchorPane.getChildren().add(obstacle2);
        obstacle3 = new ImageView(lineImage);
        obstacle3.setFitHeight(160);
        obstacle3.setFitWidth(160);
        obstacle3.setTranslateX(200-(obstacle3.getFitWidth()/3));
        obstacle3.setTranslateY(obstacle2.getTranslateY()-250);
        anchorPane.getChildren().add(obstacle3);

        //

        ball = new Ball(200, 300, 5.0, Color.YELLOW);
        anchorPane.getChildren().add(ball);

        //

        star1.setTranslateY(obstacle1.getTranslateY()+(obstacle1.getFitHeight()/2)-(star1.getRadius()/2));
        star2.setTranslateY(obstacle2.getTranslateY()+(obstacle2.getFitHeight()/2)-(star2.getRadius()/2));
        star3.setTranslateY(obstacle3.getTranslateY()+(obstacle3.getFitHeight()/2)-(star3.getRadius()/2));
        anchorPane.getChildren().add(star1);
        anchorPane.getChildren().add(star2);
        anchorPane.getChildren().add(star3);

        //

        startRotate(obstacle1);
        startRotate(obstacle2);
        startRotate(obstacle3);
    }

    AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            time += 0.016;
            ball.moveDown();
            moveObstacles();
            if (time > 4) {
                time = 0;
            }
        }
    };

    public void moveObstacles() {
     checkPositions(star1, obstacle1);
     checkPositions(star2, obstacle2);
     checkPositions(star3, obstacle3);
    }

    public void startRotate(ImageView obstacle1)
    {
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.seconds(5));
        rotateTransition.setNode(obstacle1);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();
        obstacle1.setPreserveRatio(true);
    }

    public void checkPositions(Star star1, ImageView obstacle1)
    {
        if(obstacle1.getTranslateY()>=600)
        {
            obstacle1.setTranslateY(0-obstacle1.getFitHeight());
            star1.setTranslateY(obstacle1.getTranslateY()+(obstacle1.getFitHeight()/2)-(star1.getRadius()/2));
            star1.setVisible(true);
            star1.hit=false;
        }
        if (star1.isVisible() && !star1.hit && (ball.getBoundsInParent().intersects(star1.getBoundsInParent()) || (ball.getTranslateY() < star1.getTranslateY())))
        {
            star1.hit=true;
            star1.setVisible(false);
            count++;
            label.setText(Integer.toString(count));
            System.out.println("Done");
        }
    }

    double ball_below=0;
    double ball_above=0;

    public void screenPress(MouseEvent event) {
        ball.moveUp();
        System.out.println(ball.getTranslateY());
        if(ball.getTranslateY()<ball_above || ball.getTranslateY()<350)
        {
            relativeMove(star1, obstacle1);
            relativeMove(star2, obstacle2);
            relativeMove(star3, obstacle3);
//                System.out.println(star1.getTranslateY());

//                star1.setTranslateY(star1.getTranslateY()+distance);
            ball_above=ball.getTranslateY();
        }
        if(notStart){
            notStart = false;
            animationTimer.start();
        }
    }

    public void relativeMove(Star star1, ImageView obstacle1)
    {
        trans = new TranslateTransition();
        trans.setDuration(Duration.seconds(0.16));
        trans.setCycleCount(1);
        trans.setNode(star1);
        trans.setToY(star1.getTranslateY()+30);
        trans.play();
        //
        trans = new TranslateTransition();
        trans.setDuration(Duration.seconds(0.16));
        trans.setCycleCount(1);
        trans.setNode(obstacle1);
        trans.setToY(obstacle1.getTranslateY()+30);
        trans.play();
    }

    public void buttonPress2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        Scene scene = button.getScene();
        StackPane stackPane = (StackPane) scene.getRoot();
        root.translateYProperty().set(scene.getHeight());
        stackPane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.setOnFinished(event1 -> {
            stackPane.getChildren().remove(anchorPane);
        });
        timeline.play();
    }
}
