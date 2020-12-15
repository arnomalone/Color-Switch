package sample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    Rectangle starShape;
    static int totalStars;

    @FXML
    void initialize() throws FileNotFoundException {
        totalStars = common.totalScore;
        totalStarLabel.setText(Integer.toString(totalStars));
        starShape = new Rectangle(42, 45);
        starShape.setFill(new ImagePattern(new Image(new FileInputStream("src/sample/resources/star_tran.png"))));
        starShape.setLayoutX(26);
        starShape.setLayoutY(130);
        anchorPane.getChildren().add(starShape);
        ScaleTransition transition = new ScaleTransition(Duration.seconds(3), starShape);
        transition.setCycleCount(ScaleTransition.INDEFINITE);
        transition.setAutoReverse(true);
        transition.setToX(1.3);
        transition.setToY(1.3);
        transition.setRate(2);
        transition.play();
    }

    public void press_play(ActionEvent event) throws IOException {
        Scene HomePage = FXMLLoader.load(getClass().getResource("play_options.fxml"));
        Main.gameStage.setScene(HomePage);
    }
    public void press_scores(ActionEvent event) throws IOException {
        Scene HomePage = FXMLLoader.load(getClass().getResource("scores.fxml"));
        Main.gameStage.setScene(HomePage);
    }
    public void press_quit(ActionEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        // Want to do something here?
        stage.close();
    }

    public void press_credits(ActionEvent event) throws IOException {
        Scene HomePage = FXMLLoader.load(getClass().getResource("credits.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}