package application;

import application.UtilFunctions;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class Board {
	public int size; // fixée à 16 dans le futur
	public String name;
	public String[][] grid;
	
	public Board(int size, String name)	{
		this.size = size;
		this.name = name;
		String[][] grid1 = new String[this.size][this.size];
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				grid1[i][j] = "F";
			}
		}
		this.grid = grid1;
	}
	
	public boolean checkHorizontalPossible(int x, int y) {
		int distanceToLeftBorder = y;
		int distanceToRightBorder = this.size - y - 1;
		boolean result = false;
		
		if (distanceToLeftBorder>3) {
			if (distanceToRightBorder>3) {
				// Assez de place pour vérifier toutes les lignes possibles
				for (int i = 0; i < 5; i++) {
					ArrayList<String> temp = new ArrayList<>();
					for (int j = 5; j > 0; j--) {
						temp.add(this.grid[x][y-j+1+i]);
					}
					// System.out.println(temp);
					if (UtilFunctions.containsOnce(temp, "F")) { 
						result = true;
						break;
					}
				}
				return result;
			}
			// Assez de place à gauche mais pas à droite
			for (int i = 0; i < distanceToRightBorder + 1; i++) {
				ArrayList<String> temp = new ArrayList<>();
				for (int j = 5; j > 0; j--) {
					temp.add(this.grid[x][y-j+1+i]);
				}
				if (UtilFunctions.containsOnce(temp, "F")) { 
					result = true;
					break;
				}
			}
			return result;
		}
		if (distanceToRightBorder>3) {
			// Pas de place à gauche mais assez à droite
			for (int i = 0; i < distanceToLeftBorder + 1; i++) {
				ArrayList<String> temp = new ArrayList<>();
				for (int j = 0; j < 5; j++) {
					temp.add(this.grid[x][y+j+i]);
				}
				// System.out.println(temp);
				if (UtilFunctions.containsOnce(temp, "F")) { 
					result = true;
					break;
				}
			}
			return result;
		}
		// Situation impossible dans notre cas
		return false;
	}
	
	public boolean checkVerticalPossible(int x, int y) {
		int distanceToUpBorder = x;
		int distanceToDownBorder = this.size - x - 1;
		boolean result = false;
		
		if (distanceToUpBorder>3) {
			if (distanceToDownBorder>3) {
				// Assez de place pour vérifier toutes les lignes possibles
				for (int i = 0; i < 5; i++) {
					ArrayList<String> temp = new ArrayList<>();
					for (int j = 5; j > 0; j--) {
						temp.add(this.grid[x-j+1+i][y]);
					}
					// System.out.println(temp);
					if (UtilFunctions.containsOnce(temp, "F")) { 
						result = true;
						break;
					}
				}
				return result;
			}
			// Assez de place en haut mais pas en bas
			for (int i = 0; i < distanceToDownBorder + 1; i++) {
				ArrayList<String> temp = new ArrayList<>();
				for (int j = 5; j > 0; j--) {
					temp.add(this.grid[x-j+1+i][y]);
				}
				// System.out.println(temp);
				if (UtilFunctions.containsOnce(temp, "F")) { 
					result = true;
					break;
				}
			}
			return result;
		}
		if (distanceToDownBorder>3) {
			// Pas de place en haut mais assez en bas
			for (int i = 0; i < distanceToUpBorder + 1; i++) {
				ArrayList<String> temp = new ArrayList<>();
				for (int j = 0; j < 5; j++) {
					temp.add(this.grid[x+j+i][y]);
				}
				// System.out.println(temp);
				if (UtilFunctions.containsOnce(temp, "F")) { 
					result = true;
					break;
				}
			}
			return result;
		}
		// Situation impossible dans notre cas
		return false;
	}
	
	
	public boolean checkLeftDiagPossible(int x, int y) {
	    int distanceToTopLeftBorder = Math.min(x, y);
	    int distanceToBottomRightBorder = Math.min(this.size - x - 1, this.size - y - 1);
	    boolean result = false;

	    if (distanceToTopLeftBorder > 3) {
	        if (distanceToBottomRightBorder > 3) {
	            // Enough space to check all possible diagonals
	            for (int i = 0; i < 5; i++) {
	                ArrayList<String> temp = new ArrayList<>();
	                for (int j = 5; j > 0; j--) {
	                    temp.add(this.grid[x - j + 1 + i][y - j + 1 + i]);
	                }
	                if (UtilFunctions.containsOnce(temp, "F")) {
	                    result = true;
	                    break;
	                }
	            }
	            return result;
	        }
	        // Enough space to the top-left, but not enough to the bottom-right
	        for (int i = 0; i < distanceToBottomRightBorder + 1; i++) {
	            ArrayList<String> temp = new ArrayList<>();
	            for (int j = 5; j > 0; j--) {
	                temp.add(this.grid[x - j + 1 + i][y - j + 1 + i]);
	            }
	            if (UtilFunctions.containsOnce(temp, "F")) {
	                result = true;
	                break;
	            }
	        }
	        return result;
	    }
	    if (distanceToBottomRightBorder > 3) {
	        // Not enough space to the top-left, but enough to the bottom-right
	        for (int i = 0; i < distanceToTopLeftBorder + 1; i++) {
	            ArrayList<String> temp = new ArrayList<>();
	            for (int j = 0; j < 5; j++) {
	                temp.add(this.grid[x + j + i][y + j + i]);
	            }
	            if (UtilFunctions.containsOnce(temp, "F")) {
	                result = true;
	                break;
	            }
	        }
	        return result;
	    }
	    // Impossible situation in our case
	    return false;
	}
	
	public boolean checkRightDiagonalPossible(int x, int y) {
	    int distanceToTopRightBorder = Math.min(x, this.size - y - 1);
	    int distanceToBottomLeftBorder = Math.min(this.size - x - 1, y);
	    boolean result = false;

	    if (distanceToTopRightBorder > 3) {
	        if (distanceToBottomLeftBorder > 3) {
	            // Enough space to check all possible diagonals
	            for (int i = 0; i < 5; i++) {
	                ArrayList<String> temp = new ArrayList<>();
	                for (int j = 5; j > 0; j--) {
	                    temp.add(this.grid[x - j + 1 + i][y + j - 1 - i]);
	                }
	                if (UtilFunctions.containsOnce(temp, "F")) {
	                    result = true;
	                    break;
	                }
	            }
	            return result;
	        }
	        // Enough space to the top-right, but not enough to the bottom-left
	        for (int i = 0; i < distanceToBottomLeftBorder + 1; i++) {
	            ArrayList<String> temp = new ArrayList<>();
	            for (int j = 5; j > 0; j--) {
	                temp.add(this.grid[x - j + 1 + i][y + j - 1 - i]);
	            }
	            if (UtilFunctions.containsOnce(temp, "F")) {
	                result = true;
	                break;
	            }
	        }
	        return result;
	    }
	    if (distanceToBottomLeftBorder > 3) {
	        // Not enough space to the top-right, but enough to the bottom-left
	        for (int i = 0; i < distanceToTopRightBorder + 1; i++) {
	            ArrayList<String> temp = new ArrayList<>();
	            for (int j = 0; j < 5; j++) {
	                temp.add(this.grid[x + j + i][y - j - i]);
	            }
	            if (UtilFunctions.containsOnce(temp, "F")) {
	                result = true;
	                break;
	            }
	        }
	        return result;
	    }
	    // Impossible situation in our case
	    return false;
	}

	
	public boolean checkPossible(int x, int y) {
		return checkHorizontalPossible(x, y) || checkVerticalPossible(x, y) || checkLeftDiagPossible(x, y) || checkRightDiagonalPossible(x, y);
	}
	
	@Override
	public String toString() {
		String lineSeparator = System.lineSeparator();
		StringBuilder sb = new StringBuilder();

		for (String[] row : this.grid) {
		    sb.append(Arrays.toString(row)).append(lineSeparator);
		}

		String result = sb.toString();
		return result;
	}
}