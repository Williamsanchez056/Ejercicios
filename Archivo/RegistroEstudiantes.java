package Archivo;
import java.io.*;
import java.util.*;

public class RegistroEstudiantes {
    static List<Estudiante> lista = new ArrayList<>();
    static String nombreArchivo = "estudiantes.dat";

    public static void main(String[] args) {
        cargarArchivo(); 

        Scanner leer = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("\nMENU");
            System.out.println("1. Agregar Nuevo Estudiante");
            System.out.println("2. Buscar por Matricula");
            System.out.println("3. Listar todo los registro");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion:");
            try {
                opcion = Integer.parseInt(leer.nextLine());
                if (opcion == 1) {
                    System.out.print("Nombre: "); 
                    String nom = leer.nextLine();
                    System.out.print("Matricula: "); 
                    int mat = Integer.parseInt(leer.nextLine());
                    System.out.print("Promedio: "); 
                    double pro = Double.parseDouble(leer.nextLine());

                    lista.add(new Estudiante(nom, mat, pro)); 
                    guardarEnArchivo(); 
                } 
                else if (opcion == 2) {
                    System.out.print("Buscar Matricula: ");
                    int buscar = Integer.parseInt(leer.nextLine());
                    
                    RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "r");// Utilice RandomAccesFile para aceeder directamente a cualquier parte del archivo
                    boolean encontrado = false;
                    for (Estudiante e : lista) {
                        if (e.matricula == buscar) {
                            System.out.println("Resultado:"+ e);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) System.out.println("No tienes alumnos.");
                    raf.close();
                } 
                else if (opcion == 3) {
                    if(lista.isEmpty()) System.out.println("No tienes personas registrada.");
                    for(Estudiante e : lista) System.out.println(e);
                }

            } catch (Exception e) {
                System.out.println("Pusiste algo mal.");
            }
        }
    }
    static void guardarEnArchivo() {
        try (ObjectOutputStream saliendo = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) { //ObjectOutputStream se utiliza para escribir objetos en varios archivos
            saliendo.writeObject(lista); 
        } catch (Exception e) {
            System.out.println("No se pudo guardar el archivo.");
        }
    }
    static void cargarArchivo() {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            try (ObjectInputStream entrando = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
                lista = (List<Estudiante>) entrando.readObject(); 
            } catch (Exception e) {
                System.out.println("Iniciando archivo nuevo...");
            }
        }
    }
}