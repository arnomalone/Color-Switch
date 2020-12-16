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
import java.util.Iterator;

public class C_loaded_games {
    @FXML
    private Button backButton;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ListView<Game> list;
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

        for(Game game: common.theList){
            list.getItems().add(game);
        }

        list.setOnMouseClicked(event -> {
            Game game = null;
            try{
                game = list.getSelectionModel().getSelectedItem();
                int idx = list.getSelectionModel().getSelectedIndex();
                if(idx != -1){
                    common.currGame = game;
                    Scene HomePage = null;
                    try {
                        HomePage = FXMLLoader.load(getClass().getResource("play.fxml"));
                        if(idx >= 0){
                            common.theList.remove(list.getSelectionModel().getSelectedIndex());
                        }
                        Main.gameStage.setScene(HomePage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (NullPointerException e){
                        System.out.println("no items");
                    }
                }
            } catch (NullPointerException e){
                System.out.println("no no items");
            }


        });
    }

    public void press_back(ActionEvent event) throws IOException {
        music.stop();
        Scene HomePage = FXMLLoader.load(getClass().getResource("play_options.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}