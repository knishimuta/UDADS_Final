// Kyle Nishimuta


package adsfinal;

import java.util.ArrayList;

public class MazeWriter {

	static void  buildMaze(int[][][] b) {
		/*
		 * NOTE --> Written based on the assumption that the maze is square
		 */

		/*
		 * Builds maze using initial maze as base:
		 *  - Choose random vertex in maze that is not 
		 *    connected to a wall
		 *  - Run a line from the vertex until it hits
		 *    a wall
		 *  - Make the line into a wall
		 *  - Repeat until there are no empty points to
		 *    choose from
		 */

		ArrayList<int[]> unusedVertices = new ArrayList<int[]>();

		// Fill unusedVertices with the blank vertices in the maze

		/*
		 * itemNum stores the vertices as references to two arrays:
		 * itemNum[0] references the column of the vertex (b[i])
		 * itemNum[1] references the index of the vertex within the
		 *  column (b[i][j])
		 */
		int[] vertexID = new int[2];
		for(int i = 0; i < b.length; i++) {
			vertexID[0] = i; // column number
			for(int j = 0; j < b[i].length; j++) {
				if(arrayContains(b[i][j], 1)) {
					continue;
				}
				else {
					vertexID[1] = j; // row number
					unusedVertices.add(vertexID);
					System.out.println("Added {" + vertexID[0] + ", " + vertexID[1] + "}"
							+ " as unused vertex");
				}
			}
		}


		/*
		 * Pick random unused vertex and use it to spawn a wall
		 * in a random direction, until it hits another wall.
		 * Removed used vertex and repeat for remaining vertices.
		 */

		while(!unusedVertices.isEmpty()) {
			int vertexToUse = pickRandNumber(0, unusedVertices.size() - 1);
			System.out.println("Vertices left: "+ unusedVertices.size());
			System.out.println("Vertex to use: " + vertexToUse + "\n");
			/*
			 *     0           N
			 *   3 + 1  -->  W + E
			 *     2           S
			 */
			int directionToGo = pickRandNumber(0, 3);
			int[] initalVertex = unusedVertices.remove(vertexToUse);
			if(directionToGo == 0) {
				
				
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
	static int pickRandNumber(int lowerBound, int upperBound) {
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

}