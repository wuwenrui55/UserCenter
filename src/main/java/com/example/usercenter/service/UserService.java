package com.example.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.usercenter.model.domain.User;

import javax.servlet.http.HttpServletRequest;

/**
* @author wuwenrui
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2022-03-20 12:17:38
*/
public interface UserService extends IService<User> {//用户服务

    /**
     * 用户注册
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @return id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登录
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param request
     * @return 登录的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);
}
