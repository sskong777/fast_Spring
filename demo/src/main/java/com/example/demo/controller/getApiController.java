package com.example.demo.controller;


import com.example.demo.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class getApiController {

    @GetMapping(path="/hello")
    public  String getHello(){
        return "Get Hello";
    }

    @RequestMapping(path = "/hi",  method= RequestMethod.GET)  //get http://localhost:9090/api/get/hi
    public String hi(){
        return "hi";
    }

    // Path Variable
    @GetMapping("/path/-variable/{name}")
    public String pathVariable(@PathVariable String name){
        System.out.println("PathVariable : " + name);

        return name;
    }

    // Query Parameter
    // https://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com
    @GetMapping(path="query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {

            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();

    }

    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name+" "+email + " "+ age;
    }


    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest
    ){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }


}