// Kyle Nishimuta


package adsfinal;

import java.util.ArrayList;

public class MazeWriter {

	static void  buildMaze(int[][][] b) {
		/*
		 * IMPORTANT --> Written based on the assumption that the maze is square
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

		ArrayList<Integer> unusedVertices = new ArrayList<Integer>();

		// Fill unusedVertices with the unused vertices in the maze
		int numItems = 0;
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[i].length; j++) {
				unusedVertices.add(numItems);
				System.out.println("Added " + numItems + " to list of vertices");
				numItems++;
			}
		}
		
		// Remove vertices that are on edges
		double verticesDouble = numItems;
		for(int i = 0;) {
			
		}
			
		// Make first wall
		
		
		

	}
}