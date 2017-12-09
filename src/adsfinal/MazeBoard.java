package adsfinal;


import java.util.Random;
import java.util.LinkedList;
import java.util.Arrays;

public class MazeBoard{
	static int WIDTH = 3;
	static int HEIGHT = 3;
	public static int[][][] board = new int[WIDTH][HEIGHT][4];
	static boolean[][] visited = new boolean[WIDTH][HEIGHT];

	public static void main(String[] args){
		Random random = new Random(); // For random numbers

		// build board with walls in all possible locations
		// Also mark all boards as unvisited
		for(int x = 0; x < WIDTH; x++){
			for(int y = 0; y < HEIGHT; y++){
				for(int d = 0; d < 4; d++){
					board[x][y][d] = 1;
				}
				visited[x][y] = false;
			}
		}

		// start our maze at a random point
		int xstart = (random.nextInt() % WIDTH + WIDTH) % WIDTH;
		int ystart = (random.nextInt() % HEIGHT + HEIGHT) % HEIGHT;
		System.out.printf("%d, %d\n", xstart, ystart);
		visited[xstart][ystart] = true;

		// Create a queue, and do a BFS to build the maze
		LinkedList<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {xstart, ystart});
		while(q.size() > 0){
			// grab the front of the queue
			int[] v = q.remove();
			int x = v[0];
			int y = v[1];
			// check neighbors in random order
			int dstart = random.nextInt() % 4;
			for(int i = 0; i < 4; i++){
				int dir = (dstart + i) % 4;
				if(dir == 0 && y < HEIGHT  - 1 && !visited[x][y+1]){ // North
					visited[x][y+1] = true;
					board[x][y][0] = 0;
					board[x][y+1][2] = 0;
					q.add(new int[] {x, y+1});
				}
				if(dir == 2 && y > 0 && !visited[x][y-1]){ // South
					visited[x][y-1] = true;
					board[x][y][2] = 0;
					board[x][y-1][0] = 0;
					q.add(new int[] {x, y-1});
				}
				if(dir == 3 && x > 0 && !visited[x-1][y]){ // West
					visited[x-1][y] = true;
					board[x][y][3] = 0;
					board[x-1][y][1] = 0;
					q.add(new int[] {x-1, y});
				}
				if(dir == 1 && x < WIDTH-1 && !visited[x+1][y]){ // East
					visited[x+1][y] = true;
					board[x][y][1] = 0;
					board[x+1][y][3] = 0;
					q.add(new int[] {x+1, y});
				}
			}
		}

		// Print the board
		for(int x = 0; x < WIDTH; x++){
			for(int y = 0; y < HEIGHT; y++){
				String theBS = Arrays.toString(board[x][y]);
				System.out.println(theBS);
//				int lBS = theBS.length();
				String numsOfBS = theBS.replaceAll("[^0-9]", "");
//				System.out.println("Nums:" + numsOfBS + ".  length orig.:" + lBS);
//				System.out.printf("(%d, %d): %s\n", x, y, Arrays.toString(board[x][y]));
//				System.out.println(Arrays.toString(board[x][y]));
				visited[x][y] = false;
			}
		}
	}
}
