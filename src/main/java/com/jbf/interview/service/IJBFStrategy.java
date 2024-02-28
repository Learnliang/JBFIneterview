package com.jbf.interview.service;

import com.jbf.interview.bean.Goods;

import java.util.List;

/**
 * 策略方法接口
 */
public interface IJBFStrategy {
    /**
     * 活动，每个活动都有特定的商品奖励活动，该商品活动根据算法计算出来
     */
    String count(List<Goods> goodsList);
}
