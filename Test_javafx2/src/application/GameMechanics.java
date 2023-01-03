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
	
	public static ArrayList<Line> isHorizontalPossible(int x, int y, Board board) {
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

	
	public static ArrayList<Line> isVerticalPossible(int x, int y, Board board) {
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
	
	
	public static ArrayList<Line> isLeftDiagPossible(int x, int y, Board board) {
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

	
	public static ArrayList<Line> isRightDiagPossible(int x, int y, Board board) {
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

	
	public static boolean isPossible(int x, int y, Board board) {
		if (isHorizontalPossible(x, y, board).isEmpty()) {
			if (isVerticalPossible(x, y, board).isEmpty()) {
				if (isLeftDiagPossible(x, y, board).isEmpty()) {
					if (isRightDiagPossible(x, y, board).isEmpty()) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
<<<<<<< HEAD
	public static void playMove(int x, int y, Board board) {
=======
	/**
	 * Determines if a move can be made at the specified coordinates on the board.
	 * 
	 * @param x The x coordinate of the move.
	 * @param y The y coordinate of the move.
	 * @param board The board on which to check for a playable move.
	 * @return A Line object representing the line that can be formed by making the move, or null if the move is not playable.
	 */
	public static Line isPlayable(int x, int y, Board board) {
		ArrayList<Line> testLines = new ArrayList<>();
		if (!isHorizontalPossible(x, y, board).isEmpty()) { testLines.addAll(isHorizontalPossible(x, y, board)); }
		if (!isVerticalPossible(x, y, board).isEmpty()) { testLines.addAll(isVerticalPossible(x, y, board)); }
		if (!isLeftDiagPossible(x, y, board).isEmpty()) { testLines.addAll(isLeftDiagPossible(x, y, board)); }
		if (!isRightDiagPossible(x, y, board).isEmpty()) { testLines.addAll(isRightDiagPossible(x, y, board)); }
		// System.out.println(testLines);
		if (!UtilFunctions.canPlay5D(testLines, lines).points.isEmpty()) {
			Line newLine = UtilFunctions.canPlay5D(testLines, lines);
			return newLine;
			}
		return null;
		}
	
	/**
	 * Makes a move on the board at the specified coordinates if possible.
	 * 
	 * @param x The x coordinate of the move.
	 * @param y The y coordinate of the move.
	 * @param board The board on which to make the move.
	 * @return true if the move was made, false if the move was not possible.
	 */
	public static boolean playMove(int x, int y, Board board) {
>>>>>>> 524783c0ef383153e759f1d3d64b7e33819a6af6
		if (!board.grid.get(x).get(y)) {
			if (gameRule.equals("5D")) {
				if (isPossible(x, y, board)) {
					if (!isPlayable(x, y, board).equals(null)) {
						Line newLine = isPlayable(x, y, board);
						lines.add(newLine);
						moves.add(new Point(x, y));
						board.grid.get(x).set(y, true);
<<<<<<< HEAD
=======
						return true;
						}
>>>>>>> 524783c0ef383153e759f1d3d64b7e33819a6af6
					}
				}
			}
<<<<<<< HEAD
			// Partie en 5T
		}
		// Case occupée, on ne fait rien
	}
	
=======
		return false;
		}
		
>>>>>>> 524783c0ef383153e759f1d3d64b7e33819a6af6
	public static void setGameRule(String gameRule) {
		GameMechanics.gameRule = gameRule;
		System.out.println("game mech" + GameMechanics.gameRule);
	}

}
