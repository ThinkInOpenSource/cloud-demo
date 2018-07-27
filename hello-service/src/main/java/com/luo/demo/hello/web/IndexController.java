package com.luo.demo.hello.web;

import com.luo.demo.hello.model.TestParam;
import com.luo.demo.hello.util.BindingResultUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

    @GetMapping("/param/test")
    public Object paramTest(@Valid TestParam testParam, BindingResult result) {
        if (result.hasErrors()) {
            return BindingResultUtil.formatBindingResult(result);
        }

        System.out.println(testParam);

        return testParam;
    }

}
