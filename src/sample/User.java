package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    public int totalScore;
    public ArrayList<Game> gameList;
    public ArrayList<ScoreBoard> scoreList;
    public User(){
        totalScore = 0;
        gameList = new ArrayList<>();
        scoreList = new ArrayList<>();
    }
    public User(int score, ArrayList<Game> list, ArrayList<ScoreBoard> scoreList){
        this.totalScore = score;
        this.gameList = list;
        this.scoreList = scoreList;
    }
}
