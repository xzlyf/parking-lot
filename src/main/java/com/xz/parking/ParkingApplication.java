package com.xz.parking;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描dao层
@MapperScan("com.xz.parking.dao")
public class ParkingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingApplication.class, args);
    }

}
