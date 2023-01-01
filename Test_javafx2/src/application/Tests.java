package application;

import application.*;

public class Tests {
	
	public static void main(String[] args) {
		Board tab = new Board(16, "Tableau de jeu");
		
		/* System.out.println(tab);
		tab.addPoint(1, 4);
		tab.addPoint(2, 3);
		tab.addPoint(3, 2);
		tab.addPoint(4, 1);
		
		tab.printBoard();
		
		GameMechanics.playMove(5, 0, tab);
		GameMechanics.playMove(6, 0, tab);
		
		tab.printBoard()
		*/
		
		tab.initBoard();
		tab.printBoard();
	}
}