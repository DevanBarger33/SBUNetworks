package Networks;

import javax.xml.bind.SchemaOutputResolver;
import java.net.*;
import java.io.*;

/**
 * Created by devan on 2/17/2016.
 */
public class Program2Server {
    public static void main(String[] args){
        try{
            /**This is the main transport socket for our server*/
            ServerSocket socket = new ServerSocket(64386);

            /**This is a socket used to accept messages from client.*/
            Socket sock = socket.accept();

            DataInputStream input = new DataInputStream(sock.getInputStream());
            DataOutputStream output = new DataOutputStream(sock.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String inputMessage = "";
            String outputMessage = "";

            while (!inputMessage.equals("EXITEXIT")){
                inputMessage = input.readUTF();
                System.out.println(inputMessage);
                outputMessage = br.readLine();
                output.writeUTF(outputMessage);
                output.flush();
            }
            sock.close();

        }catch(Exception e){


        }
    }
}
