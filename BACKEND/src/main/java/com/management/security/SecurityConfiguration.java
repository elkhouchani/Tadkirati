package com.management.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.security.Security;
import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    AuthenticationManager authenticationManager;
    @Bean
    public AuthenticationManager authenticationManager(
            HttpSecurity httpSecurity, BCryptPasswordEncoder bCryptPasswordEncoder,
            UserDetailsService userDetailsService
            )throws Exception{
        return  httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder)
                .and().build();

    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();


        httpSecurity.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                .cors().configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration config = new CorsConfiguration();
                        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                        config.setAllowedMethods(Collections.singletonList("*"));
                        config.setAllowCredentials(true);
                        config.setAllowedHeaders(Collections.singletonList("*"));
                        config.setExposedHeaders(Arrays.asList("Authorization"));
                        config.setMaxAge(3600L);
                        return config;
                    }
                }).and()

                .authorizeHttpRequests()
                .requestMatchers("/login").permitAll()


                //Droit d'accés
                .requestMatchers(HttpMethod.GET,"/api/users").hasAuthority("ADMIN")


                .requestMatchers(HttpMethod.GET,"/api/events").hasAnyAuthority("ADMIN","ORGANISER","CLIENT")
                .requestMatchers(HttpMethod.GET,"/api/events/**").hasAnyAuthority("ADMIN","ORGANISER","CLIENT")

                .requestMatchers(HttpMethod.GET,"/api/movies").hasAnyAuthority("ADMIN","ORGANISER","CLIENT")
                .requestMatchers(HttpMethod.GET,"/api/movies/**").hasAnyAuthority("ADMIN","ORGANISER","CLIENT")
                //.requestMatchers(HttpMethod.POST,"/api/movies/save").hasAuthority("CREATE")
                .requestMatchers(HttpMethod.PUT,"/api/movies/update").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/api/movies/delete/**").hasAuthority("ADMIN")


                .requestMatchers(HttpMethod.GET,"/api/bookings").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET,"/api/bookings/**").hasAnyAuthority("ADMIN")
                //.requestMatchers(HttpMethod.POST,"/api/movies/save").hasAuthority("CREATE")
                .requestMatchers(HttpMethod.POST,"/api/bookings/save").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT,"/api/bookings/update").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT,"/api/bookings/update/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/api/bookings/delete/**").hasAuthority("ADMIN")

                .requestMatchers(HttpMethod.GET,"/api/tickets").hasAnyAuthority("ADMIN","ORGANISER","CLIENT")
                .requestMatchers(HttpMethod.GET,"/api/tickets/**").hasAnyAuthority("ADMIN","ORGANISER","CLIENT")
                .requestMatchers(HttpMethod.GET,"/api/categories").hasAnyAuthority("ADMIN","ORGANISER","CLIENT")
                .requestMatchers(HttpMethod.GET,"/api/categories/**").hasAnyAuthority("ADMIN","ORGANISER","CLIENT")

                .requestMatchers(HttpMethod.POST,"/api/tickets/save").hasAuthority("ADMIN")

                .requestMatchers(HttpMethod.PUT,"/api/tickets/update").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/api/tickets/delete/**").hasAuthority("ADMIN")



                .requestMatchers(HttpMethod.GET,"/api/categories").hasAnyAuthority("ADMIN","ORGANISER","CLIENT")
                .requestMatchers(HttpMethod.GET,"/api/categories/**").hasAnyAuthority("ADMIN","ORGANISER","CLIENT")

                //.requestMatchers(HttpMethod.POST,"/api/events/save").hasAuthority("CREATE")

                .requestMatchers(HttpMethod.PUT,"/api/events/update").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/api/events/delete/**").hasAuthority("ADMIN")



                .anyRequest().authenticated().and()
                .addFilterBefore(new JWTAuthenticationFilter(authenticationManager), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);


        return httpSecurity.build();
    }
}
