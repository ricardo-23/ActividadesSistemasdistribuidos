import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class cliente {

    static String host = "127.0.0.1";
    private static int port = 5000;

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        int T0 = 38; //Tiempo Cliente
        int Cs; //Tiempo Servidor
        int T1 = 44; //Tiempo Cliente
        int C = 0; //Tiempo Sincronizado
        int De = 0; //Durante cuantas unidades se detendra



        System.out.println("Iniciando el Algoritmo de Cristian");
        Socket socket = new Socket(host, port);
        BufferedReader tiempoRecibido = new BufferedReader(new InputStreamReader(socket.getInputStream())); //Instancia para leer el tiempo del servidor
        Cs = Integer.parseInt(tiempoRecibido.readLine()); // Asignar tiempo del servidor leido

        C = (Cs + ((T1 - T0) / 2));
        De = T1 - C;

        System.out.println("Tiempo inicial del cliente: "+T0);
        System.out.println("Tiempo final del cliente (No sincronizado): "+T1);
        System.out.println("Tiempo del servidor: "+Cs);
        System.out.println("Tiempo del cliente sincronizado: "+C);
        System.out.println("Unidades de tiempo que se detuvo el cliente: "+De);
        socket.close();
    }
}
