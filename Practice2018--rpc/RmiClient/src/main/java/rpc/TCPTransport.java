package rpc;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPTransport {
    private String host;
    private int port;

    public TCPTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private Socket newSocket(){
        System.out.println("创建一个新的连接");
        Socket socket = null;
        try{
            return socket = new Socket(host,port);
        }  catch (IOException e) {
           throw new RuntimeException("创建连接失败");
        }
    }

    public Object send(RpcRequest request){
        Socket socket = null;
        Object result = null;
        try{
            socket = newSocket();
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(request);
            outputStream.flush();

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            result =inputStream.readObject();
            outputStream.close();
            inputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
