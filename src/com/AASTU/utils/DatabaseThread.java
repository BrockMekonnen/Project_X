package com.AASTU.utils;

public class DatabaseThread {
    public static volatile boolean RUNNING = false;

    public static volatile boolean CLINICALNOTERUNNING = false;

    public static void terminate() {
        RUNNING = false;
    }

    public static void start() {
        RUNNING = true;
    }

    public static void terminateClinicalNoteThread() {
        CLINICALNOTERUNNING = false;
    }

    public static void startClinicalNoteThread() {
        CLINICALNOTERUNNING = true;
    }

}
