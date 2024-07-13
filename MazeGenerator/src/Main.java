
import java.awt.Color;
import java.awt.GridLayout;
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
}
