package com.cherryblossom.provider.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cherryblossom.mapper.UserMapper;
import com.cherryblossom.model.User;
import com.cherryblossom.provider.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nieqiurong on 2016/11/20.
 */
@Component("userService")
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
