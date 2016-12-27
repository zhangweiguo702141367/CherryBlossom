package com.cherryblossom.baomidou.service;

import com.baomidou.mybatisplus.service.IService;
import com.cherryblossom.baomidou.model.User;

import java.util.List;

/**
 * Created by nieqiurong on 2016/11/20.
 */
public interface UserService extends IService<User> {
    /**
     * 测试事务回滚
     * @param user
     */
    void testTransaction(User user);

    /**
     * 自定义XML SQL
     * @return
     */
    List<User> testXmlSQL();

    /**
     * 自定义注解 SQL
     * @return
     */
    List<User> testAnnotationSQL();
}
