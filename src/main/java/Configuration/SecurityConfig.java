package Configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests((requests) -> requests
            .antMatchers("/entry","/save").hasRole("TEACHER") //Only TEACHER can grade
            .antMatchers("/").permitAll() //Everyone can see the home page
            .anyRequest().authenticated() //Any other request require login
    )
        .formLogin((form) -> form
                .defaultSuccessUrl("/entry", true) // Redirect to form after login
                .permitAll()
            )
        .logout((logout) -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/") // Go back to home after logout
                .permitAll()
            );
        
        return http.build();
    }
    
    @Bean 
    public UserDetailsService userDetailsService(){
        //In-Memory Authentication
        UserDetails teacher = User.builder()
            .username("ahmed")
            .password(passwordEncoder().encode("12345"))
            .roles("TEACHER")
            .build();

        UserDetails student = User.builder()
            .username("ali")
            .password(passwordEncoder().encode("student1"))
            .roles("STUDENT")
            .build();
        return new InMemoryUserDetailsManager(teacher,student);
        
    }
    @Bean PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean 
    public UserDetailsManager userDetailManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcManager = new JdbcUserDetailsManager(dataSource);

        // OPTION A: If your tables match Spring's default names exactly
    // No extra config needed.

    // OPTION B: If you have your own table names (e.g., 'members', 'roles')

    jdbcManager.setUsersByUsernameQuery("SELECT user_id, pw, active FROM members WHERE user_id = ?");
    jdbcManager.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id=?");
    return jdbcManager;
    }
    
}
