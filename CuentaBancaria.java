package Ejercicios.CuentaBancaria1;
public class CuentaBancaria {
    private double saldo;
    private String NumeroCuenta;

    public CuentaBancaria(String numeroCuenta, double saldoInicial){
        this.NumeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;

        if (saldoInicial >= 0){
            this.saldo = saldoInicial;
        }else{
            this.saldo = 0;
        }
    }
    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println("Tu deposito fue exitoso " + this.saldo);
        } else {
            System.out.println("Tu monto a depositar debe ser ser mayor a 0.");
        }
    }
    public void retirar(double monto){
        if (monto > 0 && monto <= this.saldo){
            this.saldo -= monto;
            System.out.println("Tu retiro  fue exitoso" + this.saldo);
        }
    }
    public double getSaldo(){
        return this.saldo;
    }
    public String getNumeroCuenta(){
        return this.NumeroCuenta;
    }
    
}
