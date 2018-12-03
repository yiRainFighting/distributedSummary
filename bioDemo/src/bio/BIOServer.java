import com.sun.xml.internal.ws.handler.ServerLogicalHandlerTube;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * bio服务端代码
 */
public class BIOServer {
    private static int PORT = 1234;

    private static  ServerSocket serverSocket = null;

    public static void start(){
        start(PORT,serverSocket);
    }

    private static void start(int port, ServerSocket serverSocket) {
        if(serverSocket!=null) return;

        Socket socket =null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("服务端已启动，端口号:" + PORT);
            //阻塞体现在这里
            while(true){
                socket = serverSocket.accept();
                new Thread(new ServerLogicalHander(socket)).start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //一些必要的清理工作
            if (serverSocket != null) {
                System.out.println("服务端已关闭。");
                try {
                    serverSocket.close();
                    serverSocket = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }


    }

}
