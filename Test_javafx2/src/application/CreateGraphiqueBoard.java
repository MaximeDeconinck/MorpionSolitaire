package application;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

public class CreateGraphiqueBoard extends Application {
	   // Attributs de la classe
	   private List<Line> horizontalLines;
	   private List<Line> verticalLines;
	   private List<Circle> intersectionPoints;
	   private List<Canvas> intersectionCanvas;
	   private ChoiceBox<String> choiceBox;
	   private Group linesGroup;
	   private Group lineDraw;
	   private AnchorPane anchor;
	   private Canvas canvas;
	   private Label label;
	   private Button button1;
	   private Button button2;
	   private static Board board;
	   private int counter = 1;
	   private int valx = 12;
	   
	   
	
	   
	   // Constructeur de la classe
	   public CreateGraphiqueBoard() {
	      // Initialise les membres
		   
		 
		   
		   this.anchor = new AnchorPane();
	       this.anchor.setPrefHeight(650.68);
	       this.anchor.setPrefWidth(959.04);
	       
	       this.canvas = new Canvas(anchor.getPrefWidth(), anchor.getPrefHeight());
	       anchor.getChildren().add(canvas);
	       
	       this.label = new Label("");
	       this.label.setLayoutX((anchor.getPrefWidth() - label.getPrefWidth()) / 2);
	       this.label.setLayoutY(23);
	       this.label.setPrefHeight(0);
	       this.label.setPrefWidth(100);
	       
	       
	       Label title = new Label("Morpion Solitaire");
	       Font comicSans = Font.font("Georgia", 20);
	       title.setFont(comicSans);
	       title.setPrefWidth(959.04); // largeur de la fenêtre
	       title.setAlignment(Pos.TOP_CENTER);
	       title.setLayoutY(25);
	       
	       
	       anchor.getChildren().add(title);

	       this.button1 = new Button("Reset");
	       this.button1.setLayoutX(label.getLayoutX() + label.getPrefWidth() + 50);
	       this.button1.setLayoutY(150);
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
		   
		   
		   Button buttonValider = new Button("Valider");
		   buttonValider.setLayoutX(label.getLayoutX() + label.getPrefWidth() + 50);
		   buttonValider.setLayoutY(choiceBox.getLayoutY() + choiceBox.getPrefHeight() + 20); // +20 pour l'espacement
		   buttonValider.setMnemonicParsing(false);
		   buttonValider.setPrefHeight(25);
		   buttonValider.setPrefWidth(161);
		   
		   buttonValider.setOnAction(event -> {
			   String selectedValue = choiceBox.getValue();
			   System.out.println(selectedValue);
			   GameMechanics.setGameRule(selectedValue);
			});

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
	      
	      createScoresTable();
	      
	      LineIntersectionDrawer drawer = new LineIntersectionDrawer();
	      this.intersectionPoints = drawer.drawIntersections(horizontalLines, verticalLines);
	      
	      linesGroup.getChildren().addAll(horizontalLines);
	      linesGroup.getChildren().addAll(verticalLines);
	      linesGroup.getChildren().addAll(intersectionPoints);
	      
	      // Ajoutez les éléments à anchor ici
	      
	      setMouseEvent_cicle();
	
	     
	      this.anchor.getChildren().addAll(label, button1, button2, linesGroup ,lineDraw , choiceBox ,buttonValider);
	      
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
		   // Crée un événement qui se déclenche lorsque l'utilisateur clique sur le cercle
		   circle.setOnMouseClicked(event -> {
		   // Modifie l'opacité du cercle
		   circle.setOpacity(circle.getOpacity() == 0 ? 1 : 0);
           // Crée un canvas de la même taille et position que le cercle
           Canvas canvas = new Canvas(20, 20);
           
           if (counter >= 10) {
        	   valx = 15;
        	   }

           canvas.setLayoutX(circle.getCenterX() - valx);
           canvas.setLayoutY(circle.getCenterY() -5);

           // Dessine le nombre 1 sur le canvas
           canvas.getGraphicsContext2D().setFill(Color.WHITE);
           canvas.getGraphicsContext2D().setFont(new Font("Arial", 10));
           canvas.getGraphicsContext2D().fillText(Integer.toString(counter), circle.getRadius(), circle.getRadius());

           // Ajoute le canvas à l'anchor
           anchor.getChildren().add(canvas);
           counter++;
       });
   }
		   }}
	   
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
		        line.setStrokeWidth(50);
		        System.out.println(line);
		        lineDraw.getChildren().add(line);
		    }
		}
	   
	   public static void linkBoard(Board board1) { // ajoutez cette fonction à votre classe
		    board = board1;
		}
	   
	   private void createScoresTable() {
		    Map<Integer, List<Object>> scores = Score.getScores("score.txt");
		    TableView<Map.Entry<Integer, List<Object>>> table = new TableView<>();

		    TableColumn<Map.Entry<Integer, List<Object>>, String> numgameColumn = new TableColumn<>("Numéro de partie");
		    numgameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKey().toString()));

		    TableColumn<Map.Entry<Integer, List<Object>>, String> movesColumn = new TableColumn<>("Mouvements");
		    movesColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getValue().get(0).toString()));

		    ObservableList<Map.Entry<Integer, List<Object>>> data = FXCollections.observableArrayList(scores.entrySet());
		    table.setItems(data);
		    table.getColumns().addAll(numgameColumn, movesColumn);

		    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		    table.setMaxHeight(350);

		    this.anchor.getChildren().add(table);
		    AnchorPane.setTopAnchor(table, button2.getLayoutY() + button2.getPrefHeight() +30 );
		    AnchorPane.setLeftAnchor(table, label.getLayoutX() + 120);
		}

	}