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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;

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
    @FXML
    ImageView circle0, circle1, circle2;
    @FXML
    ImageView logocircle0, logocircle1;
//    static int totalStars;

    @FXML
    public void initialize() throws FileNotFoundException {
//        totalStars = common.totalScore;
        totalStarLabel.setText(Integer.toString(common.totalScore));
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
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.seconds(5));
        rotateTransition.setNode(circle0);
        rotateTransition.setByAngle(360);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();
        RotateTransition rotateTransition1 = new RotateTransition();
        rotateTransition1.setDuration(Duration.seconds(5));
        rotateTransition1.setNode(circle1);
        rotateTransition1.setByAngle(360);
        rotateTransition1.setRate(-1);
        rotateTransition1.setInterpolator(Interpolator.LINEAR);
        rotateTransition1.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition1.setAutoReverse(false);
        rotateTransition1.play();
        RotateTransition rotateTransition2 = new RotateTransition();
        rotateTransition2.setDuration(Duration.seconds(5));
        rotateTransition2.setNode(logocircle0);
        rotateTransition2.setByAngle(360);
        rotateTransition2.setInterpolator(Interpolator.LINEAR);
        rotateTransition2.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition2.setAutoReverse(false);
        rotateTransition2.play();
        RotateTransition rotateTransition3 = new RotateTransition();
        rotateTransition3.setDuration(Duration.seconds(5));
        rotateTransition3.setNode(logocircle1);
        rotateTransition3.setByAngle(360);
        rotateTransition3.setInterpolator(Interpolator.LINEAR);
        rotateTransition3.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition3.setAutoReverse(false);
        rotateTransition3.play();
        RotateTransition rotateTransition4 = new RotateTransition();
        rotateTransition4.setDuration(Duration.seconds(5));
        rotateTransition4.setNode(circle2);
        rotateTransition4.setByAngle(360);
        rotateTransition4.setRate(-1);
        rotateTransition4.setInterpolator(Interpolator.LINEAR);
        rotateTransition4.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition4.setAutoReverse(false);
        rotateTransition4.play();
    }

    public void press_play(ActionEvent event) throws IOException {
        Scene HomePage = FXMLLoader.load(getClass().getResource("play_options.fxml"));
        Main.gameStage.setScene(HomePage);
    }
    public void press_scores(ActionEvent event) throws IOException {
        Scene HomePage = FXMLLoader.load(getClass().getResource("scores.fxml"));
        Main.gameStage.setScene(HomePage);
    }
    public void press_quit(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        // Want to do something here?
//        C_window window = new C_window();
//        window.serialize();
        User me = new User(common.totalScore, common.theList, common.scoreList);
        try{
            FileOutputStream fileOut = new FileOutputStream("gameUser");
            ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
            me.totalScore = common.totalScore;
            outStream.writeObject(me);
            System.out.println("done");
            outStream.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Scene HomePage = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        Main.gameStage.setScene(HomePage);
        stage.close();
    }

    public void press_credits(ActionEvent event) throws IOException {
        Scene HomePage = FXMLLoader.load(getClass().getResource("credits.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}