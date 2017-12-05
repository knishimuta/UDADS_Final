package adsfinal;

import java.awt.*;
import javax.swing.*;


public class mazePanel extends JPanel{

	//MAIN
	public static void main(String[] args) {
		JFrame frame = new JFrame("mkTesting");
		frame.setLayout(new BorderLayout());
		
		JPanel window = new mazePanel();
		frame.add(window, BorderLayout.CENTER);
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//CONSTRUCTOR
	mazePanel(){
		
		
		this.setLayout(new BorderLayout());


		JButton south = new JButton("South");
		this.add(south, BorderLayout.SOUTH);
		


		//Title Panel
//		p.add(new Panel pTitle, BorderLayout.NORTH);
//		tt = new TextField("Cool Maze Game"); //title text
//		stt = new TextField("A Collaboration by Kyle, Joan, and MK"); // subtitle text
//		pTitle.add(tt);
//		pTitle.add(stt);
//
//
//		p.add(new Panel pMaze, BorderLayout.CENTER);
//
//
//		p.add(new Panel pControls, BorderLayout.SOUTH);
//		pb = new JButton("Pause"); //pause button
//		rmb = new JButton("Resume"); //resume button
//		rstb = new JButton("Restart"); //restart button
//		pControls.add(pb);
//		pControls.add(rmb);
//		pControls.add(rstb);
		
	  
	}


}




















