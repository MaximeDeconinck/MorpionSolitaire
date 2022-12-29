package application;

import java.util.ArrayList;

public class UtilFunctions {
	
	public static boolean containsOnce(ArrayList<String> tab, String e) {
		if (!tab.contains(e)) { return false; }
		boolean result = true;
		int index = tab.indexOf(e);
		for (int i = index+1; i < tab.size(); i++) {
			if (tab.get(i) == e) {
				result = false;
				break;
			}
		}
		return result;
	}

}
