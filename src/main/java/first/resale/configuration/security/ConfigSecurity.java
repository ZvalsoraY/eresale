package first.resale.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

    public ConfigSecurity(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/registration").not().fullyAuthenticated()
                .antMatchers("/users/**").hasRole("ADMIN")
                .antMatchers("/**").hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin().permitAll()
                .loginPage("/login")
                .usernameParameter("user")
                .passwordParameter("pass")
                .defaultSuccessUrl("/", true)
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and().csrf().disable()
        ;
    }

}
