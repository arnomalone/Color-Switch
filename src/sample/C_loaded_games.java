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
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class C_loaded_games {
    @FXML
    private Button backButton;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ListView<Game> list;
    @FXML
    public void initialize(){
        anchorPane.setMaxHeight(800);
        anchorPane.setMinHeight(800);
//        list = new ListView<>();
        for(int i=0;i<common.theList.size();i++){
            list.getItems().add(common.theList.get(i));
        }

        list.setOnMouseClicked(event -> {
            Game game = list.getSelectionModel().getSelectedItem();
            common.currGame = game;
            Scene HomePage = null;
            try {
                HomePage = FXMLLoader.load(getClass().getResource("play.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            common.theList.remove(list.getSelectionModel().getSelectedIndex());
            Main.gameStage.setScene(HomePage);
        });
//        anchorPane.getChildren().add(list);
    }
    public void press_back(ActionEvent event) throws IOException {
        Scene HomePage = FXMLLoader.load(getClass().getResource("play_options.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}