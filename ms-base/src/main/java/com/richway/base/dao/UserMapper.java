package com.richway.base.dao;

import com.richway.base.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Created by Boao on 2018/6/13.
 */
@Component
@Mapper
public interface UserMapper {

    @Select("select * from user where name = #{name}")
    User findByName(@Param("name") String name);

    @Insert("insert into user(name,age) values (#{name},#{age})")
    int insert(@Param("name") String name,@Param("age") Integer age);
}
