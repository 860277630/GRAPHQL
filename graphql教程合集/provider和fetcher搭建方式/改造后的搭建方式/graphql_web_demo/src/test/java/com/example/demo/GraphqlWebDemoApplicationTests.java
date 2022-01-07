package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Function;

@SpringBootTest
class GraphqlWebDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test_3() {
        System.out.println(changeString("abcdefghijklmnopq",(str)->str.length()) );
    }

    // 需求：处理一些字符串
    public Integer changeString(String temp, Function<String, Integer> function) {
        return function.apply(temp);
    }

}
