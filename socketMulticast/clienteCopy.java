import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;

public class clienteCopy {

    static String host = "127.0.0.1";
    private static int port = 5000;

    public static void main(String args[]) throws IOException, ClassNotFoundException, InterruptedException {
        System.out.println("Inicio");
        int i = 0;
        while (true) {
            Thread.sleep(1000);

            MulticastSocket enviador = new MulticastSocket();

            // El dato que queramos enviar en el mensaje, como array de bytes.
            byte[] dato = new byte[] { 1, 2, 3, 4 };

            // Usamos la direccion Multicast 230.0.0.1, por poner alguna dentro del rango
            // y el puerto 55557, uno cualquiera que esté libre.
            DatagramPacket dgp = new DatagramPacket(dato, i++, InetAddress.getByName(host), port);

            // Envío
            enviador.send(dgp);

            /*
             * Socket socket = new Socket(host, port);
             * // ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
             * // String message = (String) ois.readObject();
             * // ois.close();
             * ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
             * 
             * oos.writeObject("" + i);
             * System.out.println("Sent: localhost sender's message #" + i);
             * i++;
             * 
             * socket.close();
             */
        }
        // server.close();
    }
}
