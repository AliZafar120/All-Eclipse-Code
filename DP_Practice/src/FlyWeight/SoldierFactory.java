package FlyWeight;

import java.awt.image.ImageObserver;


/**
 * Flyweight Factory
 */
public class SoldierFactory {
	/**
	 * Pool for one soldier only 
	 * if there are more soldier types 
	 * this can be an array or list or better a HashMap
	 * 
	 */
	private static ISoldier SOLDIER;
	
	/**
	 * getFlyweight
	 * @return
	 */
	public static ISoldier getSoldier(ImageObserver i){

		// this is a singleton 
		// if there is no soldier 
		if(SOLDIER==null){
			
			// create the soldier 
			SOLDIER = new SoldierImp(i);
		}
		
		// return the only soldier reference
		return SOLDIER;
	}
}
