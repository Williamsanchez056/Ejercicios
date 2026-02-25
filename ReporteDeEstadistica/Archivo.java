package ReporteDeEstadistica;
import java.io.*;
import java.util.*;

public class Archivo extends Thread{
    String nombreArchivo;
    Palabra objetoCompartido;

    public Archivo(String nombreArchivo, Palabra objetoCompartido){
        this.nombreArchivo = nombreArchivo;
        this.objetoCompartido = objetoCompartido;
    }
    public void run(){
        try{
            Scanner lector = new Scanner(new FileInputStream(nombreArchivo));
            int contador = 0;
            while(lector.hasNext()){
                lector.next();
                contador++;
            }
            lector.close();
            objetoCompartido.agregarResultado(nombreArchivo, contador);
        }catch(Exception e){
            System.out.println("Error: no se puede procesar tu archivo" + nombreArchivo);
        }
    }
}
    

