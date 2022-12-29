package application;

import application.Board;
import javafx.util.Pair;

public class GameLogic {
	
	public static void main(String[] args) {
		Board tab = new Board(16, "Tableau de jeu");
		
		// System.out.println(tab);
		tab.grid[14][11] = "T";
		tab.grid[14][12] = "T";
		tab.grid[14][13] = "T";
		tab.grid[14][10] = "T";
		System.out.println(tab);
		
		System.out.println(tab.checkHorizontalPossible(14, 14));
	}
}