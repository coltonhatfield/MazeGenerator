
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
		//initializing variables
		int dimensions = 9;
		JPanel[][] panelArray = new JPanel[dimensions][dimensions];
		JFrame main = new JFrame();
		//gridlayout input
		main.setLayout(new GridLayout(dimensions, dimensions));
		//assigning JPanels into panelArray and adding into the frame as well as changing color to black
		for(int i = 0; i < dimensions; i++) {
			for(int a = 0; a < dimensions; a++) {
				panelArray[i][a] = new JPanel();
				panelArray[i][a].setBackground(Color.black);
				main.add(panelArray[i][a]);
			}
		}
		
		//pastMoves is for tracking the past moves that were done, mostMovesIn keeps track of the farthest computed puzzle, farthestBackFromCurrentMovesIn keeps track of 
		//how far back the computer has previously iterated from the mostMovesIn variable in order to be able to go one further back
		ArrayList<Integer> pastMoves = new ArrayList<Integer>();
		int mostMovesIn = 0;
		int farthestBackFromCurrentMostMovesIn = 0;
		//sets the center and start to correct colors as well as adding the start as the first move in the correct format of [x][y] which is how inputed into array
		panelArray[dimensions/2][dimensions/2].setBackground(Color.green);
		panelArray[0][dimensions/2].setBackground(Color.white);
		pastMoves.add(0);
		pastMoves.add(dimensions/2);
		
		//the while loop iterates as long as the current location is not the center location (the end)
		//Some important function are: pastMoves.get(pastMoves.size() - 1) <-- This will give the most recent positions how far down value
		//pastMoves.get(pastMoves.size())
		while(pastMoves.get(pastMoves.size() - 1) != dimensions/2 && pastMoves.get(pastMoves.size()) != dimensions/2) {
			//creates an array for adding which spaces are open two to the top, bottom, left, and right
			ArrayList<Integer> openSpaces = new ArrayList<Integer>();
			//check the top space
			if(pastMoves.get(pastMoves.size() - 1) != 0 && panelArray[pastMoves.get(pastMoves.size() - 1) - 2][pastMoves.get(pastMoves.size())].getBackground() == Color.black) {
				openSpaces.add(1);
			}
			//check the bottom space - not finished
			if(pastMoves.get(pastMoves.size() - 1) != dimensions && panelArray[pastMoves.get(pastMoves.size() - 1) - 2][pastMoves.get(pastMoves.size())].getBackground() == Color.black) {
				openSpaces.add(1);
			}
			
			
			//randomly generates which space to go to
			int x = openSpaces.get((int)(Math.random() * openSpaces.size()));
			
			
			
		}
		
		
		main.setSize(900, 900);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);
	}
}
