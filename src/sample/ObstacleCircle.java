package sample;

import javafx.animation.ScaleTransition;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class ObstacleCircle extends Obstacle {
    private final Line line1, line2, line3, line4, line5;
    String image_path1, image_path2, image_path3;
    boolean increaseDifficulty = false;

    public ObstacleCircle() throws FileNotFoundException {
        super();
        type = 1;
        image_path0 = "src/sample/resources/circle-0.png";
        image_path1 = "src/sample/resources/circle-1.png";
        image_path2 = "src/sample/resources/circle-2.png";
        image_path3 = "src/sample/resources/circle-3.png";
        Random random = new Random();
        int num = random.nextInt(4);
        while(num == C_play.lastColor)
            num = random.nextInt(4);
        C_play.lastColor = num;
        this.currColor = num;
        this.switchColor(num);
        this.setTranslateX(250-(this.getWidth()/2));
        colorChanger = new ElementColorChanger();
        colorChanger.setNextColor(num);
        colorChanger.setTranslateY(this.getTranslateY()+300);
        star = new ElementStar(5.0);
        star.setTranslateY(this.getTranslateY()+(this.getHeight()/2)-(star.getRadius()/2));


        line1 = new Line(125, 125, 125, 25);
        line2 = new Line(125, 125, 125, 25);
        line3 = new Line(125, 125, 125, 25);
        line4 = new Line(125, 125, 125, 25);
        line5 = new Line(125, 125, 125, 25);

        this.rotateProperty().addListener(o -> {
            Point2D start1 = this.localToParent(100, 10);
            Point2D end1 = this.localToParent(180, 55);
            Point2D start2 = this.localToParent(180, 50);
            Point2D end2 = this.localToParent(190, 120);
            Point2D start3 = this.localToParent(190, 120);
            Point2D end3 = this.localToParent(130, 190);
            Point2D start4 = this.localToParent(130, 190);
            Point2D end4 = this.localToParent(40, 170);
            Point2D start5 = this.localToParent(40, 170);
            Point2D end5 = this.localToParent(10, 100);
            line1.setStartX(start1.getX()); line1.setStartY(start1.getY());
            line1.setEndX(end1.getX()); line1.setEndY(end1.getY());
            line2.setStartX(start2.getX()); line2.setStartY(start2.getY());
            line2.setEndX(end2.getX()); line2.setEndY(end2.getY());
            line3.setStartX(start3.getX()); line3.setStartY(start3.getY());
            line3.setEndX(end3.getX()); line3.setEndY(end3.getY());
            line4.setStartX(start4.getX()); line4.setStartY(start4.getY());
            line4.setEndX(end4.getX()); line4.setEndY(end4.getY());
            line5.setStartX(start5.getX()); line5.setStartY(start5.getY());
            line5.setEndX(end5.getX()); line5.setEndY(end5.getY());
        });

        ScaleTransition transition = new ScaleTransition(Duration.seconds(3), this);
        transition.setToX(1.2);
        transition.setToY(1.2);
        transition.setRate(1.1);
        transition.setCycleCount(ScaleTransition.INDEFINITE);
        transition.setAutoReverse(true);
        if(C_play.count >= 10){
            increaseDifficulty = true;
        }
        if(increaseDifficulty){
            transition.play();
        }

    }

    @Override
    public boolean isCollision(Elements ball) {
        Shape o1intersect1 = Shape.intersect(ball, line1);
        Shape o1intersect2 = Shape.intersect(ball, line2);
        Shape o1intersect3 = Shape.intersect(ball, line3);
        Shape o1intersect4 = Shape.intersect(ball, line4);
        Shape o1intersect5 = Shape.intersect(ball, line5);

        if(o1intersect1.getBoundsInLocal().getWidth() != -1 || o1intersect2.getBoundsInLocal().getWidth() != -1){
            System.out.println("collision circle");
            return true;
        }
        if(o1intersect3.getBoundsInLocal().getWidth() != -1 || o1intersect4.getBoundsInLocal().getWidth() != -1){
            System.out.println("collision circle");
            return true;
        }
        if(o1intersect5.getBoundsInLocal().getWidth() != -1){
            System.out.println("collision circle");
            return true;
        }
        return false;
    }

    @Override
    public void switchColor(int num) throws FileNotFoundException {

        if(num == 0)
            this.setFill(new ImagePattern(new Image(new FileInputStream(image_path0))));
        if(num == 1)
            this.setFill(new ImagePattern(new Image(new FileInputStream(image_path1))));
        if(num == 2)
            this.setFill(new ImagePattern(new Image(new FileInputStream(image_path2))));
        if(num == 3)
            this.setFill(new ImagePattern(new Image(new FileInputStream(image_path3))));
    }

    @Override
    public void setImage() throws FileNotFoundException {
        this.setFill(new ImagePattern(new Image(new FileInputStream(image_path1))));
    }
}
