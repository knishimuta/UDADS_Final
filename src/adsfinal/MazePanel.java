package adsfinal;

import java.awt.*;
import java.util.Arrays;

import java.util.Random;
import java.util.LinkedList;

import javax.swing.*;

public class MazePanel extends JPanel{



	//Initiate global variables
	static int MPWIDTH = 700;
	static int MPHEIGHT = MPWIDTH;
	static int N = 41;
	static int TILEWIDTH = MPWIDTH/N;
	static int TILEHEIGHT = MPHEIGHT/N;

//	static int BUFFER = 5;

	public static int[][][] board = MazeWriter.buildMaze(N);
//	static boolean[][] visited = new boolean[mbWIDTH][mbHEIGHT];

	FullFrame parent = null;

	//CONSTRUCTOR
	public MazePanel(FullFrame parent){
		//set dimension and layout type
		this.setPreferredSize(new Dimension(MPWIDTH,MPHEIGHT));
		this.setLayout(new BorderLayout());


	}




	@Override
	public void paint(Graphics gg) {
		//draw background to draw maze on top of
		Graphics2D bom = (Graphics2D) gg; //bom == background of maze
		bom.setColor(new java.awt.Color(234, 212, 249)); //light purple
		for(int i = 0; i < N-1; i++) {
			for(int j = 0; j < N-1; j++) {
				bom.drawRect(i*TILEWIDTH, j*TILEHEIGHT+TILEHEIGHT, TILEWIDTH, TILEHEIGHT);
			}
		}
		
//		mazeBoard();
		
		//draw walls of maze based off of MazeWriter.java
		Graphics2D wm = (Graphics2D) gg; //wm == walls of maze
		wm.setColor(new java.awt.Color(30,200,30)); //green
		wm.setStroke(new BasicStroke(4)); //thicker line
		
		for(int x=0; x<N; x++) {
			for(int y=0; y<N; y++) {
				
				int alpha = x*TILEWIDTH;
				int beta = (N-y)*TILEHEIGHT;
				
				if(board[x][y][0] == 1)
					wm.drawLine(alpha, beta, 
							alpha, beta-TILEHEIGHT);
				
				if(board[x][y][1] == 1)
					wm.drawLine(alpha+TILEWIDTH, beta, alpha, beta);
				
				if(board[x][y][2] == 1)
					wm.drawLine(alpha, beta, alpha, beta+TILEHEIGHT);
				
				if(board[x][y][3] == 1)
					wm.drawLine(alpha, beta, alpha-TILEHEIGHT, beta);
						
			}
		}
		
		//draw exit
		Graphics2D em = (Graphics2D) gg; //em == exit of maze
		em.setColor(new java.awt.Color(237, 237, 237)); //off-white
		em.setStroke(new BasicStroke(4)); //thicker line
		
		em.drawLine(N*TILEWIDTH-TILEWIDTH, N*TILEHEIGHT-TILEHEIGHT, N*TILEWIDTH-TILEWIDTH, N*TILEHEIGHT-2*TILEHEIGHT);
		
		
		//draw rob bug
		Graphics2D bm = (Graphics2D) gg; 
		
		bm.setColor(new java.awt.Color(32, 135, 135));
		
//		bm.fillRect((TILEWIDTH/4), (N*TILEHEIGHT)-(TILEHEIGHT/4)- TILEHEIGHT/2, TILEWIDTH/2, TILEHEIGHT/2);
		bm.fillOval((TILEWIDTH/4), (N*TILEHEIGHT)-(TILEHEIGHT/4)- TILEHEIGHT/2, TILEWIDTH/2, TILEHEIGHT/2);
		
//		while(!Arrays.equals(MazeRunner.rob, MazeRunner.end)) {
//			moveRob();
//			int robx = MazeRunner.rob[0];
//			int roby = MazeRunner.rob[1];
//			
//			bm.setColor(new java.awt.Color(32, 135, 135));
//			bm.fillRect((TILEWIDTH/4) + robx, (N*TILEHEIGHT)-(TILEHEIGHT/4)-roby- TILEHEIGHT/2, TILEWIDTH/2, TILEHEIGHT/2);
//			
//		}
		
		
		
	}
//
//	public static void moveRob() {
//		MazeRunner.rob = MazeRunner.nextStep(board, MazeRunner.rob, MazeRunner.end);
//	}

}





















