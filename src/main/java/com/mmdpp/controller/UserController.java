package com.mmdpp.controller;

/**
 * Created on 2018/12/7 11:47
 * Author: Mr Tong
 */

import com.github.pagehelper.PageInfo;
import com.mmdpp.po.User;
import com.mmdpp.querys.UserQuery;
import com.mmdpp.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * restful 接口
 *    请求类型
 *       post  put  delete get
 *    请求地址配置 避免动词(谓词)出现
 *       user/{userId}
 *       user/list   ----user/queryUserByParams
 *     响应
 *        JSON
 *
 * 接口工程:前后端分离开发模式
 *    后端:接口业务逻辑实现  接口文档
 *    前端(客户端    web 安卓  ios):页面布局  数据展示  接口调用
 *
 * 接口文档
 *     1.本地文档  word|md
 *     2.在线api文档(通过工具生成)
 *        Swagger2,(开源工具)公司内部实现
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;


    @GetMapping("user/{userId}")
    @ApiOperation(value = "根据用户Id查询用户记录")
    //@ApiImplicitParam(dataType = "integer",required = true)
    public User queryUserByUserId(@PathVariable  Integer userId){
        return userService.queryUserByUserId(userId);
    }

    @GetMapping("user/list")
    @ApiOperation(value = "列表查询用户")
    public PageInfo<User> queryUsers(UserQuery userQuery){
        return userService.queryUsers(userQuery);
    }

    @PutMapping("user")
    @ApiOperation(value = "添加用户")
    public  int saveUser(User user){
        return userService.save(user);
    }
    @PostMapping("user")
    @ApiOperation(value = "更新用户")
    public  int updateUser(User user){
        return userService.update(user);
    }

    @DeleteMapping("user/{userId}")
    @ApiOperation(value = "删除用户")
    public  int deleteUser(@PathVariable Integer userId){
        return userService.delete(userId);
    }
}
