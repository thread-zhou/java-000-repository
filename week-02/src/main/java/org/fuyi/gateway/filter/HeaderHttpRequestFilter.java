package org.fuyi.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @ClassName: HeaderHttpRequestFilter
 * @Description: HeaderHttpRequestFilter
 * @author: zhoujian
 * @date: 2021/3/16 20:25
 * @version: 1.0
 */
public class HeaderHttpRequestFilter implements HttpRequestFilter{
    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        fullRequest.headers().set("mao", "soul");
    }
}
