package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchor = new AnchorPane();
        anchor.setPrefHeight(522);
        anchor.setPrefWidth(666);
        
        Label label = new Label("Morpion Solitaire");
        label.setLayoutX(281);
        label.setLayoutY(23);
        label.setPrefHeight(17);
        label.setPrefWidth(103);
        
        Button button1 = new Button("Refresh");
        button1.setLayoutX(469);
        button1.setLayoutY(118);
        button1.setMnemonicParsing(false);
        button1.setOnAction(event -> btnRefreshClicked());
        button1.setPrefHeight(25);
        button1.setPrefWidth(161);
        
        Button button2 = new Button("Recherche de solution");
        button2.setLayoutX(469);
        button2.setLayoutY(199);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(25);
        button2.setPrefWidth(161);
        
        anchor.getChildren().addAll(label, button1, button2);
        
        Scene scene = new Scene(anchor);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void btnRefreshClicked() {
        // Code exécuté lorsque le bouton "Refresh" est cliqué
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
