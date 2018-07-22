package com.luo.demo.world.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Description:
 *
 * @author xiangnan
 * date 2018/7/22 23:41
 */
@FeignClient("hello-service")
public interface HelloServiceClient {

    @GetMapping("/")
    String index();

}
