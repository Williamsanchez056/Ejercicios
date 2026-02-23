package Hilo;
public class Boveda {

    int saldo = 50000;

    public synchronized void retirar(String nombre, int monto) {

        if (saldo >= monto) {

            System.out.println(nombre + "retiro $" + monto);

            saldo = saldo - monto;

            System.out.println("Saldo ahora:$" + saldo);

        } else {

            System.out.println(nombre + "no pudo retirar $" + monto);
        }

    }

}