package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Discription :
 * @Author LTM
 */
@RestController
@RequestMapping("/dubbo")
public class HelloController {

    @Reference
    private HelloService helloService;

    @RequestMapping("/hello")
    public Map getName(String name){
        //远程调用
        System.out.println("hhhhhhh");
        String result = helloService.sayHello(name);
        System.out.println(result);
        Map map = new HashMap<>();
        map.put("result",result);
        return map;
    }
}
