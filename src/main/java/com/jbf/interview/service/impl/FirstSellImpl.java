package com.jbf.interview.service.impl;

import com.jbf.interview.service.IJBFStrategy;
import com.jbf.interview.service.JRGoodSource;
import com.jbf.interview.bean.Goods;
import com.jbf.interview.ienum.ActivityJREnum;
import com.jbf.interview.util.Constant;

import java.text.DecimalFormat;
import java.util.List;


@JRGoodSource(ActivityJREnum.FIRST_SELL)
public class FirstSellImpl implements IJBFStrategy {
    /**
     * 3、超市做促销活动，草莓限时打 8 折。
     * 现在顾客 C 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
     * 请编写函数，对于 C 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
     */
    @Override
    public String count(List<Goods> goodsList) {
        DecimalFormat df = new DecimalFormat("#.00");
        StringBuilder sb = new StringBuilder();
        double totalMoney = 0d;
        double oldTotal = 0d;
        for (Goods goods : goodsList) {
            sb.append("编号:").append(goods.getNo()).append(",原价:").append(goods.getPrice());
            double price = goods.getPrice();
            Integer count = goods.getCount();
            oldTotal += count * price;
            if (Constant.STRAWBERRY_NO.equals(goods.getNo())) {
                // 草莓限时打 8 折
                price = goods.getPrice() * 0.8;
            }
            sb.append(",实际单价:").append(df.format(price));
            double money = count * price;
            sb.append(",重量:").append(count).append(" 斤");
            sb.append(",该件商品总价:").append(df.format(money)).append(" \t\n");
            totalMoney += money;
        }
        sb.append("原价:").append(oldTotal).append("\t\n实付:").append(df.format(totalMoney));
        return sb.toString();
    }

}
