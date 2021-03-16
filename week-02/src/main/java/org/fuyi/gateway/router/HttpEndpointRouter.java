package org.fuyi.gateway.router;

import java.util.List;

/**
 * @InterfaceName: HttpEndpointRouter
 * @Description: HttpEndpointRouter
 * @author: zhoujian
 * @date: 2021/3/16 20:25
 * @version: 1.0
 */
public interface HttpEndpointRouter {

    String route(List<String> endpoints);

}
