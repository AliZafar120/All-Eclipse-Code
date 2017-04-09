package FlyWeight;

import java.awt.image.ImageObserver;


/**
 * This is the "Heavyweight" soldier object 
 * which is the client of the FlyWeight soldier
 *  this object provides all soldier services and is used in the game 
 */
public class SoldierClient {

	/**
	 * Reference to the FlyWeight
	 */
	
	ImageObserver i;
	ISoldier soldier;
	int newLocationX=100,  newLocationY=100;
	int increment= 10;
	/**nt
	 * this state is maintained by the client 
	 */
	private int currentLocationX = 0;
	
	/**
	 * this state is maintained by the client 
	 */
	//private int currentLocationY=0;
	public SoldierClient(ImageObserver i) {
		this.i=i;
		soldier = SoldierFactory.getSoldier(i);
		newLocationX = newLocationX + increment;
		newLocationY = newLocationY + increment;
		moveSoldier(newLocationX, newLocationY);
		
		System.out.println("Hashcode of SoldierImp : " + System.identityHashCode(soldier));
		
	}
	
	public void moveSoldier(int newLocationX, int newLocationY){

		// here the actual rendering is handled by the FlyWeight object 
		soldier.moveSoldier( newLocationX, newLocationY);
		
		// this object is responsible for maintaining the state
		// that is extrinsic to the FlyWeight
		//currentLocationX = newLocationX;
		
		//currentLocationY = newLocationY;
	}
}