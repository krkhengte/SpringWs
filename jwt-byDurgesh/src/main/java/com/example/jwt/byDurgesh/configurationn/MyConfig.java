package com.example.jwt.byDurgesh.configurationn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
class MyConfig {


    // Step 2-- create userDetail service bean in which we are configuring user details
    //Core interface which loads user-specific data.
    @Bean
    public UserDetailsService userDetailsService() {

        // UserDetailsService(Interface)
        //UserDetails (interface) haveing info of user

        UserDetails userDetails = User.builder().
                username("KrKhengte")
                //we will use encoded password here in passwordEncoder() here "DURGESH" is rawPassword
                .password(passwordEncoder().encode("Kartik@123")).roles("ADMIN").
                build();
        return new InMemoryUserDetailsManager(userDetails);
    }

    // Step 3-- create passwordEncoder in which password get encoder

    // PasswordEncoder that uses the BCrypt strong hashing function. Clients can optionally supply
    // a "version" ($2a, $2b, $2y) and a "strength" (a.k.a. log rounds in BCrypt)
    // and a SecureRandom instance. T
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Step 4-- create authenticationManager in which we are configuring user details
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}