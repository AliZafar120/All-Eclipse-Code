package FlyWeight;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;


public class SoldierImp implements ISoldier{
	/**
	 * Intrinsic State maintained by FlyWeight implementation
	 * Solider Shape ( graphical represetation)
	 * how to display the soldier is up to the FlyWeight implementation
	 */
	ImageObserver i;
	public SoldierImp() {
		
	}
	
	public SoldierImp(ImageObserver i) {
		this.i=i;
		Image image = Toolkit.getDefaultToolkit().getImage("D:\\Dropbox\\Java\\hu.jpg");
	}
	
	@SuppressWarnings("unused")
	private Object soldierGraphicalRepresentation;
	
	public void Soldier(int x, int y)
	{
		Image image = Toolkit.getDefaultToolkit().getImage("D:\\Dropbox\\Java\\hu.jpg");
		WarGame.G.drawImage(image, x, y,i );
	}

	/**
	 * Note that this method accepts soldier location 
	 * Soldier Location is Extrinsic and no reference to previous location 
	 * or new location is maintained inside the FlyWeight implementation
	 */
	public void moveSoldier(int newLocationX, int newLocationY) {

		Soldier(newLocationX, newLocationY);
	}
}
