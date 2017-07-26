package com.zipkin.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * Created by huangchunbo on 2017/6/25.
 */
@SpringBootApplication
@EnableZipkinServer
public class ZipkinApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(ZipkinApplication.class, args);
    }
}
