package com.koreate.betty.domain.board.service;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreate.betty.domain.board.dao.FreeBoardRepository;
import com.koreate.betty.domain.board.vo.FreeBoard;

@Service
public class FreeBoardService {
	
	@Autowired
	FreeBoardRepository freeBoardRepository;
	
	public int write(FreeBoard board) {
		freeBoardRepository.save(board);
		return board.getBno();
	}
	
}
