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

import java.io.*;

public class C_game_over {
    @FXML
    Label starLabel, scoreLabel, theLabel;
    @FXML
    private AnchorPane anchorPane;
    Rectangle starShape;

    public void initialize() throws FileNotFoundException {
        int num = C_play.count;
        scoreLabel.setText(Integer.toString(num));
        C_application.totalStars += num;
        int total_stars = C_application.totalStars;
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
        Scene HomePage = FXMLLoader.load(getClass().getResource("play.fxml"));
        Main.gameStage.setScene(HomePage);
    }
    public void press_restart(ActionEvent event) throws IOException {
        try
        {
            File file;
            FileInputStream fileOut = new FileInputStream("game1");
            ObjectInputStream outStream = new ObjectInputStream(fileOut);
            Data saved = (Data) outStream.readObject();
            saved.total_count+=saved.count;
            saved.count=0;
            outStream.close();
            fileOut.close();
            try
            {
                FileOutputStream fileOut1 = new FileOutputStream("game1");
                ObjectOutputStream outStream1 = new ObjectOutputStream(fileOut1);
                outStream1.writeObject(saved);
                outStream1.close();
                fileOut1.close();
            }catch(IOException i)
            {
                i.printStackTrace();
            }
        }catch(IOException | ClassNotFoundException i)
        {
            i.printStackTrace();
        }
        Scene HomePage = FXMLLoader.load(getClass().getResource("play.fxml"));
        Main.gameStage.setScene(HomePage);
    }
    public void press_main_menu(ActionEvent event) throws IOException {
        Scene HomePage = FXMLLoader.load(getClass().getResource("application.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}