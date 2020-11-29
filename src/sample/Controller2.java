package sample;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Controller2 {
    @FXML
    private Button button, button1;
    @FXML
    private AnchorPane anchorPane;
    public void buttonPress2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample3.fxml"));
        Scene scene = button.getScene();
        StackPane stackPane = (StackPane) scene.getRoot();
        root.translateYProperty().set(scene.getHeight());
        stackPane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.setOnFinished(event1 -> {
            stackPane.getChildren().remove(anchorPane);
        });
        timeline.play();
    }
    public void buttonPressback(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = button1.getScene();
        StackPane stackPane = (StackPane) scene.getRoot();
        root.translateYProperty().set(scene.getHeight());
        stackPane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.setOnFinished(event1 -> {
            stackPane.getChildren().remove(anchorPane);
        });
        timeline.play();
    }
}
