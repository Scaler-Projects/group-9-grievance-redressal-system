package com.scaler.usermanagementservice.services;

import com.google.common.cache.Cache;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class JwtService {
    private static final int TOKEN_VALIDITY = 3600 * 5 * 1000;
    private static final SecretKey KEY = Jwts.SIG.HS256.key().build();

    private AuthenticationManager authManager;
    private final Cache<String, String> tokenCache;
    private UserDetailsServiceImpl userDetailsService;

    public JwtService(Cache<String, String> tokenCache) {
        this.tokenCache = tokenCache;
    }

    @Autowired
    public void setUserDetailsService(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void setAuthManager(AuthenticationManager authManager) {
        this.authManager = authManager;
    }


    public String generateToken(UserDetails userDetails) {
        String authorities = userDetails.getAuthorities().stream().map(
                        GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        Map<String, Object> claims = new HashMap<>();
        claims.put("Authorities", authorities);

        String jwtToken = Jwts.builder()
                .subject(userDetails.getUsername())
                .claims(claims)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY))
                .signWith(KEY)
                .compact();

        tokenCache.put(userDetails.getUsername(), jwtToken);

        return jwtToken;
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        } catch (DisabledException e) {
            throw new Exception("User is disabled");
        } catch (BadCredentialsException e) {
            throw new Exception("Bad credentials");
        }
    }

    public String getAuthUser(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (token == null) return null;

        return Jwts
                .parser()
                .verifyWith(KEY)
                .build()
                .parseSignedClaims(token.substring(7))
                .getPayload()
                .getSubject();
    }

    // Authenticate and return a token
    public String authenticateUser(String username, String password) throws Exception {
        authenticate(username, password);
        UserDetails user = userDetailsService.loadUserByUsername(username);
        return generateToken(user);
    }

    public void logout(String username) {
        tokenCache.invalidate(username);
    }
}
