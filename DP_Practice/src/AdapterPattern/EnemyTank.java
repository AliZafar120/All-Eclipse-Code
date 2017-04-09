package AdapterPattern;

import java.util.Random;

public class EnemyTank implements EnemyAttacker{
	
	Random generator = new Random();
	
	@Override
	public void fireWeapon() {
		
		int attackdamage = generator.nextInt(10) + 1;
		System.out.println("Enemy Tank does " + attackdamage + " damages");
	}

	@Override
	public void driveForward() {
		
		int movement = generator.nextInt(5)+1;
		System.out.println("Enemy Tank moves " + movement + " steps");
	}

	@Override
	public void assignDriver(String driver) {
		
		System.out.println( driver + " is driving " );
	}

}
