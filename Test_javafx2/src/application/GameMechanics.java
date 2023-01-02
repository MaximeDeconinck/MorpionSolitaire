package application;

import java.util.ArrayList;
import java.util.Arrays;
import application.Line;

public class GameMechanics {
	
	static ArrayList<ArrayList<Integer>> moves = new ArrayList<>();
	static ArrayList<Line> lines = new ArrayList<>();
	
	public static Line checkHorizontalPossible(int x, int y, Board board) {
        int distanceToLeftBorder = y;
        int distanceToRightBorder = board.size - y - 1;

        if (distanceToLeftBorder > 3) {
            if (distanceToRightBorder > 3) {
                // Assez de place pour vérifier toutes les lignes possibles
                for (int i = 0; i < 5; i++) {
                    ArrayList<Boolean> temp = new ArrayList<>();
                    Line line = new Line();
                    line.dir = "hor";
                    for (int j = 5; j > 0; j--) {
                        temp.add(board.grid.get(x).get(y-j+1+i));
                        line.points.add(x);
                        line.points.add(y-j+1+i);
                    }
                    // System.out.println(temp);
                    if (UtilFunctions.containsOnce(temp, false)) {
                    	return line;
                    }
                }
            }
            // Assez de place à gauche mais pas à droite
            for (int i = 0; i < distanceToRightBorder + 1; i++) {
                ArrayList<Boolean> temp = new ArrayList<>();
                Line line = new Line();
                line.dir = "hor";
                for (int j = 5; j > 0; j--) {
                    temp.add(board.grid.get(x).get(y-j+1+i));
                    line.points.add(x);
                    line.points.add(y-j+1+i);
                }
                if (UtilFunctions.containsOnce(temp, false)) { 
                	return line;
                }
            }
        }
        if (distanceToRightBorder > 3) {
            // Pas de place à gauche mais assez à droite
            for (int i = 0; i < distanceToLeftBorder + 1; i++) {
                ArrayList<Boolean> temp = new ArrayList<>();
                Line line = new Line();
                line.dir = "hor";
                for (int j = 0; j < 5; j++) {
                    temp.add(board.grid.get(x).get(y+j+i));
                    line.points.add(x);
                    line.points.add(y-j+1+i);
                }
                // System.out.println(temp);
                if (UtilFunctions.containsOnce(temp, false)) { 
                    return line;
                }
            }
        }
        // Situation impossible dans notre cas
        Line line = new Line();
        return line;
    }

	
    public static boolean checkVerticalPossible(int x, int y, Board board) {
        int distanceToUpBorder = x;
        int distanceToDownBorder = board.size - x - 1;
        boolean result = false;

        if (distanceToUpBorder > 3) {
            if (distanceToDownBorder > 3) {
                // Assez de place pour vérifier toutes les colonnes possibles
                for (int i = 0; i < 5; i++) {
                    ArrayList<Boolean> temp = new ArrayList<>();
                    for (int j = 5; j > 0; j--) {
                        temp.add(board.grid.get(x-j+1+i).get(y));
                    }
                    if (UtilFunctions.containsOnce(temp, false)) { 
                        result = true;
                        break;
                    }
                }
                return result;
            }
            // Assez de place en haut mais pas en bas
            for (int i = 0; i < distanceToDownBorder + 1; i++) {
                ArrayList<Boolean> temp = new ArrayList<>();
                for (int j = 5; j > 0; j--) {
                    temp.add(board.grid.get(x-j+1+i).get(y));
                }
                if (UtilFunctions.containsOnce(temp, false)) { 
                    result = true;
                    break;
                }
            }
            return result;
        }
        if (distanceToDownBorder > 3) {
            // Pas de place en haut mais assez en bas
            for (int i = 0; i < distanceToUpBorder + 1; i++) {
                ArrayList<Boolean> temp = new ArrayList<>();
                for (int j = 0; j < 5; j++) {
                    temp.add(board.grid.get(x+j+i).get(y));
                }
                if (UtilFunctions.containsOnce(temp, false)) { 
                    result = true;
                    break;
                }
            }
            return result;
        }
        // Situation impossible dans notre cas
        return false;
    }
	
	
    public static boolean checkLeftDiagPossible(int x, int y, Board board) {
        int distanceToTopLeftBorder = Math.min(x, y);
        int distanceToBottomRightBorder = Math.min(board.size - x - 1, board.size - y - 1);
        boolean result = false;

        if (distanceToTopLeftBorder > 3) {
            if (distanceToBottomRightBorder > 3) {
                // Enough space to check all possible diagonals
                for (int i = 0; i < 5; i++) {
                    ArrayList<Boolean> temp = new ArrayList<>();
                    for (int j = 5; j > 0; j--) {
                        temp.add(board.grid.get(x - j + 1 + i).get(y - j + 1 + i));
                    }
                    if (UtilFunctions.containsOnce(temp, false)) {
                        result = true;
                        break;
                    }
                }
                return result;
            }
            // Enough space to the top-left, but not enough to the bottom-right
            for (int i = 0; i < distanceToBottomRightBorder + 1; i++) {
                ArrayList<Boolean> temp = new ArrayList<>();
                for (int j = 5; j > 0; j--) {
                    temp.add(board.grid.get(x - j + 1 + i).get(y - j + 1 + i));
                }
                if (UtilFunctions.containsOnce(temp, false)) {
                    result = true;
                    break;
                }
            }
            return result;
        }
        if (distanceToBottomRightBorder > 3) {
            // Not enough space to the top-left, but enough to the bottom-right
            for (int i = 0; i < distanceToTopLeftBorder + 1; i++) {
                ArrayList<Boolean> temp = new ArrayList<>();
                for (int j = 0; j < 5; j++) {
                    temp.add(board.grid.get(x + j + i).get(y + j + i));
                }
                if (UtilFunctions.containsOnce(temp, false)) {
                    result = true;
                    break;
                }
            }
            return result;
        }
        // Impossible situation in our case
        return false;
    }          

	
	public static boolean checkRightDiagonalPossible(int x, int y, Board board) {
	    int distanceToTopRightBorder = Math.min(x, board.size - y - 1);
	    int distanceToBottomLeftBorder = Math.min(board.size - x - 1, y);
	    boolean result = false;

	    if (distanceToTopRightBorder > 3) {
	        if (distanceToBottomLeftBorder > 3) {
	            // Enough space to check all possible diagonals
	            for (int i = 0; i < 5; i++) {
	                ArrayList<Boolean> temp = new ArrayList<>();
	                for (int j = 5; j > 0; j--) {
	                    temp.add(board.grid.get(x - j + 1 + i).get(y + j - 1 - i));
	                }
	                if (UtilFunctions.containsOnce(temp, false)) {
	                    result = true;
	                    break;
	                }
	            }
	            return result;
	        }
	        // Enough space to the top-right, but not enough to the bottom-left
	        for (int i = 0; i < distanceToBottomLeftBorder + 1; i++) {
	            ArrayList<Boolean> temp = new ArrayList<>();
	            for (int j = 5; j > 0; j--) {
	                temp.add(board.grid.get(x - j + 1 + i).get(y + j - 1 - i));
	            }
	            if (UtilFunctions.containsOnce(temp, false)) {
	                result = true;
	                break;
	            }
	        }
	        return result;
	    }
	    if (distanceToBottomLeftBorder > 3) {
	        // Not enough space to the top-right, but enough to the bottom-left
	        for (int i = 0; i < distanceToTopRightBorder + 1; i++) {
	            ArrayList<Boolean> temp = new ArrayList<>();
	            for (int j = 0; j < 5; j++) {
	                temp.add(board.grid.get(x + j + i).get(y - j - i));
	            }
	            if (UtilFunctions.containsOnce(temp, false)) {
	                result = true;
	                break;
	            }
	        }
	        return result;
	    }
	    // Impossible situation in our case
	    return false;
	}

	
	public static boolean checkPossible(int x, int y, Board board) {
		return /*checkHorizontalPossible(x, y, board) || */ checkVerticalPossible(x, y, board) || checkLeftDiagPossible(x, y, board) || checkRightDiagonalPossible(x, y, board);
	}
	
	public static void playMove(int x, int y, Board board) {
		if (checkPossible(x, y, board)) {
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(x);
			temp.add(y);
			moves.add(temp);
			board.addPoint(x, y);
		}
	}

}
