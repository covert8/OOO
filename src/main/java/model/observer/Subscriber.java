package model.observer;

public interface Subscriber {

	void subscribeCustomer(String email);

	void removeObserver(String email);

	void notifyObservers();
}
