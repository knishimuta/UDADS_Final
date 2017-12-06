// Kyle Nishimuta


package adsfinal;

import java.util.ArrayList;

public class MazeWriter {

	static void  buildMaze(int[][][] b) {
		/**
		 * NOTE --> Written based on the assumption that the maze is square
		 */

		/**
		 * Builds maze using initial maze as base:
		 *  - Choose random vertex in maze that is not 
		 *    connected to a wall
		 *  - Run a wall from the vertex until it hits
		 *    another wall
		 *  - Repeat until there are no empty points to
		 *    choose from
		 */

		ArrayList<int[]> unusedVertices = new ArrayList<int[]>();

		// Fill unusedVertices with the blank vertices in the maze

		/**
		 * itemNum stores the vertices as references to two arrays:
		 * itemNum[0] references the column of the vertex (b[i])
		 * itemNum[1] references the index of the vertex within the
		 *  column (b[i][j])
		 */
		
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[i].length; j++) {
				if(!arrayContains(b[i][j], 1)) {
					int[] vertexID = new int[2];
					vertexID[0] = i;
					vertexID[1] = j;
					System.out.println("Adding {" + vertexID[0] + ", " + vertexID[1] + "}"
							+ " as unused vertex");
					unusedVertices.add(vertexID);
				}
				else {
					continue;
				}
				
			}
		}
		
		System.out.print("List of unused vertices: ");
		for(int i = 0; i < unusedVertices.size(); i++) {
			System.out.print("{");
			int[] item = unusedVertices.get(i);
			System.out.print(item[0] + ", " + item[1] + "} ");
		}
		System.out.println("\n");

		/*
		 * Pick random unused vertex and use it to spawn a wall
		 * in a random direction, until it hits another wall.
		 * Removed used vertex and repeat for remaining vertices.
		 */

		while(!unusedVertices.isEmpty()) {
			int vertexToUse = pickRandNumber(0, unusedVertices.size() - 1);
			int[] initialVertex = unusedVertices.remove(vertexToUse);
			System.out.println("Vertices left: "+ unusedVertices.size());
			System.out.println("Index of vertex to use: " + vertexToUse);
			System.out.println("Vertex chosen: {" + initialVertex[0] + ", " + initialVertex[1] + "}");

			/*
			 *     0           N
			 *   3 + 1  -->  W + E
			 *     2           S
			 */
			int directionToGo = pickRandNumber(0, 3);
			System.out.println("Direction to go: " + directionToGo + "\n");
			if(directionToGo == 0) {
				b[initialVertex[0]][initialVertex[1]][0] = 1;
				b[initialVertex[0]][initialVertex[1]+1][2] = 1;
				if(initialVertex[1] < b[initialVertex[0]][initialVertex[1]].length - 2) {
					b[initialVertex[0]][initialVertex[1]+1][0] = 1;
					b[initialVertex[0]][initialVertex[1]+2][2] = 1;
				}
			}
			if(directionToGo == 1) {
				b[initialVertex[0]][initialVertex[1]][1] = 1;
				b[initialVertex[0]+1][initialVertex[1]][3] = 1;
				if(initialVertex[0] < b[initialVertex[0]][initialVertex[1]].length - 2) {
					b[initialVertex[0]+1][initialVertex[1]][1] = 1;
					b[initialVertex[0]+2][initialVertex[1]][3] = 1;
				}
			}
			
			if(directionToGo == 2) {
				b[initialVertex[0]][initialVertex[1]][2] = 1;
				b[initialVertex[0]][initialVertex[1]-1][0] = 1;
				if(initialVertex[1] > 1) {
					b[initialVertex[0]][initialVertex[1]-1][2] = 1;
					b[initialVertex[0]][initialVertex[1]-2][0] = 1;
				}
			}
			
			if(directionToGo == 3) {
				b[initialVertex[0]][initialVertex[1]][3] = 1;
				b[initialVertex[0]-1][initialVertex[1]][1] = 1;
				if(initialVertex[0] > 1) {
					b[initialVertex[0]-1][initialVertex[1]][3] = 1;
					b[initialVertex[0]-2][initialVertex[1]][1] = 1;
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