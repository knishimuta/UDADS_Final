// Kyle Nishimuta


package adsfinal;

import java.util.ArrayList;
import java.util.HashMap;

public class MazeWriter {

	@SuppressWarnings({ "unchecked", "rawtypes" })
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

		HashMap<int[], ArrayList> unusedVertices = new HashMap<int[], ArrayList>();

		// Fill unusedVertices with the blank vertices in the maze

		/**
		 * itemNum stores the vertices as references to two arrays:
		 * itemNum[0] references the column of the vertex (b[i])
		 * itemNum[1] references the index of the vertex within the
		 *  column (b[i][j])
		 *  
		 *  UPDATE:
		 *  itemNum is now a HashMap. Key is an integer array of
		 *  pseudo-coordinates linked to an ArrayList the  available 
		 *  directions that the vertex can go.
		 */

		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[i].length; j++) {
				if(!arrayContains(b[i][j], 1)) {
					int[] vertexID = new int[2];
					ArrayList<Integer> vertexDir = new ArrayList<Integer>();
					vertexID[0] = i;
					vertexID[1] = j;

					// Adding direction data to vertices
					for(int direction = 0; direction < 4; direction++) {
						vertexDir.add(direction);
					}
					System.out.println("Adding {" + vertexID[0] + ", " + vertexID[1] + "}"
							+ " as unused vertex");
					unusedVertices.put(vertexID, vertexDir);
				}
				else {
					continue;
				}

			}
		}

		System.out.print("List of unused vertices: ");
		for(int i = 0; i < unusedVertices.size(); i++) {
			System.out.print("{");
			ArrayList<Integer> item = unusedVertices.get(i);
			System.out.print(item.get(0) + ", " + item.get(0) + "} ");
		}
		System.out.println("\n");

		/*
		 * Pick random unused vertex and use it to spawn a wall
		 * in a random direction, until it hits another wall.
		 * Removed used vertex and repeat for remaining vertices.
		 */

		while(!unusedVertices.isEmpty()) {
			int vertexToUse = pickRandNumber(0, unusedVertices.size() - 1);
			ArrayList<Integer> initialVertex = unusedVertices.remove(vertexToUse);
			System.out.println("Vertices left: "+ unusedVertices.size());
			System.out.println("Index of vertex to use: " + vertexToUse);
			System.out.println("Vertex chosen: {" + initialVertex.get(0) + ", " + initialVertex.get(1) + "}");

			/*
			 * Now to make the walls!
			 * 
			 *     0           N
			 *   3 + 1  -->  W + E
			 *     2           S
			 */
			ArrayList<Integer> availableDirections = new ArrayList<Integer>();
			for(int i = 2; i < initialVertex.size(); i++) {
				availableDirections.add(initialVertex.get(i));
			}
			int chosenDirection = pickRandNumber(0, availableDirections.size()-1);
			System.out.println("Direction chosen: " + chosenDirection + "\n");
			
			if(chosenDirection == 0) {
				b[initialVertex.get(0)][initialVertex.get(1)][0] = 1;
				b[initialVertex.get(0)][initialVertex.get(1)+1][2] = 1;
				
				if(initialVertex.get(1) < b[initialVertex.get(0)].length - 2) {
					
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