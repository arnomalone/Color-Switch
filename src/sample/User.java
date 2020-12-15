package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    public int totalScore;
    public ArrayList<Game> gameList;
    public User(){
        totalScore = 30;
        gameList = new ArrayList<>();
    }
    public User(int score, ArrayList<Game> list){
        this.totalScore = score;
        this.gameList = list;
    }
}
