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
    private boolean done = false;
    @FXML
    public void initialize(){
        boolean isList = false;
        try{
            FileInputStream fileIn = new FileInputStream("gameUser");
            System.out.println("welcome back");
            ObjectInputStream inStream = new ObjectInputStream(fileIn);
            me = (User) inStream.readObject();
            common.theList = me.gameList;
            common.totalScore = me.totalScore;
            common.scoreList = me.scoreList;
            isList = true;
            inStream.close();
            fileIn.close();
        } catch (FileNotFoundException e){
            System.out.println("new user");
            me = new User();
            common.theList = me.gameList;
            common.scoreList = me.scoreList;
            common.totalScore = me.totalScore;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public void press_button(ActionEvent event) throws IOException {
        Scene HomePage = FXMLLoader.load(getClass().getResource("application.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}