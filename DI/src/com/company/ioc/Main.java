package com.company.ioc;

public class Main {
    public static void main(String[] args) {
        String url = "www.naver.com/books/it?page=10&size=20&";
        System.out.println("main");

        Encoder encoder = new Encoder();
        String result = encoder.encode(url);
        System.out.println(result);
    }
}
