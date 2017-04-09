package ObserverPattern;

public class MainClass {

	public static void main(String[] args) {
		
		SmsSubscriber ss = new SmsSubscriber();
		emailSubscriber es = new emailSubscriber();
		
		BusinessNewsPublisher bp = new BusinessNewsPublisher();
		bp.Attach(ss);
		bp.Attach(es);
		bp.Notify(bp);
	}

}
