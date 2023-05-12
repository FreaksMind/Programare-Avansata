package me.freaksmind.serverapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ClientThread extends Thread {
	private Socket socket = null;
	private ServerSocket serverSocket = null;

	public ClientThread(Socket socket, ServerSocket serverSocket) {
		this.socket = socket;
		this.serverSocket = serverSocket;
	}

	public void run() {
		try {
			boolean running = true;
			while (running) {
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String request = in.readLine();
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				String response = "";
				if (request.equals("stop")) {
					response = "Server stopped";
					out.println(response);
					out.flush();
					socket.close();
					serverSocket.close();
					running = false;
				} else if (request.equals("exit")) {
					response = "Client disconnected";
					out.println(response);
					out.flush();
					socket.close();
					running = false;
				} else {
					response = "Server received the request... ";
					System.out.println("Received command [ " + request + " ] from client [ " + socket.getInetAddress().toString() + " ]");
				}
				out.println(response);
				out.flush();
			}
		} catch (

		IOException e) {
			System.err.println("Communication error... " + e);
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				System.err.println(e);
			}
		}
	}
}