package Networks;

import java.io.*;
import java.net.Socket;


/**
 * Created by devan on 2/17/2016.
 */
public class Program2Client {
    public static void main(String argv[]) throws Exception {

        try{
            Socket s = new Socket("192.168.254.5", 64386);//server ip and port
            DataInputStream input = new DataInputStream(s.getInputStream());
            DataOutputStream output = new DataOutputStream(s.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputMessage = "";
            String outputMessage = "";

            while(!inputMessage.equals("EXITEXIT")){
                outputMessage = br.readLine();
                output.writeUTF(outputMessage);
                inputMessage = input.readUTF();
                System.out.println(inputMessage);
            }

        }catch(Exception e){
            //Handle excpetions here
        }
    }
}
