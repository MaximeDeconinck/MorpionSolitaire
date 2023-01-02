package application;
import javafx.application.Application;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

public class CreateGraphiqueBoard extends Application {
	   // Attributs de la classe
	   private List<Line> horizontalLines;
	   private List<Line> verticalLines;
	   private List<Circle> intersectionPoints;
	   private ChoiceBox<String> choiceBox;
	   private Group linesGroup;
	   private Group lineDraw;
	   private AnchorPane anchor;
	   private Label label;
	   private Button button1;
	   private Button button2;
	   private static Board board;
	   
	   
	
	   
	   // Constructeur de la classe
	   public CreateGraphiqueBoard() {
	      // Initialise les membres
		   
		 
		   
		   this.anchor = new AnchorPane();
	       this.anchor.setPrefHeight(650.68);
	       this.anchor.setPrefWidth(959.04);
	       
	       this.label = new Label("Morpion Solitaire");
	       this.label.setLayoutX((anchor.getPrefWidth() - label.getPrefWidth()) / 2);
	       
	       this.label.setLayoutY(23);
	       this.label.setPrefHeight(17);
	       this.label.setPrefWidth(103);
	       
	       
	   

	       this.button1 = new Button("Reset");
	       this.button1.setLayoutX(label.getLayoutX() + label.getPrefWidth() + 50);
	       this.button1.setLayoutY(118);
	       this.button1.setMnemonicParsing(false);
	       this.button1.setOnAction(event -> btnRefreshClicked());
	       this.button1.setPrefHeight(25);
	       this.button1.setPrefWidth(161);
	       
	       ObservableList<String> options = FXCollections.observableArrayList("5D", "5T");
		   choiceBox = new ChoiceBox<>(options);
		   choiceBox.setValue("5D"); // définit la valeur par défaut
		   choiceBox.setLayoutX(label.getLayoutX() + label.getPrefWidth() + 50);
		   choiceBox.setLayoutY(70);
		   choiceBox.setPrefHeight(button1.getPrefHeight());
		   choiceBox.setPrefWidth(button1.getPrefWidth());

	       this.button2 = new Button("Recherche de solution");
	       this.button2.setLayoutX(label.getLayoutX() + label.getPrefWidth() + 50);
	       this.button2.setLayoutY(199);
	       this.button2.setMnemonicParsing(false);
	       this.button2.setPrefHeight(25);
	       this.button2.setPrefWidth(161);

	
	      
	      // Créer les lignes horizontal et vertical
	      
	      this.horizontalLines = createHorizontalLines();
	      this.verticalLines = createVerticalLines();
	      this.linesGroup = new Group();
	      this.lineDraw = new Group();
	      
	      
	      
	      LineIntersectionDrawer drawer = new LineIntersectionDrawer();
	      this.intersectionPoints = drawer.drawIntersections(horizontalLines, verticalLines);
	      
	      linesGroup.getChildren().addAll(horizontalLines);
	      linesGroup.getChildren().addAll(verticalLines);
	      linesGroup.getChildren().addAll(intersectionPoints);
	      
	      // Ajoutez les éléments à anchor ici
	      
	      setMouseEvent_cicle();
	      drawLine(1, 1, 4, 4 );
	     
	      this.anchor.getChildren().addAll(label, button1, button2, linesGroup ,lineDraw , choiceBox);
	      
	      // Créez la scène et affichez la fenêtre ici
	        
	   }
	   
	   @Override
	    public void start(Stage primaryStage) {
		   Scene scene = new Scene(anchor);
	       primaryStage.setScene(scene);
	       primaryStage.show();
	   }
	   
	   // Méthode pour créer les lignes horizontal
	   public List<Line> createHorizontalLines() {
		    List<Line> myHorizontalLines = new ArrayList<>();
		    for (int i = 0; i <= 17; i++) {
		        myHorizontalLines.add(new Line(30, 70 + (i * 30), 540, 70 + (i * 30)));
		    }
		    myHorizontalLines.remove(0);
		    myHorizontalLines.remove(myHorizontalLines.size() - 1);
		    return myHorizontalLines;
		}
	   
	   // Méthode pour créer les lignes vertical
	   private List<Line> createVerticalLines() {
		   
		   List<Line> myVerticalLines = new ArrayList<>();
		   for (int i = 0; i <= 17; i++) {
			   myVerticalLines.add(new Line(30 + (i * 30), 70, 30 + (i * 30), 580));
	        }
	        
		   myVerticalLines.remove(0);
		   myVerticalLines.remove(myVerticalLines.size() - 1); 
	       return myVerticalLines;
	   }
	   
	   
	   private void setMouseEvent_cicle() {
		   for (Circle circle : intersectionPoints) {
		        Point2D point = (Point2D)circle.getUserData();
		        if(!LineIntersectionDrawer.Point_depart().contains(point)) {
		            circle.setOnMouseClicked(event -> circle.setOpacity(circle.getOpacity() == 0 ? 1 : 0));
		        }
		   }
		}
	   
	   private void btnRefreshClicked() {
		    for (Circle circle : intersectionPoints) {
		        Point2D data = (Point2D) circle.getUserData();
		        if (!LineIntersectionDrawer.Point_depart().contains(data)) {
		            circle.setOpacity(0);
		        }
		    }
		    lineDraw.getChildren().clear();
		    GameMechanics.reset(board);
		    board.printBoard();
		
		}

	   
	   private void drawLine(double x1, double y1, double x2, double y2) {
		    Circle c1 = null;
		    Circle c2 = null;
		    for (Circle circle : intersectionPoints) {
		        Point2D data = (Point2D) circle.getUserData();
		        if (data.getX() == x1 && data.getY() == y1) {
		            c1 = circle;
		          
		        }
		        if (data.getX() == x2 && data.getY() == y2) {
		            c2 = circle;
		            
		        }
		    }
		    if (c1 != null && c2 != null) {
		        Line line = new Line();
		        
		        line.setStartX(c1.getCenterX());
		        line.setStartY(c1.getCenterY());
		        line.setEndX(c2.getCenterX());
		        line.setEndY(c2.getCenterY());
		        line.setStroke(Color.BLUE);
		        line.setStrokeWidth(5);
		        System.out.println(line);
		        lineDraw.getChildren().add(line);
		    }
		}
	   
	   public static void linkBoard(Board board1) { // ajoutez cette fonction à votre classe
		    board = board1;
		}

	}