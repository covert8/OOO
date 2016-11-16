package model.observer;

import java.util.Observable;

public interface Subscriber {
	
	public void update();

	void update(Observable o, Object arg);

}
