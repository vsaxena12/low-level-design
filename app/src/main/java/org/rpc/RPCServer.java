package org.rpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class RPCServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5050);
        System.out.println("RPC Server started on Port 5050");

        while(true) {
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Example input: add,5,10
            String request = in.readLine();
            String[] parts = request.split(",");
            String method = parts[0];
            int a = Integer.parseInt(parts[1]);
            int b = Integer.parseInt(parts[2]);

            int result = 0;
            if ("add".equals(method)) {
                result = add(a, b);
            }
            out.println(result);
            clientSocket.close();
        }
    }

    public static int add(int x, int y) {
        return x + y;
    }
}
