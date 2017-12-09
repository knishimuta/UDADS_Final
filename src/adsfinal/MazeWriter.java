// Kyle Nishimuta


package adsfinal;

import java.util.ArrayList;
import java.util.HashMap;

public class MazeWriter {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	static void  buildMaze(int[][][] b) {
		
		System.out.println("\n ~~~~~~~~~~~ Begin buildMaze feedback. ~~~~~~~~~~~ \n");
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

		ArrayList<ArrayList> unusedVertices = new ArrayList<ArrayList>();

		// Fill unusedVertices with the blank vertices in the maze

		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[i].length; j++) {
				if(!arrayContains(b[i][j], 1)) {
					ArrayList<Integer> vertexID = new ArrayList<Integer>();
					vertexID.add(i);
					vertexID.add(j);

					// Adding direction data to vertices
					for(int direction = 0; direction < 4; direction++) {
						vertexID.add(direction);
					}
					System.out.println("Adding {" + vertexID.get(0) + ", " + vertexID.get(1) + "}"
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
			ArrayList<Integer> item = unusedVertices.get(i);
			System.out.print(item.get(0) + ", " + item.get(1) + "} ");
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
			int x = initialVertex.get(0);
			int y = initialVertex.get(1);
			System.out.println("Vertices left: "+ unusedVertices.size());
			System.out.println("Index of vertex to use: " + vertexToUse);
			System.out.println("Vertex chosen: {" + x + ", " + y + "}");

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
			System.out.println("Number of directions to choose from: " + availableDirections.size());
			System.out.print("Available Directions:");
			for(int i = 0; i < availableDirections.size(); i++) {
				System.out.print(" " + availableDirections.get(i));
			}
			System.out.println("");
			System.out.println("Direction chosen: " + chosenDirection + "\n");

			if(chosenDirection == 0) {
				b[x][y][0] = 1;
				b[x][y+1][2] = 1;

				if(y == 1) {
					b[x][y+1][0] = 1;
					b[x][y+2][2] = 1;

					for(int i = 0; i < unusedVertices.size(); i++) {
						ArrayList<Integer> thisVertex = unusedVertices.remove(i);
						ArrayList<Integer> thisVertexDirections = new ArrayList<Integer>();
						for(int j = 2; j < thisVertex.size(); j++) {
							thisVertexDirections.add(thisVertex.get(j));
						}
						if((thisVertex.get(0) == 2) && (thisVertexDirections.contains(3))) {
							thisVertex.remove(3);
						}
						if((thisVertex.get(0) == 1) && (thisVertexDirections.contains(1))) {
							thisVertex.remove(1);
						}
						unusedVertices.add(thisVertex);
					}
				}


			}
			if(chosenDirection == 1) {
				b[x][y][1] = 1;
				b[x+1][y][3] = 1;

				if(x == 1) {
					b[x+1][y][1] = 1;
					b[x+2][y][3] = 1;
				}
			}
			if(chosenDirection == 2) {
				b[x][y][2] = 1;
				b[x][y-1][0] = 1;

				if(y == 2) {
					b[x][y-1][2] = 1;
					b[x][y-2][0] = 1;
				}
			}
			if(chosenDirection == 3) {
				b[x][y][3] = 1;
				b[x-1][y][1] = 1;

				if(x == 2) {
					b[x-1][y][3] = 1;
					b[x-2][y][1] = 1;
				}
			}

		}

		System.out.println("");
		Maze.drawBoard(b);

		System.out.println(" ~~~~~~~~~~~ End buildMaze feedback. ~~~~~~~~~~~ \n");
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