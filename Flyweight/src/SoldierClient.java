public class SoldierClient {

	private Soldier soldier = SoldierFactory.getSoldierflyweight();
	
	private int currentLocationX = 0;
	

	private int currentLocationY=0;
	
	
	public void moveSoldier(int newLocationX, int newLocationY){

		// here the actual rendering is handled by the flyweight object 
		soldier.moveSoldier(currentLocationX, 
			currentLocationY, newLocationX, newLocationY);
		
		// this object is responsible for maintaining the state
		// that is extrinsic to the flyweight
		currentLocationX = newLocationX;
		
		currentLocationY = newLocationY;
	}
}