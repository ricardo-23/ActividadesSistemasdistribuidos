import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class cliente {

    static String host = "127.0.0.1";
    private static int port = 5000;

    public static void main(String args[]) throws IOException, ClassNotFoundException {

        int T0; //Tiempo Servidor
        int N1 = 9998; //Tiempo de nodo 1
        int N2 = 10001; //Tiempo de nodo 2
        int N3 = 10005; //Tiempo de nodo 3
        int interTiempo = 5; //Intervalo de tiempo en la comunicaciòn

        System.out.println("----------------------------------------");
        System.out.println("Iniciando el Algoritmo de Berkeley");
        Socket socket = new Socket(host, port);
        BufferedReader tiempoRecibido = new BufferedReader(new InputStreamReader(socket.getInputStream())); //Instancia para leer el tiempo del servidor
        T0 = Integer.parseInt(tiempoRecibido.readLine()); // Asignar tiempo del servidor leido
        System.out.println("----------------------------------------");
        System.out.println("Tiempo inicial del Servidor: "+T0);
        System.out.println("Tiempo inicial del Nodo 1: "+N1);
        System.out.println("Tiempo inicial del Nodo 2: "+N2);
        System.out.println("Tiempo inicial del Nodo 3: "+N3);

        N1 = N1 + interTiempo;
        N2 = N2 + interTiempo;
        N3 = N3 + interTiempo;

        int D1 = N1 - T0;
        int D2 = N2 - T0;
        int D3 = N3 - T0;
        int Tli = T0 + interTiempo;
        
        Tli = Tli + interTiempo;
        N1 = N1 + interTiempo;
        N2 = N2 + interTiempo;
        N3 = N3 + interTiempo;

       int D1Prima = (D1 - ((Tli-T0)/2));
       int D2Prima = (D2 - ((Tli-T0)/2));
       int D3Prima = (D3 - ((Tli-T0)/2));
       int D = ((D1Prima+D2Prima+D3Prima+0)/4);

       Tli = Tli + D;

       int A1 = D - D1Prima;
       int A2 = D - D2Prima;
       int A3 = D - D3Prima;

        Tli = Tli + interTiempo;
        N1 = N1 + interTiempo;
        N2 = N2 + interTiempo;
        N3 = N3 + interTiempo;

        N1 = N1 + A1;
        N2 = N2 + A2;
        N3 = N3 + A3;
        
        System.out.println("----------------------------------------");
        System.out.println("Tiempo final del Servidor: "+Tli);
        System.out.println("Tiempo final del Nodo 1: "+N1);
        System.out.println("Tiempo final del Nodo 2: "+N2);
        System.out.println("Tiempo final del Nodo 3: "+N3);
        
        socket.close();
    }

    
}
