package org.fuyi.gateway.router;

import java.util.List;
import java.util.Random;

/**
 * @ClassName: RandomHttpEndpointRouter
 * @Description: RandomHttpEndpointRouter
 * @author: zhoujian
 * @date: 2021/3/16 20:28
 * @version: 1.0
 */
public class RandomHttpEndpointRouter implements HttpEndpointRouter {
    @Override
    public String route(List<String> urls) {
        int size = urls.size();
        Random random = new Random(System.currentTimeMillis());
        return urls.get(random.nextInt(size));
    }
}
