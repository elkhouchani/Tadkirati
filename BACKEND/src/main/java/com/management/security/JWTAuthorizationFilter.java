package com.management.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JWTAuthorizationFilter extends OncePerRequestFilter {
    private static final Logger log = LoggerFactory.getLogger(JWTAuthorizationFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt = request.getHeader("Authorization");
        if (jwt == null || !jwt.startsWith(SecurityParameters.PREFIX)) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            String token = recuperarToken(request);

            // Validate the token and extract claims
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SecurityParameters.SECRET)).build();
            DecodedJWT decodedJWT = verifier.verify(token);

            // Extract user information and authorities
            String username = decodedJWT.getSubject();
            List<String> roles = decodedJWT.getClaims().get("roles").asList(String.class);
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            for (String role : roles) {
                authorities.add(new SimpleGrantedAuthority(role));
            }

            // Set authentication in the SecurityContextHolder
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            // Continue with the filter chain
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            log.error("Error processing JWT", e);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }


    private String recuperarToken (HttpServletRequest request){
            var authorizationHeader = request.getHeader("Authorization");
            if (authorizationHeader != null) {
                return authorizationHeader.replace("Bearer ", "");
            }
            return null;
        }
    }