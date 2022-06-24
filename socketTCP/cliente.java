import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class cliente{

    static String host = "127.0.0.1";
    private static int port = 5000;

    public static void main(String args []) throws IOException, ClassNotFoundException{
           System.out.println("Inicio");
           Socket socket = new Socket(host, port);
           //ObjectInputStream ois = new ObjectInputStream(socket.getInputStream()); 
           //String message = (String) ois.readObject();
           //ois.close();
           ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
           oos.writeObject("Mi primera vez");
           socket.close();
        //server.close();
    }
}
