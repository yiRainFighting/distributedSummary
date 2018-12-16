package rpc;

import java.io.Serializable;

public class RpcRequest implements Serializable {
    private static final long serialVersionUID = -5934149792585714099L;
    private String className;
    private String methodName;
    private Object[] paraneters;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParaneters() {
        return paraneters;
    }

    public void setParaneters(Object[] paraneters) {
        this.paraneters = paraneters;
    }
}
