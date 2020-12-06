package sample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.animation.TranslateTransition;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import static javafx.fxml.FXMLLoader.load;


public class C_play {
    @FXML
    private Button pauseButton;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label label;
    static int count;
    private double time = 0;
    boolean notStart = true;
    Random random = new Random();
    private ElementBall ball;

    Obstacle obstacle1, obstacle2, obstacle3;
    TranslateTransition trans;
    static int lastColor = 2;

    @FXML
    void initialize() throws FileNotFoundException {

        count = 0;

        anchorPane.setMinHeight(800);
        anchorPane.setMaxHeight(800);

        obstacle1 = new ObstacleCircle();
        obstacle2 = new ObstacleSquare();
        obstacle3 = new ObstacleLines();

        ball = new ElementBall(200, 500);
        ball.setColor(obstacle1.colorChanger.getNextColor());

        obstacle1.colorChanger.setVisible(false);
        obstacle1.setTranslateY(400-obstacle1.getHeight());
        obstacle2.setTranslateY(obstacle1.getTranslateY()-450);
        obstacle3.setTranslateY(obstacle2.getTranslateY()-450);
        obstacle1.colorChanger.setTranslateY(obstacle1.getTranslateY()+300);
        obstacle2.colorChanger.setTranslateY(obstacle2.getTranslateY()+300);
        obstacle3.colorChanger.setTranslateY(obstacle3.getTranslateY()+300);
        obstacle1.star.setTranslateY(obstacle1.getTranslateY()+(obstacle1.getHeight()/2)-(obstacle1.star.getRadius()/2));
        obstacle2.star.setTranslateY(obstacle2.getTranslateY()+(obstacle2.getHeight()/2)-(obstacle2.star.getRadius()/2));
        obstacle3.star.setTranslateY(obstacle3.getTranslateY()+(obstacle3.getHeight()/2)-(obstacle3.star.getRadius()/2));

        anchorPane.getChildren().addAll(obstacle1, obstacle2, obstacle3, ball);
        anchorPane.getChildren().addAll(obstacle1.colorChanger, obstacle2.colorChanger, obstacle3.colorChanger);
        anchorPane.getChildren().addAll(obstacle1.star, obstacle2.star, obstacle3.star);

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
//            isCollision(ball);

            try {
                moveObstacles();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            if (time > 4) {
                time = 0;
            }
        }
    };

    public void moveObstacles() throws FileNotFoundException {

        if(obstacle1.getTranslateY() >= 1000){
            double yDist = obstacle1.getTranslateY();
            anchorPane.getChildren().removeAll(obstacle1.colorChanger, obstacle1.star, obstacle1);
            int num = random.nextInt(4);
            if(num == 0) obstacle1 = new ObstacleCircle();
            if(num == 1) obstacle1 = new ObstacleSquare();
            if(num == 2) obstacle1 = new ObstacleLines();
            if(num == 3) obstacle1 = new ObstacleTriangle();
            obstacle1.setTranslateY(yDist);
            anchorPane.getChildren().addAll(obstacle1, obstacle1.star, obstacle1.colorChanger);
        }
        if(obstacle2.getTranslateY() >= 1000){
            double yDist = obstacle2.getTranslateY();
            anchorPane.getChildren().removeAll(obstacle2.colorChanger, obstacle2.star, obstacle2);
            int num = random.nextInt(4);
            if(num == 0) obstacle2 = new ObstacleCircle();
            if(num == 1) obstacle2 = new ObstacleSquare();
            if(num == 2) obstacle2 = new ObstacleLines();
            if(num == 3) obstacle2 = new ObstacleTriangle();
            obstacle2.setTranslateY(yDist);
            anchorPane.getChildren().addAll(obstacle2, obstacle2.star, obstacle2.colorChanger);
        }
        if(obstacle3.getTranslateY() >= 1000){
            double yDist = obstacle3.getTranslateY();
            anchorPane.getChildren().removeAll(obstacle3.colorChanger, obstacle3.star, obstacle3);
            int num = random.nextInt(4);
            if(num == 0) obstacle3 = new ObstacleCircle();
            if(num == 1) obstacle3 = new ObstacleSquare();
            if(num == 2) obstacle3 = new ObstacleLines();
            if(num == 3) obstacle3 = new ObstacleTriangle();
            obstacle3.setTranslateY(yDist);
            anchorPane.getChildren().addAll(obstacle3, obstacle3.star, obstacle3.colorChanger);
        }

        checkPositions(obstacle1);
        checkPositions(obstacle2);
        checkPositions(obstacle3);
    }


    public boolean isCollision(Elements ball){

        boolean value3 = obstacle3.isCollision(ball);
        if(value3) return true;

        boolean value1 = obstacle1.isCollision(ball);
        if(value1) return true;

        boolean value2 = obstacle2.isCollision(ball);
        return value2;
    }


    public void checkPositions(Obstacle obstacle) throws FileNotFoundException {
        ElementStar star = obstacle.star;
        ElementColorChanger colorChanger = obstacle.colorChanger;
        if(obstacle.getTranslateY()>=1000)
        {
            int num = colorChanger.getNextColor();
            obstacle.switchColor(num);

            int num1 = random.nextInt(2);
            if(obstacle.type == 3){
                if(num1==0)
                    obstacle.setTranslateX(290-(obstacle.getWidth()/3));
                else
                    obstacle.setTranslateX(150-(obstacle.getWidth()/3));
                if(num1 != 0)
                    obstacle.rotateTransition.setRate(-1);
            }
            else{
                if(num1 == 0)
                    obstacle.rotateTransition.setRate(-1);
            }
            obstacle.setTranslateY(-200-obstacle.getHeight());
            colorChanger.setTranslateY(obstacle.getTranslateY()+300);
            colorChanger.setVisible(true);
            colorChanger.setHit(false);

            star.setTranslateY(obstacle.getTranslateY()+(obstacle.getHeight()/2)-(star.getRadius()/2));
            star.setVisible(true);
            star.hit=false;
        }
        if (star.isVisible() && !star.hit && (ball.getBoundsInParent().intersects(star.getBoundsInParent())
                || (ball.getTranslateY() < star.getTranslateY())))
        {
            star.hit=true;
            star.setVisible(false);
            count++;
            label.setText(Integer.toString(count));
        }
        if (colorChanger.isVisible() && !colorChanger.isHit()
                && (ball.getBoundsInParent().intersects(colorChanger.getBoundsInParent())
                || (ball.getTranslateY() < colorChanger.getTranslateY())))
        {
            colorChanger.setHit(true);
            colorChanger.setVisible(false);
            ball.setColor(colorChanger.getNextColor());
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

        animationTimer.stop();
        Scene HomePage = FXMLLoader.load(getClass().getResource("game_over.fxml"));
        Main.gameStage.setScene(HomePage);
    }

    public void press_pause(ActionEvent event) throws IOException {
//        Parent root = load(getClass().getResource("pause.fxml"));
//        Scene scene = pauseButton.getScene();
//        StackPane stackPane = (StackPane) scene.getRoot();
//        stackPane.getChildren().add(root);
//        stackPane.getChildren().remove(anchorPane);
        Scene HomePage = FXMLLoader.load(getClass().getResource("pause.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}
