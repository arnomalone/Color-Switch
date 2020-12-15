package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class C_play_options {
    @FXML
    private Button mainMenuButton, newGame, loadGameButton;
    @FXML
    private AnchorPane anchorPane;
    public void press_new_game(ActionEvent event) throws IOException {
        common.currGame = new Game();
        Scene HomePage = FXMLLoader.load(getClass().getResource("play.fxml"));
        Main.gameStage.setScene(HomePage);
    }
    public void press_load_game(ActionEvent event) throws IOException {
        Scene HomePage = FXMLLoader.load(getClass().getResource("loaded_games.fxml"));
        Main.gameStage.setScene(HomePage);
    }
    public void press_back(ActionEvent event) throws IOException {
        Scene HomePage = FXMLLoader.load(getClass().getResource("application.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}