package com.koreate.betty.domain.member;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.MultipartFile;

import com.koreate.betty.domain.book.service.BookService;
import com.koreate.betty.domain.member.dto.form.JoinForm;
import com.koreate.betty.domain.member.dto.form.LoginForm;
import com.koreate.betty.domain.member.dto.form.PointForm;
import com.koreate.betty.domain.member.dto.form.UpdateForm;
import com.koreate.betty.domain.member.service.MemberService;
import com.koreate.betty.domain.member.vo.ChkLog;
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
	BookService bs;
	
	@Test 
	public void joinTest() {
		JoinForm form = new JoinForm("123","1","1", "1" ,"1","1", "2000-11-22","1","1", "1", 0);
		
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
		String phone = "1";
		String id = ms.findId(name, phone);
		
		log.info("\n\n\n ::: findIdTest id : {}", id);
	}

//	@Test // 완료
	public void findForChangePwTest() {
		String id = "123";
		String phone = "2";
		
		int result = ms.findForChangePw(id, phone);
		
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
		
//		int result = ms.changeImg(id, img);	// 현재 서비스도 삭제됨
		
//		log.info("\n\n\n ::: changeImg result : {}", result);
	}
	
	
	
	
//	@Test // 완료
	public void deleteMemberTest() {
		String id = "123";
		
		int result = ms.deleteMember(id);
		log.info("\n\n\n ::: deleteMemberTest result : {}", result);
	}
	
	
//	@Test
	public void updateMemberTest() {
		// 대상
		// 멤버 (수정 정보)
		
		String targetId = "1224";
		MultipartFile img;
		try {
			img = new MockMultipartFile("testimg2.png", new FileInputStream(new File("src/test/resources/img", "testimg2.png")));
						
			boolean uploaded = ms.imgUpload(targetId, img);
			log.info("\n\n\n\n uploaded : {}", uploaded);
			
			UpdateForm updateform = new UpdateForm("1224","5", "5", "nick", "2", "male","2000-11-22", "3", img);
			
			int result = ms.updateMember(targetId, updateform);
			
			log.info("\n\n\n\n result : {}", result);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
//	@Test
	public void addPointTest() {
		PointForm form = new PointForm("123", "1-1-1", 10000);
		
		int result = ms.addPoint(form);
		
		log.info("\n\n\n\n result : {}", result);
	}	
	
//	@Test
	public void findMyChkLogTest() {
		
		String id = "123";
		
		List<ChkLog> list = ms.findMyChkLog(id);
		
		for (ChkLog c : list) {
			log.info("\n\n chk : {}", c);
		}		
	}
	
//	@Test
	public void updateMembershipTest() {
		String id = "1224";
		String grade = "bronze";
		
		int result = ms.updateMembership(id, grade);
		log.info("\n\n\n\n result : {}", result);
	}
}
