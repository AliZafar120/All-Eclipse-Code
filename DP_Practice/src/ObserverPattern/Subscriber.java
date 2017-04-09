package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public abstract class Subscriber {
	List<NewsPublisher> npList = new ArrayList<NewsPublisher>();
	
	public void getUpdate(NewsPublisher np)
	{
		
			np.getNews();
		
	}
	
	abstract public void addPublisher();
}
