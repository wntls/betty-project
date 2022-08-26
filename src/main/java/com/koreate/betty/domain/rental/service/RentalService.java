package com.koreate.betty.domain.rental.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koreate.betty.domain.rental.dao.RentalRepository;
import com.koreate.betty.domain.rental.vo.Rental;
import com.koreate.betty.domain.rental.vo.Reserve;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RentalService {
	
	private final RentalRepository rentalRepository;
	
	
	public List<Rental> rentalByMemberId(String id) {
		// 대여 리스트를 들고와서 보내면 끝
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reserve> reserveByMemberId(String id) {
		// 예약 리스트
		// TODO Auto-generated method stub
		return null;
	}
}
