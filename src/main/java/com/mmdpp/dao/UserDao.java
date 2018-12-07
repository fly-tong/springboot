package com.mmdpp.dao;


import com.mmdpp.po.User;
import com.mmdpp.querys.UserQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created on 2018/12/7 11:47
 * Author: Mr Tong
 */


import java.util.List;

@Mapper
public interface UserDao {

    @Select("select id,user_name userName,user_pwd userPwd from t_user where id=#{userId}")
    public User queryUserByUserId(Integer userId);


    public List<User> queryUsersByParams(UserQuery userQuery);


    @Insert("insert into t_user(user_name,user_pwd) values(#{userName},#{userPwd})")
    public  int save(User user);

    @Insert("update t_user set user_name=#{userName},user_pwd=#{userPwd} where id=#{id}")
    public  int update(User user);

    @Insert("delete from t_user where id=#{id}")
    public  int delete(Integer userId);
}
