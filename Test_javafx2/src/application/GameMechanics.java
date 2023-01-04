package application;

import java.util.ArrayList;
import java.util.Arrays;
import application.Line;
import application.CreateGraphiqueBoard;

public class GameMechanics {
	
	static ArrayList<Point> moves = new ArrayList<>();
	static ArrayList<Line> lines = new ArrayList<>();
	static String gameRule = "5D";
	
	
	// Ajouter fonction qui modifie gameRule en fonction du menu d�roulant
	
	public static void reset(Board board) {
		board.resetBoard();
		moves = new ArrayList<>();
		lines = new ArrayList<>();
		// partie graphique
	}
	
	public static ArrayList<Line> isHorizontalPossible(int x, int y, Board board) {
	    ArrayList<Line> lines1 = new ArrayList<>();
	    for (int i = 0; i < 5; i++) {
	    	if (y-4+i >= 0 && y+i < board.size && y-4+i < board.size && y+i >= 0) {
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
	    	if (x-4+i >= 0 && x+i < board.size && x-4+i < board.size && x+i >= 0) {
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
	    	if (x-4+i >= 0 && x-4+i < board.size && x+i < board.size && x+i >= 0 && y-4+i >= 0 && y-4+i < board.size && y+i >= 0 && y+i < board.size) {
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
	    	if (x-4+i >= 0 && x-4+i < board.size && x+i < board.size && x+i >= 0 && y+4-i >= 0 && y+4-i < board.size && y-i < board.size && y-i >= 0) {
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
	
	/**
	 * Determines if a move can be made at the specified coordinates on the board.
	 * 
	 * @param x The x coordinate of the move.
	 * @param y The y coordinate of the move.
	 * @param board The board on which to check for a playable move.
	 * @return A Line object representing the line that can be formed by making the move, or null if the move is not playable.
	 */
	public static Line isPlayable(int x, int y, Board board) {
		if (!board.grid.get(x).get(y)) {
			ArrayList<Line> testLines = new ArrayList<>();
			if (!isHorizontalPossible(x, y, board).isEmpty()) { testLines.addAll(isHorizontalPossible(x, y, board)); }
			if (!isVerticalPossible(x, y, board).isEmpty()) { testLines.addAll(isVerticalPossible(x, y, board)); }
			if (!isLeftDiagPossible(x, y, board).isEmpty()) { testLines.addAll(isLeftDiagPossible(x, y, board)); }
			if (!isRightDiagPossible(x, y, board).isEmpty()) { testLines.addAll(isRightDiagPossible(x, y, board)); }
			if (!UtilFunctions.canPlay5D(testLines, lines).points.isEmpty() && gameRule.equals("5D")) {
				// On est en 5D et on peut jouer
				Line newLine = UtilFunctions.canPlay5D(testLines, lines);
				return newLine;
			}
			if (!UtilFunctions.canPlay5T(testLines, lines).points.isEmpty() && gameRule.equals("5T")) {
				// On est en 5T et on peut jouer
				Line newLine = UtilFunctions.canPlay5D(testLines, lines);
				return newLine;
			}
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
		if (!board.grid.get(x).get(y)) {
			if (gameRule.equals("5D")) {
				if (isPossible(x, y, board)) {
					if (isPlayable(x, y, board) != null) {
						Line newLine = isPlayable(x, y, board);
						lines.add(newLine);
						moves.add(new Point(x, y));
						board.grid.get(x).set(y, true);
						CreateGraphiqueBoard.drawLine(newLine.points.get(0).x, newLine.points.get(0).y, newLine.points.get(newLine.points.size()-1).x, newLine.points.get(newLine.points.size()-1).y);
						return true;
					}
				}
			}
			if (gameRule.equals("5T")) {
				// Partie en 5T
			}
		}
		return false;
	}
	
	public static ArrayList<Point> playableMoves(Board board) {
        ArrayList<Point> playableMoves = new ArrayList<>();
        for (int i = 0; i < board.size; i++) {
            for (int j = 0; j < board.size; j++) {
                Board copyOfBoard = board.copy();
	            if (isPlayable(i, j, copyOfBoard) != null) {
	                playableMoves.add(new Point(i, j));
	            }
            }
        }
        return playableMoves;
    }
	
	public static boolean isGameOver(Board board) {
		ArrayList<Point> playableMoves = playableMoves(board);
		if (playableMoves.isEmpty()) {
			return false;
		}
		return true;
	}
		
	public static void setGameRule(String gameRule) {
		GameMechanics.gameRule = gameRule;
		System.out.println("game mech" + GameMechanics.gameRule);
	}

}