package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.effect.Blend;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Controller {

    private Stage stage;

    @FXML // ResourceBundle that was given to the FXMLLoader
            ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
            URL location;

    @FXML // fx:id="close"
            MenuItem close; // Value injected by FXMLLoader

    @FXML // fx:id="about"
            MenuItem about; // Value injected by FXMLLoader

    @FXML // fx:id="textfield"
    public TextField textfield; // Value injected by FXMLLoader

    @FXML // fx:id="anchorpane2"
            AnchorPane anchorpane2; // Value injected by FXMLLoader

    @FXML // fx:id="grid"
            GridPane grid; // Value injected by FXMLLoader

    @FXML // fx:id="clear"
            Button clear; // Value injected by FXMLLoader

    @FXML // fx:id="multiply"
            Button multiply; // Value injected by FXMLLoader

    @FXML // fx:id="backspace"
            Button backspace; // Value injected by FXMLLoader

    @FXML // fx:id="divide"
            Button divide; // Value injected by FXMLLoader

    @FXML // fx:id="num9"
            Button num9; // Value injected by FXMLLoader

    @FXML // fx:id="num2"
            Button num2; // Value injected by FXMLLoader

    @FXML // fx:id="num1"
            Button num1; // Value injected by FXMLLoader

    @FXML // fx:id="num5"
            Button num5; // Value injected by FXMLLoader

    @FXML // fx:id="num4"
            Button num4; // Value injected by FXMLLoader

    @FXML // fx:id="num8"
            Button num8; // Value injected by FXMLLoader

    @FXML // fx:id="num6"
            Button num6; // Value injected by FXMLLoader

    @FXML // fx:id="num3"
            Button num3; // Value injected by FXMLLoader

    @FXML // fx:id="subtract"
            Button subtract; // Value injected by FXMLLoader

    @FXML // fx:id="add"
            Button add; // Value injected by FXMLLoader

    @FXML // fx:id="point"
            Button point; // Value injected by FXMLLoader

    @FXML // fx:id="equal"
            Button equal; // Value injected by FXMLLoader

    @FXML // fx:id="num0"
            Button num0; // Value injected by FXMLLoader

    @FXML // fx:id="num7"
            Button num7; // Value injected by FXMLLoader


    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert close != null : "fx:id=\"close\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert about != null : "fx:id=\"about\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert textfield != null : "fx:id=\"textfield\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert multiply != null : "fx:id=\"multiply\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert clear != null : "fx:id=\"clear\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert backspace != null : "fx:id=\"backspace\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert divide != null : "fx:id=\"divide\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert num9 != null : "fx:id=\"num9\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert num2 != null : "fx:id=\"num2\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert num1 != null : "fx:id=\"num1\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert num5 != null : "fx:id=\"num5\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert num4 != null : "fx:id=\"num4\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert num8 != null : "fx:id=\"num8\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert num6 != null : "fx:id=\"num6\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert num3 != null : "fx:id=\"num3\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert subtract != null : "fx:id=\"subtract\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert add != null : "fx:id=\"add\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert point != null : "fx:id=\"point\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert equal != null : "fx:id=\"equal\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert num0 != null : "fx:id=\"num0\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert num7 != null : "fx:id=\"num7\" was not injected: check your FXML file 'mainUI.fxml'.";

        Button[] allButtons = new Button[]{num0, num1, num2, num3, num4, num5, num6, num7, num8, num9, point, add, subtract, multiply, divide, backspace, equal};

        //File->close
        close.setOnAction(actionEvent -> System.exit(0));

        //Easy to use when using keyboard
        equal.setDefaultButton(true);
        equal.setOnAction(e -> calculate());

        //when you click the '←' button
        backspace.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (textfield.getText().length() > 0) {
                textfield.deleteText(textfield.getText().length() - 1, textfield.getText().length());
            }
        });
        //when you click 'C' button
        clear.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> textfield.clear());

        //when you click '=' button
        equal.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> calculate());

        //when you click the remaining button
        for (Button btn : allButtons) {
            btn.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> btn.setEffect(new Glow(0.2)));
            btn.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> btn.setEffect(null));
            btn.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> btn.setEffect(new Blend()));
            btn.addEventHandler(MouseEvent.MOUSE_RELEASED, mouseEvent -> btn.setEffect(null));
            btn.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                if ((btn != equal) && (btn != backspace) && (btn != clear)) {
                    textfield.appendText(btn.getText());
                }
            });
        }

        //When you click about
        about.setOnAction(actionEvent -> {
            try {
                this.showAbout();
            } catch (java.lang.Exception e) {
                e.getStackTrace();
            }
        });


    }


    void setStage(Stage stage) {
        this.stage = stage;
    }

    //spawn a new stage owned by the previous one
    private void showAbout() throws Exception {
        Stage dialog = new Stage();
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("About.fxml"));
        Loader.setBuilderFactory(new JavaFXBuilderFactory());
        BorderPane root = Loader.load();
        dialog.setTitle("About Java calculator");
        Scene scene = new Scene(root, 240, 300);
        dialog.getIcons().add(new Image("/sample/icon.png"));
        dialog.setScene(scene);
        dialog.setResizable(false);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(stage);
        dialog.show();

    }

    private void calculate() {
        String expression = textfield.getText();
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try {
            textfield.setText(String.valueOf(engine.eval(expression)));
        } catch (ScriptException e) {
            textfield.setText("null");
        }
    }


}

