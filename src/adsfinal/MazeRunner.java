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
	  		int[] first = queue.remove();
	  		int x = first[0];
	  		int y = first[1];
	  		if((board[x][y]][0]==0) && (!visited.contains((x,y+1)))) {
	  			visited.add((x,y+1));
	  			parent[(x,y+1)] = first;
	  		}
	  		if((board[x][y]][1]==0) && (!visited.contains((x+1,y)))) {
	  			visited.add((x+1,y));
	  			parent[(x+1,y)] = first;
	  		}
	  		if((board[x][y]][2]==0) && (!visited.contains((x,y-1)))) {
	  			visited.add((x,y-1));
	  			parent[(x,y-1)] = first;
	  		}
	  		if((board[x][y]][3]==0) && (!visited.contains((x-1,y)))) {
	  			visited.add((x-1,y));
	  			parent[(x-1,y)] = first;
	  		}
	  	}
		return start;
	}
}
