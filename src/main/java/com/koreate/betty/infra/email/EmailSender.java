package com.koreate.betty.infra.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmailSender {

	private final JavaMailSender mailSender;

	public void send(String email, String code) {
		try {

			MimeMessage mesage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mesage, "UTF-8");
			helper.setFrom("show5901@gmail.com");
			helper.setTo(email);
			helper.setSubject("이메일 인증 코드 확인");
			helper.setText("왜 코드 뭐는 되고 뭔는 안되는데!! [" + code + "]", true);
			System.out.println("이메일 인증 코드" + code);
			mailSender.send(mesage);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
