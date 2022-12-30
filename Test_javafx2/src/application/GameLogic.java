package application;

import application.Board;
import javafx.util.Pair;

public class GameLogic {
	
	public static void main(String[] args) {
		Board tab = new Board(16, "Tableau de jeu");
		
		// System.out.println(tab);
		tab.grid[1][4] = "T";
		tab.grid[2][3] = "T";
		tab.grid[3][2] = "T";
		tab.grid[4][1] = "T";
		System.out.println(tab);
		
		System.out.println(tab.checkPossible(5, 0));
	}
}