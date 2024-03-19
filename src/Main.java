import observer.PaymentSubject;
import services.Inventory;
import services.ShoppingCart;
import services.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PaymentSubject subject = new PaymentSubject();

        subject.attach(new ShoppingCart());
        subject.attach(new Inventory());
        subject.attach(new User());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de compra.");
        System.out.print("Ingrese la cantidad de productos a comprar: ");

        int amount = scanner.nextInt();

        // Suponiendo que la cantidad ingresada es válida y no supera la cantidad del stock
        // hay que agregar la funcion de no comprar mas, que el stock en inventario (para una proxima entrega)
        subject.notifyObservers("Compra realizada", amount);

        scanner.close();
    }
}