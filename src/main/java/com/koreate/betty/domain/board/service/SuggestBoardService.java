package com.koreate.betty.domain.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreate.betty.domain.board.dao.SuggestBoardRepository;
import com.koreate.betty.domain.board.dto.form.SuggestBoardForm;
import com.koreate.betty.domain.board.vo.SuggestBoard;

@Service
public class SuggestBoardService {
	
	@Autowired
	SuggestBoardRepository dao;
	
	// 건의사항 등록
	public int suggestWrite(SuggestBoardForm form) {
		SuggestBoard board = form.suggestBoard();
		dao.suggestRegist(board);
		dao.updateOrigin();
		return board.getBno();
	}
	
	// 답변글 등록
	public void suggestReply(SuggestBoardForm form) {
		form.setDepth(1);
		SuggestBoard board = form.suggestBoard();
		dao.suggestReply(board);
	}
	
	// 건의사항 삭제
	public int suggestRemove(SuggestBoardForm form) {
		SuggestBoard board = form.suggestBoard();
		dao.suggestRemove(board);
		return board.getBno();
	}
	
	// 건의사항 수정
	public int suggestUpdate(SuggestBoardForm form) {
		SuggestBoard board = form.suggestBoard();
		dao.suggestUpdate(board);
		return board.getBno();
	}
	
	
}









