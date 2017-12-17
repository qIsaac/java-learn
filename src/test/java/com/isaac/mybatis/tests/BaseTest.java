package com.isaac.mybatis.tests;

import com.isaac.mybatis.entity.User;
import com.isaac.mybatis.mapper.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 9:22 2017/11/9
 */
public class BaseTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void setUp() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
    }

    @Test
    public void shouldGetAUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Mapper mapper = sqlSession.getMapper(Mapper.class);
            User use = mapper.getUser(1);
            System.out.println(use.getName());
            Assert.assertEquals("user1", use.getName());
        } finally {
            sqlSession.close();
        }
    }
    @Test
    public void shouldInsertAUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try {
            Mapper mapper = sqlSession.getMapper(Mapper.class);
            User user = new User();
            user.setId(2);
            user.setName("User2");
            mapper.insertUser(2,"user2");
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
