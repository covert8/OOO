package model.observer;

import java.util.Observable;

public interface Subscriber {
	
	public void update(String productName);

	void update(Observable o, Object arg);

}
