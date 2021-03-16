package org.fuyi.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @ClassName: HeaderHttpResponseFilter
 * @Description: HeaderHttpResponseFilter
 * @author: zhoujian
 * @date: 2021/3/16 20:27
 * @version: 1.0
 */
public class HeaderHttpResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {
        response.headers().set("kk", "java-1-nio");
    }
}
