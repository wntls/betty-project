package com.koreate.betty.domain.member;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.koreate.betty.domain.member.dto.form.JoinForm;
import com.koreate.betty.domain.member.dto.form.LoginForm;
import com.koreate.betty.domain.member.service.MemberService;
import com.koreate.betty.domain.member.vo.Member;
import com.koreate.betty.global.config.AppConfig;
import com.koreate.betty.global.config.RootConfig;
import com.koreate.betty.global.config.WebConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ContextConfiguration(classes = { WebConfig.class, AppConfig.class, RootConfig.class })
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class MemberTest {

	@Autowired
	MemberService ms;
	
	@Test // 완료
	public void joinTest() {
		JoinForm form = new JoinForm("123","2","2","2","2","2","2000-11-22","2","2","2", 0);
		
		int result = ms.joinMember(form);
		log.info("\n\n\n ::: joinTest result : {}", result);
	}
	
//	@Test // 완료
	public void loginTest() {
		LoginForm form = new LoginForm("1", "1", "on");
		Member loginMember = ms.loginMember(form);
		log.info("\n\n\n ::: loginTest Member : {}", loginMember);
	}
	
//	@Test // 완료
	public void findIdTest() {
		String name = "2";
		String phone = "2";
		String id = ms.findId(name, phone);
		
		log.info("\n\n\n ::: findIdTest id : {}", id);
	}

//	@Test // 완료
	public void confirmForChangePwTest() {
		String id = "123";
		String phone = "2";
		
		int result = ms.confirmForChangePw(id, phone);
		
		log.info("\n\n\n ::: confirmForChangePwTest : {}", result);
	}
	
//	@Test // 완료
	public void changePwTest() {
		String id = "123";
		String pw = "3";
		
		int result = ms.changePw(id, pw);
		
		log.info("\n\n\n ::: changePwTest : {}", result);
	}
	
//	@Test // 완료
	public void findAllTest() {
		List<Member> list = ms.findAll();
		for (Member m : list) {
			log.info("\n ::: findAllTest member : {}", m);
		}
	}
	
//	findOne 메소드 생략
	
//	@Test // 완료
	public void changeImgTest() {
		String id = "123";
		String img = "profile2.jpg";
		
		int result = ms.changeImg(id, img);
		
		log.info("\n\n\n ::: changeImg result : {}", result);
	}
	
//	@Test // 완료
	public void deleteMemberTest() {
		String id = "123";
		
		int result = ms.deleteMember(id);
		log.info("\n\n\n ::: deleteMemberTest result : {}", result);
	}
}
