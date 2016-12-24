package main;

import java.io.IOException;

import multi.Client;
import multi.Server;

public class Main {
	public static void main(String[] args) throws IOException {
		try {
			if(args[0].equals("true")){
				Thread serverThread = new Server(6444, 6);
				serverThread.start();
			} else {
				Thread clientThread = new Client(6444, args[1]);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
