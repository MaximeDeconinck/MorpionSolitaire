package application;

import application.Board;
import javafx.util.Pair;

public class GameLogic {
	
	public static void main(String[] args) {
		Board tab = new Board(6, "Tableau de jeu");
		System.out.println(tab.grid.keySet());
	}

}