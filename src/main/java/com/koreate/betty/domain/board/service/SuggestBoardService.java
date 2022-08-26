package com.koreate.betty.domain.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreate.betty.domain.board.dao.SuggestBoardRepository;
import com.koreate.betty.domain.board.dto.form.SuggestBoardForm;
import com.koreate.betty.domain.board.vo.SuggestBoard;
import com.koreate.betty.global.util.PageMaker;
import com.koreate.betty.global.util.SearchCriteria;
import com.koreate.betty.global.util.SearchPageMaker;

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
		return dao.suggestReply(board);
	}
	
	// 건의사항 삭제
	public int suggestRemove(int bno) {
		return dao.suggestRemove(bno);
	}
	
	// 건의사항 수정
	public int suggestUpdate(SuggestBoardForm form) {
		SuggestBoard board = form.suggestBoard();
		return dao.suggestUpdate(board);
	}
	
	// 건의사항 상세
	public SuggestBoard suggestDetail(int bno) {
		return dao.suggestRead(bno);
	}
	
	// 건의사항 목록
	public List<SuggestBoard> SuggestList(SearchCriteria cri) {
		return dao.SuggestList(cri);
	}
	
	// 조회수 증가
	public int updateCnt(int bno) {
		return dao.updateCnt(bno);
	}

	// 추천수 증가
	public int updateRecommend(int bno) {
		return dao.updateRecommend(bno);
	}
	
	// 페이징 처리
	public PageMaker getPageMaker(SearchCriteria cri) {
		int totalCount = dao.listCount(cri);
		PageMaker pm = new SearchPageMaker();
		pm.setCri(cri);
		pm.setDisplayPageNum(5);
		pm.setTotalCount(totalCount);
		return pm;
	}
	
}









