import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhiyou100.dao.mapper.AdminMapper;
import com.zhiyou100.dao.mapper.VideoMapper;
import com.zhiyou100.dao.model.Admin;
import com.zhiyou100.service.LoginService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")
public class Testservice {

	@Autowired
	LoginService lm;
	@Autowired
	VideoMapper vm;
	@Test
	public void eee(){
		Admin obj=new Admin();
		obj.setLoginName("admin");
		obj.setLoginPwd("admin");
		System.out.println(lm.show().get(3));;
//	s	System.out.println(lm.login(obj).get(0).getId());
	}
}
