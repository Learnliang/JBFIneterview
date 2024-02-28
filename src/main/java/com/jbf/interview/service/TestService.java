package com.jbf.interview.service;

import com.jbf.interview.bean.Goods;
import com.jbf.interview.context.JRSimpleContext;
import com.jbf.interview.service.impl.FirstSellImpl;
import com.jbf.interview.service.impl.NoSellImpl;
import com.jbf.interview.service.impl.SecondSellImpl;
import com.jbf.interview.util.Constant;
//import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TestService {

    private JRSimpleContext jrSimpleContext;

    @PostConstruct
    public void init(){
        ConcurrentHashMap<String, IJBFStrategy> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("1", new NoSellImpl());
        concurrentHashMap.put("3", new FirstSellImpl());
        concurrentHashMap.put("4", new SecondSellImpl());
        jrSimpleContext = new JRSimpleContext(concurrentHashMap);

        // 模拟数据库初始化商品信息 商品价格 苹果 8 元/斤，草莓 13 元/斤  芒果，其定价为 20 元/斤
        Goods goods1 = new Goods("1", "苹果", 8.0 );
        Goods goods2 = new Goods("2", "草莓", 13.0);
        Goods goods3 = new Goods("3", "芒果", 20.0);
        Constant.STORE_GOODS.put("1",goods1);
        Constant.STORE_GOODS.put("2",goods2);
        Constant.STORE_GOODS.put("3",goods3);
    }

    /**
     * 无促销活动
     */
    public Object forSell(String goodInfos, String sourceFlag) {
        // 接口得到的传来购物信息 例 苹果两斤，草莓三斤，芒果四斤
        // 1,2@2,3@3,4
        String[] totalGood = goodInfos.split("@");
        ArrayList<Goods> goodsArrayList = new ArrayList<>(totalGood.length);
        for (String googStr : totalGood) {
            String[] info = googStr.split(",");
            Goods goods = Constant.STORE_GOODS.get(info[0]);
            Goods newGood = new Goods(goods);
            newGood.setCount(Integer.valueOf(info[1]));
            goodsArrayList.add(newGood);
        }
        return jrSimpleContext.getSource(goodsArrayList,sourceFlag);
    }

}
