package sample;

import java.io.FileNotFoundException;

public class Ball6 extends ElementBall{

    public Ball6() throws FileNotFoundException {
        super();
        image_path0 = "src/sample/resources/purple_ball_6.png";
        image_path1 = "src/sample/resources/yellow_ball_6.png";
        image_path2 = "src/sample/resources/red_ball_6.png";
        image_path3 = "src/sample/resources/blue_ball_6.png";
        this.setImage();
        this.setHeight(20);
        this.setWidth(20);
        setTranslateX(250-(this.getWidth()/2));
    }

}
