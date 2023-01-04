package application;

import java.util.ArrayList;
import application.Line;

public class UtilFunctions {
	
	public static boolean containsOnce(ArrayList<Boolean> tab, Boolean e) {
		if (!tab.contains(e)) { return false; }
		boolean result = true;
		int index = tab.indexOf(e);
		for (int i = index+1; i < tab.size(); i++) {
			if (tab.get(i).equals(e)) {
				result = false;
				break;
			}
		}
		return result;
	}
	
	public static Line canPlay5D(ArrayList<Line> testLines, ArrayList<Line> playedLines) {
	    for (Line testLine : testLines) {
	    	// System.out.println("testLine : " + testLine);
	        boolean valid = true;
	        for (Line playedLine : playedLines) {
	        	// System.out.println("playedLine : " + playedLine);
	            if (testLine.hasCommonPoint(playedLine)) {
	            	// System.out.println("point en commun trouvé");
	                if (playedLine.getDirection() == testLine.getDirection()) {
	                    valid = false;
	                    break;
	                }
	            }
	        }
	        if (valid) {
	            return testLine;
	        }
	    }
	    return new Line();
	}
	
	public static Line canPlay5T(ArrayList<Line> testLines, ArrayList<Line> playedLines) {
		// To do 
		return new Line();
	}

}