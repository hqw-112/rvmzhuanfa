package com.winter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@MapperScan("com.winter.mapper")
@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class
})
public class SampleController {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleController.class, args);
	}

}
