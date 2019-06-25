package com.mycloud.auth.service;


import com.alibaba.fastjson.JSON;
import com.mycloud.auth.domain.MyUser;
import com.mycloud.auth.entity.SysPermission;
import com.mycloud.auth.entity.SysUser;
import com.mycloud.auth.exception.BizException;
import com.mycloud.auth.redis.RedisKey;
import com.mycloud.auth.redis.RedisTemplateUtils;
import com.mycloud.auth.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChengJianSheng
 * @date 2019-02-11
 */
@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = userService.getByUsername(username);
        if (null == sysUser) {
            log.warn("用户{}不存在", username);
            throw new UsernameNotFoundException(username);
        }
        List<SysPermission> permissionList = permissionService.findByUserId(sysUser.getId());
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(permissionList)) {
            for (SysPermission sysPermission : permissionList) {
                authorityList.add(new SimpleGrantedAuthority(sysPermission.getCode()));
            }
        }

        MyUser myUser = new MyUser(sysUser.getUsername(), passwordEncoder.encode(sysUser.getPassword()), authorityList);
        RedisTemplateUtils.set(RedisKey.JWT_TOKEN_USER_ID_KEY+username, JSON.toJSON(myUser));
        System.out.println("==============="+RedisTemplateUtils.getObj(RedisKey.JWT_TOKEN_USER_ID_KEY+username));
        log.info("登录成功！用户: {}", JSON.toJSONString(myUser));
        log.info("===============user: {}", RedisTemplateUtils.getObj(RedisKey.JWT_TOKEN_USER_ID_KEY+username));

        MyUser user = null;
        try {
            user = JwtUtil.getUser();
        } catch (BizException e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSON(user));

        return myUser;
    }
}
