package com.koreate.betty.domain.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koreate.betty.domain.board.dao.NoticeBoardRepository;
import com.koreate.betty.domain.board.dto.form.NoticeBoardForm;
import com.koreate.betty.domain.board.vo.NoticeBoard;
import com.koreate.betty.global.util.SearchCriteria;
import com.koreate.betty.global.util.SearchPageMaker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class NoticeBoardService {

	private final NoticeBoardRepository dao;

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
	public int remove(int bno) {
		return dao.noticeRemove(bno);
	}

	// 조회수 증가
	public int updateCnt(int bno) {
		return dao.updateCnt(bno);
	}

	// 공지사항 상세
	public NoticeBoard detail(int bno) {
		return dao.noticeDetail(bno);
	}

	// 공지사항 목록
	public List<NoticeBoard> noticeList(SearchCriteria cri) {
		String type = cri.getSearchType();
		log.info("type : {} ", type);
		String word = cri.getKeyword();
		log.info("word : {} ", word);
		
		
		List<NoticeBoard> noticeList = dao.noticeList(cri);
		log.info("noticeList 1 : {} ", noticeList);
		if(type != null && !type.trim().equals("")) {
			for(NoticeBoard vo : noticeList) {
				vo.getTitle();
				vo.getMemberId();
				vo.getContent();
				log.info("vo : {} ", vo);
			}
		}
		log.info("noticeList 2 : {}" , noticeList);
		return noticeList;
	}
	
	// 페이징 처리
	public SearchPageMaker getPageMaker(SearchCriteria cri) {
		int totalCount = dao.listAllCount(cri);
		SearchPageMaker pm = new SearchPageMaker();
		pm.setCri(cri);
		pm.setDisplayPageNum(5);
		pm.setTotalCount(totalCount);
		return pm;
	}

}
