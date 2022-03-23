package com.example.usercenter.service;

import com.example.usercenter.model.domain.User;
import com.example.usercenter.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserServiceTest {

    @Resource
    private UserServiceImpl userServiceImpl;

    @Test
    void testAddUser() {
        User user = new User();
        user.setUsername("TestAdmin");
        user.setUserAccount("123");
        user.setAvatarUrl("");
        user.setGender(0);
        user.setUserPassword("123");
        user.setPhone("123");
        user.setEmail("123");
        userServiceImpl.save(user);
        System.out.println(user.getId());
        Assertions.assertEquals(1,user.getId());
    }

    @Test
    void userRegister() {
        String userAccount = "wwrr";
        String userPassword = "12345612";//两次密码不一致
        String checkPassword = "12345";
        long l = userServiceImpl.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,l);
        userAccount = "ww";//账户小于4位
        userPassword = "12345612";
        checkPassword = "12345612";
        l = userServiceImpl.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,l);
        userAccount = "wwewq";
        userPassword = "12345";//密码小于8位
        checkPassword = "12345";
        l = userServiceImpl.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,l);
        userAccount = "ww  *&%";//账号包含特殊字符
        userPassword = "123456";
        checkPassword = "123456";
        l = userServiceImpl.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,l);
        userAccount = "123";//账户不能重复
        userPassword = "1234561223";
        checkPassword = "1234561223";
        l = userServiceImpl.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,l);
        userAccount = "wwweww";//正确
        userPassword = "123456121";
        checkPassword = "123456121";
        l = userServiceImpl.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(4,l);
    }
}