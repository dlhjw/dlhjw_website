package com.dlhjw.website.controller;

import com.qq.tars.spring.annotation.TarsHttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

@TarsHttpService("HttpObj")
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String testHello(@RequestParam Integer no){
        String ret = no + "Hello World";
        return ret;
    }


    @Autowired
    DataSource dataSource;


    @RequestMapping("/test")
    public String testDb(){

        String eq = "";
        try{
            dataSource.getConnection();
        } catch ( SQLException e ) {

            e.printStackTrace();
            eq = e.toString();
        }
        return eq;

    }

}
