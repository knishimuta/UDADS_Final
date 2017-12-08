package adsfinal;

import java.awt.*;
import javax.swing.*;

public class MazePanel extends JPanel{

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

	//CONSTRUCTOR
	public MazePanel(){
		//set dimension and layout type
		this.setPreferredSize(new Dimension(500,500));
		this.setLayout(new BorderLayout());
		

	}

	@Override
	public void paint(Graphics gg) {
		Graphics2D g = (Graphics2D) gg;
		g.setColor(new java.awt.Color(150, 50,70));
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				g.fill3DRect(i*20, j*20, 5+i, 5+j, false);
			}
		}
		
	}
	
	


}




















