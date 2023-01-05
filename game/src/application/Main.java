package application;	
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
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
		
		
		File file2 = new File("num_game.txt");
		if (!file2.exists()) {
		    file2.createNewFile();
		}
		
		File file1 = new File("score2.txt");
		if (!file1.exists()) {
		    file1.createNewFile();
		}
		
		//Point2D point = new Point2D(6.0, 7.0);
	    //Score.addPoint(1, point, "score2.txt");
	    //Score.incrementCounter("num_game.txt");
	    //System.out.println(Score.getCounter("num_game.txt"));
	    //Score.incrementCounter("score2.txt");
		
    	Application.launch(CreateGraphiqueBoard.class, args);  
    	
    }
}
