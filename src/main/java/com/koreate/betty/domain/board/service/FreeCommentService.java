package com.koreate.betty.domain.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.koreate.betty.domain.board.dao.FreeBoardCommentRepository;
import com.koreate.betty.domain.board.dto.form.FreeBoardCommentForm;
import com.koreate.betty.domain.board.vo.FreeBoard;
import com.koreate.betty.domain.board.vo.FreeBoardComment;

@Service
public class FreeCommentService {
	
	@Autowired
	FreeBoardCommentRepository dao;
	
	// 댓글 등록
	public int add(FreeBoardCommentForm form, FreeBoard board) {
		FreeBoardComment vo = form.freeBoardComment();
		dao.updateOrigin();
		return dao.commentAdd(vo, board);
	}
	
	// 댓글 수정
	public int modify(FreeBoardCommentForm form, String loginUser) {
		FreeBoardComment vo = form.freeBoardComment();
		return dao.commentModify(loginUser, vo);
	}
	
	// 댓글 삭제
	public int remove(FreeBoardCommentForm form, String loginUser) {
		FreeBoardComment vo = form.freeBoardComment();
		return dao.removeComment(loginUser, vo);	
	}
	
	// 오리진 업데이트
	public int updateOrigin() {
		return dao.updateOrigin();
	}
	
}
