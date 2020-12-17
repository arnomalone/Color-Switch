package sample;

import java.io.FileNotFoundException;

public class Ball1 extends ElementBall{

    public Ball1() throws FileNotFoundException {
        super();
        image_path0 = "src/sample/resources/purple_ball_1.png";
        image_path1 = "src/sample/resources/yellow_ball_1.png";
        image_path2 = "src/sample/resources/red_ball_1.png";
        image_path3 = "src/sample/resources/blue_ball_1.png";
        this.setImage();
        this.setHeight(20);
        this.setWidth(20);
        setTranslateX(250-(this.getWidth()/2));
    }

}
