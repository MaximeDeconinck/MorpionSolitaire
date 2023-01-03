package application;

import java.util.ArrayList;
import java.util.Arrays;
import application.Line;

public class GameMechanics {
	
	static ArrayList<Point> moves = new ArrayList<>();
	static ArrayList<Line> lines = new ArrayList<>();
	static String gameRule;
	
	
	// Ajouter fonction qui modifie gameRule en fonction du menu déroulant
	
	public static void reset(Board board) {
		board.resetBoard();
		moves = new ArrayList<>();
		lines = new ArrayList<>();
		// partie graphique
	}
	
	public static ArrayList<Line> checkHorizontalPossible(int x, int y, Board board) {
	    ArrayList<Line> lines1 = new ArrayList<>();
	    for (int i = 0; i < 5; i++) {
	    	if (y-4+i >= 0 && y+i <= board.size) {
		        ArrayList<Boolean> temp = new ArrayList<>();
		        Line line = new Line();
		        line.dir = "hor";
		        for (int j = 0; j < 5; j++) {
		            temp.add(board.grid.get(x).get(y-4+i+j));
		            line.points.add(new Point(x, y-4+i+j));
		        }
		        if (UtilFunctions.containsOnce(temp, false)) {
		            lines1.add(line);
		        }
	    	}
	    }
	    return lines1;
	}

	
	public static ArrayList<Line> checkVerticalPossible(int x, int y, Board board) {
	    ArrayList<Line> lines1 = new ArrayList<>();
	    for (int i = 0; i < 5; i++) {
	    	if (x-4+i >= 0 && x+i <= board.size) {
		        ArrayList<Boolean> temp = new ArrayList<>();
		        Line line = new Line();
		        line.dir = "vert";
		        for (int j = 0; j < 5; j++) {
		            temp.add(board.grid.get(x-4+i+j).get(y));
		            line.points.add(new Point(x-4+i+j, y));
		        }
		        if (UtilFunctions.containsOnce(temp, false)) {
		            lines1.add(line);
		        }
	    	}
	    }
	    return lines1;
	}
	
	
	public static ArrayList<Line> checkLeftDiagPossible(int x, int y, Board board) {
	    ArrayList<Line> lines1 = new ArrayList<>();
	    for (int i = 0; i < 5; i++) {
	    	if (x-4+i >= 0 && x+i <= board.size && y-4+i >= 0 && y+i <= board.size) {
		        ArrayList<Boolean> temp = new ArrayList<>();
		        Line line = new Line();
		        line.dir = "leftdiag";
		        for (int j = 0; j < 5; j++) {
		            temp.add(board.grid.get(x-4+i+j).get(y-4+i+j));
		            line.points.add(new Point(x-4+i+j, y-4+i+j));
		        }
		        if (UtilFunctions.containsOnce(temp, false)) {
		            lines1.add(line);
		        }
	    	}
	    }
	    return lines1;
	}

	
	public static ArrayList<Line> checkRightDiagPossible(int x, int y, Board board) {
	    ArrayList<Line> lines1 = new ArrayList<>();
	    for (int i = 0; i < 5; i++) {
	    	if (x-4+i >= 0 && x+i <= board.size && y+4-i >= 0 && y-i <= board.size) {
		        ArrayList<Boolean> temp = new ArrayList<>();
		        Line line = new Line();
		        line.dir = "rightdiag";
		        for (int j = 0; j < 5; j++) {
		            temp.add(board.grid.get(x-4+i+j).get(y+4-i-j));
		            line.points.add(new Point(x-4+i+j, y+4-i-j));
		        }
		        if (UtilFunctions.containsOnce(temp, false)) {
		            lines1.add(line);
		        }
	    	}
	    }
	    return lines1;
	}

	
	public static boolean checkPossible(int x, int y, Board board) {
		if (checkHorizontalPossible(x, y, board).isEmpty()) {
			if (checkVerticalPossible(x, y, board).isEmpty()) {
				if (checkLeftDiagPossible(x, y, board).isEmpty()) {
					if (checkRightDiagPossible(x, y, board).isEmpty()) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static void playMove(int x, int y, Board board) {
		if (gameRule.equals("5D")) {
			if (checkPossible(x, y, board)) {
				if (!checkHorizontalPossible(x, y, board).isEmpty()) {
					ArrayList<Line> testLines = checkHorizontalPossible(x, y, board);
					if (!UtilFunctions.canPlay5D(testLines, lines).getPoints().isEmpty()) {
						System.out.println(UtilFunctions.canPlay5D(testLines, lines));
						lines.add(UtilFunctions.canPlay5D(testLines, lines));
						moves.add(new Point(x, y));
						board.addPoint(x, y);
						return;
					}
				}
				if (!checkVerticalPossible(x, y, board).isEmpty()) {
					ArrayList<Line> testLines = checkVerticalPossible(x, y, board);
					if (!UtilFunctions.canPlay5D(testLines, lines).getPoints().isEmpty()) {
						lines.add(UtilFunctions.canPlay5D(testLines, lines));
						moves.add(new Point(x, y));
						board.addPoint(x, y);
						return;
					}
				}
				if (!checkLeftDiagPossible(x, y, board).isEmpty()) {
					ArrayList<Line> testLines = checkLeftDiagPossible(x, y, board);
					if (!UtilFunctions.canPlay5D(testLines, lines).getPoints().isEmpty()) {
						lines.add(UtilFunctions.canPlay5D(testLines, lines));
						moves.add(new Point(x, y));
						board.addPoint(x, y);
						return;
					}
				}
				if (!checkRightDiagPossible(x, y, board).isEmpty()) {
					ArrayList<Line> testLines = checkRightDiagPossible(x, y, board);
					if (!UtilFunctions.canPlay5D(testLines, lines).getPoints().isEmpty()) {
						lines.add(UtilFunctions.canPlay5D(testLines, lines));
						moves.add(new Point(x, y));
						board.addPoint(x, y);
						return;
					}
				}
			}
			// Pas possible de jouer, on ne fait rien
		}
		// Partie en 5T
		
	}
	
	public static void setGameRule(String gameRule) {
		GameMechanics.gameRule = gameRule;
		System.out.println("game mech" + GameMechanics.gameRule);
	}

}
