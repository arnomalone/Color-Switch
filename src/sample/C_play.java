package sample;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class C_play {
    @FXML
    private Button pauseButton;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ElementBall ball;
    @FXML
    private Label label;
    int count = 0;
    private double time = 0;
    boolean notStart = true;
    Random random = new Random();
    double starRadius=5.0;
    Color starColor=Color.WHITESMOKE;

    ElementStar star1, star2, star3;
    Obstacle obstacle1, obstacle2, obstacle3;
    ElementColorChanger colorChanger1, colorChanger2, colorChanger3;
    TranslateTransition trans;
    Boolean change;
    //    RotateTransition rotateTransition;
    Image purpleBallImage;
    Image yellowBallImage;
    Image redBallImage;
    Image blueBallImage;
    List<Image> imageList;

    @FXML
    void initialize() throws FileNotFoundException {


        FileInputStream circle = new FileInputStream("src/sample/resources/circle.png");
        FileInputStream square = new FileInputStream("src/sample/resources/square.png");
        FileInputStream line = new FileInputStream("src/sample/resources/line.png");
        FileInputStream star = new FileInputStream("src/sample/resources/star_tran.png");
        FileInputStream colorchanger_img = new FileInputStream("src/sample/resources/color_changer_trans.png");
        FileInputStream purpleball_img = new FileInputStream("src/sample/resources/purple_ball.png");
        FileInputStream yellowball_img = new FileInputStream("src/sample/resources/yellow_ball.png");
        FileInputStream redball_img = new FileInputStream("src/sample/resources/red_ball.png");
        FileInputStream blueball_img = new FileInputStream("src/sample/resources/blue_ball.png");


        purpleBallImage = new Image(purpleball_img);
        yellowBallImage = new Image(yellowball_img);
        redBallImage = new Image(redball_img);
        blueBallImage = new Image(blueball_img);
        imageList = Arrays.asList(purpleBallImage, yellowBallImage, redBallImage, blueBallImage);

        Image circleImage = new Image(circle);
        Image squareImage = new Image(square);
        Image lineImage = new Image(line);
        Image starImage = new Image(star);
        Image colorchangerImage = new Image(colorchanger_img);

        //


        ball = new ElementBall(200, 500, purpleBallImage);
        obstacle1 = new ObstacleCircle(circleImage);
        obstacle2 = new ObstacleSquare(squareImage);
        obstacle3 = new ObstacleLines(lineImage);
        star1 = new ElementStar(5.0, starImage);
        star2 = new ElementStar(5.0, starImage);
        star3 = new ElementStar(5.0, starImage);
        colorChanger1 = new ElementColorChanger(colorchangerImage);
        colorChanger2 = new ElementColorChanger(colorchangerImage);
        colorChanger3 = new ElementColorChanger(colorchangerImage);

//        obstacle1 = new ImageView(circleImage);
//        obstacle1.rotateProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
////                System.out.println("Rotation of s" + t1 + " degrees");
//            }
//        });

        obstacle1.setTranslateX(200-(obstacle1.getFitWidth()/2));
        obstacle1.setTranslateY(350-obstacle1.getFitHeight());
        colorChanger1.setTranslateY(obstacle1.getTranslateY()-75);
//        anchorPane.getChildren().add(obstacle1);
        obstacle2.setTranslateX(200-(obstacle2.getFitWidth()/2));
        obstacle2.setTranslateY(obstacle1.getTranslateY()-300);
        colorChanger2.setTranslateY(obstacle2.getTranslateY()-75);

//        anchorPane.getChildren().add(obstacle2);
        obstacle3.setTranslateX(230-(obstacle3.getFitWidth()/3));
        obstacle3.setTranslateY(obstacle2.getTranslateY()-300);
        colorChanger3.setTranslateY(obstacle3.getTranslateY()-75);

//        anchorPane.getChildren().add(obstacle3);
        anchorPane.getChildren().addAll(obstacle1, obstacle2, obstacle3, ball, colorChanger1, colorChanger2, colorChanger3);

        star1.setTranslateY(obstacle1.getTranslateY()+(obstacle1.getFitHeight()/2)-(star1.getRadius()/2));
        star2.setTranslateY(obstacle2.getTranslateY()+(obstacle2.getFitHeight()/2)-(star2.getRadius()/2));
        star3.setTranslateY(obstacle3.getTranslateY()+(obstacle3.getFitHeight()/2)-(star3.getRadius()/2));
        anchorPane.getChildren().add(star1);
        anchorPane.getChildren().add(star2);
        anchorPane.getChildren().add(star3);

        startRotate(obstacle1);
        startRotate(obstacle2);
        startRotate(obstacle3);
        startRotate(star1);
        startRotate(star2);
        startRotate(star3);
        startRotate(colorChanger1);
        startRotate(colorChanger2);
        startRotate(colorChanger3);
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
        checkPositions(star1, obstacle1, colorChanger1);
        checkPositions(star2, obstacle2, colorChanger2);
        checkPositions(star3, obstacle3, colorChanger3);
    }

    public void startRotate(Elements obstacle1)
    {
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.seconds(5));
        rotateTransition.setNode(obstacle1);
        int num = (random.nextInt(19)+10)*100;
        rotateTransition.setFromAngle(num);
        rotateTransition.setByAngle(360);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();
        obstacle1.setPreserveRatio(true);
    }

    public void checkPositions(ElementStar star, Obstacle obstacle, ElementColorChanger colorChanger)
    {
        if(obstacle.getTranslateY()>=760)
        {
            if(obstacle.getTranslateX()!=200-(obstacle.getFitWidth()/2)){
                int num = random.nextInt(2);
                if(num==0)
                    obstacle.setTranslateX(230-(obstacle.getFitWidth()/3));
                else
                    obstacle.setTranslateX(120-(obstacle.getFitWidth()/3));
//                obstacle.setTranslateX();
            }
            obstacle.setTranslateY(0-obstacle.getFitHeight());
            colorChanger.setTranslateY(obstacle.getTranslateY()-75);
            colorChanger.setVisible(true);
            colorChanger.hit=false;
            star.setTranslateY(obstacle.getTranslateY()+(obstacle.getFitHeight()/2)-(star.getRadius()/2));
            star.setVisible(true);
            star.hit=false;
        }
        if (star.isVisible() && !star.hit && (ball.getBoundsInParent().intersects(star.getBoundsInParent()) || (ball.getTranslateY() < star.getTranslateY())))
        {
            star.hit=true;
            star.setVisible(false);
            count++;
            label.setText(Integer.toString(count));
//            System.out.println("Done");
        }
        if (colorChanger.isVisible() && !colorChanger.hit && (ball.getBoundsInParent().intersects(colorChanger.getBoundsInParent()) || (ball.getTranslateY() < colorChanger.getTranslateY())))
        {
            colorChanger.hit=true;
            colorChanger.setVisible(false);
            while(true)
            {
                Image randomImage = imageList.get(random.nextInt(imageList.size()));
                if(ball.getColor()!=randomImage)
                {
                    System.out.println(randomImage);
                    ball.setColor(randomImage);
                    break;
                }
            }
//            System.out.println("Done");
        }
    }

    double ball_above=0;

    public void screenPress(MouseEvent event) {
        ball.moveUp();
//        System.out.println(ball.getTranslateY());
        if(ball.getTranslateY()<ball_above || ball.getTranslateY()<350)
        {
            relativeMove(star1, obstacle1, colorChanger1);
            relativeMove(star2, obstacle2, colorChanger2);
            relativeMove(star3, obstacle3, colorChanger3);
//                System.out.println(star1.getTranslateY());

//                star1.setTranslateY(star1.getTranslateY()+distance);
            ball_above=ball.getTranslateY();
        }
        if(notStart){
            notStart = false;
            animationTimer.start();
        }
    }

    public void relativeMove(ElementStar star1, ImageView obstacle1, ElementColorChanger colorChanger1)
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
        //
        trans = new TranslateTransition();
        trans.setDuration(Duration.seconds(0.16));
        trans.setCycleCount(1);
        trans.setNode(colorChanger1);
        trans.setToY(colorChanger1.getTranslateY()+30);
        trans.play();
    }

    public void press_pause(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("pause.fxml"));
        Scene scene = pauseButton.getScene();
        StackPane stackPane = (StackPane) scene.getRoot();
        stackPane.getChildren().add(root);
        stackPane.getChildren().remove(anchorPane);
    }
}
