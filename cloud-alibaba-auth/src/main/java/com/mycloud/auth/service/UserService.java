package com.mycloud.auth.service;


import com.mycloud.auth.entity.SysUser;

/**
 * @author ChengJianSheng
 * @date 2019-02-12
 */
public interface UserService {

    SysUser getByUsername(String username);
}
