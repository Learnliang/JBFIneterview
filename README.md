# 项目启动步骤和参数说明
~~~ 
1. jdk 1.8 ，启动 com.jbf.interview.InterviewApplication 类
2. 用接口调试工具，如 postman ，进行接口调用
localhost:8080/jbf/test/sell?goods=1,2@2,3@3,4&sourceFlag=3
参数说明 ，goods 用 @ 分开商品类别，用，分隔商品编号和数量
商品编号，苹果-1 ，草莓-2，芒果-3
例 苹果两斤，草莓三斤，芒果四斤   1,2@2,3@3,4
sourceFlag 促销活动标志 ，1-无促销，3-促销活动(草莓打八折) ,4-促销活动(满一百减十元)

~~~
# 自测请求示例
~~~
1、有一家超市，出售苹果和草莓。其中苹果 8 元/斤，草莓 13 元/斤。
现在顾客 A 在超市购买了若干斤苹果和草莓，需要计算一共多少钱？
请编写函数，对于 A 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
自测：顾客购买苹果两斤，草莓三斤，无促销活动
请求示例：
localhost:8080/jbf/test/sell?goods=1,2@2,3&sourceFlag=1
结果响应:
编号:1,原价:8.0,重量:2 斤,实际单价:8.00,总价:16.00 	
编号:2,原价:13.0,重量:3 斤,实际单价:13.00,总价:39.00 	
原价：55.0	
实付:55.00

2、超市增加了一种水果芒果，其定价为 20 元/斤。
现在顾客 B 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
请编写函数，对于 B 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
自测：顾客购买苹果两斤，草莓两斤，芒果六斤，无促销活动
请求示例：
localhost:8080/jbf/test/sell?goods=1,2@2,2@3,6&sourceFlag=1
结果响应:
编号:1,原价:8.0,重量:2 斤,实际单价:8.00,总价:16.00 	
编号:2,原价:13.0,重量:2 斤,实际单价:13.00,总价:26.00 	
编号:3,原价:20.0,重量:6 斤,实际单价:20.00,总价:120.00 	
原价：162.0	
实付:162.00


3、超市做促销活动，草莓限时打 8 折。
现在顾客 C 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
请编写函数，对于 C 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
自测：顾客购买苹果两斤，草莓两斤，芒果六斤，草莓限时打 8 折
请求示例：
localhost:8080/jbf/test/sell?goods=1,2@2,2@3,6&sourceFlag=3
结果响应:
编号:1,原价:8.0,实际单价:8.00,重量:2 斤,总价:16.00 	
编号:2,原价:13.0,实际单价:10.40,重量:2 斤,总价:20.80 	
编号:3,原价:20.0,实际单价:20.00,重量:6 斤,总价:120.00 	
原价:162.0	
实付:156.80


4、促销活动效果明显，超市继续加大促销力度，购物满 100 减 10 块。
现在顾客 D 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
请编写函数，对于 D 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
自测：顾客购买苹果两斤，草莓两斤，芒果六斤，草莓限时打 8 折 且 购物满 100 减 10 块。
请求示例：
localhost:8080/jbf/test/sell?goods=1,2@2,2@3,6&sourceFlag=4
结果响应:
编号:1,原价:8.0,实际单价:8.00,重量2 斤,总价:16.00 	
编号:2,原价:13.0,实际单价:10.40,重量2 斤,总价:20.80 	
编号:3,原价:20.0,实际单价:20.00,重量6 斤,总价:120.00 	
原价：162.0	
实付:155.80
~~~