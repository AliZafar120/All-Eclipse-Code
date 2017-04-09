package FlyWeight;

public interface ISoldier {
	/**
	 * Move Soldier From Old Location to New Location 
	 * Note that soldier location is extrinsic 
	 *    to the SoldierFlyweight Implementation
	 * @param previousLocationX
	 * @param previousLocationY
	 * @param newLocationX
	 * @param newLocationY
	 */
	public void moveSoldier( int newLocationX ,int newLocationY);
}
