package me.freaksmind.serverapp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
	
	public static final int PORT = 6666;

	public GameServer() throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(PORT);
			while (true) {
				System.out.println("Waiting for a client ...");
				Socket socket = serverSocket.accept();
				new ClientThread(socket, serverSocket).start();
			}
		} catch (IOException e) {
			System.err.println("Ooops... " + e);
		} finally {
			serverSocket.close();
		}
	}
}