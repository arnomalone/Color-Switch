package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private int totalScore;
    private int currBall;
    private ArrayList<Game> gameList;
    private ArrayList<ScoreBoard> scoreList;
    private ArrayList<ShopItems> shopList;
    public User(){
        totalScore = 0;
        gameList = new ArrayList<>();
        scoreList = new ArrayList<>();
        currBall = 0;
        shopList = new ArrayList<>();
        shopList.add(new ShopItems(true, 0));
        shopList.add(new ShopItems(false, 50));
        shopList.add(new ShopItems(false, 10));
        shopList.add(new ShopItems(false, 75));
        shopList.add(new ShopItems(false, 20));
        shopList.add(new ShopItems(false, 25));
        shopList.add(new ShopItems(false, 15));
    }
    public User(int score, ArrayList<Game> list, ArrayList<ScoreBoard> scoreList, ArrayList<ShopItems> shopList, int currBall){
        this.totalScore = score;
        this.gameList = list;
        this.scoreList = scoreList;
        this.shopList = shopList;
        this.currBall = currBall;
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

    public int getCurrBall() { return currBall; }

    public void setCurrBall(int currBall) { this.currBall = currBall; }

    public ArrayList<ShopItems> getShopList() { return shopList; }

    public void setShopList(ArrayList<ShopItems> shopList) { this.shopList = shopList; }
}
