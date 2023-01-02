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
	        boolean valid = true;
	        for (Line playedLine : playedLines) {
	            for (Point point : testLine.getPoints()) {
	                if (playedLine.getPoints().contains(point)) {
	                    if (playedLine.dir.equals(testLine.dir)) {
	                        valid = false;
	                        break;
	                    }
	                }
	            }
	            if (!valid) {
	                break;
	            }
	        }
	        if (valid) {
	            return testLine;
	        }
	    }
	    return null;
	}


}
