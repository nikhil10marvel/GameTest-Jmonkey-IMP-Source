/**
 * 
 */
package multi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Nikhil
 *
 */
public class Server extends Thread implements Runnable{
	
	//Initializing Vars
	protected final ServerSocket ss;
	protected SubServer[] subServers;
	
	//Main Constructor
	public Server(int port, int max_clients) throws IOException{
		ss = new ServerSocket(port, max_clients);
		subServers = new SubServer[max_clients];
	}
	
	//Run method for Thread
	public void run(){
		try {
			// ServerSocket.accept() method constantly checks for a connection in the form of sockets and assigns the socket to the variable, in this case 'connection'
			Socket connection = ss.accept();
			//Assigns the client/socket/connection to a SubServer who is like a waiter, who takes care of everything for a person at a restaurant.
			assign(connection);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Assigning clients
	protected void assign(Socket connection){
		for(int x=0;x<subServers.length;x++){
			//Find a SubServer that is free and not occupied
			if(subServers[ x ] == null){
				subServers[ x ] = new SubServer(x, connection);
				System.out.println(connection.getRemoteSocketAddress() + "was assigned to subServer id: " + x);
			//If the world/lobby is filled i.e. The maximum number of players set by the admin is reached 
			} else {
				/**Sorry Note**/
			}
		}
	}
	
	//Sending out cheaters,etc. To be done by the administrator
	protected void kick(int id){// IDs of all players joined will show up on the server console(available only for admin) upon request
		if(!(subServers[ id ] == null)){
			subServers[ id ].Terminate();
			subServers[ id ] = null;
		} else {
			System.out.println("There's no one at SubServer id:" + id);
		}
	}
	
}
