package ObserverPattern;

public class BusinessNewsPublisher extends NewsPublisher {

	int state =0;
	int increment =5;
	@Override
	void getNews() {
		System.out.println(state);
		state = state + increment;
	}

}
