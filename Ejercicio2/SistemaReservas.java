package Ejercicio2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaReservas {
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        List<Reserva> lista = new ArrayList<>();
        String opcion = "";

        System.out.println("--- GESTIÓN DE RESERVAS ---");

        while (!opcion.equals("3")) {
            System.out.println("\n1.Registrar");
            System.out.println("2.Mostrar");
            System.out.println("3.Salir");
            System.out.print("Elegir opción: ");

            opcion = lector.next();

            try {
                if (opcion.equals("1")) {
                    System.out.print("Nombre");
                    String nombre = lector.next(); 
                    
                    System.out.print("Fecha ");
                    String fecha = lector.next();
                    
                    System.out.print("Cantidad de personas: ");
                    int cantidad = lector.nextInt(); 

                    Reserva nueva = new Reserva(nombre, fecha, cantidad);
                    lista.add(nueva);
                    System.out.println("Tu reserva esta guardada");

                } else if (opcion.equals("2")) {
                    if (lista.isEmpty()) {
                        System.out.println("No tienes reservas");
                    } else {
                        for (Reserva r : lista) {
                            System.out.println(r);
                        }
                    }
                } else if (opcion.equals("3")) {
                    System.out.println("Nos vemos pronto");
                } else {
                    System.out.println("Esta opcion no es valida");
                }

            } catch (ReservaInvalidaException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Tus datos no son validos");
                lector.next(); 
            }
        }
        lector.close();
    }
}