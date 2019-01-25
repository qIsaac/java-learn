package com.isaac.mybatis;

import com.isaac.mybatis.dao.UserMapper;
import com.isaac.mybatis.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 9:09 2018/9/6
 */
@Slf4j
public class MyBatisExample {
    public static void main(String[] args) throws IOException{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(MyBatisExample.class.getClassLoader(),resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //旧版的使用方式
        /*try {
            User user = (User)session.selectOne("com.isaac.mybatis.dao.UserMapper.selectByPrimaryKey",1);
            log.info("User is : {}",user.toString());
        } finally {
            session.close();
        }*/
        //新版的使用方式
        try( SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectByPrimaryKey(1);
            log.info("User is : {}", user.toString());
        }
    }

}
