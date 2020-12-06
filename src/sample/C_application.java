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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class C_application {

    @FXML
    private javafx.scene.control.Button closeButton;
    @FXML
    Button playButton, quitButton, creditsButton, scoreButton;
    @FXML
    AnchorPane anchorPane;
    @FXML
    Label totalStarLabel;

    static int totalStars;

    @FXML
    void initialize(){
        totalStarLabel.setText(Integer.toString(totalStars));
//        anchorPane.getChildren().add(totalStarLabel);
    }

    public void press_play(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("play_options.fxml"));
//        Scene scene = playButton.getScene();
//        StackPane stackPane = (StackPane) scene.getRoot();
//        stackPane.getChildren().add(root);
//        stackPane.getChildren().remove(anchorPane);
        Scene HomePage = FXMLLoader.load(getClass().getResource("play_options.fxml"));
        Main.gameStage.setScene(HomePage);
    }
    public void press_scores(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("scores.fxml"));
//        Scene scene = scoreButton.getScene();
//        StackPane stackPane = (StackPane) scene.getRoot();
//        stackPane.getChildren().add(root);
//        stackPane.getChildren().remove(anchorPane);
        Scene HomePage = FXMLLoader.load(getClass().getResource("scores.fxml"));
        Main.gameStage.setScene(HomePage);
    }
    public void press_quit(ActionEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        // Want to do something here?
        stage.close();
    }

    public void press_credits(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("credits.fxml"));
//        Scene scene = creditsButton.getScene();
//        StackPane stackPane = (StackPane) scene.getRoot();
//        stackPane.getChildren().add(root);
//        stackPane.getChildren().remove(anchorPane);
        Scene HomePage = FXMLLoader.load(getClass().getResource("credits.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}