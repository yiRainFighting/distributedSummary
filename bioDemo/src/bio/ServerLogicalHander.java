import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerLogicalHander implements Runnable{
    private static Socket socket = null;
    public ServerLogicalHander(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        String expression;
        int result ;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            while (true) {
                if((expression=in.readLine())==null) break;
                System.out.println(("服务端收到信息：" + expression));
                result  = Calculator.cal(expression);
                out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
