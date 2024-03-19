package observer;

import java.util.ArrayList;
import java.util.List;

public class PaymentSubject {
    private final List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message, int amount) {
        for (Observer observer : observers) {
            observer.update(message, amount);
        }
    }
}