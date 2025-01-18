package br.com.ewerton.padraocamadas.config;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity
public class ConfigSpring {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .requestMatchers("http://localhost:8090/h2-console**").permitAll() // Permite o acesso ao H2 Console
//                .anyRequest().authenticated() // Demais requisições exigem autenticação
//                .and()
//                .formLogin()
//                .permitAll() // Permite o login sem restrição
//                .and()
//                .logout()
//                .permitAll() // Permite o logout sem restrição
//                .and()
//                .csrf()
//                .ignoringRequestMatchers("http://localhost:8090/h2-console/**") // Ignora a proteção CSRF para o H2 Console
//                .and()
//                .headers()
//                .frameOptions().sameOrigin(); // Permite exibir o H2 Console dentro de um frame (necessário)
//        return http.build();
//    }
}
