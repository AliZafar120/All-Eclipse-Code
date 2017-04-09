package StrategyPattern;

public class Soldier {
	
	IMode mode = null;
	public Soldier() {
		mode = new DefensiveMode();
	}
	
	public void fight() 
	{
		
		mode.fight();
	}
	
	public void setMode(IMode mode)
	{
		this.mode = mode;
	}
}
