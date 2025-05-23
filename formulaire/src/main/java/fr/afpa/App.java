package fr.afpa;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
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
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        buttonCopy.setPrefSize(100, 30);
        buttonDelete.setPrefSize(100, 30);
        buttonQuit.setPrefSize(100, 30);

        GridPane grid = new GridPane();

        // Ajout de contraintes pour avec les lignes équitablement dimensionnées
        RowConstraints rowConstraint = new RowConstraints();
        // Régler le fait que les ligne prennent 50% de l'espace disponible
        rowConstraint.setPercentHeight(50);
        // Ajout de la même 2 fois -> 1 par ligne
        grid.getRowConstraints().addAll(rowConstraint, rowConstraint);

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

        // WIP (Ludovic) : tentative de centrage du formulaire
        // idée : jouer vacec un "pane" container
        BorderPane mainContainer = new BorderPane(grid); 
        mainContainer.setCenter(grid);

        Scene scene = new Scene(mainContainer);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}