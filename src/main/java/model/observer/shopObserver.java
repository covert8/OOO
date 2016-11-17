package model.observer;

public interface shopObserver {

	public void subscribeCustomer(String email);
	public void removeObserver(String email);
	public void notifyObservers();
}
