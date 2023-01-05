package application;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	    
	    FileOutputStream fos = new FileOutputStream(textFile, false);
	    fos.write(sb.toString().getBytes());
	    fos.close();
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
	
	public static Map<Integer, List<Object>> getScores(String textFile) {
	    Map<Integer, List<Object>> scores = new HashMap<>();
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader(textFile));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] parts = line.split(", ");
	            int numGame = Integer.parseInt(parts[0].split(": ")[1]);
	            int moves = Integer.parseInt(parts[1].split(": ")[1]);
	            String coordinates = "";
	            for (int i = 2; i < parts.length; i++) {
	                coordinates += parts[i] + " ";
	            }
	            List<Object> score = new ArrayList<>();
	            score.add(moves);
	            score.add(coordinates);
	            scores.put(numGame, score);
	        }
	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return scores;
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
	
	public static void incrementCounter(String textFile) {
	    try {
	        // Lire le fichier texte
	        BufferedReader reader = new BufferedReader(new FileReader(textFile));
	        String line;
	        int counter = 0;
	        StringBuilder sb = new StringBuilder();
	        while ((line = reader.readLine()) != null) {
	            if (line.startsWith("Counter: ")) {
	                // Incrémenter le compteur
	                counter = Integer.parseInt(line.split(": ")[1]) + 1;
	                // Remplacer la ligne du compteur par la nouvelle valeur
	                line = "Counter: " + counter;
	            }
	            sb.append(line).append("\n");
	        }
	        reader.close();

	        // Écrire les données modifiées dans le fichier
	        BufferedWriter bw = new BufferedWriter(new FileWriter(textFile, false));
	        bw.write(sb.toString());
	        bw.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public static int getCounter(String textFile) {
	    int counter = 0;
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader(textFile));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            if (line.startsWith("Counter: ")) {
	                counter = Integer.parseInt(line.split(": ")[1]);
	                break;
	            }
	        }
	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return counter;
	}
	
	

}
