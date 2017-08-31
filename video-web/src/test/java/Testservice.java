import javax.mail.Message;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhiyou100.dao.mapper.AdminMapper;
import com.zhiyou100.dao.model.Admin;
import com.zhiyou100.service.LoginService;
import com.zhiyou100.web.util.MailUtil;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")
public class Testservice {

	@Autowired
	LoginService lm;
	@Test
	public void eee(){
		Admin obj=new Admin();
		obj.setLoginName("admin");
		obj.setLoginPwd("admin");
		;
		System.out.println(lm.login(obj).get(0).getLoginName()+"----"+lm.login(obj).get(0).getId());
	}
	@Test
	public void mmm() throws Exception{
		MailUtil.send("m18803838096@163.com", "lalaal", "<a href='https://www.baidu.com'>°Ù¶È</a>");
	}
}
