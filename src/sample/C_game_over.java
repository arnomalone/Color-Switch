package sample;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C_game_over {
    @FXML
    Label starLabel, scoreLabel, theLabel;
    @FXML
    private AnchorPane anchorPane;
    Rectangle starShape;

    public void initialize() throws FileNotFoundException {
        int num = C_play.count;
        scoreLabel.setText(Integer.toString(num));
        int total_stars = common.totalScore;
        starLabel.setText(Integer.toString(total_stars));
        starShape = new Rectangle(42, 45);
        starShape.setFill(new ImagePattern(new Image(new FileInputStream("src/sample/resources/star_tran.png"))));
        starShape.setLayoutX(25);
        starShape.setLayoutY(160);
        anchorPane.getChildren().add(starShape);
        ScaleTransition transition = new ScaleTransition(Duration.seconds(3), starShape);
        transition.setCycleCount(ScaleTransition.INDEFINITE);
        transition.setAutoReverse(true);
        transition.setToX(1.3);
        transition.setToY(1.3);
        transition.setRate(2);
        transition.play();
    }

    public void press_revive(ActionEvent event) throws IOException {
        if(C_application.totalStars >= 10){
            C_application.totalStars -= 10;
            Scene HomePage = FXMLLoader.load(getClass().getResource("play.fxml"));
            Main.gameStage.setScene(HomePage);
        }
        else{
            System.out.println("not enough stars");
        }
    }
    public void press_restart(ActionEvent event) throws IOException {
        int num = C_play.count;
        common.totalScore += num;
        common.currGame = new Game();
        Scene HomePage = FXMLLoader.load(getClass().getResource("play.fxml"));
        Main.gameStage.setScene(HomePage);
    }
    public void press_main_menu(ActionEvent event) throws IOException {
        int num = C_play.count;
        common.totalScore += num;
        Scene HomePage = FXMLLoader.load(getClass().getResource("application.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}