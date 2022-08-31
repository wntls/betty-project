package com.koreate.betty.infra.sms;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;

@Component
@RequiredArgsConstructor
public class SMSSender {

	private final DefaultMessageService messageService;
	
	public Map<String,String> send(String phone, String code) {
		
		Message message = new Message();
		message.setFrom("01045725901");
		message.setTo("01000000000"); // message.setTo(phone);
		message.setText("테스트 전송 메세지 입니다.해당 인증번호는[" + code + "]입니다.");
		System.out.println("메시지 인증 코드" + code);
		SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
		Map<String, String> map = new HashMap<>();
		map.put("code", code);
		map.put("result", response.getStatusCode());
		return map;
	}
	
}
