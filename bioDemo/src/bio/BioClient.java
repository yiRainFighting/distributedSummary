import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BioClient {
    private static int PORT = 1234;
    private static  String IP = "127.0.0.1";
    private static  String expression = "";
    public static void send(String expression){
        send(IP,expression);
    }

    private static void send(String ip, String expression) {
        System.out.println("发送的表达式为"+expression);
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            socket = new Socket(IP,PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println(expression);
            System.out.println("客户端收到结果为："+in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

                try {
                    if (in != null) {
                        in.close();
                        in = null;
                    }

                    if (socket != null) {
                        socket.close();
                        socket = null;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }



            }

            if (out != null) {
                out.close();
                out = null;

            }




        }
    }

