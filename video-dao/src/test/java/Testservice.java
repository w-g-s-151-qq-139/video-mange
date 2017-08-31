import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhiyou100.dao.mapper.AdminMapper;
import com.zhiyou100.dao.mapper.VideoMapper;
import com.zhiyou100.dao.model.Admin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class Testservice {

	@Autowired
	AdminMapper lm;
	@Autowired
	VideoMapper vm;
	@Test
	public void eee(){
		Admin obj=new Admin();
		obj.setLoginName("admin");
		obj.setLoginPwd("admin");
//		System.out.println(lm.find().get(0).getId());;
		System.out.println(vm.show().get(3));
	}
}
