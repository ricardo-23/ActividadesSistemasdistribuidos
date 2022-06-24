import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class clienteCopy2 {

    static String host = "127.0.0.1";
    private static int port = 5000;

    public static void main(String args[]) throws IOException, ClassNotFoundException, InterruptedException {
        System.out.println("Inicio");
        int i = 2;
        while (true) {
            Thread.sleep(1000);
            Socket socket = new Socket(host, port);
            // ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            // String message = (String) ois.readObject();
            // ois.close();
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            oos.writeObject("" + i);
            System.out.println("Sent: localhost sender's message #" + i);
            i++;
            socket.close();
        }
        // server.close();
    }
}
