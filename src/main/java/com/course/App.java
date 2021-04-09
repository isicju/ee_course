package com.course;

import spark.Spark;

public class App {
    public static void main(String[] args) {
        Spark.setPort(1111);
        Spark.setIpAddress("185.195.26.241");
        Spark.staticFileLocation("/public");
        Spark.get("/rest", (req, res) -> {
            return "hello from sparkjava.com";
        });
    }
}
