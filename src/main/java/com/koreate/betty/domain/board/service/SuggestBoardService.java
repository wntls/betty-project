package com.koreate.betty.domain.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreate.betty.domain.board.dao.SuggestBoardRepository;
import com.koreate.betty.domain.board.dto.form.SuggestBoardForm;
import com.koreate.betty.domain.board.vo.SuggestBoard;
import com.koreate.betty.global.util.SearchCriteria;

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
	public int suggestReply(SuggestBoardForm form) {
		form.setDepth(1);
		SuggestBoard board = form.suggestBoard();
		dao.suggestReply(board);
		return board.getBno();
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
	
	// 건의사항 상세
	public int suggestDetail(SuggestBoardForm form) {
		SuggestBoard board = form.suggestBoard();
		return dao.suggestRead(board);
	}
	
	// 건의사항 목록
	public List<SuggestBoard> SuggestList(SuggestBoardForm form, SearchCriteria cri) {
		SuggestBoard board = form.suggestBoard();
		return dao.SuggestList(cri, board);
	}
	
	// 조회수 증가
	public int updateCnt(int bno) {
		return dao.updateCnt(bno);
	}

	// 추천수 증가
	public int updateRecommend(int bno) {
		return dao.updateRecommend(bno);
	}
	
	
}









