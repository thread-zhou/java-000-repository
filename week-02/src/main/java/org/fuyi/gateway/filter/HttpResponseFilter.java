package org.fuyi.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @InterfaceName: HttpResponseFilter
 * @Description: HttpResponseFilter
 * @author: zhoujian
 * @date: 2021/3/16 20:24
 * @version: 1.0
 */
public interface HttpResponseFilter {

    void filter(FullHttpResponse response);

}
