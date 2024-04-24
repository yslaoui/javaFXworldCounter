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

import java.util.Arrays;

public class webPageJavaFxApplication extends Application {
    int number_of_words = 0;
    int number_of_letters = 0;
    String longest_word = "";

    @Override
    public void start(Stage window) {

        HBox hbottombox = new HBox();
        hbottombox.setSpacing(20);
        hbottombox.getChildren().addAll(new Label("Letters: " + number_of_letters),
                new Label("Words: " + number_of_words),
                new Label("The longest word is: " + longest_word));

        TextArea textarea = new TextArea();
        textarea.textProperty().addListener((observable, oldValue, newValue) -> {
//            System.out.println(oldValue + "->" + newValue);
            String[] letters = newValue.split("");
            String[] words = newValue.split(" ");
//            for (String word: words) {
//                System.out.println(word);
//            }
            longest_word =  Arrays.stream(words).sorted((a, b) -> b.length() - a.length()).findFirst().get();
            if (newValue.length() == 0) {
                number_of_letters = 0;
                number_of_words = 0;
            }
            else {
                number_of_letters = letters.length;
                number_of_words = words.length;
            }

            System.out.println("new value is  " + newValue );
            System.out.println("number_of_words is: "   + number_of_words);
            System.out.println("number_of_letters is: " + number_of_letters);
            System.out.println("longest word is: " + longest_word);
            System.out.println("***************************");
            hbottombox.getChildren().setAll(new Label("letters: " + number_of_letters),
                    new Label("Words: " + number_of_words),
                    new Label("The longest word is: " + longest_word));
        });




        BorderPane border = new BorderPane();
        border.setCenter(textarea);
        border.setBottom(hbottombox);
        Scene scene = new Scene(border);
        window.setTitle("World counter by @cabrero");
        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch(webPageJavaFxApplication.class);
    }
}
