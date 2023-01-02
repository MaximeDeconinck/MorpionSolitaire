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
        int distanceToLeftBorder = y;
        int distanceToRightBorder = board.size - y - 1;
        ArrayList<Line> lines1 = new ArrayList<>();

        if (distanceToLeftBorder > 3) {
            if (distanceToRightBorder > 3) {
                // Assez de place pour vérifier toutes les lignes possibles
                for (int i = 0; i < 5; i++) {
                    ArrayList<Boolean> temp = new ArrayList<>();
                    Line line = new Line();
                    line.dir = "hor";
                    for (int j = 5; j > 0; j--) {
                        temp.add(board.grid.get(x).get(y-j+1+i));
                        line.points.add(new Point(x, y-j+1+i));
                    }
                    // System.out.println(temp);
                    if (UtilFunctions.containsOnce(temp, false)) {
                    	lines1.add(line);
                    }
                }
                return lines1;  
            }
            // Assez de place à gauche mais pas à droite
            for (int i = 0; i < distanceToRightBorder + 1; i++) {
                ArrayList<Boolean> temp = new ArrayList<>();
                Line line = new Line();
                line.dir = "hor";
                for (int j = 5; j > 0; j--) {
                    temp.add(board.grid.get(x).get(y-j+1+i));
                    line.points.add(new Point(x, y-j+1+i));
                }
                if (UtilFunctions.containsOnce(temp, false)) { 
                	lines1.add(line);
                }
            }
            return lines1;  
        }
        if (distanceToRightBorder > 3) {
            // Pas de place à gauche mais assez à droite
            for (int i = 0; i < distanceToLeftBorder + 1; i++) {
                ArrayList<Boolean> temp = new ArrayList<>();
                Line line = new Line();
                line.dir = "hor";
                for (int j = 0; j < 5; j++) {
                    temp.add(board.grid.get(x).get(y+j+i));
                    line.points.add(new Point(x, y+j+i));
                }
                // System.out.println(temp);
                if (UtilFunctions.containsOnce(temp, false)) { 
                	lines1.add(line);
                }
            }
            return lines;  
        }
        // Situation impossible dans notre cas
        return lines;
    }

	
    public static ArrayList<Line> checkVerticalPossible(int x, int y, Board board) {
        int distanceToUpBorder = x;
        int distanceToDownBorder = board.size - x - 1;
        ArrayList<Line> lines1 = new ArrayList<>();

        if (distanceToUpBorder > 3) {
            if (distanceToDownBorder > 3) {
                // Assez de place pour vérifier toutes les colonnes possibles
                for (int i = 0; i < 5; i++) {
                    ArrayList<Boolean> temp = new ArrayList<>();
                    Line line = new Line();
                    line.dir = "ver";
                    for (int j = 5; j > 0; j--) {
                        temp.add(board.grid.get(x-j+1+i).get(y));
                        line.points.add(new Point(x-j+1+i, y));
                    }
                    if (UtilFunctions.containsOnce(temp, false)) { 
                    	lines1.add(line);
                    }
                }
                return lines1;  
            }
            // Assez de place en haut mais pas en bas
            for (int i = 0; i < distanceToDownBorder + 1; i++) {
                ArrayList<Boolean> temp = new ArrayList<>();
                Line line = new Line();
                line.dir = "ver";
                for (int j = 5; j > 0; j--) {
                    temp.add(board.grid.get(x-j+1+i).get(y));
                    line.points.add(new Point(x-j+1+i, y));
                }
                if (UtilFunctions.containsOnce(temp, false)) { 
                    lines1.add(line);
                }
            }
            return lines1;  
        }
        if (distanceToDownBorder > 3) {
            // Pas de place en haut mais assez en bas
            for (int i = 0; i < distanceToUpBorder + 1; i++) {
                ArrayList<Boolean> temp = new ArrayList<>();
                Line line = new Line();
                line.dir = "ver";
                for (int j = 0; j < 5; j++) {
                    temp.add(board.grid.get(x+j+i).get(y));
                    line.points.add(new Point(x+j+i, y));
                }
                if (UtilFunctions.containsOnce(temp, false)) { 
                    lines1.add(line);
                }
            }
            return lines1;  
        }
        // Situation impossible dans notre cas
        return lines1;    
    }
	
	
    public static ArrayList<Line> checkLeftDiagPossible(int x, int y, Board board) {
        int distanceToTopLeftBorder = Math.min(x, y);
        int distanceToBottomRightBorder = Math.min(board.size - x - 1, board.size - y - 1);
        ArrayList<Line> lines1 = new ArrayList<>();

        if (distanceToTopLeftBorder > 3) {
            if (distanceToBottomRightBorder > 3) {
                // Enough space to check all possible diagonals
                for (int i = 0; i < 5; i++) {
                    ArrayList<Boolean> temp = new ArrayList<>();
                    Line line = new Line();
                    line.dir = "leftDiag";
                    for (int j = 5; j > 0; j--) {
                        temp.add(board.grid.get(x - j + 1 + i).get(y - j + 1 + i));
                        line.points.add(new Point(x-j+1+i, y-j+1+i));
                    }
                    if (UtilFunctions.containsOnce(temp, false)) {
                        lines1.add(line);
                    }
                }
                return lines1;  
            }
            // Enough space to the top-left, but not enough to the bottom-right
            for (int i = 0; i < distanceToBottomRightBorder + 1; i++) {
                ArrayList<Boolean> temp = new ArrayList<>();
                Line line = new Line();
                line.dir = "leftDiag";
                for (int j = 5; j > 0; j--) {
                    temp.add(board.grid.get(x - j + 1 + i).get(y - j + 1 + i));
                    line.points.add(new Point(x-j+1+i, y-j+1+i));
                }
                if (UtilFunctions.containsOnce(temp, false)) {
                    lines1.add(line);
                }
            }
            return lines1; 
        }
        if (distanceToBottomRightBorder > 3) {
            // Not enough space to the top-left, but enough to the bottom-right
            for (int i = 0; i < distanceToTopLeftBorder + 1; i++) {
                ArrayList<Boolean> temp = new ArrayList<>();
                Line line = new Line();
                line.dir = "leftDiag";
                for (int j = 0; j < 5; j++) {
                    temp.add(board.grid.get(x + j + i).get(y + j + i));
                    line.points.add(new Point(x+j+i, y+j+i));
                }
                if (UtilFunctions.containsOnce(temp, false)) {
                    lines1.add(line);
                }
            }
            return lines1; 
        }
        // Impossible situation in our case
        return lines1; 
    }          

	
	public static ArrayList<Line> checkRightDiagPossible(int x, int y, Board board) {
	    int distanceToTopRightBorder = Math.min(x, board.size - y - 1);
	    int distanceToBottomLeftBorder = Math.min(board.size - x - 1, y);
	    ArrayList<Line> lines1 = new ArrayList<>();

	    if (distanceToTopRightBorder > 3) {
	        if (distanceToBottomLeftBorder > 3) {
	            // Enough space to check all possible diagonals
	            for (int i = 0; i < 5; i++) {
	                ArrayList<Boolean> temp = new ArrayList<>();
	                Line line = new Line();
	                line.dir = "rightDiag";
	                for (int j = 5; j > 0; j--) {
	                    temp.add(board.grid.get(x - j + 1 + i).get(y + j - 1 - i));
	                    line.points.add(new Point(x-j+1+i, y+j-1-i));
	                }
	                if (UtilFunctions.containsOnce(temp, false)) {
	                    lines1.add(line);
	                }
	            }
	            return lines1; 
	        }
	        // Enough space to the top-right, but not enough to the bottom-left
	        for (int i = 0; i < distanceToBottomLeftBorder + 1; i++) {
	            ArrayList<Boolean> temp = new ArrayList<>();
	            Line line = new Line();
                line.dir = "rightDiag";
	            for (int j = 5; j > 0; j--) {
	                temp.add(board.grid.get(x - j + 1 + i).get(y + j - 1 - i));
                    line.points.add(new Point(x-j+1+i, y+j-1-i));
	            }
	            if (UtilFunctions.containsOnce(temp, false)) {
	            	lines1.add(line);
	            }
	        }
            return lines1; 
	    }
	    if (distanceToBottomLeftBorder > 3) {
	        // Not enough space to the top-right, but enough to the bottom-left
	        for (int i = 0; i < distanceToTopRightBorder + 1; i++) {
	            ArrayList<Boolean> temp = new ArrayList<>();
	            Line line = new Line();
                line.dir = "rightDiag";
	            for (int j = 0; j < 5; j++) {
	                temp.add(board.grid.get(x + j + i).get(y - j - i));
                    line.points.add(new Point(x+j+i, y-j-i));
	            }
	            if (UtilFunctions.containsOnce(temp, false)) {
	            	lines1.add(line);
	            }
	        }
            return lines1; 
	    }
	    // Impossible situation in our case
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
