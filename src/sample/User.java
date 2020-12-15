package sample;

import java.util.ArrayList;

public class User {
    public int totalScore;
    public ArrayList<Game> gameList;
    public User(){
        totalScore = 30;
        gameList = new ArrayList<>();
    }
}
