
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor{

    private static ServerSocket server;
    private static int puerto = 5000;

    public static void main(String args []) throws IOException, ClassNotFoundException{

        server = new ServerSocket(puerto);
        int T0 = 10000; //Tiempo del Servidor

        while(true){
           System.out.println("Esperado Nodos");
           Socket socket = server.accept();//Se queda porque espera que el cliente le envie un socket
           PrintWriter tiempoEnviado = new PrintWriter(socket.getOutputStream(),true); //Instancia para escribir el tiempo
           tiempoEnviado.println(""+T0); //Escribiendo el tiempo envia al cliente
           System.out.println("Terminando el request");
        }
        //server.close();
    }
}

