package model.observer;

public interface shopObserver {

	public void registerObserver();
	public void removeObserver();
	public void notifyObservers();
}
