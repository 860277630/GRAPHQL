package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

// 用于模拟数据库  存储订单信息  注意要存储的不完善  以测试  其他功能
public  class orderData {
    private static List<Order> orders  = new ArrayList<>();

    public static List<Order>  getData(){
        return orders;
    }

    public static void createOrders(Integer num){
        //创造订单数据  单数的是不全的  双数的是全的
        for (Integer i = 0; i < num; i++) {
            if(i%2 == 0){
                //创造全的订单信息
                orders.add(allOfInfo());
            }
            else{
                //创造不全的订单信息
                orders.add(partOfInfo());
            }
        }
    }
    //创造全的订单信息
    private static Order allOfInfo(){
        Commodity commodity = Commodity.builder().name(getStr(5)).num(getNum()).build();
        Logistics logistics = Logistics.builder().company(getStr(8)).orderNum(getStr(16)).build();
        return Order.builder().commodity(commodity).logistics(logistics).build();
    }
    //创造不全的订单信息
    private static Order partOfInfo(){
        //只有商品信息  没有物流信息
        Commodity commodity = Commodity.builder().name(getStr(5)).num(getNum()).build();
        return Order.builder().commodity(commodity).logistics(null).build();
    }

    //创造不同位数的UUID
    private static String getStr(Integer num){
        String uuid = UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
        return uuid.substring(0,num);
    }
    //生成0~100的随机数
    private static Integer getNum(){
        Random r = new Random(1);
        return r.nextInt(100);
    }
}
