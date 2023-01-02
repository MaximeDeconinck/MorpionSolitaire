package application;

import application.*;

public class Tests {
	
	public static void main(String[] args) {
		Board tab = new Board(16, "Tableau de jeu");

		tab.initBoard();
		tab.addPoint(1, 4);
		tab.addPoint(2, 3);
		tab.addPoint(3, 2);
		tab.addPoint(4, 1);
		
		tab.printBoard();
		
	}
}