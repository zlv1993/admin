package com.zlv.admin.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private com.zlv.admin.config.security.UrlAccessDeniedHandle urlAccessDeniedHandle;
    @Autowired
    private com.zlv.admin.config.security.UrlAuthenticationEntryPoint urlAuthenticationEntryPoint;
    @Autowired
    private SpUserDetailService userDetailService;
    @Autowired
    private UrlAuthenticationFailureHandler spAuthenticationFailureHandler;
    @Autowired
    private com.zlv.admin.config.security.UrlAuthenticationSuccessHandler spAuthenticationSuccessHandler;
    @Autowired
    private com.zlv.admin.config.security.SpSecurityMetadataSource mySecurityMetadataSource;
    @Autowired
    private SpAccessDecisionManager myAccessDecisionManager;
    @Autowired
    private com.zlv.admin.config.security.JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login","/").permitAll()
                .and().authorizeRequests().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                object.setAccessDecisionManager(myAccessDecisionManager);
                object.setSecurityMetadataSource(mySecurityMetadataSource);
                return object;
            } })
                .and().authorizeRequests().anyRequest().authenticated()
                .and().csrf().disable().cors()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().formLogin().successHandler(spAuthenticationSuccessHandler).failureHandler(spAuthenticationFailureHandler)
                .and().exceptionHandling().accessDeniedHandler(urlAccessDeniedHandle).authenticationEntryPoint(urlAuthenticationEntryPoint)
                .and().addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

}
