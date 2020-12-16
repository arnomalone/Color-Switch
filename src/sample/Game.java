package sample;

import java.io.Serializable;
import java.util.Random;

public class Game implements Serializable {
    private int score;
    private Double y1, y2, y3;
    private int t1, t2, t3;
    private Double y_ball;
    private int lastColor;
    private boolean ccv1, ccv2, ccv3;
    private boolean sv1, sv2, sv3;
    private boolean cch1, cch2, cch3;
    private boolean sh1, sh2, sh3;
    private int currColor1, currColor2, currColor3;
    private int ballColor;
    private String name;
    private String id;

    public Game(){
        name = ""; id = "10";
        score = 0; y1 = 200.0;
        y2 = y1 - 450.0;
        y3 = y2 - 450.0;
        Random random = new Random();
        t1 = random.nextInt(4)+1;
        t2 = random.nextInt(4)+1;
        t3 = random.nextInt(4)+1;
        y_ball = 480.0; lastColor = -1;
        ccv1 = false; ccv2 = true; ccv3 = true;
        sv1 = true; sv2 = true; sv3 = true;
        cch1 = false; cch2 = false; cch3 = false;
        sh1 = false; sh2 = false; sh3 = false;
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
        ballColor = currColor1;
    }

    public String getName() { return name; }

    public Double getY1() { return y1; }

    public Double getY2() { return y2; }

    public Double getY3() { return y3; }

    public Double getY_ball() { return y_ball; }

    public int getBallColor() { return ballColor; }

    public int getCurrColor1() { return currColor1; }

    public int getCurrColor2() { return currColor2; }

    public int getCurrColor3() { return currColor3; }

    public int getLastColor() { return lastColor; }

    public int getScore() { return score; }

    public int getT1() { return t1; }

    public int getT2() { return t2; }

    public int getT3() { return t3; }

    public boolean isCch1() { return cch1; }

    public boolean isCch2() { return cch2; }

    public boolean isCch3() { return cch3; }

    public boolean isCcv1() { return ccv1; }

    public boolean isCcv2() { return ccv2; }

    public boolean isCcv3() { return ccv3; }

    public boolean isSh1() { return sh1; }

    public boolean isSh2() { return sh2; }

    public boolean isSh3() { return sh3; }

    public boolean isSv1() { return sv1; }

    public boolean isSv2() { return sv2; }

    public boolean isSv3() { return sv3; }

    public String getId() { return id; }

    public void setBallColor(int ballColor) { this.ballColor = ballColor; }

    public void setCch1(boolean cch1) { this.cch1 = cch1; }

    public void setCch2(boolean cch2) { this.cch2 = cch2; }

    public void setCch3(boolean cch3) { this.cch3 = cch3; }

    public void setName(String name) { this.name = name; }

    public void setCcv1(boolean ccv1) { this.ccv1 = ccv1; }

    public void setCcv2(boolean ccv2) { this.ccv2 = ccv2; }

    public void setCcv3(boolean ccv3) { this.ccv3 = ccv3; }

    public void setCurrColor1(int currColor1) { this.currColor1 = currColor1; }

    public void setCurrColor2(int currColor2) { this.currColor2 = currColor2; }

    public void setCurrColor3(int currColor3) { this.currColor3 = currColor3; }

    public void setId(String id) { this.id = id; }

    public void setLastColor(int lastColor) { this.lastColor = lastColor; }

    public void setScore(int score) { this.score = score; }

    public void setSh1(boolean sh1) { this.sh1 = sh1; }

    public void setSh2(boolean sh2) { this.sh2 = sh2; }

    public void setSh3(boolean sh3) { this.sh3 = sh3; }

    public void setSv1(boolean sv1) { this.sv1 = sv1; }

    public void setSv2(boolean sv2) { this.sv2 = sv2; }

    public void setSv3(boolean sv3) { this.sv3 = sv3; }

    public void setT1(int t1) { this.t1 = t1; }

    public void setT2(int t2) { this.t2 = t2; }

    public void setT3(int t3) { this.t3 = t3; }

    public void setY1(Double y1) { this.y1 = y1; }

    public void setY2(Double y2) { this.y2 = y2; }

    public void setY3(Double y3) { this.y3 = y3; }

    public void setY_ball(Double y_ball) { this.y_ball = y_ball; }

    @Override
    public String toString(){
        String output = String.format("%15s %5d ☆%20s", this.name, this.score, this.id);
        return output;
    }
}
