package com.jbf.interview.service.impl;

import com.jbf.interview.bean.Goods;
import com.jbf.interview.ienum.ActivityJREnum;
import com.jbf.interview.service.IJBFStrategy;
import com.jbf.interview.service.JRGoodSource;

import java.text.DecimalFormat;
import java.util.List;


@JRGoodSource(ActivityJREnum.NO_SELL)
public class NoSellImpl implements IJBFStrategy {
    /**
     * 无促销活动
     */
    @Override
    public String count(List<Goods> goodsList) {
        DecimalFormat df = new DecimalFormat("#.00");
        StringBuilder sb = new StringBuilder();
        double totalMoney = 0d;
        for (Goods goods : goodsList) {
            sb.append("编号:").append(goods.getNo()).append(",原价:").append(goods.getPrice());
            double price = goods.getPrice();
            sb.append(",重量:").append(goods.getCount()).append(" 斤");
            sb.append(",实际单价:").append(df.format(price));
            double money = goods.getCount() * price;
            sb.append(",总价:").append(df.format(money)).append(" \t\n");
            totalMoney += money;
        }
        sb.append("原价：").append(totalMoney).append("\t\n实付:").append(df.format(totalMoney));
        return sb.toString();
    }

}
