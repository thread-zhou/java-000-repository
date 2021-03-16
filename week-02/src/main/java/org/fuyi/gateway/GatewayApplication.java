package org.fuyi.gateway;

import org.fuyi.gateway.inbound.HttpInboundServer;

import java.util.Arrays;

/**
 * @ClassName: GatewayApplication
 * @Description: 启动类
 * @author: zhoujian
 * @date: 2021/3/16 20:12
 * @version: 1.0
 */
public class GatewayApplication {

    public final static String GATEWAY_NAME = "NIOGateway";
    public final static String GATEWAY_VERSION = "3.0.0";

    public static void main(String[] args) {
        String proxyPort = System.getProperty("proxyPort","8088");
        // 这是多个后端url走随机路由的例子
        String proxyServers = System.getProperty("proxyServers","http://localhost:9090,http://localhost:9091");
        int port = Integer.parseInt(proxyPort);
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" starting...");
        HttpInboundServer server = new HttpInboundServer(port, Arrays.asList(proxyServers.split(",")));
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" started at http://localhost:" + port + " for server:" + server.toString());
        try {
            server.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
