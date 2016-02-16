package Networks;

/**
 * Created by devan on 2/15/2016.
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {
    public static void main(String argv[]) throws Exception
    {
        String sentence;
        String modifiedSentence;
        String path;
        String host;
        String [] string;

        sentence = userInputWebAddress();

        string = parseString(sentence);
        host = string[0];
        path = string[1];

        Socket clientSocket = new Socket(host, 80);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        outToServer.writeBytes("GET " + path + " HTTP/1.1\nHost: " + host + "\nConnection: close\n\n");

        System.out.println("From Server:");
        while ((modifiedSentence = inFromServer.readLine()) != null) {
            System.out.println(modifiedSentence);
        }
        clientSocket.close();
    }

    public static String userInputWebAddress(){

        /* userInputWebAddress simply creates a scanner object
        * and adds the input from the user into a string that
        * we can use later for the host name and file path. */

        String string;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Enter the web address: ");
        string = scan.nextLine();
        return string;
    }

    public static String[] parseString(String string){

        /* parse String is given a string, which is split
         * at the "/" character and then returns a string
         * array of two strings which are now the host name
         * and the file path. */

        String [] stringArray = new String[2];
        if (string.contains("/")){
            stringArray[0] = string.substring(0, string.indexOf("/"));
            stringArray[1] = string.substring(string.indexOf("/"));
        }else{
            stringArray[0] = string;
            stringArray[1] = "/";
        }
        return stringArray;
    }
}

