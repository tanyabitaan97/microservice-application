/*
 * package com.example.apigateway;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.web.server.ServerHttpSecurity; import
 * org.springframework.security.web.server.SecurityWebFilterChain;
 * 
 * @Configuration public class ResourceServerConfig {
 * 
 * @Bean public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity
 * http) {
 * 
 * http.oauth2ResourceServer( c ->
 * c.jwt(j->j.jwkSetUri("http://localhost:9000/oauth2/jwks")) ); return
 * http.build(); } }
 */