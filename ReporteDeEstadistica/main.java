package ReporteDeEstadistica;
import java.io.*;
import java.util.*;

public class main{
    public static void main(String[] args){
        Palabra control = new Palabra();

        try{
            crearArchivo("texto1.txt", 75);
            crearArchivo("texto2.txt", 80);
            crearArchivo("texto3.txt", 77);

        }catch(Exception e){
            System.out.println("Error al crear tu archivo de entrada");
        }
        long inicio = System.currentTimeMillis();

        Archivo hilo1 = new Archivo("texto1.txt", control);
        Archivo hilo2 = new Archivo("texto2.txt", control);
        Archivo hilo3 = new Archivo("texto3.txt", control);

        hilo1.start();
        hilo2.start();
        hilo3.start();

        try{
            hilo1.join();
            hilo2.join();
            hilo3.join();

            long tiempoFin = System.currentTimeMillis();

            PrintWriter reporteEstadistica = new PrintWriter(new FileOutputStream("estadistica.txt"));

            reporteEstadistica.println("========================================");
            reporteEstadistica.println("REPORTE DE PROCESAMIENTO DE ARCHIVOS");
            reporteEstadistica.println("========================================");
            reporteEstadistica.println();

            for(String archivo : control.getContadorPorArchivo().keySet()){
                reporteEstadistica.println("Archivo: " + archivo);
                reporteEstadistica.println("Palabras encontradas: " + control.getContadorPorArchivo().get(archivo));
                reporteEstadistica.println();
            }

            reporteEstadistica.println("----------------------------------------");
            reporteEstadistica.println("Total de palabras procesadas: " + control.getTotalGlobal());
            reporteEstadistica.println("Tiempo de procesamiento: " + (tiempoFin - inicio) + " ms");
            reporteEstadistica.println("========================================");
            reporteEstadistica.close();

            System.out.println("Tu reporte esta generado");
            System.out.println("Total de palabras: " + control.getTotalGlobal());

            
        } catch (Exception e){
            System.out.println("Tienes un error al generar tu reporte");
        }
    }
    public static void crearArchivo(String nombreArchivo, int cantidad) throws Exception{
        PrintWriter pw = new PrintWriter(new FileOutputStream(nombreArchivo));
        for(int i = 0; i < cantidad; i++){
            pw.println("palabra" + i);
        }
        pw.close();
    }
}    




