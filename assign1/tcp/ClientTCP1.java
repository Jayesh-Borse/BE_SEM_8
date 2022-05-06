// A Java program for a Client
import java.net.*;
import java.io.*;
import java.math.*;
import java.util.*;

public class ClientTCP1
{
	// initialize socket and input output streams
	private Socket socket		 = null;
	private DataInputStream in	 = null;
	private DataOutputStream out	 = null;

	// constructor to put ip address and port
	public ClientTCP1(String address, int port)
	{
		// establish a connection
		try
		{
			socket = new Socket(address, port);
			System.out.println("Connected");

			// takes input from terminal
			in = new DataInputStream(socket.getInputStream());
				
			// sends output to the socket
			out = new DataOutputStream(socket.getOutputStream());

			Scanner sc= new Scanner(System.in);
			int a=0,b=0;
			
			while (a != -1)
			{
				System.out.print("Enter base: ");  
				a= sc.nextInt();  
				System.out.print("Enter power: ");  
				b= sc.nextInt();
				
				System.out.println("Sending Base and Power to Server");
				
				out.writeInt(a);
				out.writeInt(b);
				System.out.println(i);
				System.out.println("Answer recieved from server : " + in.readInt());

				System.out.println("Closing connection");
				out.close();
				socket.close();
			}
		}	
		catch(Exception i)
		{
			System.out.println(i.printStackTrace());
		}
	}

	public static void main(String args[])
	{
		ClientTCP1 client = new ClientTCP1("127.0.0.1", 5000);
	}
}
