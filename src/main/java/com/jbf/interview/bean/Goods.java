package com.jbf.interview.bean;

public class Goods {
    /**
     * 商品编号
     */
    private String no;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品价格 苹果 8 元/斤，草莓 13 元/斤  芒果，其定价为 20 元/斤
     */
    private Double price;

    /**
     * 水果斤数,值为大于等于 0 的整数
     */
    private Integer count;


    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Goods() {
    }

    public Goods(String no, String name, Double price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }

    public Goods(Goods goods) {
        this.no = goods.no;
        this.name = goods.name;
        this.price = goods.price;
    }
}
