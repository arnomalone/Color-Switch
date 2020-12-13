package sample;

import javafx.animation.*;
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
//<<<<<<< HEAD

import java.awt.*;
import java.io.*;
//=======
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//>>>>>>> 0e05c4f4fd0ca4a38f8fb6c3e84e0a17bf763c4b

public class C_pause {
    @FXML
    private Label scoreLabel, starLabel;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    Rectangle starShape;

    public void initialize() throws FileNotFoundException {
        starShape = new Rectangle(42, 45);
        starShape.setFill(new ImagePattern(new Image(new FileInputStream("src/sample/resources/star_tran.png"))));
        starShape.setLayoutX(25);
        starShape.setLayoutY(160);
        anchorPane.getChildren().add(starShape);

        int num = C_play.count;
        scoreLabel.setText(Integer.toString(num));
        C_application.totalStars += num;
        int total_stars = C_application.totalStars;
        starLabel.setText(Integer.toString(total_stars));
        ScaleTransition transition = new ScaleTransition(Duration.seconds(3), starShape);
        transition.setCycleCount(ScaleTransition.INDEFINITE);
        transition.setAutoReverse(true);
        transition.setToX(1.3);
        transition.setToY(1.3);
        transition.setRate(2);
        transition.play();
    }

    public void press_resume(ActionEvent event) throws IOException {
        Scene HomePage = FXMLLoader.load(getClass().getResource("play.fxml"));
        Main.gameStage.setScene(HomePage);
    }
    public void press_restart(ActionEvent event) throws IOException {
        int totalstars=0;
        try
        {
            FileInputStream fileOut = new FileInputStream("stars");
            ObjectInputStream outStream = new ObjectInputStream(fileOut);
            totalstars = outStream.readInt();
            System.out.println("SUCCESS");
            outStream.close();
            fileOut.close();
        }catch(IOException i)
        {
            i.printStackTrace();
        }
        try
        {
            File file;
            FileInputStream fileOut = new FileInputStream("game1");
            ObjectInputStream outStream = new ObjectInputStream(fileOut);
            Data saved = (Data) outStream.readObject();
            totalstars+= saved.count;
            saved.count=0;
            saved.reset();
            outStream.close();
            fileOut.close();
            try
            {
                FileOutputStream fileOut1 = new FileOutputStream("game1");
                ObjectOutputStream outStream1 = new ObjectOutputStream(fileOut1);
                System.out.println(saved.count);
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
        try
        {
            FileOutputStream fileOut1 = new FileOutputStream("stars");
            ObjectOutputStream outStream1 = new ObjectOutputStream(fileOut1);
            System.out.println();
            outStream1.writeInt(totalstars);
            outStream1.close();
            fileOut1.close();
        }catch(IOException i)
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