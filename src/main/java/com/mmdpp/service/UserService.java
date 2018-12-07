package com.mmdpp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmdpp.dao.UserDao;
import com.mmdpp.po.User;
import com.mmdpp.querys.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 2018/12/7 11:50
 * Author: Mr Tong
 */

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User queryUserByUserId(Integer userId){
       return  userDao.queryUserByUserId(userId);
    }

    public PageInfo<User> queryUsers(UserQuery userQuery){
        PageHelper.startPage(userQuery.getPageNum(),userQuery.getPageSize());
        return new PageInfo<User>(userDao.queryUsersByParams(userQuery));
    }

    public int save(User user){
        return userDao.save(user);
    }
    public int update(User user){
        return userDao.update(user);
    }
    public int delete(Integer userId){
        return userDao.delete(userId);
    }
}
