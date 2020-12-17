package sample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.animation.TranslateTransition;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class C_play {
    @FXML
    private Button pauseButton;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label label;
    @FXML
    private MediaPlayer music;
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
        music.setOnEndOfMedia(() -> music.seek(Duration.ZERO));
        music.play();
        count = common.currGame.getScore();

        anchorPane.setMinHeight(800);
        anchorPane.setMaxHeight(800);

        label.setText(Integer.toString(count));

        if(common.currGame.getT1() == 1){ obstacle1 = new ObstacleCircle(common.currGame.getCurrColor1()); }
        else if(common.currGame.getT1() == 2){ obstacle1 = new ObstacleSquare(common.currGame.getCurrColor1()); }
        else if(common.currGame.getT1() == 3){ obstacle1 = new ObstacleLines(common.currGame.getCurrColor1()); }
        else { obstacle1 = new ObstacleTriangle(common.currGame.getCurrColor1()); }

        if(common.currGame.getT2() == 1){ obstacle2 = new ObstacleCircle(common.currGame.getCurrColor2()); }
        else if(common.currGame.getT2() == 2){ obstacle2 = new ObstacleSquare(common.currGame.getCurrColor2()); }
        else if(common.currGame.getT2() == 3){ obstacle2 = new ObstacleLines(common.currGame.getCurrColor2()); }
        else { obstacle2 = new ObstacleTriangle(common.currGame.getCurrColor2()); }

        if(common.currGame.getT3() == 1){ obstacle3 = new ObstacleCircle(common.currGame.getCurrColor3()); }
        else if(common.currGame.getT3() == 2){ obstacle3 = new ObstacleSquare(common.currGame.getCurrColor3()); }
        else if(common.currGame.getT3() == 3){ obstacle3 = new ObstacleLines(common.currGame.getCurrColor3()); }
        else { obstacle3 = new ObstacleTriangle(common.currGame.getCurrColor3()); }

        lastColor = common.currGame.getLastColor();
        if(common.currBall == 0) ball = new Ball0();
        if(common.currBall == 1) ball = new Ball1(); if(common.currBall == 2) ball = new Ball2();
        if(common.currBall == 3) ball = new Ball3(); if(common.currBall == 4) ball = new Ball4();
        if(common.currBall == 5) ball = new Ball5(); if(common.currBall == 6) ball = new Ball6();

        ball.setTranslateY(common.currGame.getY_ball());

        obstacle1.setTranslateY(common.currGame.getY1());
        obstacle2.setTranslateY(common.currGame.getY2());
        obstacle3.setTranslateY(common.currGame.getY3());

        obstacle1.colorChanger.setTranslateY(obstacle1.getTranslateY()+300);
        obstacle2.colorChanger.setTranslateY(obstacle2.getTranslateY()+300);
        obstacle3.colorChanger.setTranslateY(obstacle3.getTranslateY()+300);

        obstacle1.star.setTranslateY(obstacle1.getTranslateY()+(obstacle1.getHeight()/2)-(obstacle1.star.getRadius()/2));
        obstacle2.star.setTranslateY(obstacle2.getTranslateY()+(obstacle2.getHeight()/2)-(obstacle2.star.getRadius()/2));
        obstacle3.star.setTranslateY(obstacle3.getTranslateY()+(obstacle3.getHeight()/2)-(obstacle3.star.getRadius()/2));

        obstacle1.colorChanger.setNextColor(common.currGame.getCurrColor1());
        obstacle2.colorChanger.setNextColor(common.currGame.getCurrColor2());
        obstacle3.colorChanger.setNextColor(common.currGame.getCurrColor3());

        ball.setColor(common.currGame.getBallColor());

        obstacle1.star.hit = common.currGame.isSh1();
        obstacle2.star.hit = common.currGame.isSh2();
        obstacle3.star.hit = common.currGame.isSh3();

        obstacle1.colorChanger.setHit(common.currGame.isCch1());
        obstacle2.colorChanger.setHit(common.currGame.isCch2());
        obstacle3.colorChanger.setHit(common.currGame.isCch3());

        obstacle1.colorChanger.setVisible(common.currGame.isCcv1());
        obstacle2.colorChanger.setVisible(common.currGame.isCcv2());
        obstacle3.colorChanger.setVisible(common.currGame.isCcv3());

        obstacle1.star.setVisible(common.currGame.isSv1());
        obstacle2.star.setVisible(common.currGame.isSv2());
        obstacle3.star.setVisible(common.currGame.isSv3());

        anchorPane.getChildren().addAll(obstacle1, obstacle2, obstacle3, ball);
        anchorPane.getChildren().addAll(obstacle1.colorChanger, obstacle2.colorChanger, obstacle3.colorChanger);
        anchorPane.getChildren().addAll(obstacle1.star, obstacle2.star, obstacle3.star);

    }

    AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            time += 0.02;
            ball.moveDown();

            if(isCollision(ball)){
                try {
                    gameOverMenu();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

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
            int color;
            if(num != 3){
                color = random.nextInt(4);
                while(color == lastColor){
                    color = random.nextInt(4);
                }
            }else{
                color = random.nextInt(3)+1;
                while(color == lastColor){
                    color = random.nextInt(3)+1;
                }
            }
            lastColor = color;
            if(num == 0) obstacle1 = new ObstacleCircle(color); if(num == 1) obstacle1 = new ObstacleSquare(color);
            if(num == 2) obstacle1 = new ObstacleLines(color); if(num == 3) obstacle1 = new ObstacleTriangle(color);
            obstacle1.setTranslateY(yDist);
            anchorPane.getChildren().addAll(obstacle1, obstacle1.star, obstacle1.colorChanger);
        }
        if(obstacle2.getTranslateY() >= 1000){
            double yDist = obstacle2.getTranslateY();
            anchorPane.getChildren().removeAll(obstacle2.colorChanger, obstacle2.star, obstacle2);
            int num = random.nextInt(4);
            int color;
            if(num != 3){
                color = random.nextInt(4);
                while(color == lastColor){
                    color = random.nextInt(4);
                }
            }else{
                color = random.nextInt(3)+1;
                while(color == lastColor){
                    color = random.nextInt(3)+1;
                }
            }
            lastColor = color;
            if(num == 0) obstacle2 = new ObstacleCircle(color); if(num == 1) obstacle2 = new ObstacleSquare(color);
            if(num == 2) obstacle2 = new ObstacleLines(color); if(num == 3) obstacle2 = new ObstacleTriangle(color);
            obstacle2.setTranslateY(yDist);
            anchorPane.getChildren().addAll(obstacle2, obstacle2.star, obstacle2.colorChanger);
        }
        if(obstacle3.getTranslateY() >= 1000){
            double yDist = obstacle3.getTranslateY();
            anchorPane.getChildren().removeAll(obstacle3.colorChanger, obstacle3.star, obstacle3);
            int num = random.nextInt(4);
            int color;
            if(num != 3){
                color = random.nextInt(4);
                while(color == lastColor){
                    color = random.nextInt(4);
                }
            }else{
                color = random.nextInt(3)+1;
                while(color == lastColor){
                    color = random.nextInt(3)+1;
                }
            }
            lastColor = color;
            if(num == 0) obstacle3 = new ObstacleCircle(color); if(num == 1) obstacle3 = new ObstacleSquare(color);
            if(num == 2) obstacle3 = new ObstacleLines(color); if(num == 3) obstacle3 = new ObstacleTriangle(color);
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

        return obstacle2.isCollision(ball);
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

    public void saveState(){
        common.currGame.setY1(obstacle1.getTranslateY());
        common.currGame.setY2(obstacle2.getTranslateY());
        common.currGame.setY3(obstacle3.getTranslateY());
        common.currGame.setY_ball(ball.getTranslateY());
        common.currGame.setT1(obstacle1.type);
        common.currGame.setT2(obstacle2.type);
        common.currGame.setT3(obstacle3.type);
        common.currGame.setCcv1(obstacle1.colorChanger.isVisible());
        common.currGame.setCcv2(obstacle2.colorChanger.isVisible());
        common.currGame.setCcv3(obstacle3.colorChanger.isVisible());
        common.currGame.setSv1(obstacle1.star.isVisible());
        common.currGame.setSv2(obstacle2.star.isVisible());
        common.currGame.setSv3(obstacle3.star.isVisible());
        common.currGame.setLastColor(lastColor);
        common.currGame.setCurrColor1(obstacle1.currColor);
        common.currGame.setCurrColor2(obstacle2.currColor);
        common.currGame.setCurrColor3(obstacle3.currColor);
        common.currGame.setSh1(obstacle1.star.hit);
        common.currGame.setSh2(obstacle2.star.hit);
        common.currGame.setSh3(obstacle3.star.hit);
        common.currGame.setCch1(obstacle1.colorChanger.isHit());
        common.currGame.setCch2(obstacle2.colorChanger.isHit());
        common.currGame.setCch3(obstacle3.colorChanger.isHit());
        common.currGame.setBallColor(ball.currColor);
        common.currGame.setScore(count);
    }

    public void gameOverMenu() throws IOException {
        saveState();
        anchorPane.getChildren().removeAll(obstacle1.star, obstacle1.colorChanger, obstacle1);
        anchorPane.getChildren().removeAll(obstacle2.star, obstacle2.colorChanger, obstacle2);
        anchorPane.getChildren().removeAll(obstacle3.star, obstacle3.colorChanger, obstacle3);
        common.currGame.setY_ball(common.currGame.getY_ball()+200);;
        animationTimer.stop();
        music.stop();
        Scene HomePage = FXMLLoader.load(getClass().getResource("game_over.fxml"));
        Main.gameStage.setScene(HomePage);
    }

    public void press_pause(ActionEvent event) throws IOException {
        saveState();
        anchorPane.getChildren().removeAll(obstacle1.star, obstacle1.colorChanger, obstacle1);
        anchorPane.getChildren().removeAll(obstacle2.star, obstacle2.colorChanger, obstacle2);
        anchorPane.getChildren().removeAll(obstacle3.star, obstacle3.colorChanger, obstacle3);
        animationTimer.stop();
        music.stop();
        Scene HomePage = FXMLLoader.load(getClass().getResource("pause.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}
