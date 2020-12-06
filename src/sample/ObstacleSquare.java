package sample;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class ObstacleSquare extends Obstacle {
    private final Image color0, color1, color2, color3;
    private final Line line1, line2, line3;
    public ObstacleSquare(Image color0, Image color1, Image color2, Image color3, Image colorChangerImage, Image starImage){
        super(color0);
        type = 2;
        this.color0 = color0;
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.setTranslateX(250-(this.getWidth()/2));
        colorChanger = new ElementColorChanger(colorChangerImage);
        colorChanger.setNextColor(0);
        star = new ElementStar(5.0, starImage);

        line1 = new Line(125, 125, 125, 25);
        line2 = new Line(125, 125, 125, 25);
        line3 = new Line(125, 125, 125, 25);

        this.rotateProperty().addListener(o -> {
            Point2D start1 = this.localToParent(20, 10);
            Point2D end1 = this.localToParent(180, 10);
            Point2D start2 = this.localToParent(10, 20);
            Point2D end2 = this.localToParent(10, 180);
            Point2D start3 = this.localToParent(20, 190);
            Point2D end3 = this.localToParent(180, 190);
            line1.setStartX(start1.getX());
            line1.setStartY(start1.getY());
            line1.setEndX(end1.getX());
            line1.setEndY(end1.getY());
            line2.setStartX(start2.getX());
            line2.setStartY(start2.getY());
            line2.setEndX(end2.getX());
            line2.setEndY(end2.getY());
            line3.setStartX(start3.getX());
            line3.setStartY(start3.getY());
            line3.setEndX(end3.getX());
            line3.setEndY(end3.getY());
        });

    }

    @Override
    public boolean isCollision(Elements ball) {
        Shape intersect1 = Shape.intersect(ball, line1);
        Shape intersect2 = Shape.intersect(ball, line2);
        Shape intersect3 = Shape.intersect(ball, line3);
        if (intersect1.getBoundsInLocal().getWidth() != -1 || intersect2.getBoundsInLocal().getWidth() != -1) {
            System.out.println("collision square");
            return true;
        }
        if (intersect3.getBoundsInLocal().getWidth() != -1) {
            System.out.println("collision square");
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
