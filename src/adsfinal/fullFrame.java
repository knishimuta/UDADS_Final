package adsfinal;


import java.awt.*;
import javax.swing.*;

public class fullFrame extends JPanel{

	//MAIN
	public static void main(String[] args) {
		JFrame frame = new JFrame("mkTesting");
		frame.setLayout(new BorderLayout());
		
		JPanel window = new fullFrame();
		frame.add(window, BorderLayout.CENTER);
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//CONSTRUCTOR
	fullFrame(){
		
		
		this.setLayout(new BorderLayout());

		
		/* *****************************************************************************
		 * TITLE - NORTH PANEL OF "WINDOW"
		 */
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		JTextField title = new JTextField("Cool Maze Thing");
		JTextField subtitle = new JTextField("A Collaboration by Joan, Kyle, and MK");
		title.setBackground(new java.awt.Color(179, 255, 230)); //light blue-green
		subtitle.setBackground(new java.awt.Color(179, 255, 230)); //light blue-green
		titlePanel.add(title, BorderLayout.NORTH);
		titlePanel.add(subtitle,BorderLayout.CENTER);
		this.add(titlePanel, BorderLayout.NORTH);
		
		// ******************************************************************************
		
		
		
		
		
		/* ******************************************************************************
		 * CONTROL PANEL - SOUTH PANEL OF "WINDOW"
		 */
		
		//Create new panel for southern panel of "window"
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout());
		
		//Create new buttons for controlPanel
		JButton pause = new JButton("Pause");
		pause.setBackground(new java.awt.Color(255, 77, 77)); //red
		JButton resume = new JButton("Resume");		
		resume.setBackground(new java.awt.Color(0, 102, 0)); //green
		JButton idek = new JButton("Idek...but this is a button");
		idek.setBackground(new java.awt.Color(204, 153, 255)); //purple
		
		//Add buttons to controlPanel
		controlPanel.add(pause);
		controlPanel.add(resume);
		controlPanel.add(idek);
		
		//Add controlPanel to window
		this.add(controlPanel, BorderLayout.SOUTH);
		
		// *******************************************************************************
		
		
		
		
		
		/* *******************************************************************************
		 * DRAWINGMAZEPANEL - CENTER PANEL OF "WINDOW" 
		 */
//		//Create new panel for center panel of "window"
//		JPanel drawingMazePanel = new JPanel();
//		drawingMazePanel.setLayout(new BorderLayout());
		
		//Draw Maze...somehow
		//Call mazePanel Class
		mazePanel MP = new mazePanel();
		this.add(MP, BorderLayout.CENTER);
		
		// *******************************************************************************

	}


}



