package com.isaac.mybatis.mapper;

import com.isaac.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 9:27 2017/11/9
 */
public interface Mapper {
    User getUser(Integer id);
    void insertUser(@Param("id") Integer id, @Param("name") String name);
}
