
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor{

    private static ServerSocket server;
    private static int puerto = 5000;

    public static void main(String args []) throws IOException, ClassNotFoundException{
        server = new ServerSocket(puerto);
        int Cs = 37; //Tiempo del Servidor
       
        while(true){
           System.out.println("Esperado al Cliente");
           Socket socket = server.accept();//Se queda porque espera que el cliente le envie un socket
           PrintWriter tiempoEnviado = new PrintWriter(socket.getOutputStream(),true); //Instancia para escribir el tiempo
           tiempoEnviado.println(""+Cs); //Escribiendo el tiempo envia al cliente
           System.out.println("Terminando el request");
        }
        //server.close();
    }
}

