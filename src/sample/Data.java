package sample;

import sample.ElementBall;
import sample.Obstacle;

import java.io.FileNotFoundException;
import java.io.Serializable;

public class Data implements Serializable {
    public double y1;
    boolean v1;
    public double y2;
    boolean v2;
    public double y3;
    boolean v3;
    public int count;
    public int total_count;
//    public ElementBall ball;
    public Data(double y1, double y2, double y3)
    {
        this.y1=y1;
        this.y2=y2;
        this.y3=y3;
        this.count=0;
    }

    public void load() throws FileNotFoundException {
//        obstacle1.spawn();
//        obstacle2.spawn();
//        obstacle3.spawn();
    }

    public void reset()
    {
        y1=200;
        y2=y1-450;
        y3=y2-450;
    }

    public void save() {
    }
}
