package com.RestFull.example.RestfullWebservices.helloWorld;

import org.springframework.web.bind.annotation.*;

//Controler
//this will be handling http request that why it is a controller
@RestController
public class HelloWorldController {

    //GET
    //URI - //hello-world
    //method - "Hello World"
    //@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    //hello-world-bean
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World", "aaa");
    }

    @GetMapping(path = "/hello-world/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World %s", name), "aaa");
    }
}
