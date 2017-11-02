package com.tracker.app.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.tracker.app.security.JWTAuthenticationFilter;
import com.tracker.app.security.JWTAuthorizationFilter;
import com.tracker.app.services.AuthenticationService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	private AuthenticationService authService;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	 @Value("${JWT_REGISTER_URL}")
	private String SIGN_UP_URL; // = "/auth/register";

	public WebSecurity(AuthenticationService authService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.authService = authService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.cors()
				.and()
				.csrf()
				.disable()
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.addFilter(new JWTAuthenticationFilter(authenticationManager()))
				.addFilter(new JWTAuthorizationFilter(authenticationManager()));
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authService).passwordEncoder(bCryptPasswordEncoder);
	}

	/**
	 * Configure a <code>CorsConfigurationSource</code>
	 * Necessary to explicitly set the exposed headers required by client.
	 * @return
	 */
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();

		config.setAllowCredentials(true);
//		config.addAllowedOrigin("http://localhost:4200");
//		config.addAllowedOrigin("http://localhost");
//		config.addAllowedOrigin("http://localhost:443");
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.setExposedHeaders(Arrays.asList("x-access-token", "Authorization", "Origin", "Accept", ""));
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		

		source.registerCorsConfiguration("/**", config);

		return source;
	}

}
