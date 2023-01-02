package application;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point2D;

public class Score {
	
	public static void addPoint(int numGame, Point2D point, String textFile) {
	    try {
	        String pointString = "(" + point.getX() + "," + point.getY() + ")";
	        BufferedReader reader = new BufferedReader(new FileReader(textFile));
	        String line;
	        boolean found = false;
	        StringBuilder sb = new StringBuilder();
	        while ((line = reader.readLine()) != null) {
	            if (line.startsWith("numgame: " + numGame)) {
	                String[] parts = line.split(", ");
	                int moves = Integer.parseInt(parts[1].split(": ")[1]) + 1;
	                line = parts[0] + ", moves: " + moves + ", " + parts[2] + " " + pointString;
	               
	                found = true;
	            }
	            sb.append(line).append("\n");
	        }
	        reader.close();
	        
	        if (!found) {
	            String newLine = "numgame: " + numGame + ", moves: 1, " + pointString;
	            sb.append(newLine).append("\n");
	        }
	        
	        BufferedWriter bw = new BufferedWriter(new FileWriter(textFile, false));
	        bw.write(sb.toString());
	        bw.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void readFile(String textFile) {
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader(textFile));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] parts = line.split(", ");
	            System.out.print(parts[0] + ", " + parts[1] + ", ");
	            for (int i = 2; i < parts.length; i++) {
	                System.out.print(parts[i] + " ");
	            }
	            System.out.println();
	        }
	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void clear(String textFile) {
	    try {
	        BufferedWriter bw = new BufferedWriter(new FileWriter(textFile, false));
	        bw.write("");
	        bw.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	
	

}
