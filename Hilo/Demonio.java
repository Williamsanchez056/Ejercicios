package Hilo;
public class Demonio extends Thread{
    Boveda boveda;
    public Demonio(Boveda boveda) {
        this.boveda = boveda;
    }
    public void run(){
        while(true){
            System.out.println("Ve saldo: $" + boveda.saldo);

            try{
                Thread.sleep(2000);
            }catch (Exception e){

            }
        }
    }
}