package sample;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;

public class C_window {
    public User me;
    @FXML
    private Button sampleButton;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private StackPane stackPane;
    @FXML
    public void initialize(){
        try{
            FileInputStream fileIn = new FileInputStream("gameUser");
            System.out.println("welcome back");
            ObjectInputStream inStream = new ObjectInputStream(fileIn);
            me = (User) inStream.readObject();
            common.theList = me.getGameList();
            common.totalScore = me.getTotalScore();
            common.scoreList = me.getScoreList();
            common.currBall = me.getCurrBall();
            common.availableBalls = me.getShopList();
            inStream.close();
            fileIn.close();
        } catch (FileNotFoundException e){
            System.out.println("new user");
            me = new User();
            common.theList = me.getGameList();
            common.scoreList = me.getScoreList();
            common.totalScore = me.getTotalScore();
            common.currBall = me.getCurrBall();
            common.availableBalls = me.getShopList();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

    }

    public void press_button(ActionEvent event) throws IOException {
        Scene HomePage = FXMLLoader.load(getClass().getResource("application.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}