package SingletonPattern;

public class SingleTon {
	
	private static SingleTon instance = new SingleTon();

	private SingleTon()
	{
		System.out.println("Singleton(): Initializing Instance");
	}

	public static SingleTon getInstance()
	{    
		return instance;
	}

	public void doSomething()
	{
		System.out.println("doSomething(): Singleton does something!");
	}
}
