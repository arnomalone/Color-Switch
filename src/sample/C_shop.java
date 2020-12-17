package sample;

import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.io.IOException;
import java.util.ArrayList;

public class C_shop {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button backButton, doneButton;
    @FXML
    ImageView image0, image1, image2, image3, image4, image5, image6;
    @FXML
    ToggleGroup allBalls;
    @FXML
    RadioButton ball0, ball1, ball2, ball3, ball4, ball5, ball6;
    @FXML
    private MediaPlayer music;
    @FXML
    private Label label;
    @FXML
    private Label label1, label2, label3, label4, label5, label6;
    private ArrayList<RadioButton> buttonList;
    @FXML
    public void initialize(){
        music.setOnEndOfMedia(() -> music.seek(Duration.ZERO));
        music.play();
        ball0.getStyleClass().remove("radio-button"); ball0.getStyleClass().add("toggle-button");
        ball1.getStyleClass().remove("radio-button"); ball1.getStyleClass().add("toggle-button");
        ball2.getStyleClass().remove("radio-button"); ball2.getStyleClass().add("toggle-button");
        ball3.getStyleClass().remove("radio-button"); ball3.getStyleClass().add("toggle-button");
        ball4.getStyleClass().remove("radio-button"); ball4.getStyleClass().add("toggle-button");
        ball5.getStyleClass().remove("radio-button"); ball5.getStyleClass().add("toggle-button");
        ball6.getStyleClass().remove("radio-button"); ball6.getStyleClass().add("toggle-button");

        String style0=String.format("-fx-text-fill: %s;-fx-fill: %s;-fx-background-color: %s; -fx-border-color: white", "white", "white", "black");
        ball0.setStyle(style0); ball1.setStyle(style0); ball2.setStyle(style0); ball3.setStyle(style0);
        ball4.setStyle(style0); ball5.setStyle(style0); ball6.setStyle(style0);

        String style1=String.format("-fx-text-fill: %s;-fx-fill: %s;-fx-background-color: %s;", "white", "white", "grey");

        ball0.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){ ball0.setStyle(style1); }else{ ball0.setStyle(style0); } });
        ball1.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){ ball1.setStyle(style1); }else{ ball1.setStyle(style0); } });
        ball2.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){ ball2.setStyle(style1); }else{ ball2.setStyle(style0); } });
        ball3.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){ ball3.setStyle(style1); }else{ ball3.setStyle(style0); } });
        ball4.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){ ball4.setStyle(style1); }else{ ball4.setStyle(style0); } });
        ball5.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){ ball5.setStyle(style1); }else{ ball5.setStyle(style0); } });
        ball6.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){ ball6.setStyle(style1); }else{ ball6.setStyle(style0); } });

        buttonList = new ArrayList<>();
        buttonList.add(ball0); buttonList.add(ball1); buttonList.add(ball2); buttonList.add(ball3);
        buttonList.add(ball4); buttonList.add(ball5); buttonList.add(ball6);


        RotateTransition rt = new RotateTransition(Duration.seconds(3)); rt.setByAngle(360);
        rt.setCycleCount(RotateTransition.INDEFINITE); rt.setInterpolator(Interpolator.LINEAR); rt.setRate(1.2);
        RotateTransition rt1 = new RotateTransition(Duration.seconds(3)); rt1.setByAngle(360);
        rt1.setCycleCount(RotateTransition.INDEFINITE); rt1.setInterpolator(Interpolator.LINEAR); rt1.setRate(1.2);
        RotateTransition rt2 = new RotateTransition(Duration.seconds(3)); rt2.setByAngle(360);
        rt2.setCycleCount(RotateTransition.INDEFINITE); rt2.setInterpolator(Interpolator.LINEAR); rt2.setRate(1.2);
        RotateTransition rt3 = new RotateTransition(Duration.seconds(3)); rt3.setByAngle(360);
        rt3.setCycleCount(RotateTransition.INDEFINITE); rt3.setInterpolator(Interpolator.LINEAR); rt3.setRate(1.2);
        RotateTransition rt4 = new RotateTransition(Duration.seconds(3)); rt4.setByAngle(360);
        rt4.setCycleCount(RotateTransition.INDEFINITE); rt4.setInterpolator(Interpolator.LINEAR); rt4.setRate(1.2);
        RotateTransition rt5 = new RotateTransition(Duration.seconds(3)); rt5.setByAngle(360);
        rt5.setCycleCount(RotateTransition.INDEFINITE); rt5.setInterpolator(Interpolator.LINEAR); rt5.setRate(1.2);
        RotateTransition rt6 = new RotateTransition(Duration.seconds(3)); rt6.setByAngle(360);
        rt6.setCycleCount(RotateTransition.INDEFINITE); rt6.setInterpolator(Interpolator.LINEAR); rt6.setRate(1.2);

        ScaleTransition st = new ScaleTransition(Duration.seconds(3)); st.setToX(1.3); st.setToY(1.3);
        st.setRate(2); st.setCycleCount(ScaleTransition.INDEFINITE);st.setAutoReverse(true);
        ScaleTransition st1 = new ScaleTransition(Duration.seconds(3)); st1.setToX(1.3); st1.setToY(1.3);
        st1.setRate(2); st1.setCycleCount(ScaleTransition.INDEFINITE);st1.setAutoReverse(true);
        ScaleTransition st2 = new ScaleTransition(Duration.seconds(3)); st2.setToX(1.3); st2.setToY(1.3);
        st2.setRate(2); st2.setCycleCount(ScaleTransition.INDEFINITE);st2.setAutoReverse(true);
        ScaleTransition st3 = new ScaleTransition(Duration.seconds(3)); st3.setToX(1.3); st3.setToY(1.3);
        st3.setRate(2); st3.setCycleCount(ScaleTransition.INDEFINITE);st3.setAutoReverse(true);
        ScaleTransition st4 = new ScaleTransition(Duration.seconds(3)); st4.setToX(1.3); st4.setToY(1.3);
        st4.setRate(2); st4.setCycleCount(ScaleTransition.INDEFINITE);st4.setAutoReverse(true);
        ScaleTransition st5 = new ScaleTransition(Duration.seconds(3)); st5.setToX(1.3); st5.setToY(1.3);
        st5.setRate(2); st5.setCycleCount(ScaleTransition.INDEFINITE);st5.setAutoReverse(true);
        ScaleTransition st6 = new ScaleTransition(Duration.seconds(3)); st6.setToX(1.3); st6.setToY(1.3);
        st6.setRate(2); st6.setCycleCount(ScaleTransition.INDEFINITE);st6.setAutoReverse(true);

        ParallelTransition pt = new ParallelTransition(image0, rt, st); pt.play();
        ParallelTransition pt1 = new ParallelTransition(image1, rt1, st1); pt1.play();
        ParallelTransition pt2 = new ParallelTransition(image2, rt2, st2); pt2.play();
        ParallelTransition pt3 = new ParallelTransition(image3, rt3, st3); pt3.play();
        ParallelTransition pt4 = new ParallelTransition(image4, rt4, st4); pt4.play();
        ParallelTransition pt5 = new ParallelTransition(image5, rt5, st5); pt5.play();
        ParallelTransition pt6 = new ParallelTransition(image6, rt6, st6); pt6.play();

        label.setVisible(false);
        anchorPane.setMaxHeight(800);
        anchorPane.setMinHeight(800);

        if(common.currBall == 0) ball0.setSelected(true); if(common.currBall == 1) ball1.setSelected(true);
        if(common.currBall == 2) ball2.setSelected(true); if(common.currBall == 3) ball3.setSelected(true);
        if(common.currBall == 4) ball4.setSelected(true); if(common.currBall == 5) ball5.setSelected(true);
        if(common.currBall == 6) ball6.setSelected(true);

        for(int i=0;i<7;i++){
            if(common.availableBalls.get(i).isSold()){
                if(i==1) label1.setVisible(false);
                if(i==2) label2.setVisible(false);
                if(i==3) label3.setVisible(false);
                if(i==4) label4.setVisible(false);
                if(i==5) label5.setVisible(false);
                if(i==6) label6.setVisible(false);
            }
        }
    }

    public void press_done(ActionEvent event) throws IOException{
        for(int i=0;i<7;i++){
            if(buttonList.get(i).isSelected()){
                if(common.availableBalls.get(i).isSold()){
                    common.currBall = i;
                    System.out.println("ball " + i);
                    music.stop();
                    Scene HomePage = FXMLLoader.load(getClass().getResource("application.fxml"));
                    Main.gameStage.setScene(HomePage);
                }else if(common.availableBalls.get(i).getPrice() <= common.totalScore){
                    common.totalScore -= common.availableBalls.get(i).getPrice();
                    common.availableBalls.get(i).setSold(true);
                    common.currBall = i;
                    System.out.println("ball " + i);
                    music.stop();
                    Scene HomePage = FXMLLoader.load(getClass().getResource("application.fxml"));
                    Main.gameStage.setScene(HomePage);
                }else{
                    label.setVisible(true);
                }
            }
        }
    }

    public void press_back(ActionEvent event) throws IOException {
        music.stop();
        Scene HomePage = FXMLLoader.load(getClass().getResource("application.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}