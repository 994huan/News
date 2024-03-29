package com.fafu.dao;

import com.fafu.domain.user.User;
import com.fafu.domain.user.User_login;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    @Select("select * from user where username = #{username}")
    @Results({
            @Result(id = true, property = "uid", column = "uid"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "roles", column = "uid",many = @Many(select = "com.fafu.dao.RoleDao.findUid")),
            @Result(property = "roleId",column = "uid",many = @Many(select = "com.fafu.dao.RoleDao.findid"))
    })
    public User findUser(String username);

    @Select("select * from user where username like #{query}")
    public List<User_login> findAll_User(String query);

    @Select("select * from user where uid = #{uid}")
    public  User_login findId_User(Integer uid);

    @Update("update user set username = #{username}, password =  #{password}, email = #{email}, phone = #{phone}," +
            "identity = #{identity} where uid = #{uid}")
    public Integer update_User(User_login user);

    @Insert("Insert into user values(null,#{username},#{password},#{email},#{phone},#{identity})")
    @Options(useGeneratedKeys = true,keyProperty = "uid")
    public Integer save_User(User_login uer);

    @Delete("delete from user where uid = #{uid}")
    public Integer detele_User(Integer uid);
}
