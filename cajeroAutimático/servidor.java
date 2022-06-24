import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor {

    private static ServerSocket server;
    private static int puerto = 5000;
    private static int puertoE = 5001;
    static String host = "127.0.0.1";

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        server = new ServerSocket(puerto);
        String op;
        while (true) {
            System.out.println("SERVIDOR ACTIVO");
            // recibir
            Socket socketEscuchando = server.accept();
            ObjectInputStream ois = new ObjectInputStream(socketEscuchando.getInputStream());
            op = (String) ois.readObject();
            if (op.equals("1")) {
                ois.close();
                //server.close();
                Socket socketEnviando = new Socket(host, puertoE);
                ObjectOutputStream oos = new ObjectOutputStream(socketEnviando.getOutputStream());
                oos.writeObject("CONSULTAR");
                System.out.println("CONSUTLANDO");
                oos.close();
                //ocketEnviando.close();
            } else if (op.equals("2")) {
                ois.close();
                //server.close();
                Socket socketEnviando = new Socket(host, puertoE);
                ObjectOutputStream oos = new ObjectOutputStream(socketEnviando.getOutputStream());
                oos.writeObject("DEPOSITAR");
                System.out.println("DEPOSITANDO");
                oos.close();
                //socketEnviando.close();
            } else if (op.equals("3")) {
                ois.close();
                //server.close();
                Socket socketEnviando = new Socket(host, puertoE);
                ObjectOutputStream oos = new ObjectOutputStream(socketEnviando.getOutputStream());
                oos.writeObject("RETIRAR");
                System.out.println("RETIRANDO");
                oos.close();
                //socketEnviando.close();
            }
           // ois.close();
            // Enviar
            //server.close();
        }
            //System.out.println("Received: localhost sender's message #" + message);

            // Cerrar escucha
            
            // socket.close();
            // System.out.println("Terminando el request");
        
            
    }
    
}
