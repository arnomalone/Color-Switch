package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.IOException;

public class C_play_options {
    @FXML
    private Button mainMenuButton, newGame, loadGameButton;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private MediaPlayer music;
    @FXML
    void initialize(){
        music.setOnEndOfMedia(() -> music.seek(Duration.ZERO));
        music.play();
    }
    public void press_new_game(ActionEvent event) throws IOException {
        music.stop();
        common.currGame = new Game();
        Scene HomePage = FXMLLoader.load(getClass().getResource("play.fxml"));
        Main.gameStage.setScene(HomePage);
    }
    public void press_load_game(ActionEvent event) throws IOException {
        music.stop();
        Scene HomePage = FXMLLoader.load(getClass().getResource("loaded_games.fxml"));
        Main.gameStage.setScene(HomePage);
    }
    public void press_back(ActionEvent event) throws IOException {
        music.stop();
        Scene HomePage = FXMLLoader.load(getClass().getResource("application.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}