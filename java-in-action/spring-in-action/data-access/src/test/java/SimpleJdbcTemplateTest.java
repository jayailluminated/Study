import com.roadrantz.dao.RantDao;
import com.roadrantz.domain.Motorist;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * User: moretajoo
 * Date: Mar 18, 2010
 * Time: 11:55:25 PM
 */
public class SimpleJdbcTemplateTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	private BeanFactory factory;

	@Before
	public void setUp() {
		factory = new ClassPathXmlApplicationContext("data-access-jdbcTemplate.xml");
	}

	@After
	public void tearDown () {
	}

	@Test
	public void testSimpleJdbcTemplateTest () {
		RantDao rantDao = (RantDao) factory.getBean("rantDao");

		Motorist motorist = new Motorist();
		motorist.setId(1);
		motorist.setEmail("moretajoo@gmail.com");
		motorist.setPassword("test");
		motorist.setFirstName("jungjoo");
		motorist.setLastName("seo");

		rantDao.saveMotorist(motorist);

		Motorist motorist2 = rantDao.getMotoristById(1L);

		assertEquals(motorist, motorist2);

	}

}