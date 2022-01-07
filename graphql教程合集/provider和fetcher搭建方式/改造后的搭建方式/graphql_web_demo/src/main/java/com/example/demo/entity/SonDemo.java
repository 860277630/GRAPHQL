package com.example.demo.entity;


import lombok.Data;

@Data
public class SonDemo extends FatherDemo{
    private String id;
    private String name;

    public SonDemo(String id,String name,String address, String firstName) {
        super(address, firstName);
        this.id = id;
        this.name = name;
    }

    //继承关系  子类的tostring  要重写
    @Override
    public String toString() {
        return "SonDemo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}'+super.toString();
    }
}
