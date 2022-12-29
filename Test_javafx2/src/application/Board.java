package application;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class Board {
	public int size;
	public String name;
	public String[][] grid;
	
	public Board(int size, String name)	{
		this.size = size;
		this.name = name;
		String[][] grid1 = new String[this.size][this.size];
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				grid1[i][j] = "F";
			}
		}
		this.grid = grid1;
	}
	
	public boolean checkHorizontalPossible(int x, int y) {
		if (y != 0) {
			if (y != this.size-1) {
				// Check si il y a un point a gauche ou a droite
				List<String> gd = new ArrayList<>();
				if (this.grid[x][y-1] == "T") { gd.add("left"); }
				if (this.grid[x][y+1] == "T") { gd.add("point"); }
				
				// LEFT TO DO
				
			}
			// On est sur un bord droite, on cherche donc vers la gauche si il y a des points
			for (int i = 1; i < 5; i++) {
				if (this.grid[x][y-i] == "F") { return false; }
			}
			return true;
		}
		// On est sur un bord gauche, on cherche donc vers la droite si il y a des points
		for (int i = 1; i < 5; i++) {
			if (this.grid[x][y+i] == "F") { return false; }
		}
		return true;
	}
	
	public boolean checkVerticalPossible(int x, int y) {
		if (x != 0) {
			if (x != this.size-1) {
				// Check si il y a un point en bas ou en haut
				List<String> gd = new ArrayList<>();
				if (this.grid[x-1][y] == "T") { gd.add("down"); }
				if (this.grid[x+1][y] == "T") { gd.add("up"); }
				
				// LEFT TO DO
				
			}
			// On est sur un bord haut, on cherche donc vers le bas si il y a des points
			for (int i = 1; i < 5; i++) {
				if (this.grid[x-i][y] == "F") { return false; }
			}
			return true;
		}
		// On est sur un bord bas, on cherche donc vers le haut si il y a des points
		for (int i = 1; i < 5; i++) {
			if (this.grid[x+i][y] == "F") { return false; }
		}
		return true;
	}
	
	/*
	public boolean checkLeftDiagPossible(int x, int y) {
		TODO();
		return true;
	}
	
	public boolean checkRightDiagPossible(int x, int y) {
		TODO();
		return true;
	}
	
	public boolean checkPossible(String x, String y) {
		TODO();
		return true;
	}
	*/
	
	@Override
	public String toString() {
		String lineSeparator = System.lineSeparator();
		StringBuilder sb = new StringBuilder();

		for (String[] row : this.grid) {
		    sb.append(Arrays.toString(row)).append(lineSeparator);
		}

		String result = sb.toString();
		return result;
	}
}