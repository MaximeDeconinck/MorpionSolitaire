package application;	
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Main {

  /*	
    @Override
    public void start(Stage primaryStage) throws Exception { */
        /*AnchorPane anchor = new AnchorPane();
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
        button2.setPrefWidth(161); */
        
        //Group linesGroup = new Group();
        /*
        List<Line> horizontalLines = new ArrayList<>();
        List<Line> verticalLines = new ArrayList<>();
        
        
        for (int i = 0; i <= 17; i++) {
            horizontalLines.add(new Line(30, 70 + (i * 30), 540, 70 + (i * 30)));
        }
        
        horizontalLines.remove(0);
        horizontalLines.remove(horizontalLines.size() - 1);
        linesGroup.getChildren().addAll(horizontalLines);
     
        for (int i = 0; i <= 17; i++) {
            verticalLines.add(new Line(30 + (i * 30), 70, 30 + (i * 30), 580));
        }
        
        verticalLines.remove(0);
        verticalLines.remove(verticalLines.size() - 1); 
        linesGroup.getChildren().addAll(verticalLines); */
        
        
        
       /* LineIntersectionFinder finder = new LineIntersectionFinder();  
        List<Point2D> intersectionCoordinates = finder.getIntersectionCoordinates(horizontalLines, verticalLines); */
        
        // retourne les corrdonées des intersections.
        
        /*
        System.out.println(intersectionCoordinates);
        for (Point2D intersection : intersectionCoordinates) {
        	
            double x = intersection.getX();
            double y = intersection.getY();
            System.out.println("Coordonnées de l'intersection: (" + x + ", " + y + ")");
            
        }
        */
        
        /*
        Group checkBoxGroup = new Group();
        
        List<CheckBox> intersectionCheckBoxes = finder.getIntersectionCheckBoxes(intersectionCoordinates);
        checkBoxGroup.getChildren().addAll(intersectionCheckBoxes);  */
        
        
        
        
        /*LineIntersectionDrawer drawer = new LineIntersectionDrawer();
        List<Circle> intersectionPoints = drawer.drawIntersections(horizontalLines, verticalLines); */
        
        
        //linesGroup.getChildren().addAll(intersectionPoints);
        
        /*
        // affiche les id des cicles
        for (Circle intersectionPoint : intersectionPoints) {
        	Point2D coordinate = (Point2D) intersectionPoint.getUserData();
        	System.out.println(coordinate);
        	}
        
        */
        // crée l'evenement de clique
        /*for (Circle circle : intersectionPoints) {
            circle.setOnMouseClicked(event -> circle.setOpacity(circle.getOpacity() == 0 ? 1 : 0));
        } */
        
       
        /*
        anchor.getChildren().addAll(label, button1, button2, linesGroup );
        
       
        Scene scene = new Scene(anchor);
        primaryStage.setScene(scene);
        primaryStage.show();
        */
        
     
    	

  


   //}
    
 
    
    public static void main(String[] args) throws IOException {
    	
    	
    	Board tab = new Board(16, "Tableau de jeu");
        /*
		tab.initBoard();
		tab.addPoint(1, 4);
		tab.addPoint(2, 3);
		tab.addPoint(3, 2);
		tab.addPoint(4, 1);
		
		tab.printBoard();
		
		
		
        */
		CreateGraphiqueBoard.linkBoard(tab);
    	Application.launch(CreateGraphiqueBoard.class, args);  
    	
    	
    	//Point2D point = new Point2D(5, 9);
    	//Score.addPoint(3, point, "score.txt");
		
    	Score.readFile("score.txt");
    	
    	


        
   
    	
    	
    }
}
