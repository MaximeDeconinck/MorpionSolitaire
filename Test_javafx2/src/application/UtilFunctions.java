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
            boolean canPlay = true;
            int intersections = 0;
            for (Line playedLine : playedLines) {
                for (int point : testLine.points) {
                    if (playedLine.points.contains(point)) {
                        intersections++;
                        if (intersections > 1 || playedLine.dir.equals(testLine.dir)) {
                            canPlay = false;
                            break;
                        }
                    }
                }
            }
            if (canPlay) {
                return testLine;
            }
        }
        return null;
    }
}
