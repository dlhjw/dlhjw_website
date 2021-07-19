package com.dlhjw.website;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;

@Slf4j
@MapperScan("com.dlhjw.website.mapper")
@SpringBootApplication
public class DlhjwWebsiteApplication {


    public static void main( String[] args ) {

        //SpringApplication.run(DlhjwWebsiteApplication.class, args);

        //启动即测试数据库连接，如果不想测试，可以将下面代码删去，开启上面代码
        try{
            ConfigurableApplicationContext context = SpringApplication.run(DlhjwWebsiteApplication.class, args);

            DataSource dataSource = context.getBean(DataSource.class);
            dataSource.getConnection().close();
            System.err.println("my-dataSource:" + context.getBean(DataSource.class));
        }catch (Exception e) {
            e.printStackTrace();
        }


    }
}
