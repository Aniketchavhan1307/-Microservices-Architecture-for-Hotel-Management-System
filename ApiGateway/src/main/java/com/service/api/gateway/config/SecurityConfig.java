package com.service.api.gateway.config;

public class SecurityConfig{
	
}
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//@Configuration
//@EnableWebFluxSecurity
//public class SecurityConfig 
//{
//	
//	@Bean
//	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity)
//	{
//		// ServerHttpSecurity because flux-security
//		
//		httpSecurity
//					.authorizeExchange()
//					.anyExchange()
//					.authenticated()
//					.and()
//					.oauth2Client()
//					.and()
//					.oauth2ResourceServer()
//					.jwt();
//		
//		return httpSecurity.build();
//		
//		
////		return httpSecurity
////		        .csrf(csrf -> csrf.disable()) // Disable CSRF for stateless APIs
////		        .cors(cors -> cors.disable())  // Disable CORS (enable if required)
////		        .authorizeExchange(exchange -> exchange
////		            .anyExchange().authenticated()  // Secure all endpoints (authentication required)
////		        )
////		        .oauth2Client(Customizer.withDefaults())  // For outgoing OAuth2 client requests (default configuration)
////		        .oauth2ResourceServer(oauth2 -> oauth2.jwt())  // Validate incoming JWT tokens
////		        .build();
//		
//	}
//
//}
