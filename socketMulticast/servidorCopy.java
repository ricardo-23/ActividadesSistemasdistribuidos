
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class servidorCopy {

    private static ServerSocket server;
    private static int puerto = 5000;

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        server = new ServerSocket(puerto);
        String message;
        while (true) {

            // El mismo puerto que se uso en la parte de enviar.
            MulticastSocket escucha = new MulticastSocket(puerto);

            // Nos ponemos a la escucha de la misma IP de Multicast que se uso en la parte
            // de enviar.
            escucha.joinGroup(InetAddress.getByName("127.0.0.1"));

            // Un array de bytes con tamaño suficiente para recoger el mensaje enviado,
            // bastaría con 4 bytes.
            byte[] dato = new byte[1024];

            // Se espera la recepción. La llamada a receive() se queda
            // bloqueada hasta que llegue un mesnaje.
            DatagramPacket dgp = new DatagramPacket(dato, dato.length);
            escucha.receive(dgp);

            // Obtención del dato ya relleno.
            byte[] dato2 = dgp.getData();
            System.out.println("Received: localhost sender's message #"+dato2);
            // System.out.println("Esperado....");
            /*
             * Socket socket = server.accept();//Se queda porque espera que el cliente le
             * envie un socket
             * ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
             * message = (String) ois.readObject();
             * System.out.println("Received: localhost sender's message #"+message);
             * ois.close();
             */
            // socket.close();
            // System.out.println("Terminando el request");
        }
        // server.close();
    }
}
