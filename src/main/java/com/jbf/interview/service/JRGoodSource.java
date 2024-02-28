package com.jbf.interview.service;


import com.jbf.interview.ienum.ActivityJREnum;

import java.lang.annotation.*;

/**
 * 节日商品注解
 * @author 12134
 *
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface JRGoodSource {

    ActivityJREnum value();

}