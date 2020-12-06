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
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class C_loaded_games {
    @FXML
    private Button backButton;
    @FXML
    private AnchorPane anchorPane;
    public void press_back(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("play_options.fxml"));
//        Scene scene = backButton.getScene();
//        StackPane stackPane = (StackPane) scene.getRoot();
//        stackPane.getChildren().add(root);
//        stackPane.getChildren().remove(anchorPane);
        Scene HomePage = FXMLLoader.load(getClass().getResource("play_options.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}