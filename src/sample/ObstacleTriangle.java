package sample;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class ObstacleTriangle extends Obstacle {
    String image_path1, image_path2;
    private final Line line1, line2;
    public ObstacleTriangle() throws FileNotFoundException {
        super();
        type = 4;
        image_path0 = "src/sample/resources/triangle-1.png";
        image_path1 = "src/sample/resources/triangle-2.png";
        image_path2 = "src/sample/resources/triangle-3.png";
        Random random = new Random();
        int num = random.nextInt(4);
        while(num == C_play.lastColor || num == 0)
            num = random.nextInt(4);
        C_play.lastColor = num;
        this.setTranslateX(250-(this.getWidth()/2));
        setImage();
        colorChanger = new ElementColorChanger();
        colorChanger.setNextColor(num);
        colorChanger.setTranslateY(this.getTranslateY()+300);
        star = new ElementStar(5.0);
        star.setTranslateY(this.getTranslateY()+(this.getHeight()/2)-(star.getRadius()/2));

        line1 = new Line(125, 125, 125, 25);
        line2 = new Line(125, 125, 125, 25);

        this.rotateProperty().addListener(o -> {
            Point2D start1 = this.localToParent(100, 10);
            Point2D end1 = this.localToParent(20, 180);
            Point2D start3 = this.localToParent(10, 190);
            Point2D end3 = this.localToParent(175, 190);
            line1.setStartX(start1.getX());
            line1.setStartY(start1.getY());
            line1.setEndX(end1.getX());
            line1.setEndY(end1.getY());
            line2.setStartX(start3.getX());
            line2.setStartY(start3.getY());
            line2.setEndX(end3.getX());
            line2.setEndY(end3.getY());
        });
    }

    @Override
    public boolean isCollision(Elements ball) {
        Shape intersect1 = Shape.intersect(ball, line1);
        Shape intersect2 = Shape.intersect(ball, line2);
        if (intersect1.getBoundsInLocal().getWidth() != -1 || intersect2.getBoundsInLocal().getWidth() != -1) {
            System.out.println("collision triangle");
            return true;
        }
        return false;
    }

    @Override
    public void switchColor(int num) throws FileNotFoundException {
        if(num == 1)
            this.setFill(new ImagePattern(new Image(new FileInputStream(image_path0))));
        if(num == 2)
            this.setFill(new ImagePattern(new Image(new FileInputStream(image_path1))));
        if(num == 3)
            this.setFill(new ImagePattern(new Image(new FileInputStream(image_path2))));
    }

    @Override
    public void setImage() throws FileNotFoundException {
        this.setFill(new ImagePattern(new Image(new FileInputStream(image_path1))));
    }
}
