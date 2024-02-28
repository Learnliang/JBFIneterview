package com.jbf.interview.ienum;

/**
 * 3、超市做促销活动，草莓限时打 8 折。
 * 现在顾客 C 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
 * 请编写函数，对于 C 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
 *
 * 4、促销活动效果明显，超市继续加大促销力度，购物满 100 减 10 块。
 * 现在顾客 D 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
 * 请编写函数，对于 D 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
 */
public enum ActivityJREnum {

    /**
     * 第一次促销活动
     */
    NO_SELL(1,"无促销活动"),
    /**
     * 第一次促销活动
     */
    FIRST_SELL(3,"第一次促销，草莓限时八折"),

    /**
     * 第二次促销活动
     */
    SECOND_SELL(4,"第二次促销，购物满 100 减 10 块。");

    private Integer code;
    private String desc;

    ActivityJREnum() {
    }

    ActivityJREnum(Integer code, String name) {
        this.code = code;
        this.desc = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
