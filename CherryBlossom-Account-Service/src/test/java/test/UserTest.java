package test;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.cherryblossom.model.User;
import com.cherryblossom.provider.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * Created by nieqiurong on 2016/11/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-config.xml"})
public class UserTest {
    private Logger logger = LoggerFactory.getLogger(UserTest.class);
    @Autowired
    private UserService userService;

    @Test
    public void testInsertUser(){
        boolean result =  userService.insert(new User("testInsert"+System.currentTimeMillis(),4));
        Assert.assertTrue(result);
    }

    @Test
    public void testInsertBatch(){
        List<User> userList = new ArrayList<User>(Arrays.asList(new User("insertBatch1",1),new User("insertBatch2",2)));
        boolean result = userService.insertBatch(userList);
        Assert.assertTrue(result);
    }

    @Test
    public void testSelectPage(){
        Page<User> userPage = userService.selectPage(new Page<User>(1,10));
        List<User> userList = userPage.getRecords();
        logger.info(userPage.toString());
        for(User user:userList){
            logger.info(user.toString());
        }
        userPage = userService.selectPage(new Page<User>(1,10),new EntityWrapper<User>(new User(),"userId,userName"));
        userList = userPage.getRecords();
        logger.info(userPage.toString());
        for(User user:userList){
            logger.info(user.toString());
        }
    }

    @Test
    public void testSelectById(){
        User user = userService.selectById(1);
        Assert.assertNotNull(user);
        logger.debug(user.toString());
    }

    @Test
    public void testSelectByMap(){
        Map<String,Object> columnMap = new HashMap<String,Object>();
        columnMap.put("userName","insert");
        columnMap.put("userId",null);
        List<User> userList = userService.selectByMap(columnMap);
        for(User user:userList){
            logger.debug(user.toString());
        }
    }

    @Test
    public void testSelectList(){
        List<User> userList = userService.selectList(new EntityWrapper<User>(new User(),"userId,userName"));
        for(User user:userList){
            logger.debug(user.toString());
        }
    }

    @Test
    public void testSelectCount(){
        int count = userService.selectCount(new EntityWrapper<User>(new User()));
        logger.debug("search Count:{}",count);
    }

    @Test
    public void testSelectOne(){
        User entity = new User();
        entity.setUserId(1L);
        User user = userService.selectOne(new EntityWrapper<User>(entity));
        logger.debug(user.toString());
        user = userService.selectOne(new EntityWrapper<User>(entity,"userId,userName"));
        logger.debug(user.toString());
    }

    @Test
    public void testSelectBatchIds(){
        List<Long> idList = new ArrayList<Long>(Arrays.asList(1l,2l,3l));
        List<User> userList = userService.selectBatchIds(idList);
        for(User user:userList){
            logger.debug(user.toString());
        }
    }

    @Test
    public void testUpdate(){
        User user = new User(2L,"testUpdate",12);
        boolean result = userService.update(user,new EntityWrapper<User>(new User(2l)));
        Assert.assertTrue(result);
    }

    @Test
    public void testUpdateById(){
        boolean result = userService.updateById(new User(1L,"testUpdateById",12));
        Assert.assertTrue(result);
    }

    @Test
    public void testUpdateBatchById(){
        List<User> userList = new ArrayList<User>(Arrays.asList(new User(1L,"updateBatch1",1),new User(2l,"updateBatch2",2)));
        boolean result = userService.updateBatchById(userList);
        Assert.assertTrue(result);
    }

    @Test
    public void testDelete(){
        boolean result = userService.delete(new EntityWrapper<User>(new User("delete",2)));
        Assert.assertFalse(result);
    }

    @Test
    public void testDeleteById(){
        boolean result = userService.deleteById(2);
        Assert.assertTrue(result);
    }

    @Test
    public void testDeleteByMap(){
        Map<String,Object> columnMap = new HashMap<String,Object>();
        columnMap.put("userId",0L);
        boolean result = userService.deleteByMap(columnMap);
        Assert.assertFalse(result);
    }

    @Test
    public void testDeleteBatchIds(){
        List<Long> idList = new ArrayList<Long>(Arrays.asList(3l,4l,5L));
        boolean result = userService.deleteBatchIds(idList);
        Assert.assertFalse(result);
    }

    @Test
    public void testInsertOrUpdate(){
        boolean result = userService.insertOrUpdate(new User("insertOrUpdate",2));
        Assert.assertTrue(result);
        result = userService.insertOrUpdate(new User(2L,"insertOrUpdate",2));
        Assert.assertTrue(result);
    }

    @Test
    public void testXmlSQL(){
        List<User> userList = userService.testXmlSQL();
        for(User user:userList){
            logger.debug(user.toString());
        }
    }

    @Test
    public void testAnnotationSQL(){
        List<User> userList = userService.testAnnotationSQL();
        for(User user:userList){
            logger.debug(user.toString());
        }
    }

    @Test
    public void testTransaction(){
        userService.testTransaction(new User("testTransaction",4));
    }
}
