package org.bliz.trivial;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlizzardTrivialApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlizzardTrivialApplication.class, args);
	}

	@Bean(name = "dozerBean")
	public Mapper configDozer() {
		List<String> configFiles = new ArrayList<>();
		configFiles.add("dozer.xml");

		return new DozerBeanMapper(configFiles);
	}
}
