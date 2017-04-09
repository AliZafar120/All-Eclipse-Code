package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public abstract class NewsPublisher {
	List<Subscriber> sList = new ArrayList<Subscriber>();
	public void Attach(Subscriber s)
	{
		sList.add(s);
	}
	
	public void Detach(Subscriber s)
	{
		for (Subscriber subscriber : sList) {
			if(subscriber.equals(s))
				sList.remove(subscriber);
		}
	}
	
	public void Notify(NewsPublisher np)
	{
		for (Subscriber subscriber : sList) {
			subscriber.getUpdate(np);
		}
	}
	
	abstract void getNews();
}
