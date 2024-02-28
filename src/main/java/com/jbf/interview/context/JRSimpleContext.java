package com.jbf.interview.context;

import com.jbf.interview.service.IJBFStrategy;
import com.jbf.interview.bean.Goods;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JRSimpleContext {
    private final Map<String, IJBFStrategy> strategyMap = new ConcurrentHashMap<>();

    /**
     * 构造函数
     *
     * @param strategyMap
     */
    public JRSimpleContext(Map<String, IJBFStrategy> strategyMap) {
        strategyMap.forEach(this.strategyMap::put);
    }

    /**
     * 商品订单编号处理
     */
    public String getSource(List<Goods> goodsInfo,String sourceFlag) {
        return strategyMap.get(sourceFlag).count(goodsInfo);
    }
}
