package rpc;

public class ServerDemo {
    public static void main(String[] args){
        MyHello myHello = new MyHelloImpl();
        RpcServer server = new RpcServer();
        server.publisher(myHello,8888);
    }
}
