package com.mycloud.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author liyingjie
 * @Title: ResourceServerConfig
 * @Description:
 * @date 2019/6/24
 */
@Order(3)
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()//禁用了csrf（跨站请求伪造）功能
                .authorizeRequests()//限定签名成功的请求
                //必须认证过后才可以访问;注意：hasAnyRole 会默认加上ROLE_前缀，而hasAuthority不会加前缀
                //.antMatchers("/api/**").hasAuthority("user") // 在角色过滤的时候需要注意user角色需要加角色前缀
                .antMatchers("/api/**").authenticated()
                .antMatchers("/test/**").permitAll()
                // 免验证请求
                .antMatchers("/oauth/**").permitAll();
    }
}
