package com.koreate.betty.domain.offline;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreate.betty.domain.rental.vo.Rental;
import com.koreate.betty.domain.rental.vo.Reserve;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/offline")
public class OfflineController {

	@PostMapping("receipt")
	public String rentalRecept(rentalDto rsv) {
		log.info("reserve = {}",rsv);
		return "redirect:/offline";
	}
	
	
	@PostMapping("return")
	public String rentalReturn(rentalDto rental) {
		log.info("rental = {}",rental);
		return "redirect:/offline";
	}
	
	// Rental 가져올 곳 많으면 따로 클래스 만들어도됨
	@Data
	@NoArgsConstructor
	static class rentalDto{
		private String code;
		private String num;
		private String id;
	}
	
}
