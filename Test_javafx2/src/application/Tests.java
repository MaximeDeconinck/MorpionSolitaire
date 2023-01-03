package application;

import application.*;
import java.util.ArrayList;
import javafx.application.Application;

public class Tests {
	
	public static void main(String[] args) {
		Board tab = new Board(16, "Tableau de jeu");
		GameMechanics.gameRule = "5D";

		tab.initBoard();
		
		tab.addPoint(0, 1);
		tab.addPoint(0, 2);
		tab.addPoint(0, 3);
		tab.addPoint(0, 4);
		
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
		
		tab.addPoint(0, 11);
		tab.addPoint(0, 12);
		tab.addPoint(0, 13);
		tab.addPoint(0, 14);
		
		tab.printBoard();
		GameMechanics.playMove(0, 15, tab);
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