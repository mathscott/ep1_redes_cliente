package ep1_redes_cliente;

import java.io.*;
import java.net.*;
import java.util.*;
 
public class Client {
 
   public static void main(String argv[])
      {
	   try{
		    Socket s= new Socket("localhost",5555);
		    System.out.println("Client: "+"Connection Established");
		    
		    DataInputStream din = new DataInputStream(s.getInputStream());
		    DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		    InputStreamReader isr = new InputStreamReader(System.in);
		    BufferedReader br = new BufferedReader(isr);
		    String msgin="",msgout="";
		    while(!msgin.equals("end")) {
				msgin = din.readUTF();
		    	System.out.println(msgin);
		    	msgout = br.readLine();
		    	dout.writeUTF(msgout);
		    	
		    }
		    s.close();
 

 
	   }catch(Exception e){e.printStackTrace();}
      }
}