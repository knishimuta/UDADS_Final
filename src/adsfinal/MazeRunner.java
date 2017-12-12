package adsfinal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class MazeRunner {

	static HashMap<Integer,Integer> parent = new HashMap<Integer,Integer>();
	static int[] rob = {0,0};		
	static int robInt = 1000*rob[0] + rob[1];
	static int[] end = {MazePanel.N - 1, 1};

	public static void main(String[] args) {
		MazeBoard mb = new MazeBoard();
		System.out.println(Arrays.toString(nextStep(mb.board, rob, end)));
	}

	public static int[] nextStep(int[][][] board, int[] initLoc, int[] exit) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		int robInt = 1000*rob[0] + rob[1];
		int endInt = 1000*end[0] + end[1];
		queue.add(robInt);
		visited.add(robInt);
		while(!queue.isEmpty()) {
			int first = queue.remove();
			if(first==endInt) {
				return findPath(end);
			}
			else {
				int x = first / 1000;
				int y = first % 1000;
				int north = 1000*x + (y+1);
				int east = 1000*(x+1) + y;
				int south = 1000*x + (y-1);
				int west = 1000*(x-1) + y;
				if((board[x][y][0]==0) && (!visited.contains(north))) {
					visited.add(north);
					parent.put(north, first);
					queue.add(north);
				}
				if((board[x][y][1]==0) && (!visited.contains(east))) {
					visited.add(east);
					parent.put(east, first);
					queue.add(east);
				}
				if((board[x][y][2]==0) && (!visited.contains(south))) {
					visited.add(south);
					parent.put(south, first);
					queue.add(south);
				}
				if((board[x][y][3]==0) && (!visited.contains(west))) {
					visited.add(west);
					parent.put(west, first);
					queue.add(west);
				}
			}
		}
		return null;
	}

	public static int[] findPath(int[] exit) {
		int current = 1000*exit[0] + exit[1];
		if(parent.get(1000*exit[0] + exit[1])==(robInt)) {
			return exit;
		}
		else 
			while(parent.get(current) != robInt) {
				current = parent.get(current);
			}
		return new int[] {current/1000, current % 1000};

	}
}
