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
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Collections;

public class C_scores {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button backButton;
    @FXML
    private ListView<ScoreBoard> list;
    @FXML
    private MediaPlayer music;
    @FXML
    public void initialize(){
        music.setOnEndOfMedia(() -> music.seek(Duration.ZERO));
        music.play();
        anchorPane.setMaxHeight(800);
        anchorPane.setMinHeight(800);
        list.setStyle("-fx-font-size: 24px; -fx-font-family: 'SketchFlow Print';");
        anchorPane.getStylesheets().add(getClass().getResource("listStyle.css").toExternalForm());
        list.setFixedCellSize(60.0);
        Collections.sort(common.scoreList);
        for(int i=0;i<common.scoreList.size();i++){
            list.getItems().add(common.scoreList.get(i));
        }
    }

    public void press_back(ActionEvent event) throws IOException {
        music.stop();
        Scene HomePage = FXMLLoader.load(getClass().getResource("application.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}