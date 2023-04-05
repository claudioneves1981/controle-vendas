package com.magazineaziul.controlevendas.config;

import com.magazineaziul.controlevendas.model.Cargo;
import com.magazineaziul.controlevendas.repository.UsuarioRepository;
import com.magazineaziul.controlevendas.service.SecurityDatabaseService;
import com.magazineaziul.controlevendas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityDatabaseService securityService;

    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(securityService).passwordEncoder(new BCryptPasswordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/admin/\\w+").hasAnyRole("ROLE_ADMIN","ROLE_DIRECTORS","ROLE_MANAGERS","ROLE_USERS")
                .antMatchers("/directories/\\w+").hasAnyRole("ROLE_DIRECTORS","ROLE_MANAGERS","ROLE_USERS")
                .antMatchers("/managers/\\w+").hasAnyRole("ROLE_MANAGERS","ROLE_USERS")
                .antMatchers("/users").hasAnyRole("ROLE_USERS")
                .anyRequest().authenticated().and().formLogin();
    }
}
