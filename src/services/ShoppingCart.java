package services;

import observer.Observer;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Observer {
    private List<Product> productos;

    public ShoppingCart() {
        this.productos = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            productos.add(new Product("Producto " + i, 1));
        }
    }

    @Override
    public void update(String message, int amount) {
        System.out.println("CarritoDeCompras notificado: " + message);
        comprarProductos(amount);
    }

    private void comprarProductos(int amount) {
        if (amount < productos.size()) {
            productos = productos.subList(0, productos.size() - amount);
        } else {
            productos.clear();
        }

        System.out.println("Productos restantes en el carrito de compras: " + productos.size());
        for (Product producto : productos) {
            System.out.println(producto.getNombre() + " - Cantidad: " + producto.getCantidad());
        }
    }
}