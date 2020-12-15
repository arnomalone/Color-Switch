package sample;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Game {
    public int score;
    public Double y1, y2, y3;
    public int t1, t2, t3;
    public Double y_ball;
    public int lastColor;
    public boolean ccv1, ccv2, ccv3;
    public boolean sv1, sv2, sv3;
    public int currColor1, currColor2, currColor3;
    public int ballColor;
//    public String id;

    public Game(){
//        id = "raggsss_arno";
        score = 0;
        y1 = 200.0;
        y2 = y1 - 450.0;
        y3 = y2 - 450.0;
        t1 = 1; t2 = 2; t3 = 3;
        y_ball = 480.0;
        lastColor = 3;
        ccv1 = false;
        ccv2 = true;
        ccv3 = true;
        sv1 = true;
        sv2 = true;
        sv3 = true;
        currColor3 = 2;
        currColor2 = 1;
        currColor1 = 3;
        ballColor = 3;
//        score = 12;
//        y1 = 60.67708333333334;
//        y2 = 998.8281249999999;
//        y3 = 537.9947916666667;
//        y_ball = 370.7999999999871;
//        t1 = 3; t2 = 1; t3 = 2;
//        lastColor = 0;
//        ccv1 = false;
//        ccv2 = false;
//        ccv3 = false;
//        sv1 = true;
//        sv2 = false;
//        sv3 = false;
//        currColor1 = 1;
//        currColor2 = 1;
//        currColor3 = 3;
//        ballColor = 1;

    }

    @Override
    public String toString(){
        String timeStamp = new SimpleDateFormat("MM/dd - HH:mm:ss").format(Calendar.getInstance().getTime());
        return timeStamp;
    }
}
