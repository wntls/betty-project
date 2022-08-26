package com.koreate.betty.domain.member.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.koreate.betty.domain.member.dao.MemberRepository;
import com.koreate.betty.domain.member.dto.form.JoinForm;
import com.koreate.betty.domain.member.dto.form.LoginForm;
import com.koreate.betty.domain.member.dto.form.PointForm;
import com.koreate.betty.domain.member.dto.form.UpdateForm;
import com.koreate.betty.domain.member.vo.ChkLog;
import com.koreate.betty.domain.member.vo.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import net.koreate.file.utils.MediaUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

	private final MemberRepository memberRepository;
	private final ServletContext context;
	
	public Member loginMember(LoginForm form) {
		String id = form.getMemberId();
		String pw = form.getPw();
		
		String cookie = form.getLoginCookie();
		
		log.info("id = {} , pw = {} , cookie= {}", id, pw, cookie);
		
		
		if (cookie != null) {
			// 쿠키만드는 작업 해줘
			// 나중에 함
		}
		
		return memberRepository.login(id, pw);
	}

	public int joinMember(JoinForm form) {
		
		int result = 0;
		
		String pw = form.getPw();
		String repw = form.getRepw();
		
		if (!pw.equals(repw)) {
			return result;
		}
		
		Member joinMember = form.createMember();
				
		result = memberRepository.join(joinMember);
		return result;
	}
	
	public boolean checkIdForJoin(String id) {
		String checkId = memberRepository.checkIdForJoin(id);
		
		return checkId != null ? true : false;
	}
	
	public boolean checkNickForJoin(String nick) {
		String checkNick = memberRepository.checkNickForJoin(nick);
		
		return checkNick != null ? true : false; 
	}
	
	public boolean checkEmailForJoin(String email) {
		String checkEmail = memberRepository.checkEmailForJoin(email);
		
		return checkEmail != null ? true : false;
	}
	
	public String findId(String name, String phone) {
		String id = null;
		
		id = memberRepository.findId(name, phone);
				
		return id;
	}
	
	public int findForChangePw(String id, String phone) {
		int result = 0;
		
		result = memberRepository.findForChangePw(id, phone);
		
		return result;
	}
	
	public int changePw(String id, String pw) {
		int result = 0;
		
		result = memberRepository.changePw(id, pw);
		
		return result;
	}
	
	public List<Member> findAll() {
		List<Member> list = memberRepository.findAll();
		return list;
	}

	public int deleteMember(String id) {
		int result = 0;
		
		result = memberRepository.deleteMember(id);
		
		return result;
	}

	public int updateMember(String targetId, UpdateForm form) {
		Member update = form.createMember();
		int result = memberRepository.updateMember(targetId, update); 
		
		return result;
	}

	public int addPoint(PointForm form) {
		String id = form.getId();
		int point = form.getPoint();
		int result = memberRepository.addPoint(id, point);
		return result;
	}

	public List<ChkLog> findMyChkLog(String id) {
		return memberRepository.findMyChkLog(id);
	}
	
//	src\main\webapp\resources\img\member\origin
	public boolean imgUpload(String targetId, MultipartFile img) {
		
		boolean uploaded = false;
		
		String originalName = img.getName();
		String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
		log.info("\n\n\n\n originalName : {}", originalName);
		log.info("\n\n\n\n formatName : {}", formatName);
		
		if (MediaUtils.getMediaType(formatName) == null) { // 이미지 파일이 아닐 경우
			return uploaded;
		}
		
		String sp = File.separator;
		String originPath = context.getRealPath(sp+"resources"+sp+"img"+sp+"member"+sp+"origin");
		String middlePath = context.getRealPath(sp+"resources"+sp+"img"+sp+"member"+sp+"middle");
		String thumbPath = context.getRealPath(sp+"resources"+sp+"img"+sp+"member"+sp+"thumbnail");
		
		String imgName = targetId + "_" + originalName; 
		
		File file = new File(originPath, imgName);
		
		try {
			img.transferTo(file); // 오리진에 넣음			
			
			BufferedImage originImg = ImageIO.read(file);			
						
			BufferedImage middleImg = Thumbnails.of(originImg).size(300, 300).keepAspectRatio(false).asBufferedImage();
			BufferedImage thumbImg = Thumbnails.of(originImg).size(50, 50).keepAspectRatio(false).asBufferedImage();
			
			File mFile = new File(middlePath, imgName);
			ImageIO.write(middleImg, formatName, mFile);
			File tFile = new File(thumbPath, imgName);			
			ImageIO.write(thumbImg, formatName, tFile);
			
			uploaded = true;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return uploaded;
	}

	public int updateMembership(String id, String membershipGrade) {
		return memberRepository.updateMembership(id, membershipGrade);		
	}

	public String findGradeById(String id) {
		
		return null;
	}
	
}