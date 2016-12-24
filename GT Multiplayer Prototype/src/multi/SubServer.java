package multi;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SubServer extends Thread{
	
	//PLAYER DATA
	private Socket client;
	private int m_id;
	
	private DataInputStream INPUT;
	private DataOutputStream OUTPUT;

	public SubServer(int id, Socket connection){
		//Connection is the socket received by the ss.accept() method at Server.java line no. 29.
		this.client = connection;
		this.m_id = id;
		try{
			INPUT = new DataInputStream(client.getInputStream());
			OUTPUT = new DataOutputStream(client.getOutputStream());
		}catch(Exception e){
			if(e instanceof NullPointerException){
				System.out.println("Connection was null");
			}
		}
	}
	
	//Command for kicking out players or just for ending connection i.e, exiting
	public void Terminate() {
		try {
			OUTPUT.writeUTF("You have been kicked out of the Server");
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		//super.run(); //Super refers to the class we are extending from, in this case it is Thread.
		welcome();
		//This while loop is telling java that until this Thread is interrupted keep running the code. 
		//The interrupted() method is actually in the Thread class and we need not call it by Thread.interrupted() as we have extended the class
		while(!interrupted()){//Interrupted in the sense force exit, this occurs when user Control+C which causes Keyboard Interruption
			/***processing client's requests***/
			/***sending requests to clients***/
		}
		Terminate();
	}
	
	//Sends a welcome message to the client
	public void welcome(){
		try {
			OUTPUT.writeUTF("You have been assigned to subServer " + m_id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
