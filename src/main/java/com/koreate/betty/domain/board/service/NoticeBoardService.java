package com.koreate.betty.domain.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreate.betty.domain.board.dao.NoticeBoardRepository;
import com.koreate.betty.domain.board.dto.form.NoticeBoardForm;
import com.koreate.betty.domain.board.vo.NoticeBoard;
import com.koreate.betty.global.util.SearchCriteria;

import lombok.extern.slf4j.Slf4j;

@Service
public class NoticeBoardService {
	
	@Autowired
	NoticeBoardRepository dao;
	
	// 공지사항 등록
	public int write(NoticeBoardForm form) {
		NoticeBoard board = form.noticeBoard();		
		return dao.noticeRegist(board);
	}

	// 공지사항 수정
	public int update(NoticeBoardForm form) {
		NoticeBoard board = form.noticeBoard();
		return dao.noticeUpdate(board);
	}
	
	// 공지사항 삭제
	public int remove(NoticeBoardForm form) {
		NoticeBoard board = form.noticeBoard();		
		return dao.noticeRemove(board.getBno());
	}	
	
	// 조회수 증가
	public int updateCnt(int bno) {
		return dao.updateCnt(bno);
	}
	
	// 공지사항 상세
	public int detail(NoticeBoardForm form) {
		NoticeBoard board = form.noticeBoard();
		return dao.noticeDetail(board);
	}
	
	// 공지사항 목록
	public List<NoticeBoard> noticeList(NoticeBoardForm form, SearchCriteria cri){
		NoticeBoard board = form.noticeBoard();
		return dao.noticeList(cri, board);
	}
	
	
	
}
