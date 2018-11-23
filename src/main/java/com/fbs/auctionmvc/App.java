package com.fbs.auctionmvc;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@MapperScan("com.fbs.auctionmvc.dao")
@SpringBootApplication
public class App {

    @RequestMapping("/index")
    public String index(){
        return "hello";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
        System.out.println("11111111111111111111111111");
    }
    @Bean
    public DefaultKaptcha adsI(){
        Properties properties = new Properties();
        properties.put("kaptcha.textproducer.char.length",4);
        Config config = new Config(properties);

        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }


}
