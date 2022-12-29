package application;

import java.util.List;
import java.util.Map;
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
	
	/*
	public boolean checkHorizontalPossible(int x, int y) {
		TODO();
		return true;
	}
	
	public boolean checkVerticalPossible(int x, int y) {
		TODO();
		return true;
	}
	
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
		    sb.append(Arrays.toString(row))
		      .append(lineSeparator);
		}

		String result = sb.toString();
		return result;
	}
}