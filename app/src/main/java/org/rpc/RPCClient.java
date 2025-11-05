package org.rpc;

// RPCClient.java
import java.io.*;
import java.net.*;

public class RPCClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5050);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );

        // Simulating an RPC call: add(5, 10)
        out.println("add,5,40");

        String response = in.readLine();
        System.out.println("Response from server: " + response);

        socket.close();
    }
}
