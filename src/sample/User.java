package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private int totalScore;
    private ArrayList<Game> gameList;
    private ArrayList<ScoreBoard> scoreList;
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

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public ArrayList<Game> getGameList() {
        return gameList;
    }

    public void setGameList(ArrayList<Game> gameList) {
        this.gameList = gameList;
    }

    public ArrayList<ScoreBoard> getScoreList() {
        return scoreList;
    }

    public void setScoreList(ArrayList<ScoreBoard> scoreList) {
        this.scoreList = scoreList;
    }
}
