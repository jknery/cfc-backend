package br.com.carrefour.cfc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = {"br.com.carrefour.cfc.configurtions", "br.com.carrefour.cfc.endpoints", "br.com.carrefour.cfc"})
public class CfcBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CfcBackendApplication.class, args);
	}

}
