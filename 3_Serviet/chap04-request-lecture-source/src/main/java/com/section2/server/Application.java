package com.section2.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Application {

    public static void main(String[] args) throws IOException {

        /* Header 값을 출력하는 간단한 웹서버 구현 */

        /* 요청을 한번 보내면 총 3번의 요청이 들어온다.
         * 이유는 브라우저가 favicon 요청을 위해 request를 다시 한 번 보내기 때문이다.
         * Firefox는 favicon을 최초 한 번 요청하고 favicon이 없으면 다시 한 번 요청을 보내므로
         * favicon이 없는 경우 본 요청 시 3번째 요청이 된다.
         * 여기서는 favicon 설정 없이 진행할 예정이므로 3번째 요청에 대해서만 처리하도록 구현한다.
         * */

        /* 클라이언트의 요청을 기다릴 ServerSocket 생성 */
        ServerSocket listener = new ServerSocket(8002);

        /* 요청 횟수를 판단하기 위한 변수 선언 */
        int count = 1;

        try {

            System.out.println("Http Server started at 8002 port");

            while (true) {

                /* 클라이언트 요청이 들어오면 통신할 socket 생성 */
                Socket socket = listener.accept();

                try {
                    /* 요청한 클라이언트의 정보 받아옴 */
                    System.out.printf("New Client Connect! Connected IP : %s, Port : %d\n",
                            socket.getInetAddress(), socket.getPort());

                    count++;

                    InputStream in = socket.getInputStream();
                    OutputStream out = socket.getOutputStream();

                    /* 파비콘 요청을 위한 요청은 건너뛰고 header 내용은 3번째 요청인 본 요청으로 읽음 */
                    int value = 0;
                    while((value = in.read()) != -1 && count == 3) {
                        System.out.print((char)value);
                    }

                    String responseText = "<h1>Hello World</h1>";

                    String responseGeneralHeader = "HTTP/1.1 200 OK \r\n";
                    String contentType = "Content-Type: text/html; charset=utf-8\r\n";
                    String contentLength = "Content-Length: " + responseText.length() + "\r\n";
                    String whiteLine = "\r\n";

                    /* 패킷 통신을 위해 byte 단위로 출력하도록 함 */
                    out.write(responseGeneralHeader.getBytes());
                    out.write(contentType.getBytes());
                    out.write(contentLength.getBytes());
                    out.write(whiteLine.getBytes());

                    out.write(responseText.getBytes());
                    out.write(whiteLine.getBytes());

                    out.flush();

                } finally {
                    /* 자원 반납 */
                    socket.close();
                }
            }
        } finally {
            /* 자원 반납 */
            listener.close();
        }

    }


}