package Ejercicios.CuentaBancaria1;
abstract class Empleado {
    abstract double calcularSalario();
}

class EmpleadoFijo extends Empleado {
    @Override
    double calcularSalario() {
        return 2500.0; 
    }
}

class EmpleadoPorHora extends Empleado {
    private int horas = 40;
    @Override
    double calcularSalario() {
        return horas * 20.0; 
    }
}
