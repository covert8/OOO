package model.observer;

/**
 * Created by yanice on 17/11/16.
 */
public interface Subject {
    void registerObserver(String email);

    void removeObserver(String email);

    void notifyObserver(String ProductName);
}
