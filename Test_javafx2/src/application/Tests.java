package application;

import application.*;
import javafx.application.Application;

public class Tests {
	
	public static void main(String[] args) {
		Board tab = new Board(16, "Tableau de jeu");
		GameMechanics.gameRule = "5D";

		tab.initBoard();
		
		tab.printBoard();
		GameMechanics.playMove(3, 5, tab);
		tab.printBoard();
		GameMechanics.playMove(3, 4, tab);
		tab.printBoard();
	}
}