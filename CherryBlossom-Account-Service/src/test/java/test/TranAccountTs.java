package test;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cherryblossom.model.User;
import com.cherryblossom.provider.UserService;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * className：TranAccountTs Function： 多线程测试Mysql for update 行级锁， date:
 * 2014-10-31-下午2:13:43
 * 
 * @author laich
 */

// @Transactional 不添加事务处理，即默认用Mysql自动提交方式 auto commit();
public class TranAccountTs extends TestCase {
	private Logger logger = LoggerFactory.getLogger(UserTest.class);
	ClassPathXmlApplicationContext context;
	UserService userService;

	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] { "consumer.xml" });
		super.setUp();
		userService = (UserService) context.getBean("userService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		context = null;
	}

	public void testCreateAccount() {
		User entity = new User();
		entity.setUserId(1L);
		User user = userService.selectOne(new EntityWrapper<User>(entity));
		logger.debug(user.toString());
		user = userService.selectOne(new EntityWrapper<User>(entity,"userId,userName"));
		logger.debug(user.toString());
		System.out.println("-------------------------------------");
		System.out.println(user);

	}

}
