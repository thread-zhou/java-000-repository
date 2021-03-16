package org.fuyi.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @InterfaceName: HttpRequestFilter
 * @Description: HttpRequestFilter
 * @author: zhoujian
 * @date: 2021/3/16 20:26
 * @version: 1.0
 */
public interface HttpRequestFilter {

    void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx);

}
