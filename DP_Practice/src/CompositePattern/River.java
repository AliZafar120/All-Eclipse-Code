package CompositePattern;

public class River extends Shape {

	@SuppressWarnings("unused")
	private int x1, y1, x2, y2, x3, y3, x4, y4;

	public River() {

		DrawShape();
	}

	public River(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
		this.x4 = x4;
		this.y4 = y4;

		DrawShape();
	}

	@Override
	public void BuildShape() {
		list.add(new RiverBank(x1, y1, x2, y2,x3,y3,x4,y4));
		list.add(new RiverBank(x1+50, y1+100, x2, y2+80,x3,y3+80,x4+50,y4));
		
		/**
	 	list.add(new Line(0, 500, 300, 200));
		 
		list.add(new Line(300, 200, 300, 250));
		list.add(new Line(300, 250, 550, 0));

		list.add(new Line(100, 600, 350, 300));
		list.add(new Line(350, 300, 350, 350));
		list.add(new Line(350, 350, 650, 0));
		 */
	}

}
