package com.miniredis;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class RedisServer {

    private static final int PORT = 6379;

    public static void main(String[] args) {

        KeyValueStore database = new KeyValueStore();
        CommandHandler commandHandler = new CommandHandler(database);

        System.out.println("=================================");
        System.out.println("       MINI REDIS SERVER");
        System.out.println("=================================");
        System.out.println("Starting server on port " + PORT + "...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("Server started successfully!");
            System.out.println("Waiting for client connection...");

            while (true) {

                Socket clientSocket = serverSocket.accept();

                System.out.println("Client connected: "
                        + clientSocket.getInetAddress());

                new Thread(() ->
                        handleClient(clientSocket, commandHandler)
                ).start();
            }

        } catch (IOException e) {

            System.out.println("Server error: " + e.getMessage());
        }
    }

    private static void handleClient(
            Socket clientSocket,
            CommandHandler commandHandler) {

        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream()));

                PrintWriter writer = new PrintWriter(
                        clientSocket.getOutputStream(), true)
        ) {

            writer.println("Welcome to Mini Redis!");
            writer.println("Type commands like SET name Devesh");

            String command;

            while ((command = reader.readLine()) != null) {

                if (command.equalsIgnoreCase("EXIT")) {
                    writer.println("Goodbye!");
                    break;
                }

                String result = commandHandler.execute(command);

                writer.println(result);
            }

        } catch (IOException e) {

            System.out.println("Client disconnected.");
        }

        try {
            clientSocket.close();
        } catch (IOException ignored) {
        }
    }
}