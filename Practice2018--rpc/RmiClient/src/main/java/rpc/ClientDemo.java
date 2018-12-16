package rpc;

public class ClientDemo {
    public static void main(String[] args){
        RpcClientProxy clientProxy = new RpcClientProxy();
        MyHello myHello = clientProxy.ClientProxy(MyHello.class,"localhost", 8888);
        //myHello.sayHello("赵春秋");
        System.out.println(myHello.sayHello("赵春秋"));
    }
}
