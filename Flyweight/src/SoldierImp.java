import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class SoldierImp implements Soldier {


	private BufferedImage img = null;
	
	private void Soldier() {
		try {
		    img = ImageIO.read(new File("C:\\Users\\User\\Desktop\\download.jpg"));
		} catch (IOException e) {
		};

	}
	
	public void moveSoldier(int previousLocationX, int previousLocationY,
			int newLocationX, int newLocationY) {

	
	
	}
}