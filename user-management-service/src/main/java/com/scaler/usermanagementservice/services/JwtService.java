package com.scaler.usermanagementservice.services;

import com.google.common.cache.Cache;
import com.scaler.usermanagementservice.dtos.JwtResponseDto;
import com.scaler.usermanagementservice.dtos.UserLoginRequestDto;
import com.scaler.usermanagementservice.models.User;
import com.scaler.usermanagementservice.repositories.UserRepository;
import com.scaler.usermanagementservice.security.JwtUtility;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Setter
@Service
public class JwtService implements UserDetailsService {
    private final UserRepository userRepository;
    private final JwtUtility jwtUtility;
    private final AuthenticationManager authenticationManager;
    private final Cache<String, String> tokenCache;

    public JwtService(UserRepository userRepository, JwtUtility jwtUtility, @Lazy AuthenticationManager authenticationManager, Cache<String, String> tokenCache) {
        this.userRepository = userRepository;
        this.jwtUtility = jwtUtility;
        this.authenticationManager = authenticationManager;
        this.tokenCache = tokenCache;
    }


    public JwtResponseDto createJwtToken(UserLoginRequestDto userLoginRequestDto) throws Exception {
        String username = userLoginRequestDto.getUsername();
        String password = userLoginRequestDto.getPassword();
        authenticate(username, password);

        final UserDetails userDetails = loadUserByUsername(username);
        User user = userRepository.findByUsername(username).get();

        String jwtToken = "Bearer " + jwtUtility.generateToken(userDetails);
        tokenCache.put(username, jwtToken);

        return new JwtResponseDto(user, jwtToken);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("Username is not valid");
        }

        User user = optionalUser.get();

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                getAuthorities(user)
        );
    }

    private Set<SimpleGrantedAuthority> getAuthorities(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("Role_" + user.getRole().name()));

        return authorities;
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        } catch (DisabledException e) {
            throw new Exception("User is disabled");
        } catch (BadCredentialsException e) {
            throw new Exception("Bad credentials");
        }
    }

//    public String getToken(String username) {
//        return tokenCache.getIfPresent(username);
//    }

    public void logout(String username) {
        tokenCache.invalidate(username);
    }
}
