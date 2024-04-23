package webPage;

import gridPane.GridPaneJavaFXapplication;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class webPageJavaFxApplication extends Application {
    @Override
    public void start(Stage window) {
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.getChildren().addAll(new Button("First"), new Button("Second"), new Button("Third"));

        VBox vbox = new VBox();
        vbox.setSpacing(50);
        vbox.getChildren().addAll(new Label("First"), new Label("Second"), new Label("Third"));

        TextArea textarea = new TextArea();

        BorderPane border = new BorderPane();
        border.setTop(hbox);
        border.setLeft(vbox);
        border.setCenter(textarea);
        Scene scene = new Scene(border);
        window.setTitle("Web Page");
        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch(webPageJavaFxApplication.class);
    }
}
