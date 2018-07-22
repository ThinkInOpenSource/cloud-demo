package com.luo.demo.world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Description:
 *
 * @author xiangnan
 * date 2018/7/22 23:39
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class WorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorldApplication.class, args);
    }

}
