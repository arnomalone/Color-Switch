package sample;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class ObstacleCircle extends Obstacle {
    private final Image color0, color1, color2, color3;
    private final Line line1, line2, line3, line4, line5;

    public ObstacleCircle(Image color0, Image color1, Image color2, Image color3, Image colorChangerImage, Image starImage){
        super(color1);
        type = 1;
        this.color0 = color0;
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.setTranslateX(250-(this.getWidth()/2));
        this.setTranslateY(400-this.getHeight());
        colorChanger = new ElementColorChanger(colorChangerImage);
        colorChanger.setNextColor(1);
        colorChanger.setTranslateY(this.getTranslateY()+300);
        star = new ElementStar(5.0, starImage);
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

    }

//    @Override
//    public void switchColor(int num){
//        System.out.println("hi");;
//        if(num == 0) this.setColor(color0);
//        if(num == 1) this.setColor(color1);
//        if(num == 2) this.setColor(color2);
//        if(num == 3) this.setColor(color3);
//    }

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
    public void switchColor(int num) {
        if(num == 0) this.setColor(color0);
        if(num == 1) this.setColor(color1);
        if(num == 2) this.setColor(color2);
        if(num == 3) this.setColor(color3);
    }
}
