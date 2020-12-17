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
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;

public class C_application {

    @FXML
    private javafx.scene.control.Button closeButton;
    @FXML
    Button playButton, quitButton, creditsButton, scoreButton, shopButton, helpButton;
    @FXML
    AnchorPane anchorPane;
    @FXML
    Label totalStarLabel;
    @FXML
    private MediaPlayer music;
    Rectangle starShape;
    @FXML
    ImageView circle0, circle1, circle2, shopImage;
    @FXML
    ImageView logocircle0, logocircle1;
//    static int totalStars;

    @FXML
    public void initialize() throws FileNotFoundException {
        music.setOnEndOfMedia(() -> music.seek(Duration.ZERO));
        music.play();
//        totalStars = common.totalScore;
        shopImage.setPreserveRatio(true);
        totalStarLabel.setText(Integer.toString(common.totalScore));
        starShape = new Rectangle(42, 45);
        starShape.setFill(new ImagePattern(new Image(new FileInputStream("src/sample/resources/star_tran.png"))));
        starShape.setLayoutX(26);
        starShape.setLayoutY(130);
        anchorPane.getChildren().add(starShape);
        ScaleTransition transition = new ScaleTransition(Duration.seconds(3), starShape);
        transition.setCycleCount(ScaleTransition.INDEFINITE);
        transition.setAutoReverse(true); transition.setToX(1.3);
        transition.setToY(1.3); transition.setRate(2); transition.play();
        RotateTransition rt = new RotateTransition(); rt.setDuration(Duration.seconds(5));
        rt.setNode(circle0); rt.setByAngle(360); rt.setInterpolator(Interpolator.LINEAR);
        rt.setCycleCount(RotateTransition.INDEFINITE); rt.setAutoReverse(false); rt.play();
        RotateTransition rt1 = new RotateTransition(); rt1.setDuration(Duration.seconds(5));
        rt1.setNode(circle1); rt1.setByAngle(360); rt1.setRate(-1);
        rt1.setInterpolator(Interpolator.LINEAR); rt1.setCycleCount(RotateTransition.INDEFINITE);
        rt1.setAutoReverse(false); rt1.play();
        RotateTransition rt3 = new RotateTransition(); rt3.setDuration(Duration.seconds(5));
        rt3.setNode(logocircle0); rt3.setByAngle(360); rt3.setInterpolator(Interpolator.LINEAR);
        rt3.setCycleCount(RotateTransition.INDEFINITE); rt3.setAutoReverse(false); rt3.play();
        RotateTransition rt4 = new RotateTransition(); rt4.setDuration(Duration.seconds(5));
        rt4.setNode(logocircle1); rt4.setByAngle(360); rt4.setInterpolator(Interpolator.LINEAR);
        rt4.setCycleCount(RotateTransition.INDEFINITE); rt4.setAutoReverse(false); rt4.play();
        RotateTransition rt5 = new RotateTransition(); rt5.setDuration(Duration.seconds(5));
        rt5.setNode(circle2); rt5.setByAngle(360); rt5.setRate(-1);
        rt5.setInterpolator(Interpolator.LINEAR); rt5.setCycleCount(RotateTransition.INDEFINITE);
        rt5.setAutoReverse(false); rt5.play();
        RotateTransition rt6 = new RotateTransition(); rt6.setDuration(Duration.seconds(5));
        rt6.setNode(shopImage); rt6.setByAngle(360); rt6.setInterpolator(Interpolator.LINEAR);
        rt6.setCycleCount(RotateTransition.INDEFINITE); rt6.setAutoReverse(false); rt6.play();
    }

    public void press_play(ActionEvent event) throws IOException {
        music.stop();
        Scene HomePage = FXMLLoader.load(getClass().getResource("play_options.fxml"));
        Main.gameStage.setScene(HomePage);
    }
    public void press_scores(ActionEvent event) throws IOException {
        music.stop();
        Scene HomePage = FXMLLoader.load(getClass().getResource("scores.fxml"));
        Main.gameStage.setScene(HomePage);
    }
    public void press_shop(ActionEvent event) throws IOException {
        music.stop();
        Scene HomePage = FXMLLoader.load(getClass().getResource("shop.fxml"));
        Main.gameStage.setScene(HomePage);
    }
    public void press_help(ActionEvent event) throws IOException {
        music.stop();
        Scene HomePage = FXMLLoader.load(getClass().getResource("help.fxml"));
        Main.gameStage.setScene(HomePage);
    }
    public void press_quit(ActionEvent event) throws IOException {
        music.stop();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        User me = new User(common.totalScore, common.theList, common.scoreList, common.availableBalls, common.currBall);
        try{
            FileOutputStream fileOut = new FileOutputStream("gameUser");
            ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
            me.setTotalScore(common.totalScore);
            outStream.writeObject(me);
            System.out.println("done");
            outStream.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.close();
    }

    public void press_credits(ActionEvent event) throws IOException {
        music.stop();
        Scene HomePage = FXMLLoader.load(getClass().getResource("credits.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}