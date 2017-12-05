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

		ArrayList<Integer[]> unusedVertices = new ArrayList<Integer[]>();

		// Fill unusedVertices with the unused vertices in the maze

		/*
		 * itemNum stores the vertices as references to two arrays:
		 * itemNum[0] references the column of the vertex (b[i])
		 * itemNum[1] references the index of the vertex within the
		 *  column (b[i][j])
		 */
		int[] itemNum = new int[2];
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[i].length; j++) {

			}
		}


	}
}