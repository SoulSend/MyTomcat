package org.example;

import org.example.connector.Impl.HttpConnector;

import java.util.logging.Logger;

//在这里启动http服务器
public class Main {
    public static void main(String[] args) {
        try (HttpConnector connector = new HttpConnector()) {
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        System.out.println("jerrymouse http server was shutdown.");
    }
}