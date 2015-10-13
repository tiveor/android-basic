package com.possiblelabs.asynctasktest;

/**
 * Created by possiblelabs on 10/7/15.
 */
public class TaskUtil {

    public static void sleep2s() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
