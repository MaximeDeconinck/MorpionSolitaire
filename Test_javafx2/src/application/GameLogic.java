package application;

import application.Board;
import javafx.util.Pair;

public class GameLogic {
	
	public static void main(String[] args) {
		Board tab = new Board(7, "Tableau de jeu");
		
		// System.out.println(tab);
		tab.grid[0][1] = "T";
		tab.grid[0][2] = "T";
		tab.grid[0][3] = "T";
		tab.grid[0][4] = "T";
		tab.grid[1][6] = "T";
		tab.grid[2][6] = "T";
		tab.grid[3][6] = "T";
		tab.grid[4][6] = "T";
		System.out.println(tab);
		
		System.out.println(tab.checkHorizontalPossible(0, 0));
		System.out.println(tab.checkHorizontalPossible(0, 5));
		System.out.println(tab.checkHorizontalPossible(0, 6));
		
		System.out.println(tab.checkVerticalPossible(0, 6));
		System.out.println(tab.checkVerticalPossible(5, 6));
		System.out.println(tab.checkVerticalPossible(6, 6));
	}

}