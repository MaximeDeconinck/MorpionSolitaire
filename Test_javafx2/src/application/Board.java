package application;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Board {
	public int size;
	public String name;
	public Map<String, List<Boolean>> grid;
	
	public Board(int size, String name)	{
		this.size = size;
		this.name = name;
		Map<String, List<Boolean>> grid1 = new TreeMap<>();
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				String tempkey = i + "." + j;
				List<Boolean> tempvalue = new ArrayList<>();
				tempvalue.add(false);
				grid1.put(tempkey, tempvalue);
			}
		}
		this.grid = grid1;
	}
	
	@Override
	public String toString() {
		return this.grid.keySet().toString();
	}
}