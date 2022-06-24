import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

public class cliente {

    static String host = "127.0.0.1";
    private static int port = 5000;
    private static int portR = 5001;
    private static ServerSocket respuesta;

    public static void main(String args[]) throws IOException, ClassNotFoundException, InterruptedException {
        System.out.println("Inicio");
         //int i = 1;
        Scanner sc = new Scanner(System.in);

        // Thread.sleep(1000);

        // ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        // String message = (String) ois.readObject();
        // ois.close();
        int op = 0;
        double saldo = 10000.00;
        double cant = 0.00;
        String message;
        while (op < 5) {

            System.out.println("BIENVENIDO");
            System.out.println("Seleccione la operación que desee realizar:");
            System.out.println("1. Consultar saldo.");
            System.out.println("2. Depositar.");
            System.out.println("3. Retirar.");
            System.out.println("4. Salir");
            System.out.print("Opcion :");
            // Enviar
            Socket socketEnviando = new Socket(host, port);
            ObjectOutputStream oos = new ObjectOutputStream(socketEnviando.getOutputStream());
            op = sc.nextInt();
            oos.writeObject("" + op);
            oos.close();
            //socketEnviando.close();

            // Escuchar
            respuesta = new ServerSocket(portR);
            Socket socketRespuesta = respuesta.accept();// Se queda porque espera que el cliente le envie un socket
            ObjectInputStream ois = new ObjectInputStream(socketRespuesta.getInputStream());
            message = (String) ois.readObject();
            switch(message){
                case "CONSULTAR":
                    System.out.println("Saldo Actual: $ " + saldo);
                    ois.close();
                    //respuesta.close();
                    break;
                case "DEPOSITAR":
                    System.out.print("Ingrese la cantidad que desee depositar: $");
                    cant = sc.nextInt();
                    System.out.println("Saldo Actual: $ " + saldo);
                    System.out.println("Cantidad Depositada: $ " + (saldo = saldo + cant));
                    ois.close();
                    //respuesta.close();
                    break;
                case "RETIRAR":
                    System.out.print("Ingrese la cantidad que desee retirar: $");
                    cant = sc.nextInt();
                    System.out.println("Saldo Actual: $ " + saldo);
                    System.out.println("Cantidad Depositada: $ " + (saldo = saldo - cant));
                    ois.close();
                    //respuesta.close();
                    break;
                default:
                ois.close();    
                //respuesta.close();
                break;
            }
            
            //respuesta.close();
            // System.out.println("Sent: localhost sender's message #" + i);
            /* 
            switch (op) {
                case 1:
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad que desee depositar: $");
                    cant = sc.nextInt();
                    System.out.println("Saldo Actual: $ " + saldo);
                    System.out.println("Cantidad Depositada: $ " + cant);
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad que desee retirar: $");
                    cant = sc.nextInt();
                    saldo = interfaz.retiro(cant, saldo);
                    System.out.println("Saldo Actual: $ " + saldo);
                    System.out.println("Cantidad Depositada: $ " + cant);
                    break;
                default:
                    break;
            }*/
        }
        System.out.println("GRACIAS POR SU PREFERIRNOS");
        // server.close();
    }
}
