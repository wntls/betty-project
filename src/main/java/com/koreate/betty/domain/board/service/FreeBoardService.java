package com.koreate.betty.domain.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreate.betty.domain.board.dao.FreeBoardRepository;
import com.koreate.betty.domain.board.dto.form.FreeBoardWriteForm;
import com.koreate.betty.domain.board.vo.FreeBoard;

import lombok.extern.slf4j.Slf4j;

@Service
public class FreeBoardService {
	
	@Autowired
	FreeBoardRepository freeBoardRepository;
	
	public int write(FreeBoardWriteForm form) {
		FreeBoard board = form.createFreeBoard();
		freeBoardRepository.save(board);
		return board.getBno();
	}
	
}
