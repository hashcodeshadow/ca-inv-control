/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.renap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-sql.html
//http://localhost:8080/carrier/search/findByCarrierId?carrierId=2

@Configuration
@ComponentScan
//@EnableAutoConfiguration
//@EntityScan("com.springdrboot.domain")
@EntityScan("org.renap.orm")
//@EnableJpaRepositories("sample.data.jpa.service")
@EnableTransactionManagement

@SpringBootApplication // or @EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
