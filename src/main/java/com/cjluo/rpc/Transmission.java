package com.cjluo.rpc;

import com.cjluo.rpc.dto.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author cj.luo
 * @date 2019/4/10
 */
public class Transmission {

    /**
     * 默认端口
     */
    private static final int PORT = 8080;
    /**
     * 默认服务地址
     */
    private static final String HOST = "localhost";


    public static Object send(Request request) {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        Object result = null;
        try (Socket socket = new Socket(HOST, PORT)) {
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(request);
            oos.flush();
            ois = new ObjectInputStream(socket.getInputStream());
            result = ois.readObject();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != ois) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return result;
    }
}
