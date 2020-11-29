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

public class Controller1 {
    @FXML
    private Button button;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private StackPane stackPane;
    public void buttonPress(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        Scene scene = button.getScene();
        root.translateXProperty().set(scene.getWidth());
        stackPane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.setOnFinished(event1 -> {
            stackPane.getChildren().remove(anchorPane);
        });
        timeline.play();
//        Parent root1 = FXMLLoader.load(getClass().getResource("sample2.fxml"));
//        Scene scene1 = new Scene(root1);
//        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        stage.setScene(scene1);
//        stage.show();
//        System.out.println( "hello world");
    }
}
