package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class C_game_over {
    @FXML
    private Button reviveButton, mainMenuButton, restartButton;
    @FXML
    private Label starLabel, scoreLabel;
    @FXML
    private AnchorPane anchorPane;

    public void initialize(){
        int num = C_play.count;
        scoreLabel.setText(Integer.toString(num));
        C_application.totalStars += num;
        int total_stars = C_application.totalStars;
        starLabel.setText(Integer.toString(total_stars));
    }

    public void press_revive(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("play.fxml"));
//        Scene scene = reviveButton.getScene();
//        StackPane stackPane = (StackPane) scene.getRoot();
//        stackPane.getChildren().add(root);
//        stackPane.getChildren().remove(anchorPane);
        Scene HomePage = FXMLLoader.load(getClass().getResource("play.fxml"));
        Main.gameStage.setScene(HomePage);
    }
    public void press_restart(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("play.fxml"));
//        Scene scene = restartButton.getScene();
//        StackPane stackPane = (StackPane) scene.getRoot();
//        stackPane.getChildren().add(root);
//        stackPane.getChildren().remove(anchorPane);
        Scene HomePage = FXMLLoader.load(getClass().getResource("play.fxml"));
        Main.gameStage.setScene(HomePage);
    }
    public void press_main_menu(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("application.fxml"));
//        Scene scene = mainMenuButton.getScene();
//        StackPane stackPane = (StackPane) scene.getRoot();
//        stackPane.getChildren().add(root);
//        stackPane.getChildren().remove(anchorPane);
        Scene HomePage = FXMLLoader.load(getClass().getResource("application.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}