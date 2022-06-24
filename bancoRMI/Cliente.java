import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
//import java.io.*;
import java.util.Scanner;
//import java.util.InputMismatchException;

public class Cliente {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        try {
            InterfazRMI interfaz = (InterfazRMI) Naming.lookup("rmi://localhost/banco");
            //System.out.println("como te llamas");
            Scanner sc = new Scanner(new InputStreamReader(System.in));   
            int op = 0;
            double saldo = 10000.00;
            double cant = 0.00;
            while (op < 3) { 
                System.out.println("BIENVENIDO");
                System.out.println("Seleccione la operación que desee realizar:");
                System.out.println("1. Depositar");
                System.out.println("2. Retirar");
                System.out.println("3. Salir");
                System.out.print("Opcion :");
                op = sc.nextInt();
                switch (op) {
                    case 1:
                     
                    System.out.print("Ingrese la cantidad que desee depositar: $");
                        cant = sc.nextInt();
                        saldo = interfaz.deposito(cant, saldo);
                        System.out.println("Saldo Actual: $ "+saldo);
                        System.out.println("Cantidad Depositada: $ "+cant);
                        break;
                    case 2:
                        System.out.print("Ingrese la cantidad que desee retirar: $");
                        cant = sc.nextInt();
                        saldo = interfaz.retiro(cant, saldo);
                        System.out.println("Saldo Actual: $ "+saldo);
                        System.out.println("Cantidad Depositada: $ "+cant);
                        break;
                    default:
                        break;
                }
            }
            System.out.println("GRACIAS POR SU VISITA");
        } catch (Exception e) {
            System.out.println("sss" + e);
        }
    }
}