package application;

import application.*;
import java.util.ArrayList;
import javafx.application.Application;

public class Tests {
	
	public static void main(String[] args) {
		Board tab = new Board(16, "Tableau de jeu");
		GameMechanics.gameRule = "5D";

		tab.initBoard();
		
		tab.printBoard();
		ArrayList<Line> lines = new ArrayList<>();
		lines.addAll(GameMechanics.checkLeftDiagPossible(5, 10, tab));
		lines.addAll(GameMechanics.checkVerticalPossible(2, 6, tab));
		System.out.println(lines);
	}
}