// Kyle Nishimuta


package adsfinal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class MazeWriter {

	static void  buildMaze(int N) {
		
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
				int[] newPoint = {i, j};
				unusedVertices.add(N*j + i);
				System.out.println("Added (" + i + ", " + j + ")");
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
					Maze.drawBoard(b);
				}
			}
			
			
		}

		Maze.drawBoard(b);
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

}