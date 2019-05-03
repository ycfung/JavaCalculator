package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.fxml.JavaFXBuilderFactory;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("Running");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainUI.fxml"));
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        BorderPane root = fxmlLoader.load();
        Controller controller = fxmlLoader.getController();
        controller.setStage(primaryStage);
        primaryStage.setTitle("Java Calculator");
        Scene scene = new Scene(root, 320, 400);
        primaryStage.getIcons().add(new Image("/sample/icon.png"));
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

        //Handle keyboard input
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ESCAPE) {
                controller.textfield.clear();
            } else if (keyEvent.getCode() == KeyCode.BACK_SPACE && controller.textfield.getText().length() > 0) {
                controller.textfield.deleteText(controller.textfield.getText().length() - 1, controller.textfield.getText().length());
            } else if (keyEvent.getText().length() > 0 && "+-*/.1234567890".contains(keyEvent.getText().substring(keyEvent.getText().length() - 1))) {
                controller.textfield.appendText(keyEvent.getText().substring(keyEvent.getText().length() - 1));
            }
        });


        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }


}
