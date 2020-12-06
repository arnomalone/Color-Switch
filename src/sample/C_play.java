package sample;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
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
import javafx.scene.shape.Line;
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

import static javafx.fxml.FXMLLoader.load;


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

    Obstacle obstacle1, obstacle2, obstacle3;
    TranslateTransition trans;
    Image purpleBallImage, yellowBallImage;
    Image redBallImage, blueBallImage;
    List<Image> imageList;
    Image circleImage0, circleImage1, circleImage2, circleImage3;
    Image squareImage0, squareImage1, squareImage2, squareImage3;
    Image lineImage0, lineImage1, lineImage2, lineImage3;
    Image starImage, colorChangerImage;

    int lastColor = 2;
    private Stage GameOverStage;

    @FXML
    void initialize() throws FileNotFoundException {


        FileInputStream circle0 = new FileInputStream("src/sample/resources/circle-0.png");
        FileInputStream circle1 = new FileInputStream("src/sample/resources/circle-1.png");
        FileInputStream circle2 = new FileInputStream("src/sample/resources/circle-2.png");
        FileInputStream circle3 = new FileInputStream("src/sample/resources/circle-3.png");
        FileInputStream square0 = new FileInputStream("src/sample/resources/square-0.png");
        FileInputStream square1 = new FileInputStream("src/sample/resources/square-1.png");
        FileInputStream square2 = new FileInputStream("src/sample/resources/square-2.png");
        FileInputStream square3 = new FileInputStream("src/sample/resources/square-3.png");
        FileInputStream line0 = new FileInputStream("src/sample/resources/line-0.png");
        FileInputStream line1 = new FileInputStream("src/sample/resources/line-1.png");
        FileInputStream line2 = new FileInputStream("src/sample/resources/line-2.png");
        FileInputStream line3 = new FileInputStream("src/sample/resources/line-3.png");
        FileInputStream star = new FileInputStream("src/sample/resources/star_tran.png");
        FileInputStream colorChanger_img = new FileInputStream("src/sample/resources/color_changer_trans.png");
        FileInputStream purpleBall_img = new FileInputStream("src/sample/resources/purple_ball.png");
        FileInputStream yellowBall_img = new FileInputStream("src/sample/resources/yellow_ball.png");
        FileInputStream redBall_img = new FileInputStream("src/sample/resources/red_ball.png");
        FileInputStream blueBall_img = new FileInputStream("src/sample/resources/blue_ball.png");

        purpleBallImage = new Image(purpleBall_img);
        yellowBallImage = new Image(yellowBall_img);
        redBallImage = new Image(redBall_img);
        blueBallImage = new Image(blueBall_img);
        imageList = Arrays.asList(purpleBallImage, yellowBallImage, redBallImage, blueBallImage);

        starImage = new Image(star); colorChangerImage = new Image(colorChanger_img);
        circleImage0 = new Image(circle0); circleImage1 = new Image(circle1);
        circleImage2 = new Image(circle2); circleImage3 = new Image(circle3);
        squareImage0 = new Image(square0); squareImage1 = new Image(square1);
        squareImage2 = new Image(square2); squareImage3 = new Image(square3);
        lineImage0 = new Image(line0); lineImage1 = new Image(line1);
        lineImage2 = new Image(line2); lineImage3 = new Image(line3);

        ball = new ElementBall(250, 500, yellowBallImage);
        obstacle1 = new ObstacleCircle(circleImage0, circleImage1, circleImage2, circleImage3, colorChangerImage, starImage);
        obstacle2 = new ObstacleSquare(squareImage0, squareImage1, squareImage2, squareImage3, colorChangerImage, starImage);
        obstacle3 = new ObstacleLines(lineImage0, lineImage1, lineImage2, lineImage3, colorChangerImage, starImage);

        obstacle1.colorChanger.setVisible(false);
        obstacle2.setTranslateY(obstacle1.getTranslateY()-450);
        obstacle2.colorChanger.setTranslateY(obstacle2.getTranslateY()+300);
        obstacle2.star.setTranslateY(obstacle2.getTranslateY()+(obstacle2.getHeight()/2)-(obstacle2.star.getRadius()/2));
        obstacle3.setTranslateY(obstacle2.getTranslateY()-450);
        obstacle3.colorChanger.setTranslateY(obstacle3.getTranslateY()+300);
        obstacle3.star.setTranslateY(obstacle3.getTranslateY()+(obstacle3.getHeight()/2)-(obstacle3.star.getRadius()/2));
        anchorPane.getChildren().addAll(obstacle1, obstacle2, obstacle3, ball);
        anchorPane.getChildren().addAll(obstacle1.colorChanger, obstacle2.colorChanger, obstacle3.colorChanger);
        anchorPane.getChildren().addAll(obstacle1.star, obstacle2.star, obstacle3.star);
        anchorPane.setMinHeight(800);
        anchorPane.setMaxHeight(800);
    }

    AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long l) {
//            time += 0.016;
            time += 0.02;
            ball.moveDown();

            if(isCollision(ball)){
                try {
                    gameOverMenu();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            checkPositions(obstacle1);
            checkPositions(obstacle2);
            checkPositions(obstacle3);
//            moveObstacles();

            if (time > 4) {
                time = 0;
            }
        }
    };

    public boolean isCollision(Elements ball){

        boolean value3 = obstacle3.isCollision(ball);
        if(value3) return true;

        boolean value1 = obstacle1.isCollision(ball);
        if(value1) return true;

        boolean value2 = obstacle2.isCollision(ball);
        if(value2) return true;

        return false;
    }

    public void moveObstacles() {
        checkPositions(obstacle1);
        checkPositions(obstacle2);
        checkPositions(obstacle3);
    }

    public void checkPositions(Obstacle obstacle)
    {
        ElementStar star = obstacle.star;
        ElementColorChanger colorChanger = obstacle.colorChanger;
        if(obstacle.getTranslateY()>=1000)
        {
            int num = colorChanger.getNextColor();
            obstacle.switchColor(num);

            if(obstacle.getTranslateX()!=250-(obstacle.getWidth()/2)){
                int num1 = random.nextInt(2);
                if(num1==0)
                    obstacle.setTranslateX(280-(obstacle.getWidth()/3));
                else
                    obstacle.setTranslateX(170-(obstacle.getWidth()/3));
            }
            obstacle.setTranslateY(-200-obstacle.getHeight());
            colorChanger.setTranslateY(obstacle.getTranslateY()+300);
            colorChanger.setVisible(true);
            colorChanger.setHit(false);

            star.setTranslateY(obstacle.getTranslateY()+(obstacle.getHeight()/2)-(star.getRadius()/2));
            star.setVisible(true);
            star.hit=false;
        }
        if (star.isVisible() && !star.hit && (ball.getBoundsInParent().intersects(star.getBoundsInParent()) || (ball.getTranslateY() < star.getTranslateY())))
        {
            star.hit=true;
            star.setVisible(false);
            count++;
            label.setText(Integer.toString(count));
        }
        if (colorChanger.isVisible() && !colorChanger.isHit() && (ball.getBoundsInParent().intersects(colorChanger.getBoundsInParent()) || (ball.getTranslateY() < colorChanger.getTranslateY())))
        {
            colorChanger.setHit(true);
            colorChanger.setVisible(false);
            ball.setColor(imageList.get(colorChanger.getNextColor()));
            int num2 = random.nextInt(4);
            while(num2==lastColor){
                num2 = random.nextInt(4);
            }
            lastColor = num2;
            colorChanger.setNextColor(num2);
        }
    }

    double ball_above=0;

    public void screenPress(MouseEvent event) {
        ball.moveUp();
        if(ball.getTranslateY()<ball_above || ball.getTranslateY()<350)
        {
            relativeMove(obstacle1);
            relativeMove(obstacle2);
            relativeMove(obstacle3);
            ball_above=ball.getTranslateY();
        }
        if(notStart){
            notStart = false;
            animationTimer.start();
        }
    }

    public void relativeMove(Obstacle obstacle)
    {
        ElementColorChanger colorChanger = obstacle.colorChanger;
        ElementStar star = obstacle.star;
        trans = new TranslateTransition();
        trans.setCycleCount(1);
        trans.setNode(star);
        trans.setToY(star.getTranslateY()+50);
        trans.play();

        trans = new TranslateTransition();
        trans.setCycleCount(1);
        trans.setNode(obstacle);
        trans.setToY(obstacle.getTranslateY()+50);
        trans.play();

        trans = new TranslateTransition();
        trans.setCycleCount(1);
        trans.setNode(colorChanger);
        trans.setToY(colorChanger.getTranslateY()+50);
        trans.play();
    }

    public void gameOverMenu() throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("pause.fxml"));
//        Button useless = new Button();
//        anchorPane.getChildren().add(useless);
//        Scene scene = useless.getScene();
//        StackPane stackPane = (StackPane) scene.getRoot();
//        stackPane.getChildren().add(root);
//        stackPane.getChildren().remove(anchorPane);
//        anchorPane = (AnchorPane) FXMLLoader.load("game_over.fxml");
//        anchorPane.getChildren().setAll(FXMLLoader.load(toString("game_over.fxml")));
//        GameOverStage = new Stage();
//        GameOverStage.setScene(load(getClass().getResource("game_over.fxml")));
//        GameOverStage.show();
    }

    public void press_pause(ActionEvent event) throws IOException {
        Parent root = load(getClass().getResource("pause.fxml"));
        Scene scene = pauseButton.getScene();
        StackPane stackPane = (StackPane) scene.getRoot();
        stackPane.getChildren().add(root);
        stackPane.getChildren().remove(anchorPane);
    }
}
