package adsfinal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class MazeRunner {
	
	/*
	 * Joan to do:
	 * -Use board from Maze.java to find “neighbors” s.t. 1 means wall and 0 means neighbor that “bug” can move to
	 * -Use linked list to get queue going for breadth first search to find shortest pathway

	 */
	
	public static void main(String[] args) {
		int[] rob = {0,0};
		
		
		
		
	}

	
	
	
	public int[] nextStep(int[] initLoc) {
		
		int [] start = {0,0};
		HashMap<int[],int[]> parent = new HashMap<int[],int[]>();
	  	LinkedList<int[]> queue = new LinkedList<int[]>();
	  	HashSet<int[]> visited = new HashSet<int[]>();
	  	
	  	queue.add(start);
	  	visited.add(start);
	  	while(!queue.isEmpty()) {
	  		int[] first = queue.pop();
	  		
	  		
	  	}

		return start;
		
	}
}
