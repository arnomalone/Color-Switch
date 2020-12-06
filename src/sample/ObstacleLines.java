package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class ObstacleLines extends Obstacle {
    private final Image color0, color1, color2, color3;
    private Line line1, line2;
    public ObstacleLines(Image color0, Image color1, Image color2, Image color3, Image colorChangerImage, Image starImage){
        super(color3);
        type = 3;
        this.color0 = color0;
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.setTranslateX(280-(this.getWidth()/3));
        colorChanger = new ElementColorChanger(colorChangerImage);
        colorChanger.setNextColor(3);
        star = new ElementStar(5.0, starImage);


        line1 = new Line(125, 125, 125, 25);
        line2 = new Line(125, 125, 125, 25);

        this.rotateProperty().addListener(o -> {
            Point2D start1 = this.localToParent(100, 10);
            Point2D end1 = this.localToParent(100, 190);
            Point2D start3 = this.localToParent(100, 100);
            Point2D end3 = this.localToParent(190, 100);
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
            System.out.println("collision line");
            return true;
        }
        return false;
    }

    @Override
    public void switchColor(int num) {
        if(num == 0) this.setColor(color0);
        if(num == 1) this.setColor(color1);
        if(num == 2) this.setColor(color2);
        if(num == 3) this.setColor(color3);
    }
}
