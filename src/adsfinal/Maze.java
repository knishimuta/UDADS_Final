package adsfinal;

import javax.swing.JFrame;

public class Maze extends JFrame{
	static int N = 6;
	/*
	public static int[][][] board =
		{
				{{1,1,0,0},{1,0,1,0},{1,0,1,0},{0,1,1,0}}, //Line 0
				{{0,1,0,0},{0,0,0,0},{0,0,0,0},{0,1,0,0}}, //Line 1
				{{0,1,0,1},{0,0,0,0},{0,0,0,0},{0,1,0,1}}, //Line 2
				{{1,0,0,1},{0,0,1,0},{1,0,0,0},{0,0,1,1}}  //Line 3
		};
		*/

	public static void main(String[] args) {
		
		
		drawBoard(MazeWriter.removeWall(MazeWriter.buildMaze(N), 1, 2, 1));
		
	}

	

	public static void drawBoard(int[][][] b) {
		for(int y = N-1; y >=0; y--) {
			for(int x = 0; x < N; x++) {
				System.out.print("X");
				if(b[x][y][1] == 1) {
					System.out.print("*****");
				} else {
					System.out.print("     ");
				}
			}
			System.out.println("");
			for(int i = 0; i < 3; i++) {
				for(int x = 0; x < N; x++) {
					if(b[x][y][2] == 1)
						System.out.print("*");
					else
						System.out.print(" ");

					System.out.print("     ");
				}
				System.out.println("");
			}
		}
	}

	/*public static void neighborsOf(int x, int y) {
		System.out.printf("Neighbors of (%d, %d)\n", x, y);
		if(board[x][y+1][1] == 0) System.out.println("N");
		if(board[x+1][y][0] == 0) System.out.println("E");
		if(board[x][y][1] == 0) System.out.println("S");
		if(board[x][y][0] == 0) System.out.println("W");
	}

*/

}
