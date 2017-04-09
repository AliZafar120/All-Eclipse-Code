package PrototypePattern2;

public class TestCloning {

	public static void main(String[] args) {
		CloneFactory animalClone = new CloneFactory();
		
		Sheep sally = new Sheep();
		
		Sheep cloneSheep = (Sheep) animalClone.getClone(sally);
		
		System.out.println(sally);
		System.out.println(cloneSheep);
		
		System.out.println("Sheep Hash: "+ System.identityHashCode(sally));
		System.out.println("Clone Sheep Hash: "+ System.identityHashCode(cloneSheep));

	}

}
