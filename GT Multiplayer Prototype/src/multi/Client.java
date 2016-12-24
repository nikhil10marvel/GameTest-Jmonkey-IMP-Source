/**
 * 
 */
package multi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author Nikhil
 *
 */
public class Client extends Thread implements Runnable {
	
	protected DataInputStream din;
	protected DataOutputStream dos;
	private Socket server;
	
	public Client(int port, String hostname) {
		try {
			server = new Socket(hostname,port);
			din = new DataInputStream(server.getInputStream());
			dos = new DataOutputStream(server.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		//super.run();
		while(!interrupted()){
			/**Requesting to the server**/
			/**Request Handling from the server**/
		}
	}

}
