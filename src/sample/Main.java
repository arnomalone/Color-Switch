package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.fxml.FXMLLoader.load;

public class Main extends Application {

    static Stage gameStage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Color Switch");
//        primaryStage.setScene(new Scene(root, 500, 800));
//        primaryStage.show();
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
