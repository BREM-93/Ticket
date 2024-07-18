
package Ventas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Orden {
    private Cliente cliente;
    private List<Producto> productos;
    private LocalDate fechaOrden;

    public Orden(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.fechaOrden = LocalDate.now(); // La fecha de orden se inicializa con la fecha actual
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    // Getters y setters
    public LocalDate getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(LocalDate fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
