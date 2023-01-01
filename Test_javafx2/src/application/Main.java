package application;
	
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchor = new AnchorPane();
        anchor.setPrefHeight(626.4);
        anchor.setPrefWidth(799.2);
        
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
        
        Group linesGroup = new Group();

        Line line1 = new Line(30, 70, 330, 70);
        Line line2 = new Line(30, 100, 330, 100);
        Line line3 = new Line(30, 130, 330, 130);
        Line line4 = new Line(30, 160, 330, 160);
        Line line5 = new Line(30, 190, 330, 190);
        Line line6 = new Line(30, 220, 330, 220);
        Line line7 = new Line(30, 250, 330, 250);
        Line line8 = new Line(30, 280, 330, 280);
        Line line9 = new Line(30, 310, 330, 310);
        Line line10 = new Line(30, 340, 330, 340);
        Line line11 = new Line(30, 370, 330, 370);
        Line line12 = new Line(30, 400, 330, 400);
        Line line13 = new Line(30, 430, 330, 430);
        Line line14 = new Line(30, 460, 330, 460);
        Line line15 = new Line(30, 490, 330, 490);
        Line line16 = new Line(30, 520, 330, 520);
        
        linesGroup.getChildren().addAll(line1, line2,line3,line4, line5, line6, line7,line8,line9,line10,line11, line12, line13, line14, line15, line16 );
        
        
        anchor.getChildren().addAll(label, button1, button2, linesGroup);
        
       
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
