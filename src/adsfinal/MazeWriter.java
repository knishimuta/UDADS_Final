// Kyle Nishimuta


package adsfinal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MazeWriter {

	static int[][][] buildMaze(int N) {

		int[][][] b = new int[N][N][4];

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				b[i][j][0] = 0;
				b[i][j][1] = 0;
				b[i][j][2] = 0;
				b[i][j][3] = 0;
			}
		}

		for(int i = 0; i < N-1; i++) {
			b[i][0][1] = 1;
			b[i+1][0][3] = 1;

			b[i][N-1][1] = 1;
			b[i+1][N-1][3] = 1;
		}

		for(int j = 0; j < N-1; j++) {
			b[0][j][0] = 1;
			b[0][j+1][2] = 1;

			b[N-1][j][0] = 1;
			b[N-1][j+1][2] = 1;
		}


		ArrayList<Integer> unusedVertices = new ArrayList<Integer>();

		for(int i = 1; i < N-1; i++) {
			for(int j = 1; j < N-1; j++) {
				unusedVertices.add(N*j + i);
			}
		}

		while(!unusedVertices.isEmpty()) {
			int current = unusedVertices.get(pickRandNum(0, unusedVertices.size()-1));
			;
			int direction = pickRandNum(0, 3);

			while(unusedVertices.contains(current)) {
				unusedVertices.remove((Integer) current);
				int x = current % N;
				int y = current / N;
				if(direction == 0) {
					b[x][y][0] = 1;
					b[x][y+1][2] = 1;

					//current[0] = x;
					//current[1] = y+1;
					current = N*(y+1) + x;
				}
				if(direction == 1) {
					b[x][y][1] = 1;
					b[x+1][y][3] = 1;

					//current[0] = x;
					//current[1] = y+1;
					current = N*y + (x+1);
				}
				if(direction == 2) {
					b[x][y][2] = 1;
					b[x][y-1][0] = 1;

					//current[0] = x;
					//current[1] = y+1;
					current = N*(y-1) + x;
				}
				if(direction == 3) {
					b[x][y][3] = 1;
					b[x-1][y][1] = 1;

					//current[0] = x;
					//current[1] = y+1;
					current = N*y + (x-1);
				}
			}


		}
		return b;
	}

	static int[][][] removeWall(int[][][] b, int x, int y, int dir){

		/*
		 * 0. Check that wall is movable (i.e. that the wall
		 *    exists and that it is not an edge)
		 * 1. Remove wall (make sure to remove both directions of 
		 *    wall)
		 * 2. Add wall in random location
		 * 3. Look for cycle
		 * 4. Remove wall that is a member of cycle but is not the
		 *    wall that was just added
		 */

		/*
		 * This is the height of the maze only,  but since the maze
		 * should be square it shouldn't matter whether the height
		 * or width is chosen. N should apply to both.
		 */
		int N = b.length; 

		// Checks to see if selected wall is an edge.
		if(isEdge(b, x, y, dir)){
			System.out.println("Cannot change edges. Please try again.");
			return b;
		}
		else {

			// Checks to see if selected wall is empty.
			if(b[x][y][dir] != 1) {
				System.out.println("That wall does not exist. Please try again.");
				return b;
			}
			else {


				// Removing selected wall.
				changeWalls(b, x, y, dir, false);

				// Make new wall
				int newX = pickRandNum(1, N-2);
				int newY = pickRandNum(1, N-2);
				int newDir = pickRandNum(0, 3);
				while(b[newX][newY][newDir] == 1) {
					newX = pickRandNum(1, N-2);
					newY = pickRandNum(1, N-2);
					newDir = pickRandNum(0, 3);
				}
				changeWalls(b, newX, newY, newDir, true);

				//check for cycles
				HashSet<int[]> visited = new HashSet<int[]>();
				

				System.out.println("Changed (" + x + ", " + y + ") in direction " + dir);
				return b;
			}
		}
	}

	static boolean arrayContains(int[] array, int x) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == x) {
				return true;
			}
		}
		return false;
	}

	// interval is inclusive 
	static int pickRandNum(int lowerBound, int upperBound) {
		int number = 0;
		if(lowerBound > upperBound){
			System.out.println("Please ensure that you enter your lower bound and then upper bound");
			return 0;
		}
		double interval = upperBound - lowerBound;
		number = (int) Math.round(Math.random()*interval);
		number = number + lowerBound;

		return number;

	}

	static void removeDirection(HashMap<int[], HashMap<Integer, Boolean>> vertices, ArrayList<int[]> keys, int directionToRemove) {
		for(int i = 0; i < keys.size(); i++) {
			HashMap<Integer, Boolean> vertexDirections = vertices.get(keys.get(i));
			if(vertexDirections.containsKey(directionToRemove)) {
				vertexDirections.remove(directionToRemove);
			}
		}
	}

	static boolean isEdge(int[][][] b, int x, int y, int dir) {
		if(y == 0) {
			if(dir == 1 || dir == 3) {
				return true;
			}
		}
		if(y == b.length - 1) {
			if(dir == 1 || dir == 3) {
				return true;
			}
		}
		if(x == 0) {
			if(dir == 0 || dir == 2) {
				return true;
			}
		}
		if(x == b[x].length - 1) {
			if(dir == 0 || dir == 2) {
				return true;
			}
		}
		return false;
	}

	//boolean condition determines whether the function adds walls or removes them
	static void changeWalls(int[][][] board, int x, int y, int dir, boolean add) { 
		if(add) {
			if(dir == 0) {
				board[x][y][0] = 1;
				board[x][y+1][2] = 1;
			}
			if(dir == 1) {
				board[x][y][1] = 1;
				board[x+1][y][3] = 1;
			}
			if(dir == 2) {
				board[x][y][2] = 1;
				board[x][y-1][0] = 1;
			}
			if(dir == 3) {
				board[x][y][3] = 1;
				board[x-1][y][1] = 1;
			}
		}
		else {
			if(dir == 0) {
				board[x][y][0] = 0;
				board[x][y+1][2] = 0;
			}
			if(dir == 1) {
				board[x][y][1] = 0;
				board[x+1][y][3] = 0;
			}
			if(dir == 2) {
				board[x][y][2] = 0;
				board[x][y-1][0] = 0;
			}
			if(dir == 3) {
				board[x][y][3] = 0;
				board[x-1][y][1] = 0;
			}
		}

	}


	static boolean containsCycles(int[][][] board) {
		
		return true;
	}

	/* 
	 * Returns neighbors (neighboring coordinates linked by wall) in 
	 * form of ArrayList of neighbors
	 */
	static ArrayList<int[]> getNeighbors(int[][][] board, int x, int y) {
		ArrayList<int[]> neighbors = new ArrayList<int[]>();
		int[] coordinates = new int[2];
		if(board[x][y][0] == 1) {
			coordinates[0] = x;
			coordinates[1] = y+1;
		}
		if(board[x][y][1] == 1) {
			coordinates[0] = x+1;
			coordinates[1] = y;
		}
		if(board[x][y][2] == 1) {
			coordinates[0] = x;
			coordinates[1] = y-1;
		}
		if(board[x][y][3] == 1) {
			coordinates[0] = x-1;
			coordinates[1] = y;
		}
		return neighbors;
	}
}