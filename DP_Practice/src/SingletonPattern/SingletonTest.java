package SingletonPattern;

public class SingletonTest {

	public static void main(String[] args) {
		SingleTon s1 = SingleTon.getInstance();
		System.out.println(System.identityHashCode(s1));
		
		SingleTon s2 = SingleTon.getInstance();
		System.out.println(System.identityHashCode(s2));
	}
	
}
