package Hilo;
import java.util.Random;

public class Cajero extends Thread{
    Boveda boveda;
    int transaccion = 0;
    Random r = new Random();

    public Cajero(String nombre, Boveda boveda) {
        super(nombre);
        this.boveda = boveda;
    }
    public void run(){
        int cliente = r.nextInt(3) + 3;
        for(int i = 0; i < cliente; i++){
            int monto = r.nextInt(1501) + 500;
            boveda.retirar(getName(), monto);
            transaccion++;

            try{
                Thread.sleep((r.nextInt(3) + 1) * 1000);
            }catch (Exception e){

            }

        }
        System.out.println(getName() + "termino");

    }
}