// Fig. 8.20: TestDraw.java
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;


import java.awt.event.MouseAdapter;


import java.awt.event.MouseListener;



// Creating a JFrame to display a DrawPanel.
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.w3c.dom.events.MouseEvent;

public class TestDraw extends MouseAdapter
{
   public static void main( String[] args )
   {
	   //adding panel to jframe
      DrawPanel panel = new DrawPanel();  
      JPanel pan= new JPanel();
      JFrame application = new JFrame();
      panel.addMouseListener(new MousePosition());
      
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      application.add( panel );
      application.setSize( 900, 600 );
      application.setVisible( true );

   } 
   
} 

class DrawPanel extends JPanel
{

   public void paintComponent( Graphics g )
   {
	//drawings
	   
      super.paintComponent( g );
      House house1= new House(161,219,g);
      House house2= new House(475,138,g);
      House house3= new House(736,473,g);
      House house4= new House(544,508,g);
      River river1= new River(2,352,880,127,g);
      Tree tree1= new Tree(254, 210, 80, g);
      Tree tree2= new Tree(108, 222, 80, g);
      Tree tree3= new Tree(454, 135, 80, g);
      Tree tree4= new Tree(548, 128, 80, g);
      Tree tree5= new Tree(509, 504, 80, g);
      Tree tree6= new Tree(711, 468, 80, g);
      Tree tree7= new Tree(824, 466, 80, g);
      Tree tree8= new Tree(624, 505, 80, g);
      
      house1.drawshape();
      house2.drawshape();
      house3.drawshape();
      house4.drawshape();
      river1.drawshape();
      tree1.drawshape();
      tree2.drawshape();
      tree3.drawshape();
      tree4.drawshape();
      tree5.drawshape();
      tree6.drawshape();
      tree7.drawshape();
      tree8.drawshape();
      
      
   } 
} 



class MousePosition extends MouseAdapter{
	
	// helper class to find out where to place items
	   public void mouseClicked(java.awt.event.MouseEvent e){
		   int x=e.getX();
		   int y= e.getY();
		   System.out.println("X is "+ x+"\n"+"Y is "+y);
	   }
	
	
}

