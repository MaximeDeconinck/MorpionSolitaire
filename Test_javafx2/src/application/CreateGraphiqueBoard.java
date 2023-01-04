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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

public class CreateGraphiqueBoard extends Application {
	   // Attributs de la classe
	   private List<Line> horizontalLines;
	   private List<Line> verticalLines;
	   private static List<Circle> intersectionPoints;

	   
       
	   private List<Canvas> Canvaslist;
	   private ChoiceBox<String> choiceBox;
	   private Group linesGroup;
	   private static Group lineDraw;
	   private AnchorPane anchor;
	   private Canvas canvas;
	   private Label label;
	   private Label label4;
	   private Button button1;
	   private Button button2;
	   private Button hintbutton;
	   private static Board board;
	   private int counter = 1;
	   private int valx = 12;
	   
	   
	
	   
	   // Constructeur de la classe
	   public CreateGraphiqueBoard() {
	      // Initialise les membres
		   
		   
		   /*Alert alert = new Alert(Alert.AlertType.WARNING);
		   alert.setTitle("Titre de la fenêtre");
		   alert.setHeaderText("Titre du message");
		   alert.setContentText("Contenu du message");
		   alert.showAndWait(); */
		   
		   Canvaslist = new ArrayList<>();
		   
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
	       
	       TextField textField = new TextField();
	       textField.setLayoutX(100); // Définissez la position du champ de texte sur l'axe x
	       textField.setLayoutY(30);
	       
	       Label label2 = new Label("Nom utilisateur :");
	       label2.setLayoutX(11);
	       label2.setLayoutY(32);
	       
	       Label label3 = new Label("Etat de la partie :");
	       label3.setLayoutX(160);
	       label3.setLayoutY(600);
	       label3.setFont(new Font(17));
	        
	       this.label4 = new Label("EN COURS");
	       this.label4.setLayoutX(295);
	       this.label4.setLayoutY(597);
	       this.label4.setFont(new Font(22));
	       this.label4.setTextFill(Color.GREEN);
	       
	       Rectangle rect = new Rectangle(155, 590, 250, 40);
	       rect.setArcWidth(10);
	       rect.setArcHeight(10);
	       rect.setStroke(Color.GREY);
	       rect.setStrokeWidth(2);
	       rect.setFill(Color.TRANSPARENT);
	       
	       

	       
	       
	       Label title = new Label("Morpion Solitaire");
	       Font comicSans = Font.font("Georgia", 20);
	       title.setFont(comicSans);
	       title.setPrefWidth(959.04); // largeur de la fenï¿½tre
	       title.setAlignment(Pos.TOP_CENTER);
	       title.setLayoutY(15);
	       
	       
	       
	       anchor.getChildren().add(title);
	       
	       

	       this.button1 = new Button("Reset");
	       this.button1.setLayoutX(label.getLayoutX() + label.getPrefWidth() + 50);
	       this.button1.setLayoutY(150);
	       this.button1.setMnemonicParsing(false);
	       this.button1.setOnAction(event -> btnRefreshClicked());
	       this.button1.setPrefHeight(25);
	       this.button1.setPrefWidth(161);
	       
	       this.hintbutton = new Button("Hint");
	       this.hintbutton.setOnAction(event -> giveHint());
	       this.hintbutton.setLayoutX(button1.getLayoutX());
	       this.hintbutton.setLayoutY(180);
	       this.hintbutton.setMnemonicParsing(false);
	       this.hintbutton.setPrefHeight(25);
	       this.hintbutton.setPrefWidth(161);
	       
	       ObservableList<String> options = FXCollections.observableArrayList("5D", "5T");
		   choiceBox = new ChoiceBox<>(options);
		   choiceBox.setValue("5D"); // dï¿½finit la valeur par dï¿½faut
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
			   btnRefreshClicked();
			   String selectedValue = choiceBox.getValue();
			   GameMechanics.setGameRule(selectedValue);
			});

	       this.button2 = new Button("Recherche de solution");
	       this.button2.setLayoutX(label.getLayoutX() + label.getPrefWidth() + 50);
	       this.button2.setLayoutY(210);
	       this.button2.setMnemonicParsing(false);
	       this.button2.setPrefHeight(25);
	       this.button2.setPrefWidth(161);
	       
	       this.button2.setOnAction(event -> searchSolution());

	
	      
	      // Crï¿½er les lignes horizontal et vertical
	      
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
	      
	      // Ajoutez les ï¿½lï¿½ments ï¿½ anchor ici
	      
	      setMouseEvent_cicle();
	
	     
	      this.anchor.getChildren().addAll(label, button1, button2, linesGroup ,lineDraw , choiceBox ,buttonValider ,hintbutton, textField, label2, label3, label4, rect);
	      
	      // Crï¿½ez la scï¿½ne et affichez la fenï¿½tre ici
	        
	   }
	   
	   @Override
	    public void start(Stage primaryStage) {
		   Scene scene = new Scene(anchor);
	       primaryStage.setScene(scene);
	       primaryStage.show();
	   }
	   
	   // Mï¿½thode pour crï¿½er les lignes horizontal
	   public List<Line> createHorizontalLines() {
		    List<Line> myHorizontalLines = new ArrayList<>();
		    for (int i = 0; i <= 17; i++) {
		        myHorizontalLines.add(new Line(30, 70 + (i * 30), 540, 70 + (i * 30)));
		    }
		    myHorizontalLines.remove(0);
		    myHorizontalLines.remove(myHorizontalLines.size() - 1);
		    return myHorizontalLines;
		}
	   
	   // Mï¿½thode pour crï¿½er les lignes vertical
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
				if(!containsPoint2D(LineIntersectionDrawer.Point_depart(), point)) {
					// Crée un événement qui se déclenche lorsque l'utilisateur clique sur le cercle
					circle.setOnMouseClicked(event -> {
						// Appelle la fonction playMove
						if (GameMechanics.playMove((int)point.getX(), (int)point.getY(), board)) {
							// Modifie l'opacité du cercle
							
							if( hintPoints.contains(point)) {
								circle.setOpacity(0);
							}
							
							hintPoints.remove(point);
							resetHintCircles();
							hintPoints.clear();
							
							circle.setOpacity(circle.getOpacity() == 0 ? 1 : 0);
							// Crée un canvas de la même taille et position que le cercle
							Canvas canvas = new Canvas(20, 20);
							if (counter >= 10) {
								valx = 15;
							}
							canvas.setLayoutX(circle.getCenterX() - valx);
							canvas.setLayoutY(circle.getCenterY() - 5);

							// Dessine le nombre 1 sur le canvas
							canvas.getGraphicsContext2D().setFill(Color.WHITE);
							canvas.getGraphicsContext2D().setFont(new Font("Arial", 10));
							canvas.getGraphicsContext2D().fillText(Integer.toString(counter), circle.getRadius(), circle.getRadius());

							// Ajoute le canvas à l'anchor
							anchor.getChildren().add(canvas);

							counter++;
							Canvaslist.add(canvas);
						    isItTheEnd();
							
							
						}
							// Réinitialise l'opacité des cercles dans hintPoints et vide la liste
							
					});
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
		// Supprime tous les canvas de l'anchor
		   for (Canvas c : Canvaslist) {
		       anchor.getChildren().remove(c);
		   }
		   // Vide la liste de canvas
		   Canvaslist.clear();
		   counter = 1;
		   hintPoints.clear();
		   
		   label4.setText("EN COURS");
		   this.label4.setTextFill(Color.GREEN);
	   }


	   

	   
	   public static void drawLine(double x1, double y1, double x2, double y2) {
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
		        
		        // Si la ligne est horizontale
		        if (x1 == x2) {
		            line.setStartX(c1.getCenterX() + 10);
		            line.setEndX(c2.getCenterX() - 10);
		            line.setStartY(c1.getCenterY());
			        line.setEndY(c2.getCenterY());
		            
		        }
		        // Si la ligne est verticale
		        else if (y1 == y2) {
		      
		            line.setStartX(c1.getCenterX());
		            line.setEndX(c2.getCenterX());
		            
		            line.setStartY(c1.getCenterY() + 10);
			        line.setEndY(c2.getCenterY() - 10);
		         
		        }
		        // Si la ligne est diagonale
		        else {
		        	// en haut à droite 
		        	if (x1 > x2 && y1 < y2) {
		        		line.setStartX(c1.getCenterX() - 5);
		        		line.setEndX(c2.getCenterX() + 5);   
			            line.setStartY(c1.getCenterY() + 5);
				        line.setEndY(c2.getCenterY() - 5);
			        }
			        // Cas où c1 est en bas à droite de c2
			        else if (x1 > x2 && y1 > y2) {
			            line.setStartX(c1.getCenterX() + 5);
			            line.setEndX(c2.getCenterX() - 5);
			            
			            line.setStartY(c1.getCenterY() + 5);
				        line.setEndY(c2.getCenterY() - 5);
			        }
			        // Cas où c1 est en haut à gauche de c2
			        else if (x1 < x2 && y1 < y2) {
			            line.setStartX(c1.getCenterX() + 5);
			            line.setEndX(c2.getCenterX() - 5);
			            
			            line.setStartY(c1.getCenterY() + 5);
				        line.setEndY(c2.getCenterY() - 5);
			        }
			        // Cas où c1 est en bas à gauche de c2
			        else if (x1 < x2 && y1 > y2) {
			            line.setStartX(c1.getCenterX() - 5);
			            line.setEndX(c2.getCenterX() + 5);
			            
			            line.setStartY(c1.getCenterY() + 5);
				        line.setEndY(c2.getCenterY() - 5);
			        }

		           
		        }
		        
		       
		        line.setStroke(Color.BLUE);
		        line.setStrokeWidth(3);
		        System.out.println(line);
		        lineDraw.getChildren().add(line);
		    }
		}

	   
	   public static void linkBoard(Board board1) { 
		    board = board1;
		}
	   
	   private void createScoresTable() {
		    Map<Integer, List<Object>> scores = Score.getScores("score.txt");
		    TableView<Map.Entry<Integer, List<Object>>> table = new TableView<>();

		    TableColumn<Map.Entry<Integer, List<Object>>, String> numgameColumn = new TableColumn<>("Numï¿½ro de partie");
		    numgameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKey().toString()));

		    TableColumn<Map.Entry<Integer, List<Object>>, String> movesColumn = new TableColumn<>("Mouvements");
		    movesColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getValue().get(0).toString()));

		    ObservableList<Map.Entry<Integer, List<Object>>> data = FXCollections.observableArrayList(scores.entrySet());
		    data.sort((entry1, entry2) -> ((Integer)entry2.getValue().get(0)).compareTo((Integer)entry1.getValue().get(0)));
		    table.setItems(data);
		    table.getColumns().addAll(numgameColumn, movesColumn);

		    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		    table.setMaxHeight(350);

		    this.anchor.getChildren().add(table);
		    AnchorPane.setTopAnchor(table, button2.getLayoutY() + button2.getPrefHeight() +30 );
		    AnchorPane.setLeftAnchor(table, label.getLayoutX() + 120);
		}
	   
	   private boolean containsPoint2D(List<Point2D> list, Point2D point) {
		    for (Point2D p : list) {
		        if (p.getX() == point.getX() && p.getY() == point.getY()) {
		            return true;
		        }
		    }
		    return false;
		}
       
	   

	   private List<Point2D> hintPoints = new ArrayList<>();

	   private void giveHint() {
	   ArrayList<Point> playableMoves = GameMechanics.playableMoves(board);
	   for (Circle circle : intersectionPoints) {
	   Point2D point = (Point2D)circle.getUserData();
	   for (Point p : playableMoves) {
	   if (point.getX() == p.x && point.getY() == p.y) {
	   circle.setOpacity(0.5);
	   hintPoints.add(point);
	   }
	   }
	   }
	   }
	   
	   private void resetHintCircles() {
		    for (Point2D hintPoint : hintPoints) {
		        for (Circle circle : intersectionPoints) {
		            Point2D point = (Point2D)circle.getUserData();
		            if (point.equals(hintPoint)) {
		                circle.setOpacity(0);
		            }
		        }
		    }
		}
	   
	   
	   private void isItTheEnd() {
		   if (GameMechanics.isGameOver(board)) {
			   label4.setText("TERMINÉ");
			   label4.setTextFill(Color.web("#3EC0F5"));
		   	}
		 }
	   
	   private void searchSolution() {
		    btnRefreshClicked();
		    while (!GameMechanics.isGameOver(board)) {
		        // Récupère la liste des mouvements possibles
		        ArrayList<Point> playableMoves = GameMechanics.playableMoves(board);
		        // Choisit un mouvement au hasard
		        Point randomMove = playableMoves.get((int) (Math.random() * playableMoves.size()));
		        // Récupère le cercle correspondant au mouvement
		        Circle targetCircle = null;
		        for (Circle circle : intersectionPoints) {
		            Point2D data = (Point2D) circle.getUserData();
		            if (data.getX() == randomMove.x && data.getY() == randomMove.y) {
		                targetCircle = circle;
		                break;
		            }
		        }
		        // Simule un clic sur le cercle
		       
		        targetCircle.fireEvent(new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, MouseButton.PRIMARY, 1, true, true, true, true, true, true, true, true, true, true, null));
		       
		    
		    }
		}


	}