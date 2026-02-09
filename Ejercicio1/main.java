package Ejercicio1;
import java.util.Scanner;

public class main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMENU");
            System.out.println("1. Cuenta Bancaria");
            System.out.println("2.Empleados");
            System.out.println("3. Ocultamiento de Atributos");
            System.out.println("4.Referencias");
            System.out.println("0. Salir");           
            System.out.print("Elige una Opcion:");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    CuentaBancaria cuenta = new CuentaBancaria("ABC-123", 500.0);
                    cuenta.depositar(200.0);
                    cuenta.retirar(100.0);
                    System.out.println("Saldo final: " + cuenta.getSaldo());
                    break;

                case 2:

                    Empleado emp1 = new EmpleadoFijo();
                    Empleado emp2 = new EmpleadoPorHora();
                    System.out.println("Salario Fijo: " + emp1.calcularSalario());
                    System.out.println("Salario por Horas: " + emp2.calcularSalario());
                    break;

                case 3:
                    A obj = new B(); 
                    System.out.println("Valor de x " + obj.x);
                    break;

                case 4:
                    int[] array1 = {1, 2, 3};
                    int[] array2 = array1; 
                    array2[0] = 99;
                    System.out.print("Contenido del array: ");
                    for(int n : array1) System.out.print(n + " ");
                    System.out.println("\n(Mismo espacio en memoria");
                    break;
            }
        } while (opcion != 0);
        


        System.out.println("El programa finalizo");
        sc.close();
    }
}