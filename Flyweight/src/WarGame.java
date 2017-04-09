public class WarGame {

	public static void main(String[] args) {
		SoldierFactory factory= new SoldierFactory();
		
		Soldier warsolders[] = new Soldier[10000000];
		for(int i =0;i<1000000;i++)
			warsolders[i]=factory.getSoldierflyweight();
		
		
		
		Soldier warsolders1[] = new Soldier[100000000];
		for(int i =0;i<100000000;i++)
			warsolders1[i]=factory.getSoldierWithoutflyweight();
		
		
		
		
		
		
/*		SoldierClient warSoldiers [] ={
				new SoldierClient(),
				new SoldierClient(),
				new SoldierClient(),
				new SoldierClient(),
				new SoldierClient()
		};
		
		warSoldiers[0].moveSoldier(17, 2112);
		
		warSoldiers[1].moveSoldier(137, 112);*/
		
	}
}