/* This file has no use currently */
package sample;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class AboutController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="imageview"
    private ImageView imageview; // Value injected by FXMLLoader

    @FXML // fx:id="text"
    private Text text; // Value injected by FXMLLoader

    @FXML // fx:id="textarea"
    private TextArea textarea; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert imageview != null : "fx:id=\"imageview\" was not injected: check your FXML file 'About.fxml'.";
        assert text != null : "fx:id=\"text\" was not injected: check your FXML file 'About.fxml'.";
        assert textarea != null : "fx:id=\"textarea\" was not injected: check your FXML file 'About.fxml'.";

    }
}
