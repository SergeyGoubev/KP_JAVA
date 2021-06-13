package Agency.config;

import Agency.DAO.UserDAO;
import Agency.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan("Agency")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDAO userDao;
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl(userDao);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/organizator/orders/**").hasRole("ORGANIZATOR")
            .antMatchers("/user/orders/**").hasRole("USER")
            .and()
            .formLogin().loginPage("/entry").defaultSuccessUrl("/userIndex")
            .failureUrl("/entry?error")
            .usernameParameter("login").passwordParameter("password")
            .and()
            .exceptionHandling().accessDeniedPage("/403")
            .and()
            .logout().logoutSuccessUrl("/index")
            .and()
            .csrf().disable();
    }
}
