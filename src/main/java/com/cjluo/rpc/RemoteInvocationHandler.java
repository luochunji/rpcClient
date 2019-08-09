package com.cjluo.rpc;

import com.cjluo.rpc.dto.Request;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 接口代理，将接口调用信息封装成Request
 * 通过网路传输组件发起RPC请求
 *
 * @author cj.luo
 * @date 2019/4/10
 */
public class RemoteInvocationHandler implements InvocationHandler {

    /**
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Request request = new Request();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParams(args);
        return NettyTransmission.send(request);
    }
}
