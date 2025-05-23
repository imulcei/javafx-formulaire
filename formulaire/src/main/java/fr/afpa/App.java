package fr.afpa;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("JavaFx");

        Label labelUser = new Label("Entrée utilisateur");
        TextField textFieldUser = new TextField();

        Label labelCopy = new Label("Copie de l'entrée");
        TextField textFieldCopy = new TextField();
        textFieldCopy.setEditable(false);
        textFieldCopy.setDisable(false);

        textFieldUser.setPrefWidth(250);
        textFieldCopy.setPrefWidth(250);

        Button buttonCopy = new Button("Recopier");
        Button buttonDelete = new Button("Effacer");
        Button buttonQuit = new Button("Quitter");

        buttonCopy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String copiedText = textFieldUser.getText();
                textFieldCopy.setText(copiedText);
            }
        });

        buttonDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textFieldUser.clear();
                textFieldCopy.clear();
            }
        });

        buttonQuit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });

        VBox vbox = new VBox(buttonCopy, buttonDelete, buttonQuit);
        vbox.setSpacing(10);
        buttonCopy.setPrefSize(100, 30);
        buttonDelete.setPrefSize(100, 30);
        buttonQuit.setPrefSize(100, 30);

        GridPane grid = new GridPane();

        grid.setStyle("-fx-border-style: dotted;");

        grid.add(labelUser, 0, 0, 1, 1);
        grid.add(labelCopy, 0, 1, 1, 1);
        grid.add(textFieldUser, 1, 0, 1, 1);
        grid.add(textFieldCopy, 1, 1, 1, 1);
        grid.add(vbox, 2, 0, 1, 2);
        grid.setGridLinesVisible(true);

        GridPane.setValignment(labelCopy, VPos.CENTER);
        GridPane.setValignment(labelUser, VPos.CENTER);
        GridPane.setValignment(textFieldUser, VPos.CENTER);
        GridPane.setValignment(textFieldCopy, VPos.CENTER);
        GridPane.setValignment(vbox, VPos.CENTER);

        //grid.setAlignment(Pos.CENTER);
        grid.setHgap(30);

        Scene scene = new Scene(grid);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}