package com.discover.main;

import com.netflix.discovery.shared.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by kerns on 2017/3/23.
 */
@SpringBootApplication
@EnableEurekaServer
public class Discover {
    public static void main(String[] args) {
        SpringApplication.run(Discover.class, args);
    }
}
