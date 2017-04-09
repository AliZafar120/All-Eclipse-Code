

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Test extends JPanel{
	private static Graphics myGraphics;
	
	@Override
	public void paintComponent( Graphics g ){
		myGraphics = g;
		super.paintComponent( myGraphics );
	    //new Rectangle(10, 10, 40, 40, myGraphics).drawShape();
	    //new Triangle(100, 120, 290, 290, 150, 350, myGraphics).drawShape();
	    new Tree(200, 200, 200, 300, myGraphics).drawShape();
	    new Tree(1150, 480, 1150, 580, myGraphics).drawShape();
	    new Tree(1000, 80, 1000, 200, myGraphics).drawShape();
	    new Tree(100, 200, 100, 250, myGraphics).drawShape();
	    new River(0, 500 , 550, 350, 550, 450, 1200, 250, myGraphics).drawShape();
	    new House(300, 200, 500, 300, 100, myGraphics).drawShape();
	    new House(850, 520, 1100, 650, 80, myGraphics).drawShape();
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame("Draw");
		frame.setSize(1200, 700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Test test = new Test();
		frame.add(test);
	}
}
