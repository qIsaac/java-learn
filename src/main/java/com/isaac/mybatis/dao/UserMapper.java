package com.isaac.mybatis.dao;

import com.isaac.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 9:37 2018/9/6
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUserName(String userName);

    User selectLogin(@Param("username") String username, @Param("password")String password);

    int checkUsername(String username);

    int checkEmail(String email);

    String selectQuestionByUsername(String username);

    int checkAnswer(@Param("username") String username,@Param("question") String question,@Param("answer") String answer);

    int updatePasswordByUsername(@Param("username") String username, @Param("passwordNew")String passwordNew);

    int checkPassword(@Param(value="password")String password,@Param("userId")Integer userId);

    int checkEmailByUserId(@Param(value="email")String email,@Param(value="userId")Integer userId);
}
