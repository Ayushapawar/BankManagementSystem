package edu.j2ee.e1_sb_db.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
}
