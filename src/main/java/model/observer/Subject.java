package model.observer;

/**
 * Created by yanice on 17/11/16.
 */
public interface Subject {
    void registerObserver();

    void removeObserver();

    void notifyObserver();
}
