package StrategyPattern;

public class Commander {

	public static void main(String[]args)
	{
		Soldier newSoldier = new Soldier();
		
		newSoldier.fight();
		
		newSoldier.setMode(new AggresiveMode());
		newSoldier.fight();
		
		newSoldier.setMode(new NormalMode());
		newSoldier.fight();
	}
}
