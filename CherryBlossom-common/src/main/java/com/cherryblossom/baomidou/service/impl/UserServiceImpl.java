package com.cherryblossom.baomidou.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cherryblossom.baomidou.mapper.UserMapper;
import com.cherryblossom.baomidou.model.User;
import com.cherryblossom.baomidou.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nieqiurong on 2016/11/20.
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    public void testTransaction(User user) {
        this.insert(user);
        int i = 1/0;
    }

    public List<User> testXmlSQL() {
        return baseMapper.testXmlSQL();
    }

    public List<User> testAnnotationSQL() {
        return baseMapper.testAnnotationSQL();
    }
}
