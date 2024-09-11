package net.newlearning.journalApp.config;


import net.newlearning.journalApp.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SpringSecurity  {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceimple;


@Bean
public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws  Exception{
    httpSecurity.authorizeRequests()
            .antMatchers("/journal/**/user/**").authenticated()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .anyRequest().permitAll()
            .and()
            .httpBasic();
    httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();

    return httpSecurity.build();
}


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceimple).passwordEncoder(passwordEncoder());
    }


    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}