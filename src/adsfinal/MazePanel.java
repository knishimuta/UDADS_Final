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
	MazePanel(){
		//set dimension and layout type
		this.setPreferredSize(new Dimension(500,500));
		this.setLayout(new BorderLayout());
		
		
		//override paint command to do animation
		
		
		//    
		Graphics2D g = (Graphics2D) this.getGraphics();
		g.setColor(Color.gray);

		

	}


}




















