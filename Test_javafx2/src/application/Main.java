package application;
	
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Point2D;
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
        anchor.setPrefHeight(650.68);
        anchor.setPrefWidth(959.04);
        
        Label label = new Label("Morpion Solitaire");
        label.setLayoutX((anchor.getPrefWidth() - label.getPrefWidth()) / 2);
        label.setLayoutY(23);
        label.setPrefHeight(17);
        label.setPrefWidth(103);

        Button button1 = new Button("Refresh");
        button1.setLayoutX(label.getLayoutX() + label.getPrefWidth() + 50);
        button1.setLayoutY(118);
        button1.setMnemonicParsing(false);
        button1.setOnAction(event -> btnRefreshClicked());
        button1.setPrefHeight(25);
        button1.setPrefWidth(161);

        Button button2 = new Button("Recherche de solution");
        button2.setLayoutX(label.getLayoutX() + label.getPrefWidth() + 50);
        button2.setLayoutY(199);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(25);
        button2.setPrefWidth(161);
        
        Group linesGroup = new Group();
        
        List<Line> horizontalLines = new ArrayList<>();
        List<Line> verticalLines = new ArrayList<>();
        
        
        for (int i = 0; i <= 17; i++) {
            horizontalLines.add(new Line(30, 70 + (i * 30), 480, 70 + (i * 30)));
        }
        linesGroup.getChildren().addAll(horizontalLines);
        
        
        verticalLines.add(new Line(30, 70, 30, 520));
        for (int i = 0; i <= 15; i++) {
            verticalLines.add(new Line(30 + (i * 30), 70, 30 + (i * 30), 520));
        }
        
        linesGroup.getChildren().addAll(verticalLines);
        
        
        
        LineIntersectionFinder finder = new LineIntersectionFinder();
        
       
      
        List<Point2D> intersectionCoordinates = finder.getIntersectionCoordinates(horizontalLines, verticalLines);
        
        System.out.println(intersectionCoordinates);
        for (Point2D intersection : intersectionCoordinates) {
        	
            double x = intersection.getX();
            double y = intersection.getY();
            System.out.println("Coordonnées de l'intersection: (" + x + ", " + y + ")");
            
        }
        
        
        
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
