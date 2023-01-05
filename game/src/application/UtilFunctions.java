package application;

import java.util.ArrayList;
import application.Line;

public class UtilFunctions {

	public static boolean containsOnce(ArrayList<Boolean> tab, Boolean e) {
		if (!tab.contains(e)) {
			return false;
		}
		boolean result = true;
		int index = tab.indexOf(e);
		for (int i = index + 1; i < tab.size(); i++) {
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
					if (playedLine.getDirection().equals(testLine.getDirection())) {
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
		for (Line testLine : testLines) {
			for (Line playedLine : playedLines) {
				// System.out.println("testLine extremities : " + testLine.firstExtremity() + "
				// ; " + testLine.secondExtremity());
				// System.out.println("playedLine extremities : " + playedLine.firstExtremity()
				// + " ; " + playedLine.secondExtremity());
				if (playedLine.getDirection().equals(testLine.getDirection())
						&& (playedLine.firstExtremity().equals(testLine.firstExtremity())
								|| playedLine.secondExtremity().equals(testLine.firstExtremity())
								|| playedLine.firstExtremity().equals(testLine.secondExtremity())
								|| playedLine.secondExtremity().equals(testLine.secondExtremity()))) {
					// System.out.println("SAME DIRECTION AND EXTREMITIES");
					return testLine;
				}
			}
		}
		return canPlay5D(testLines, playedLines);
	}

}