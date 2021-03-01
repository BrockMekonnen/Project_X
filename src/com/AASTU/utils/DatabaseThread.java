package com.AASTU.utils;

public class DatabaseThread {
    public static volatile boolean RUNNING = false;

    public static void terminate() {
        RUNNING = false;
    }

    public static void start() {
        RUNNING = true;
    }

}
