package application;

import application.*;
import java.util.ArrayList;
import javafx.application.Application;

public class Tests {
	
	public static void main(String[] args) {
		Board tab = new Board(16, "Tableau de jeu");
		GameMechanics.gameRule = "5D";

		tab.initBoard();
		
		GameMechanics.playMove(3, 5, tab);
		tab.printBoard();
		System.out.println("lines : " + GameMechanics.lines);
		System.out.println("moves : " + GameMechanics.moves);
		
		GameMechanics.playMove(3, 4, tab);
		tab.printBoard();
		System.out.println("lines : " + GameMechanics.lines);
		System.out.println("moves : " + GameMechanics.moves);
	}
}