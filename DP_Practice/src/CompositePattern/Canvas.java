package CompositePattern;

import java.awt.Graphics;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Canvas extends JFrame {

	public static Graphics G;

	public  Canvas() 
	{
		setTitle("Canvas");
		setSize(900, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@SuppressWarnings("unused")
	public void paint(Graphics g)
	{
		G=g;
		
		House h1 = new House(100, 100, 100, 100);
		House h2 = new House(700,400,100,150);
		House h3 = new House(750,150,50,70);
		House h4 = new House(450, 400, 100,150);
		House h5 = new House(600,150,50,70);
		
		
		Tree t1 = new Tree(45, 80, 120);
		Tree t2 = new Tree(255, 80, 120);
		Tree t3 = new Tree(700, 110, 90);
		Tree t4 = new Tree(650, 400, 100);
		Tree t5 = new Tree(850, 150, 50);
		Tree t6 = new Tree(720, 110, 90);
		Tree t7 = new Tree(400, 350, 150);
		Tree t8 = new Tree(570, 100, 100);
		
		
		River r2 = new River(0, 500, 300, 200,320, 250, 550, 0);
		
		//r2.DrawShape();
		//River r = new River();
		


	}
	
	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		Canvas canvas = new Canvas();
		/**JFrame frame = new JFrame("Canvas");
        frame.setSize(900, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        **/
        
		
	}

}
