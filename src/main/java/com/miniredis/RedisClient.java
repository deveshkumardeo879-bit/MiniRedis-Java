package com.miniredis;

import java.io.*;
import java.net.Socket;

public class RedisClient {

    public static void main(String[] args) {

        String host = "localhost";
        int port = 6379;

        try (
                Socket socket = new Socket(host, port);

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                PrintWriter writer = new PrintWriter(
                        socket.getOutputStream(), true);

                BufferedReader console = new BufferedReader(
                        new InputStreamReader(System.in))
        ) {

            System.out.println("Connected to Mini Redis!");

            // Read welcome messages
            System.out.println(reader.readLine());
            System.out.println(reader.readLine());

            while (true) {

                System.out.print("redis-client> ");

                String command = console.readLine();
                writer.println(command);

                writer.println(command);

                String response = reader.readLine();

                System.out.println(response);

                if (command.equalsIgnoreCase("EXIT")) {
                    break;
                }
            }

        } catch (IOException e) {

            System.out.println("Connection error: " + e.getMessage());
        }
    }
}