package adsfinal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class MazeRunner {
	
	static HashMap<int[],int[]> parent = new HashMap<int[],int[]>();
	static int[] rob = {0,0};		
	static int[] end = {2,1};
	
	/*
	 * Joan to do:
	 * -Use board from Maze.java to find “neighbors” s.t. 1 means wall and 0 means neighbor that “bug” can move to
	 * -Use linked list to get queue going for breadth first search to find shortest pathway

	 */
	
	public static void main(String[] args) {
		
	}

	public int[] nextStep(int[] initLoc) {
	  	LinkedList<int[]> queue = new LinkedList<int[]>();
	  	HashSet<int[]> visited = new HashSet<int[]>();
	  	queue.add(rob);
	  	visited.add(rob);
	  	while(!queue.isEmpty()) {
	  		int[] first = queue.remove();
	  		if(Arrays.equals(first, end)) {
	  			return findPath(end);
	  		}
	  		else {
	  			int x = first[0];
		  		int y = first[1];
		  		int[] north = new int[] {x,y+1};
		  		int[] east = new int[] {x+1,y};
		  		int[] south = new int[] {x,y-1};
		  		int[] west = new int[] {x-1,y};
		  		if((MazeBoard.board[x][y][0]==0) && (!visited.contains(north))) {
		  			visited.add(north);
		  			parent.put(north,first);
		  		}
		  		if((MazeBoard.board[x][y][1]==0) && (!visited.contains(east))) {
		  			visited.add(east);
		  			parent.put(east, first);
		  		}
		  		if((MazeBoard.board[x][y][2]==0) && (!visited.contains(south))) {
		  			visited.add(south);
		  			parent.put(south, first);
		  		}
		  		if((MazeBoard.board[x][y][3]==0) && (!visited.contains(west))) {
		  			visited.add(west);
		  			parent.put(west, first);
		  		}
		  	}
		}
	}
	
	public int[] findPath(int[] exit) {
		int[] current = exit;
		if(Arrays.equals(parent.get(exit),rob)) {
			current = exit;
		}
		else while(!Arrays.equals(parent.get(current), rob)) {
			current = parent.get(current);
		}
		return current;
		
	}
}
