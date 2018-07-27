package com.luo.demo.hello.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author xiangnan
 */
@Data
public class TestParam {

    @NotEmpty
    private String name;

    @Min(0)
    @Max(120)
    private int age;
}
