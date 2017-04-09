package AdapterPattern;

import java.util.Random;

//Adaptee
public class EnemyRobot {
	
	Random generator = new Random();
	
	public void smashWithHand()
	{
		int attackDamage = generator.nextInt(10)+1;
		System.out.println("Enemy Robot causes " + attackDamage + " damages with its hand");
	}
	
	public void walkForward()
	{
		int movement = generator.nextInt(5) +1 ;
		System.out.println("Enemy robot walks " + movement + " steps " );
	}
	
	public void reactToHuman(String driverName)
	{
		System.out.println("Enemy robot tramps at " + driverName);
	}
}
