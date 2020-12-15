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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class C_user_input {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button backButton;
    @FXML
    private Button doneButton;
    @FXML
    private TextField textField;
    @FXML
    private Label label;

    public void initialize(){
        label.setVisible(false);
    }

    public void press_done(ActionEvent event) throws IOException {
        String name = textField.getText();
        boolean isPresent = false;
        for(int i=0;i<common.theList.size();i++){
            if(common.theList.get(i).name.equals(name)){
//                label.setText("NAME ALREADY EXISTS");
                label.setVisible(true);
                isPresent = true;
                break;
            }
        }
        if(!isPresent){
            common.currGame.name = name;
            common.theList.add(common.currGame);
            Scene HomePage = FXMLLoader.load(getClass().getResource("application.fxml"));
            Main.gameStage.setScene(HomePage);
        }
    }
    public void press_back(ActionEvent event) throws IOException {
        Scene HomePage = FXMLLoader.load(getClass().getResource("pause.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}