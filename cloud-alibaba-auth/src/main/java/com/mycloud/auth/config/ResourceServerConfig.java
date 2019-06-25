package com.mycloud.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author liyingjie
 * @Title: ResourceServerConfig
 * @Description:
 * @date 2019/6/24
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login");
        http.csrf().disable();
        // 引用默认配置
        http.authorizeRequests()
                .antMatchers("/login","/oauth/**").permitAll();
    }

}
