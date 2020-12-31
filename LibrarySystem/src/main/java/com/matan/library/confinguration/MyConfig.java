package com.matan.library.confinguration;

import java.util.HashMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import com.matan.library.security.CustomSession;

@Configuration
public class MyConfig {

	@Bean
	public HashMap<String, CustomSession> tokensInMemory() {
		return new HashMap<>();
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

	/*
	 * @Bean public CorsFilter corsFilter() { final UrlBasedCorsConfigurationSource
	 * source = new UrlBasedCorsConfigurationSource(); final CorsConfiguration
	 * config = new CorsConfiguration(); config.setAllowCredentials(true);
	 * config.addAllowedOrigin(CorsConfiguration.ALL); config.addAllowedHeader("*");
	 * config.addExposedHeader("Authorization"); config.addAllowedMethod("OPTIONS");
	 * config.addAllowedMethod("HEAD"); config.addAllowedMethod("GET");
	 * config.addAllowedMethod("PUT"); config.addAllowedMethod("POST");
	 * config.addAllowedMethod("DELETE"); config.addAllowedMethod("PATCH");
	 * source.registerCorsConfiguration("/**", config); return new
	 * CorsFilter(source); }
	 */

}