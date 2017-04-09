package PrototypePattern;

public class LspTest {
	
	private static Rectangle getNewRectangle()
	{
		// it can be an object returned by some factory ...
//		Square sq = new Square(); 
//		System.out.println(System.identityHashCode(sq));
		return new Square() ;
	}

	public static void main (String args[])
	{
//		LspTest ls = new LspTest();
		
		Rectangle r = LspTest.getNewRectangle();
		Rectangle r2 = LspTest.getNewRectangle();
		
		System.out.println(System.identityHashCode(r));
        System.out.println(System.identityHashCode(r2));
		r.setWidth(5);
//		r.setHeight(10);
		// user knows that r it's a rectangle.
		// It assumes that he's able to set the width and height as for the base class

		System.out.println(r.getArea());
		// now he's surprised to see that the area is 100 instead of 50.
	}
}
