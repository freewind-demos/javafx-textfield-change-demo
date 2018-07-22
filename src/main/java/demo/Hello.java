package demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Hello extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Change Listener");
        VBox root = new VBox() {{
            TextField field = new TextField();
            getChildren().add(field);
            getChildren().add(new Label() {{
                field.textProperty().addListener((observable, oldValue, newValue) -> {
                    String oldText = this.getText();
                    this.setText(oldText + "ChangeListener: " + oldValue + " -> " + newValue + "\n");
                });
            }});
        }};
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}