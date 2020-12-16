package sample;

import java.io.Serializable;
import java.util.Random;

public class Game implements Serializable {
    public int score;
    public Double y1, y2, y3;
    public int t1, t2, t3;
    public Double y_ball;
    public int lastColor;
    public boolean ccv1, ccv2, ccv3;
    public boolean sv1, sv2, sv3;
    public boolean cch1, cch2, cch3;
    public boolean sh1, sh2, sh3;
    public int currColor1, currColor2, currColor3;
    public int ballColor;
    public String name;
    public String id;

    public Game(){
        name = "";
        id = "10";
        score = 0;
        y1 = 200.0;
        y2 = y1 - 450.0;
        y3 = y2 - 450.0;
//        t1 = 1; t2 = 2; t3 = 3;
        Random random = new Random();
        t1 = random.nextInt(4)+1;
        t2 = random.nextInt(4)+1;
        t3 = random.nextInt(4)+1;
        y_ball = 480.0;
        lastColor = -1;
        ccv1 = false;
        ccv2 = true;
        ccv3 = true;
        sv1 = true;
        sv2 = true;
        sv3 = true;
        cch1 = false;
        cch2 = false;
        cch3 = false;
        sh1 = false;
        sh2 = false;
        sh3 = false;
        if(t1 != 4){
            currColor1 = random.nextInt(4);
            while(currColor1==lastColor){
                currColor1 = random.nextInt(4);
            }
        }else{
            currColor1 = random.nextInt(3)+1;
            while(currColor1==lastColor){
                currColor1 = random.nextInt(3)+1;
            }
        }
        lastColor = currColor1;
        if(t2 != 4){
            currColor2 = random.nextInt(4);
            while(currColor2==lastColor){
                currColor2 = random.nextInt(4);
            }
        }else{
            currColor2 = random.nextInt(3)+1;
            while(currColor2==lastColor){
                currColor2 = random.nextInt(3)+1;
            }
        }
        lastColor = currColor2;
        if(t3 != 4){
            currColor3 = random.nextInt(4);
            while(currColor3==lastColor){
                currColor3 = random.nextInt(4);
            }
        }else{
            currColor3 = random.nextInt(3)+1;
            while(currColor3==lastColor){
                currColor3 = random.nextInt(3)+1;
            }
        }
        lastColor = currColor3;
//        lastColor = currColor1;
//        currColor2 = random.nextInt(4);
//        while(currColor2==lastColor || (t2 == 4 && currColor2 == 0)){
//            currColor2 = random.nextInt(4);
//        }
//        lastColor = currColor2;
//        currColor3 = random.nextInt(4);
//        while(currColor3==lastColor || (t3 == 4 && currColor3 == 0)){
//            currColor3 = random.nextInt(4);
//        }
//        lastColor = currColor3;
//        currColor3 = 2;
//        currColor2 = 1;
//        currColor1 = 3;
        ballColor = currColor1;
        System.out.println("t1: " + t1 + " t2: " + t2 + " t3: " + t3);
        System.out.println("color1: " + currColor1 + " color2: " + currColor2 + " color3: " + currColor3);
    }

    @Override
    public String toString(){
        String output = String.format("%15s %5d ☆%20s", this.name, this.score, this.id);
        return output;
    }
}
