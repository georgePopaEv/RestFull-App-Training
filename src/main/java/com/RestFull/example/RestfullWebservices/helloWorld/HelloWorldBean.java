package com.RestFull.example.RestfullWebservices.helloWorld;

public class HelloWorldBean {
    private String message;
    private String tezt;

    public HelloWorldBean(String hello_world, String tes) {
        this.message = hello_world;
        this.tezt = tes;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getTezt() {
        return tezt;
    }

    public void setTezt(String tezt) {
        this.tezt = tezt;
    }

    @Override
    public String toString() {
        return String.format("HelloWorldBean [message=%s] and text is %s", message, tezt );
    }
}
