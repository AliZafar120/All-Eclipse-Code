public class SoldierFactory {

	private static Soldier SOLDIER;
	public static Soldier getSoldierflyweight(){

		if(SOLDIER==null){
			
			SOLDIER = new SoldierImp();
		}
		
		return SOLDIER;
	}
	
	public static Soldier getSoldierWithoutflyweight(){

			SOLDIER = new SoldierImp();
		
		
		return SOLDIER;
	}
}