//new method with functionality of MazeBoard.java so that it can have 
//control of all the stuff and use it later on to draw stuff 
//public static void mazeBoard() {
//
//
////	public static void main(String[] args){
//	Random random = new Random(); // For random numbers
//
//	// build board with walls in all possible locations
//	// Also mark all boards as unvisited
//	for(int x = 0; x < mbWIDTH; x++){
//		for(int y = 0; y < mbHEIGHT; y++){
//			for(int d = 0; d < 4; d++){
//				board[x][y][d] = 1;
//			}
//			visited[x][y] = false;
//		}
//	}
//
//	// start our maze at a random point
//	int xstart = (random.nextInt() % mbWIDTH + mbWIDTH) % mbWIDTH;
//	int ystart = (random.nextInt() % mbHEIGHT + mbHEIGHT) % mbHEIGHT;
//	System.out.printf("%d, %d\n", xstart, ystart);
//	visited[xstart][ystart] = true;
//
//	// Create a queue, and do a BFS to build the maze
//	LinkedList<int[]> q = new LinkedList<int[]>();
//	q.add(new int[] {xstart, ystart});
//	while(q.size() > 0){
//		// grab the front of the queue
//		int[] v = q.remove();
//		int x = v[0];
//		int y = v[1];
//		// check neighbors in random order
//		int dstart = random.nextInt() % 4;
//		for(int i = 0; i < 4; i++){
//			int dir = (dstart + i) % 4;
//			if(dir == 0 && y < mbHEIGHT  - 1 && !visited[x][y+1]){ // North
//				visited[x][y+1] = true;
//				board[x][y][0] = 0;
//				board[x][y+1][2] = 0;
//				q.add(new int[] {x, y+1});
//			}
//			if(dir == 2 && y > 0 && !visited[x][y-1]){ // South
//				visited[x][y-1] = true;
//				board[x][y][2] = 0;
//				board[x][y-1][0] = 0;
//				q.add(new int[] {x, y-1});
//			}
//			if(dir == 3 && x > 0 && !visited[x-1][y]){ // West
//				visited[x-1][y] = true;
//				board[x][y][3] = 0;
//				board[x-1][y][1] = 0;
//				q.add(new int[] {x-1, y});
//			}
//			if(dir == 1 && x < mbWIDTH-1 && !visited[x+1][y]){ // East
//				visited[x+1][y] = true;
//				board[x][y][1] = 0;
//				board[x+1][y][3] = 0;
//				q.add(new int[] {x+1, y});
//			}
//		}
//	}
//
//}
//
//
//
//



//	//MAIN
//	public static void main(String[] args) {
//		JFrame frame = new JFrame("mkTesting");
//		frame.setLayout(new BorderLayout());
//		
//		JPanel window = new mazePanel();
//		frame.add(window, BorderLayout.CENTER);
//		
//		frame.pack();
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}


//
//String theBoardString = Arrays.toString(board[x][y]);
//String cleanBS = theBoardString.replaceAll("[^0-9]", ""); // get rid of all non-int elements of theBoardString
//for(int i=0; i<4; i++) {
//	String iCleanBS = cleanBS.substring(i, i+1); //iCleanBS == ith element of cleaned theBoardString
//	int iBN = Integer.parseInt(iCleanBS); // convert iCleanBS to integer
//	if(iBN == 0)
//		continue;
//	else
//		wm.drawLine(x, TILEHEIGHT, x+TILEWIDTH, y*TILEHEIGHT);
//}
//






//		wm.drawLine(0, 0, 0, 500/3);
//		for(int x=0; x<3; x++) {
//			for(int y=0; y<3; y++) regex{
//				String[] s = Arrays.toString(board[x][y]);
//				if s[0] == 1
//			}
//		}
//		




