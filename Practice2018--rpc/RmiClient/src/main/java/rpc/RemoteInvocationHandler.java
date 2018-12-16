package rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RemoteInvocationHandler implements InvocationHandler {
    private String host;
    private int port;
    public RemoteInvocationHandler(String host,int port){
        this.host = host;
        this.port = port;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest request = new RpcRequest();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParaneters(args);

        TCPTransport transport = new TCPTransport(host, port);
        return transport.send(request);
    }
}
