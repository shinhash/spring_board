package kr.or.ddit;

import static org.junit.Assert.*;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/root-context.xml", 
								   "classpath:kr/or/ddit/config/spring/application-context.xml",
								   "classpath:kr/or/ddit/config/spring/datasource-context.xml",
								   "classpath:kr/or/ddit/config/spring/transaction-context.xml"})
@WebAppConfiguration
@Ignore
public class WebTestConfig {

	
	
	@Autowired // 동일한 타입으로 자동주입
	private WebApplicationContext context;
	
	protected MockMvc mockMvc; // dispatcher servlet 역할을 하는 객체
	
	
	@Resource(name = "dataSource")
	private DataSource dataSource;
	
	
	@Before
	public void setup() {
	mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	
	
	ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
	
//		new ClassPathResource("/kr/or/ddit/config/db/initData.sql"); // 리소스에 대한 경로를 가져오는 클래스
	// 해당 리소스 경로에 있는 스크립트를 가져오는 메서드 ==> addScript()
	// 가져오는 리소스가 복수개일 경우도 있다.
	populator.addScripts(new ClassPathResource("/kr/or/ddit/config/db/initData.sql"));
	
	// 에러발생시 멈출것인지 계속진행할 것인지에 대한 옵션
	populator.setContinueOnError(false);
	
	// 쿼리를 실행하는 메서드 execute()
	DatabasePopulatorUtils.execute(populator, dataSource);
	}
	
	
	
	
	@Ignore
	@Test
	public void test() {

	}

}
