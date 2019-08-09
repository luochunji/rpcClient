package com.cjluo.rpc;

import java.lang.reflect.Proxy;

/**
 * @author cj.luo
 * @date 2019/4/10
 */
public class ProxyClient {

    /**
     * 生成服务接口的代理对象
     * @param clazz server暴露的服务接口
     * @param <T>
     * @return
     */
    public static <T> T newProxyInstance(Class clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new RemoteInvocationHandler());
    }
}
