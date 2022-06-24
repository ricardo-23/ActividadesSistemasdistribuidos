
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor{

    private static ServerSocket server;
    private static int puerto = 5000;

    public static void main(String args []) throws IOException, ClassNotFoundException{
        server = new ServerSocket(puerto);
        String message;
        while(true){
           System.out.println("Esperado....");
           Socket socket = server.accept();//Se queda porque espera que el cliente le envie un socket
           ObjectInputStream ois = new ObjectInputStream(socket.getInputStream()); 
           message = (String) ois.readObject();
            System.out.println("Mensaje "+message);
           ois.close();
           //socket.close();
           System.out.println("Terminando el request");
        }
        //server.close();
    }
}

