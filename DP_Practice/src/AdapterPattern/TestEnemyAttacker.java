package AdapterPattern;

public class TestEnemyAttacker {

	public static void main(String[] args) {
		
		EnemyTank et = new EnemyTank();
		
		EnemyRobot er = new EnemyRobot();
		
		EnemyAttacker robotAdapter = new EnemyRobotAdapter(er);
		
		System.out.println("The Robot");
		
		er.reactToHuman("Jhumu");
		er.walkForward();
		er.smashWithHand();
		
		System.out.println("The enemy tank");
		et.assignDriver("Mumu");
		et.driveForward();
		et.fireWeapon();
		
		System.out.println("The robot with Adapter");
		
		robotAdapter.assignDriver("Fabiha");
		robotAdapter.driveForward();
		robotAdapter.fireWeapon();
		
		

	}

}
