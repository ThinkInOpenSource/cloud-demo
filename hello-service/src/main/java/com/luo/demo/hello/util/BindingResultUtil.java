package com.luo.demo.hello.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * @author xiangnan
 */
public class BindingResultUtil {

    /**
     * format error filed & message
     */
    public static String formatBindingResult(BindingResult result) {
        if (result.hasErrors()) {
            FieldError fieldError = result.getFieldError();
            return fieldError.getField() + fieldError.getDefaultMessage();
        } else {
            return "";
        }
    }

}
