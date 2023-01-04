package application;

import application.*;
import java.util.ArrayList;
import javafx.application.Application;

public class Tests {
	
	public static void main(String[] args) {
		Board tab = new Board(16, "Tableau de jeu");
		GameMechanics.gameRule = "5T";
		
		tab.printBoard();
		
		System.out.println(GameMechanics.isGameOver(tab));
		
		tab.initBoard();		
		tab.printBoard();
		System.out.println(GameMechanics.isGameOver(tab));
		
		/*
		GameMechanics.playMove(3, 5, tab);
		tab.printBoard();
		System.out.println(GameMechanics.moves);
		System.out.println(GameMechanics.lines);
		
		GameMechanics.playMove(2, 6, tab);
		tab.printBoard();
		System.out.println(GameMechanics.moves);
		System.out.println(GameMechanics.lines);
		
		GameMechanics.playMove(5, 5, tab);
		tab.printBoard();
		System.out.println(GameMechanics.moves);
		System.out.println(GameMechanics.lines);
		
		GameMechanics.playMove(10, 5, tab);
		tab.printBoard();
		System.out.println(GameMechanics.moves);
		System.out.println(GameMechanics.lines);
		*/
	}
}