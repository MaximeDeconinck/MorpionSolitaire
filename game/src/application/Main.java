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
   
    public static void main(String[] args) throws IOException {
    	
    	Board tab = new Board(16, "Tableau de jeu");
        
		tab.initBoard();
		
		tab.printBoard();
		
		CreateGraphiqueBoard.linkBoard(tab);
		
    	Application.launch(CreateGraphiqueBoard.class, args);  
    	
    }
}
