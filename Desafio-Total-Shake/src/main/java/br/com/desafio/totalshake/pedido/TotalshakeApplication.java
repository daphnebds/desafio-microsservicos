package br.com.desafio.totalshake.pedido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TotalshakeApplication{

	public static void main(String[] args) {
		SpringApplication.run(TotalshakeApplication.class, args);
	}

}
