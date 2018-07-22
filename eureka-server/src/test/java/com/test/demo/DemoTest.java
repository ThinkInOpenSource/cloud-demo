package com.test.demo;

import com.luo.demo.eureka.EurekaApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xiangnan
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EurekaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoTest {

    @Test
    public void test() {
    }

}
