package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.io.IOException;

public class C_help {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button backButton, doneButton;
    @FXML
    private MediaPlayer music;
    @FXML
    public void initialize(){
        music.setOnEndOfMedia(() -> music.seek(Duration.ZERO));
        music.play();
        anchorPane.setMaxHeight(800);
        anchorPane.setMinHeight(800);
    }

    public void press_done(ActionEvent event) throws IOException{
        music.stop();
        Scene HomePage = FXMLLoader.load(getClass().getResource("play_options.fxml"));
        Main.gameStage.setScene(HomePage);
    }

    public void press_back(ActionEvent event) throws IOException {
        music.stop();
        Scene HomePage = FXMLLoader.load(getClass().getResource("application.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}