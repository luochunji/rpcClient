package com.cjluo.rpc;

import com.cjluo.rpc.api.IPayService;
import com.cjluo.rpc.dto.User;

/**
 * @author cj.luo
 * @date 2019/4/10
 */
public class App {

    public static void main(String[] args) {
        IPayService payService = ProxyClient.newProxyInstance(IPayService.class);
        User user = new User("cj.luo");
        String result = payService.doPay(user);
        System.out.println(result);

    }
}