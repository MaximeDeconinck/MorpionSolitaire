package application;

import application.Board;
import javafx.util.Pair;

public class GameLogic {
	
	public static void main(String[] args) {
		Board tab = new Board(16, "Tableau de jeu");
		
		// System.out.println(tab);
		tab.addPoint(1, 4);
		tab.addPoint(2, 3);
		tab.addPoint(3, 2);
		tab.addPoint(4, 1);
		tab.printBoard();
		
		System.out.println(tab.checkPossible(5, 0));
	}
}