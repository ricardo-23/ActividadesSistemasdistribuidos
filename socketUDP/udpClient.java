//package socketUDP;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class udpClient {
        public static void main (String args []) throws SocketException, IOException{
            InetAddress IPAdress = InetAddress.getByName("127.0.0.1");
            DatagramSocket clientSocket = new DatagramSocket();
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
 
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

                System.out.println("Envio de dato");
                String sentence = inFromUser.readLine();
                sendData = sentence.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAdress, 9878);
                clientSocket.send(sendPacket);

                /*RECIBE */
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                String modifiedSentence = new String(receivePacket.getData());
                System.out.println("FROM SERVER: "+ modifiedSentence);
                clientSocket.close();

                System.out.println("SERVER OUT");
        }
    
}
