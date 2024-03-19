package services;

import observer.Observer;

public class User implements Observer {
    @Override
    public void update(String message, int amount) {
        System.out.println("Usuario notificado: " + message);
    }
}
