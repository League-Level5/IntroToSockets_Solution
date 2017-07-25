package client;

import java.net.*;
import java.io.*;

public class ClientGreeter {

   public static void main(String [] args) {
	  //1. Create a String for the ip address of the server. 
	  // If you don't know how to find a computer's ip address, ask about ifconfig on linux/mac and ipconfig on windows.
      String serverName = "192.168.7.79";
      
      //2. Create an integer for the server's port number
      int port = 8080;
      
      //3. Make a try-catch block that catches any IOExceptions
      try {
    	 //4. Create an object of the Socket class. When initializing the object, pass in the ip address and the port number
         System.out.println("Connecting to " + serverName + " on port " + port);
         Socket client = new Socket(serverName, port);
         
         //5. Create a DataOutputStream object. When initializing it, use the Server object you created in step 4 to call the getOutputStream() method.
         System.out.println("Just connected to " + client.getRemoteSocketAddress());
         DataOutputStream out = new DataOutputStream(client.getOutputStream());
         
         //6. Use the DataOutputStream object to send a message to the server using the writeUTF(String message) method
         out.writeUTF("Hello from " + client.getLocalSocketAddress());
         
         //7. Create a DataInputStream object. When initializing it, use the Server object you created in step 4 to call the getInputStream() method.
         DataInputStream in = new DataInputStream(client.getInputStream());
         
         //8. Use the DataInputStream object to print a message from the server using the readUTF() method.
         System.out.println("Server says " + in.readUTF());
         
         //9. Close the client's server object
         client.close();
      }catch(IOException e) {
         e.printStackTrace();
      }
   }
}