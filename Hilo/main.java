package Hilo;
public class main{
    public static void main(String[] args){
        Boveda boveda = new Boveda();
        Cajero cajero1 = new Cajero("Cajero 1 ", boveda);
        Cajero cajero2 = new Cajero("Cajero 2 ", boveda);
        Cajero cajero3 = new Cajero("Cajero 3 ", boveda);
        Demonio demonio = new Demonio(boveda);

        demonio.start();

        cajero1.start();
        cajero2.start();
        cajero3.start();

        try{
            cajero1.join();
            cajero2.join();
            cajero3.join();
        }catch (Exception e){
            System.out.println("Error:" + e.getMessage());

        }
        System.out.println("Resultado");

        System.out.println("Transacciones de Cajero 1: " + cajero1.transaccion);
        System.out.println("Transacciones de Cajero 2: " + cajero2.transaccion);
        System.out.println("Transacciones de Cajero 3: " + cajero3.transaccion);


    }
}