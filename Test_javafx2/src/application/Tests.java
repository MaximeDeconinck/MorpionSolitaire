package application;

import application.*;
import java.util.ArrayList;
import javafx.application.Application;

public class Tests {
	
	public static void main(String[] args) {
		Board tab = new Board(16, "Tableau de jeu");
		GameMechanics.gameRule = "5D";

		tab.initBoard();
		
		tab.addPoint(1, 0);
		tab.addPoint(2, 0);
		tab.addPoint(3, 0);
		tab.addPoint(4, 0);
		
		tab.printBoard();
		GameMechanics.playMove(0, 0, tab);
		tab.printBoard();
		System.out.println(GameMechanics.moves);
		System.out.println(GameMechanics.lines);
		
		tab.addPoint(11, 15);
		tab.addPoint(12, 15);
		tab.addPoint(13, 15);
		tab.addPoint(14, 15);
		
		tab.printBoard();
		GameMechanics.playMove(15, 15, tab);
		tab.printBoard();
		System.out.println(GameMechanics.moves);
		System.out.println(GameMechanics.lines);
		
		tab.addPoint(15, 5);
		tab.addPoint(15, 6);
		tab.addPoint(15, 7);
		tab.addPoint(15, 8);
		
		tab.printBoard();
		GameMechanics.playMove(15, 4, tab);
		tab.printBoard();
		System.out.println(GameMechanics.moves);
		System.out.println(GameMechanics.lines);
		
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