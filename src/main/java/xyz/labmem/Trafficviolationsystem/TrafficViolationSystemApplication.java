package xyz.labmem.Trafficviolationsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("xyz.labmem.Trafficviolationsystem.Mapper")
public class TrafficViolationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrafficViolationSystemApplication.class, args);
	}

}
