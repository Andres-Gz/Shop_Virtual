package services;

import model.Product;
import observer.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Inventory implements Observer {
    private Map<String, Product> productos;
    private Random random = new Random();

    public Inventory() {
        this.productos = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            productos.put("Producto " + i, new Product("Producto " + i, 5));
        }
    }

    @Override
    public void update(String message, int amount) {
        System.out.println("Inventario notificado: " + message);
        imprimirInventario("Inventario antes de la compra:");
        actualizarInventario(amount);
        imprimirInventario("Inventario después de la compra:");
    }

    private void actualizarInventario(int amount) {
        List<Product> listaProductos = new ArrayList<>(productos.values());

        for (int i = 0; i < amount; i++) {
            int index = random.nextInt(listaProductos.size());
            Product productoSeleccionado = listaProductos.get(index);

            productoSeleccionado.setCantidad(productoSeleccionado.getCantidad() - 1);

            if (productoSeleccionado.getCantidad() <= 0) {
                listaProductos.remove(index);
            }

            System.out.println(productoSeleccionado.getNombre() + " - Cantidad en inventario: " + productoSeleccionado.getCantidad());
        }
    }

    private void imprimirInventario(String message) {
        System.out.println(message);
        productos.values().forEach(producto ->
                System.out.println(producto.getNombre() + " - Cantidad en inventario: " + producto.getCantidad())
        );
    }
}
