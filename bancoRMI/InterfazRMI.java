import java.rmi.RemoteException;
import java.rmi.Remote;


public interface InterfazRMI extends Remote{
    //public String saludar(String msj)throws RemoteException;
    public double retiro(double cant, double saldo)throws RemoteException;
    public double deposito(double cant, double saldo)throws RemoteException;
    
}
