package Archivo;

import java.io.Serializable;

public class Estudiante implements Serializable {
    String nombre;
    int matricula;
    double promedio;

    public Estudiante(String nombre, int matricula, double promedio){
        this.nombre = nombre;
        this.matricula = matricula;
        this. promedio = promedio;
    }
    @Override
    public String toString(){
        return "Matrícula:"+ matricula +"| "+ nombre +"("+promedio +")";
    }
    
}
