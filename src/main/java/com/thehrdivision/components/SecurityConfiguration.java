package com.thehrdivision.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String[] PERMITED_ALL = new String[]{"/register/add", "/login", "/register", "/api/**", "/h2**", "/webjars/**", "/resetPassword", "/resetPassword/**"};
    private static final String[] AUTHENTICATED = new String[]{"/products", "/products/*", "/products/**"};
    private static final String[] ADMIN = new String[]{"/admin*", "/admin/**"};
    private static final String[] NOT_REGISTERER = new String[]{"/resetPassword", "/resetPassword/**"};
    
    private final UserDetailsService userDetailsService;


    public SecurityConfiguration(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(PERMITED_ALL)
                .permitAll()
                .antMatchers(AUTHENTICATED)
                .authenticated()
                .antMatchers(NOT_REGISTERER)
                .anonymous()
                .antMatchers(ADMIN)
                .hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .usernameParameter("login")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login");
    }

    @Autowired
    void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}
