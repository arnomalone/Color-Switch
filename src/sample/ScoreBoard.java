package sample;

import java.io.Serializable;

public class ScoreBoard implements Comparable<ScoreBoard>, Serializable {
    int score;
    String time;

    public ScoreBoard(int score, String time){
        this.score = score;
        this.time = time;
    }

    @Override
    public int compareTo(ScoreBoard o){
        return (o.score - this.score);
    }

    @Override
    public String toString(){
        String output = String.format("%5d ☆%20s", this.score, this.time);
        return output;
    }
}
