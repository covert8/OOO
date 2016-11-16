package model.observer;

public interface Subscriber {

	public void registerObserver();
	public void removeObserver();
	public void notifyObservers();
}
