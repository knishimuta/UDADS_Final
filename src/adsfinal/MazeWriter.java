// Kyle Nishimuta


package adsfinal;

import java.util.ArrayList;
import java.util.HashMap;

public class MazeWriter {

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

		HashMap<int[], HashMap<Integer, Boolean>> unusedVertices = new HashMap<int[], HashMap<Integer, Boolean>>();
		ArrayList<int[]> keyChoices = new ArrayList<int[]>();

		// Fill unusedVertices with the blank vertices in the maze

		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[i].length; j++) {
				if(!arrayContains(b[i][j], 1)) {
					int[] coordinates = {i, j};
					unusedVertices.put(coordinates, addDirections(coordinates));
					keyChoices.add(coordinates);
				}
				else {
					continue;
				}

			}
		}


		/*
		 * Pick random unused vertex and use it to spawn a wall
		 * in a random direction, until it hits another wall.
		 * Removed used vertex and repeat for remaining vertices.
		 */

		while(!unusedVertices.isEmpty()) {
			int randVertexIndex = pickRandNumber(0, keyChoices.size()-1);
			int[] thisVertex = keyChoices.remove(randVertexIndex);
			HashMap<Integer, Boolean> thisVertexDirections = unusedVertices.remove(thisVertex);

			int x = thisVertex[0];
			int y = thisVertex[1];


			ArrayList<Integer> possibleDirections = new ArrayList<Integer>();
			for(int i = 0; i < 4; i++) {
				if(thisVertexDirections.containsKey(i)) {
					possibleDirections.add(i);
				}
				else {
					continue;
				}
			}
			int thisDirection = possibleDirections.get(pickRandNumber(0, possibleDirections.size()-1));

			/*
			 * Now to make the walls!
			 * 
			 *     0           N
			 *   3 + 1  -->  W + E
			 *     2           S
			 */
			if(thisDirection == 0) {
				b[x][y][0] = 1;
				b[x][y + 1][2] = 1;

				if((thisVertexDirections.get(thisDirection) /*== true*/) && (y == 1)){
					b[x][y + 1][0] = 1;
					b[x][y + 2][2] = 1;
					
					if(x == 1) {
						removeDirection(unusedVertices, keyChoices, 3);
					}
					else {
						removeDirection(unusedVertices, keyChoices, 1);
					}
				}
			}
			
			if(thisDirection == 1) {
				b[x][y][1] = 1;
				b[x + 1][y][3] = 1;

				if((thisVertexDirections.get(thisDirection)) && (x == 1)){
					b[x + 1][y][1] = 1;
					b[x + 2][y][3] = 1;
					
					if(y == 1) {
						removeDirection(unusedVertices, keyChoices, 2);
					}
					else {
						removeDirection(unusedVertices, keyChoices, 0);
					}
				}
			}
			if(thisDirection == 2) {
				b[x][y][2] = 1;
				b[x][y - 1][0] = 1;

				if((thisVertexDirections.get(thisDirection)) && (y == 2)){
					b[x][y - 1][2] = 1;
					b[x][y - 2][0] = 1;
					
					if(x == 1) {
						removeDirection(unusedVertices, keyChoices, 3);
					}
					else {
						removeDirection(unusedVertices, keyChoices, 1);
					}
				}
			}
			
			if(thisDirection == 3) {
				b[x][y][3] = 1;
				b[x - 1][y][1] = 1;

				if((thisVertexDirections.get(thisDirection)) && (x == 2)){
					b[x - 1][y][3] = 1;
					b[x - 2][y][1] = 1;
					
					if(y == 1) {
						removeDirection(unusedVertices, keyChoices, 2);
					}
					else {
						removeDirection(unusedVertices, keyChoices, 0);
					}
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

	static HashMap<Integer, Boolean> addDirections(int[] coor){
		HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();

		if(coor[0] == 1) {
			hm.put(1, true);
			hm.put(3, false);
		}
		if(coor[0] == 2) {
			hm.put(3, true);
			hm.put(1, false);
		}
		if(coor[1] == 1) {
			hm.put(0, true);
			hm.put(2, false);
		}
		if(coor[1] == 2) {
			hm.put(2, true);
			hm.put(0, false);
		}

		return hm;
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