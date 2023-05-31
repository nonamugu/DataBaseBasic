package com.section2.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Application1 {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8013);

        Socket client;

        while((client = serverSocket.accept()) != null) {

            Socket finalClient = client;
            new Thread(() -> {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(finalClient.getInputStream()));

                    String generalHeader = reader.readLine();
                    System.out.println("generalHeader = " + generalHeader);

                    String requestMethod = generalHeader.split(" ")[0];
                    String requestPath = generalHeader.split(" ")[1];
                    System.out.println("requestMethod = " + requestMethod);
                    System.out.println("requestPath = " + requestPath);
                    
                    Map<String, String> requestHeader = new HashMap<>();
                    String line;
                    
                    while((line = reader.readLine()) != null) {

                        if(line.isBlank()) {
                            break;
                        }

                        String key = line.split(":")[0];
                        String value = line.split(":")[1];

                        requestHeader.put(key, value);
                    }

                    System.out.println("requestHeader = " + requestHeader);

                    String body = null;
                    if("POST".equals(requestMethod)) {

                        int contentLength = Integer.parseInt(requestHeader.get("Content-length"));
                        char[] temp = new char[contentLength];
                        reader.read(temp);
                        body = new String(temp).trim();
                    }

                    System.out.println("body = " + body);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }).start();
        }

    }

}
