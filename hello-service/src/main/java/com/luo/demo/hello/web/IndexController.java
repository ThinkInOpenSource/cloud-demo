package com.luo.demo.hello.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiangnan
 */
@RestController
public class IndexController {

    @Value("${application.index.info}")
    private String info;

    @GetMapping("/")
    public String index() {
        return info;
    }

}
