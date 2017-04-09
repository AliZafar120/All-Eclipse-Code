package FlyWeight;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.JFrame;


/**
 * Driver : War Game 
 */
@SuppressWarnings("serial")
public class WarGame extends JFrame{

	public static Graphics G;
	
	public WarGame() {
		setTitle("Game");
		setSize(900,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g)
	{
		G=g;
		ImageObserver i = this;
		//SoldierImp s = new SoldierImp(i);
		//s.moveSoldier(100, 100);
		/**SoldierClient warSoldiers [] ={
				new SoldierClient(i),
				new SoldierClient(i),
				new SoldierClient(i),
				new SoldierClient(i),
				new SoldierClient(i)
		};
		
		// move each soldier to his location 
		// take user input to move each soldier 
		warSoldiers[0].moveSoldier(107, 210);
		
		// 	take user input to move each soldier 
		warSoldiers[1].moveSoldier(137, 112);
		**/
		
		for(int j=0;j<1000;j++)
		{
			@SuppressWarnings("unused")
			SoldierClient s = new SoldierClient(i);
			
			System.out.println("Hashcode of soldierClient : "+System.identityHashCode(s));
		}
		
	}
	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		WarGame wargame = new WarGame();
		
		
		
		// note that there is only one SoldierImp ( FlyWeight Imp)
		// for all the 5 soldiers 
		// Soldier Client size is small due to the small state it maintains
		// SoliderImp size might be large or might be small 
		// however we saved memory costs of creating 5 Soldier representations
	}
}