package com.fafu.dao;

import com.fafu.domain.user.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Mapper
@Repository
public interface RoleDao {
    @Select("select * from role where rid in (select role_id from user_role where user_id = #{uid})")
    public List<Role> findUid(Integer uid);

    @Select("select rid from role where rid in (select role_id from user_role where user_id = #{uid})")
    public ArrayList<Integer> findid(Integer uid);

    @Select("select *from role")
    public List<Role> findAll_Role();

    @Select("select rid from role where identity = #{identity}")
    public Integer findRid(String identity);

    @Insert("Insert into user_role values(null,#{uid},#{rid})")
    public Integer save_user_role(Integer rid , Integer uid);

    @Delete("delete from user_role where user_id = #{uid}")
    public Integer delete_user_role(Integer uid);

}
