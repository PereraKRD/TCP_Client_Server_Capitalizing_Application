package TCP_PACK;

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws Exception{
        String clientSentence;
        String capitalizedSentence;

        System.out.println("Waiting for clients");
        ServerSocket welcomeSocket = new ServerSocket(9806);

        while (true){

            Socket connectionSocket = welcomeSocket.accept();

            System.out.println("Connection is established");
            System.out.println("Getting client data");

            BufferedReader in = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence = in.readLine();

            capitalizedSentence = clientSentence.toUpperCase() + '\n';

            out.writeBytes(capitalizedSentence);

        }
    }
}
