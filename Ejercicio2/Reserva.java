package Ejercicio2;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Reserva {
    private String nombreCliente;
    private Date fechaReserva;
    private int cantidadPersonas;

    public Reserva(String nombre, String fechaTexto, int cantidad) throws ReservaInvalidaException {
        validarNombre(nombre);
        validarFecha(fechaTexto);
        validarCantidad(cantidad);
    }
    private void validarNombre(String nombre) throws ReservaInvalidaException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ReservaInvalidaException("Tu nombre no puede estar vacio:");
        }
        this.nombreCliente = nombre.trim(); // Esta funcion se utiliza para quitar espacios innecesarios
    }
    private void validarFecha(String fechaTexto) throws ReservaInvalidaException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
        try {
            this.fechaReserva = formato.parse(fechaTexto);
        } catch (Exception e) {
            throw new ReservaInvalidaException("Tu fecha debe tener este formato: dd/MM/yyyy");
        }
    }
    private void validarCantidad(int cantidad) throws ReservaInvalidaException {
        if (cantidad <= 0) {
            throw new ReservaInvalidaException("Las cantidad de persona debe de ser mayor a 0");
        }
        this.cantidadPersonas = cantidad;
    }
    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return "Cliente: " + nombreCliente + " | Fecha: " + formato.format(fechaReserva) + " | Personas: " + cantidadPersonas;
    }
}