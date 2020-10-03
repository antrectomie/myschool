package ro.alin.myschool.config;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ro.alin.myschool.userManagement.MyUserDetailsService;

import javax.sql.DataSource;

@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurity extends WebSecurityConfigurerAdapter {
//
//    @NonNull
//    private DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests()
//                .antMatchers("/error").permitAll()
//                .antMatchers("/error/**").permitAll()
                .antMatchers("/student/").hasAnyRole("PRINCIPAL","USER")
                .antMatchers("/security/principal").hasAnyRole("PRINCIPAL","USER")
                .antMatchers("/appUser/save").hasAnyRole("PRINCIPAL","USER")
//                .hasAnyRole("ADMIN", "USER", "STUDENT")
//                .antMatchers("/appUser/save").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic();
//                .and()
//                .formLogin()
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
//        auth.inMemoryAuthentication()
//                .withUser("alinescuUser").password("{noop}123").roles("USER")
//                .and()
//                .withUser("manager").password("{noop}123").roles("MANAGER");
    }
}
