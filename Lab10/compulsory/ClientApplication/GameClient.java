package me.freaksmind.clientapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GameClient {
	public static void main(String[] args) throws IOException {
		String serverAddress = "127.0.0.1";
		int PORT = 6666;
		try (Socket socket = new Socket(serverAddress, PORT);
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String command = "";
			boolean running = true;
			while (running) {
				System.out.println("Enter a command: ");
				command = br.readLine();
				out.println(command);
				String response = in.readLine();
				System.out.println(response);
				if (command.equals("stop") || command.equals("exit"))
					running = false;
			}
		} catch (UnknownHostException e) {
			System.err.println("No server listening... " + e);
		}
	}
}
