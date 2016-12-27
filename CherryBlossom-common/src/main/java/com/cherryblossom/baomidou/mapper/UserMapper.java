package com.cherryblossom.baomidou.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cherryblossom.baomidou.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by nieqiurong on 2016/11/20.
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> testXmlSQL();

    @Select(value = "select * from t_user where userId > 1")
    List<User> testAnnotationSQL();
}
