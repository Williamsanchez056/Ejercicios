package ReporteDeEstadistica;
import java.util.*;

public class Palabra {
    private HashMap<String, Integer> contadorPorArchivo = new HashMap<>();
    private int totalGlobal = 0;

    public synchronized void agregarResultado(String nombreArchivo, int cantidad){
        contadorPorArchivo.put(nombreArchivo, cantidad);
        totalGlobal += cantidad;
    }
    public HashMap<String, Integer> getContadorPorArchivo(){
        return contadorPorArchivo;
    }
    public int getTotalGlobal(){
        return totalGlobal;
    }
}

    

