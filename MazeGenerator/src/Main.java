
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
//unimportant change just making a change in general
public class Main {
	//an arraylist keeping track of moves made
	//an integer keeping track of the furthest that the maze has generated, how many squares have been filled in at most
	//an integer keeping track of how far back from the furthest forward maze has generated that we have gone back in the arraylist, no need to remember how it generated
	//so can delete previous sequences
	//move made -> update arraylist with the new position  -> check if surrounded by walls or just check if space moved to is already turned white/taken  -> if it is
	//check if a new record on furthest distance traveled is made -> if it is change int maxDistance to it and reset counter of moves back if not increase counter of 
	//moves back by one and move that many spaces back
	
	public static void main(String[] args) {
		int dimensions = 9;
		JPanel[][] panelArray = new JPanel[dimensions][dimensions];
		JFrame main = new JFrame();
		
		main.setLayout(new GridLayout(dimensions, dimensions));
		
		for(int i = 0; i < dimensions; i++) {
			for(int a = 0; a < dimensions; a++) {
				panelArray[i][a] = new JPanel();
				panelArray[i][a].setBackground(Color.black);
				main.add(panelArray[i][a]);
			}
		}
		
		
		ArrayList<Integer> pastMoves = new ArrayList<Integer>();
		int mostMovesIn = 0;
		int farthestBackFromCurrentMostMovesIn = 0;
		
		panelArray[dimensions/2][dimensions/2].setBackground(Color.green);
		panelArray[0][dimensions/2].setBackground(Color.white);
		pastMoves.add(0);
		pastMoves.add(dimensions/2);
		
		int currentX = dimensions/2;
		int currentY = 0;
		
		while(currentX != dimensions/2 && currentY != dimensions/2) {
			ArrayList<Integer> openSpaces = new ArrayList<Integer>();
			if(currentY != 0) {
				openSpaces.add(1);
			}
			if(currentY != dimensions) {
				openSpaces.add(3);
			}
			if(currentX != 0) {
				openSpaces.add(4);
			}
			if(currentX != dimensions) {
				openSpaces.add(2);
			}
			
			int x = openSpaces.get((int)(Math.random() * openSpaces.size()));
			
			if(x == 1) {
				currentY -= 2;
				
			}
		}
		
		
		
		
		
		main.setSize(900, 900);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);
	}
}
