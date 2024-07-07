
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
//unimportant change just making a change in general
public class Main {
	public static JPanel createJPanels() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.black);
		
		
		return panel;
	}
	
	public static int rng(int x) {
		return (int)(Math.random()*x);
	}

	public static int numWalls(int square, int dimensions, JPanel [] array) {
		int count = 0;
		boolean top = false;
		boolean bottom = false;
		boolean left = false;
		boolean right = false;
		String[] emptySpaces = new String[4];
		emptySpaces[0] = "top";
		emptySpaces[1] = "bottom";
		emptySpaces[2] = "left";
		emptySpaces[3] = "right";
		
		
		if(square < dimensions) {
			count++;
			emptySpaces[0] = "null";
			top = true;
		}//top
		if (square >= dimensions*dimensions - dimensions) {
			count++;
			emptySpaces[1] = "null";
			bottom = true;
		}//bottom
		if(square % dimensions == 0) {
			count++;
			emptySpaces[2] = "null";
			left = true;
		}// left
		if((square + 1) % dimensions == 0) {
			count++;
			emptySpaces[3] = "null";
			right = true;
		}// right
		
		//checking if the square in that direction is already taken by the path
		if(!top) {
			if(array[square - (2 * dimensions)].getBackground().equals(Color.WHITE)) {
				top = true;
				emptySpaces[0] = "null";
				count++;
			}
			if(array[square - (2 * dimensions)].getBackground().equals(Color.GREEN)) {
				return -1;
			}
		}
		
		if(!bottom) {
			if(array[square + (2 * dimensions)].getBackground().equals(Color.WHITE)) {
				bottom = true;
				emptySpaces[1] = "null";
				count++;
			}
			if(array[square + (2 * dimensions)].getBackground().equals(Color.GREEN)) {
				return -1;
			}	
		}
		
		if(!left) {
			if(array[square - 2].getBackground().equals(Color.WHITE)) {
				left = true;
				emptySpaces[2] = "null";
				count++;
			}
			if(array[square - 2].getBackground().equals(Color.GREEN)) {
				return -1;
			}	
		}
		
		if(!right) {
			if(array[square + 2].getBackground().equals(Color.WHITE)) {
				right = true;
				emptySpaces[3] = "null";
				count++;
			}
			if(array[square + 2].getBackground().equals(Color.GREEN)) {
				return -1;
			}	
		}
		
		int counts = 0;
		while(counts < 20) {
			int random = rng(4);
			if(!emptySpaces[random].equals("null")){
				return random;
			}
		}
		
		return -2;
	}
	
	public static JFrame createPuzzle(int puzzleSize) {

		int puzzleDimensions = 13;
		puzzleDimensions = puzzleSize;
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(new GridLayout(puzzleDimensions,puzzleDimensions,0,0));
		
		
		JPanel[] boxes = new JPanel[puzzleDimensions*puzzleDimensions];
		for(int i = 0; i < puzzleDimensions*puzzleDimensions; i++) {
			boxes[i] = createJPanels();
			frame.add(boxes[i]);
		}
		
		boxes[puzzleDimensions/2].setBackground(Color.white);
		boxes[boxes.length/2].setBackground(Color.green);
		
		int currentBox = puzzleDimensions/2;
		int x = 0;
		int direction = 0;
		while(x < 50) {
			x++;
			direction = numWalls(currentBox, puzzleDimensions, boxes);
			if(direction == 0) {
				boxes[currentBox - (2*puzzleDimensions)].setBackground(Color.white);
				currentBox = currentBox + (2*puzzleDimensions);
			}//top
			if(direction == 1) {
				boxes[currentBox + (2*puzzleDimensions)].setBackground(Color.white);
				currentBox = currentBox - (2*puzzleDimensions);
			}//bottom
			if(direction == 2) {
				boxes[currentBox - 2].setBackground(Color.white);
				currentBox-= 2;
			}//left
			if(direction == 3) {
				boxes[currentBox + 2].setBackground(Color.white);
				currentBox+= 2;
			}//right
			
			break;
		}
		frame.setVisible(true);
		
		if(direction == -1) {
			return frame;
		}//if it is green
		return createPuzzle(puzzleSize);
	}
	
	
	public static void main(String[] args) {
		JFrame main = createPuzzle(9);
		main.setVisible(true);
	}
}
