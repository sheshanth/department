package com.example.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class DepartmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentApplication.class, args);
	}

}

@RestController
@RequestMapping("/")
class Greeting {

	@Autowired
	public DiscoveryClient discoveryClient;

	@Value("${spring.application.name}")
	private String appName;

	@GetMapping
	public String greetings() {
		return "Hello!, from department application";
	}

	@GetMapping
	public List<String> getAllServices() {
		return this.discoveryClient.getServices();
	}

	@GetMapping("/department/app/name")
	public String getAppName() {
		return this.appName;
	}

}
