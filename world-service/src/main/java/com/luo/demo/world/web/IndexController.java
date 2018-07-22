package com.luo.demo.world.web;

import com.luo.demo.world.client.HelloServiceClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author xiangnan
 * date 2018/7/22 23:40
 */
@RestController
public class IndexController {

    @Resource
    private HelloServiceClient helloServiceClient;

    @GetMapping("/")
    public String index() {
        return helloServiceClient.index() + " -> world-service";
    }

}
