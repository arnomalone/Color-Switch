package sample;

import java.io.FileNotFoundException;

public abstract class Obstacle extends Elements {
    protected int type;
    int x=200;
    int y=200;
    protected ElementColorChanger colorChanger;
    ElementStar star;
    public Obstacle()
    {
        super();
        this.setHeight(200);
        this.setWidth(200);
    }

    public abstract void spawn() throws FileNotFoundException;

    public abstract boolean isCollision(Elements ball);

    public abstract void switchColor(int num) throws FileNotFoundException;
}
