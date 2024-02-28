package com.jbf.interview.controller;

import com.jbf.interview.ienum.ActivityJREnum;
import com.jbf.interview.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 */

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    /**
     * @param sourceFlag
     * 无促销活动
     * @see ActivityJREnum#NO_SELL;
     * 第一次促销活动  草莓限时八折
     * @see ActivityJREnum#FIRST_SELL;
     * 第二次加大力度的促销活动  购物满 100 减 10 块。
     * @see ActivityJREnum#SECOND_SELL;
     */
    @GetMapping("/sell")
    public Object getInfossell(String goods, String sourceFlag) {
        return testService.forSell(goods, sourceFlag);
    }

    @GetMapping("/getTest")
    public String testPath(){
        return "success";
    }

}
