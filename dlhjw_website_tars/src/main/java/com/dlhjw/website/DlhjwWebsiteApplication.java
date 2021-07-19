package com.dlhjw.website;

import com.qq.tars.spring.annotation.EnableTarsServer;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@EnableTarsServer
@MapperScan("com.dlhjw.website.mapper")
@SpringBootApplication
public class DlhjwWebsiteApplication {



    public static void main( String[] args ) {

        SpringApplication.run(DlhjwWebsiteApplication.class, args);

    }
}
