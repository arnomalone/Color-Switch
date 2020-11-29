package View;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewManger {
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 800;

    public ViewManger(){
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createButton();
    }
    public Stage getMainStage(){
        return mainStage;
    }

    private void createButton(){
        Button button = new Button();
        button.setLayoutX(100);
        button.setLayoutY(100);
        mainPane.getChildren().add(button);

        button.setOnMouseEntered((EventHandler<Event>) event -> System.out.println("mouse is clicked."));
    }
}
