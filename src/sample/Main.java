package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static javafx.fxml.FXMLLoader.load;

public class Main extends Application {

    static Stage gameStage = new Stage();
    static boolean begin = true;

    @Override
    public void start(Stage primaryStage) throws Exception{
        gameStage.initStyle(StageStyle.UNDECORATED);
        gameStage.setMaxWidth(500);
        gameStage.setMaxHeight(800);
        Scene scene = load(getClass().getResource("sample.fxml"));
        gameStage.setTitle("Color Switch");
        gameStage.setScene(scene);
        gameStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
