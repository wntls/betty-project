package com.koreate.betty.domain.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;

public class tempSignController {
	
	/*
	private final DefaultMessageService messageService;
	private final JavaMailSender mailSender;
	
	 내부 로직 빼낼 예정
			@PostMapping("sms")
			@ResponseBody
			public Map<String, String> sendSMS(String phone) throws Exception {
				// code 생성
				String code = "";
				for (int i = 0; i < 5; i++) {
					code += (int) (Math.random() * 10);
				}

				Message message = new Message();
				message.setFrom("01045725901");
				message.setTo("01000000000"); // message.setTo(phone);
				message.setText("테스트 전송 메세지 입니다.해당 인증번호는[" + code + "]입니다.");

				SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));

				Map<String, String> map = new HashMap<>();
				map.put("code", code);
				map.put("result", response.getStatusCode());
				return map;
			}
			
			@GetMapping("/checkEmail")
			@ResponseBody
			public String checkEmail(
					@RequestParam("email") String email
					) throws Exception{
				
				boolean result = signService.checkEmailDupl(email);	// true : 검색된 이메일이 있음
				if (result) {
					
							@@
					  		사용자에게 중복 이메일이 있음을 알리고
					    	아래 코드가 실행되지 않도록 리턴
					     
					   
					
				}
				
				System.out.println(email);
				String code = "";
				
				for(int i=0; i<5; i++) {
					code +=(int)(Math.random()*10);
				}
				
				MimeMessage mesage = mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(mesage,"UTF-8");
				helper.setFrom("show5901@gmail.com");
				helper.setTo(email);
				helper.setSubject("이메일 인증 코드 확인");
				helper.setText("왜 코드 뭐는 되고 뭔는 안되는데!! ["+code+"]", true);
				mailSender.send(mesage);
				System.out.println("발신 완료");
				
				return code;
			}
			
			*/
			
		

}