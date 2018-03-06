package com.iphotowalking.samples;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.iphotowalking.samples.mybatis.mapper")
public class SpringbootSamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSamplesApplication.class, args);
        System.out.println("[Sample服务]已启动");
    }
}
