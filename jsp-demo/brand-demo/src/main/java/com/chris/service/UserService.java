package com.chris.service;

import com.chris.mapper.BrandMapper;
import com.chris.mapper.UserMapper;
import com.chris.pojo.Brand;
import com.chris.pojo.User;
import com.chris.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public User login(String username, String password){
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.select(username, password);
        sqlSession.close();
        return user;
    }

    public boolean register(User user){
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u = mapper.selectByUsername(user.getUsername());
        if(u==null){
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return u==null;
    }
}
