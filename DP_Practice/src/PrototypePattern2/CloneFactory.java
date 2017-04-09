package PrototypePattern2;

public class CloneFactory {

	public Animal getClone(Animal animalsample)
	{
		return animalsample.makeCopy();
	}
}
