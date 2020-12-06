package sample;

import java.io.FileNotFoundException;

public abstract class Obstacle extends Elements {
    protected int type;
    protected ElementColorChanger colorChanger;
    ElementStar star;
    public Obstacle()
    {
        super();
        this.setHeight(200);
        this.setWidth(200);

    }

    public abstract boolean isCollision(Elements ball);

    public abstract void switchColor(int num) throws FileNotFoundException;
}
