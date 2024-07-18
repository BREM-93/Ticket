package test;

import Ventas.Cliente;
import Ventas.Orden;
import Ventas.Producto;
import java.time.format.DateTimeFormatter;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ventas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos del cliente
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Tipo de pago: 1. Tarjeta 2. Efectivo: ");
        String tipoPagoCliente = scanner.nextLine();

        // Crear el cliente
        Cliente cliente = new Cliente(nombreCliente, tipoPagoCliente);

        // Crear una lista para almacenar los productos
        List<Producto> productos = new ArrayList<>();

        // Solicitar datos de los productos hasta que el usuario decida terminar
        while (true) {
            System.out.print("Ingrese el nombre del producto (Si no hay productos escriba 'fin' para terminar): ");
            String nombreProducto = scanner.nextLine();
            if (nombreProducto.equalsIgnoreCase("fin")) {
                break;
            }
            System.out.print("Ingrese el precio del producto: ");
            double precioProducto = Double.parseDouble(scanner.nextLine());

            // Crear el producto y agregarlo a la lista
            Producto producto = new Producto(nombreProducto, precioProducto);
            productos.add(producto);
        }

        // Crear una orden con el cliente y los productos ingresados
        Orden orden = new Orden(cliente);
        for (Producto producto : productos) {
            orden.agregarProducto(producto);
        }

        // Establecer la fecha de la orden (opcional, se usa la fecha actual por defecto)
        // orden.setFechaOrden(LocalDate.of(2024, Month.JULY, 18));

        // Calcular el total de la orden
        double totalOrden = orden.calcularTotal();

        // Mostrar información en la consola
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("\nResumen de la Orden:");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Dirección: " + cliente.getDireccion());
        System.out.println("Tipo de Pago: " + cliente.getTipoPago());
        System.out.println("Fecha de Orden: " + orden.getFechaOrden().format(formatter));
        System.out.println("Productos en la orden:");
        for (Producto producto : orden.getProductos()) {
            System.out.println("- " + producto.getNombre() + ": $" + producto.getPrecio());
        }
        System.out.println("Total de la orden: $" + totalOrden);

        // Cerrar el scanner al finalizar
        scanner.close();
    }
}
