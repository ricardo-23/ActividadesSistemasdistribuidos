
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ImplementationRMI extends UnicastRemoteObject implements InterfazRMI{
    public ImplementationRMI() throws RemoteException{
        super();
    }

    public double retiro(double cant, double saldo) throws RemoteException{
        return (saldo-cant);
    }
    public double deposito(double cant, double saldo) throws RemoteException{
        return (saldo+cant);
    }
}
