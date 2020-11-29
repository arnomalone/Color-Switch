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
        Parent root = FXMLLoader.load(getClass().getResource("play.fxml"));
        Scene scene = newGame.getScene();
        StackPane stackPane = (StackPane) scene.getRoot();
        stackPane.getChildren().add(root);
        stackPane.getChildren().remove(anchorPane);
    }
    public void press_load_game(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loaded_games.fxml"));
        Scene scene = loadGameButton.getScene();
        StackPane stackPane = (StackPane) scene.getRoot();
        stackPane.getChildren().add(root);
        stackPane.getChildren().remove(anchorPane);
    }
    public void press_back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("application.fxml"));
        Scene scene = mainMenuButton.getScene();
        StackPane stackPane = (StackPane) scene.getRoot();
        stackPane.getChildren().add(root);
        stackPane.getChildren().remove(anchorPane);
    }
}