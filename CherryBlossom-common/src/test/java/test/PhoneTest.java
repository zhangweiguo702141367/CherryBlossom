package test;


import com.baomidou.mybatisplus.mapper.SqlQuery;
import com.cherryblossom.baomidou.model.Phone;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by nieqiurong on 2016/12/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-config.xml"})
public class PhoneTest {
    private Logger logger = LoggerFactory.getLogger(PhoneTest.class);

    @Test
    public void testActiveRecord(){
        Phone phone = new Phone();
        phone.setUserName("testActiveRecord");
        boolean result = phone.insert();
        System.out.println();
        Assert.assertTrue(result);
    }

    @Test
    public void testSqlQuery(){
        int count = SqlQuery.db(Phone.class).selectCount("select count(1) from t_phone");
        logger.debug("search count:{}",count);
        boolean result = SqlQuery.db(Phone.class).delete("delete from t_phone where id = {0} ",1);
        Assert.assertFalse(result);
    }
    @Test
    public void testGetOne(){
    	Phone phone = new Phone();
    	List<Phone> selectAll = phone.selectAll();
    	System.out.println(selectAll);
    }
}
