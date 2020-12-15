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

public class C_window {
    @FXML
    private Button sampleButton;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private StackPane stackPane;
    public void initialize(){
        User me = new User();
        common.theList = me.gameList;
    }
    public void press_button(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("application.fxml"));
//        Scene scene = sampleButton.getScene();
//        stackPane.getChildren().add(root);
//        stackPane.getChildren().remove(anchorPane);
        Scene HomePage = FXMLLoader.load(getClass().getResource("application.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}