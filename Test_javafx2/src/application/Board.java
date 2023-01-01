package application;

import application.UtilFunctions;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class Board {
	public int size; // fixée à 16 dans le futur
    public String name;
    public ArrayList<ArrayList<Boolean>> grid;
    
    public Board(int size, String name) {
        this.size = size;
        this.name = name;
        ArrayList<ArrayList<Boolean>> grid1 = new ArrayList<>();
        for (int i = 0; i < this.size; i++) {
            ArrayList<Boolean> row = new ArrayList<>();
            for (int j = 0; j < this.size; j++) {
                row.add(false);
            }
            grid1.add(row);
        }
        this.grid = grid1;
    }
    
    public void initBoard() {
    	addPoint(3, 6);
    	addPoint(3, 7);
    	addPoint(3, 8);
    	addPoint(3, 9);
    	
    	addPoint(6, 3);
    	addPoint(6, 4);
    	addPoint(6, 5);
    	addPoint(6, 6);
    	addPoint(6, 9);
    	addPoint(6, 10);
    	addPoint(6, 11);
    	addPoint(6, 12);
    	
    	addPoint(9, 3);
    	addPoint(9, 4);
    	addPoint(9, 5);
    	addPoint(9, 6);
    	addPoint(9, 9);
    	addPoint(9, 10);
    	addPoint(9, 11);
    	addPoint(9, 12);
    	
    	addPoint(12, 6);
    	addPoint(12, 7);
    	addPoint(12, 8);
    	addPoint(12, 9);
    	
    	addPoint(4, 6);
    	addPoint(4, 9);
    	addPoint(5, 6);
    	addPoint(5, 9);
    	addPoint(7, 3);
    	addPoint(7, 12);
    	addPoint(8, 3);
    	addPoint(8, 12);
    	addPoint(10, 6);
    	addPoint(10, 9);
    	addPoint(11, 6);
    	addPoint(11, 9);
    }
    
    public void addPoint(int x, int y) {
    	grid.get(x).set(y, true);
    }
	
	public void printBoard() {
		for (ArrayList<Boolean> row : this.grid) {
			ArrayList<String> temp = new ArrayList<>();
			for (boolean value : row) {
				if (value) { 
					temp.add("o");
				} else {
					temp.add(".");
				}
			}
			System.out.println(temp);
		}
		System.out.println();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (ArrayList<Boolean> row : this.grid) {
		    sb.append(row);
		}

		String result = sb.toString();
		return result;
	}
}