package com.koreate.betty.domain.book.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koreate.betty.domain.book.dao.BookRepository;
import com.koreate.betty.domain.book.dto.form.BookBuyForm;
import com.koreate.betty.domain.book.dto.form.BookDeleteForm;
import com.koreate.betty.domain.book.dto.form.BookSearchForm;
import com.koreate.betty.domain.book.dto.form.BookUpdateForm;
import com.koreate.betty.domain.book.vo.Book;
import com.koreate.betty.domain.book.vo.JBookSingle;
import com.koreate.betty.global.util.Criteria;
import com.koreate.betty.global.util.PageMaker;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;
	
	// 페이징 처리가 필요한 뷰는 맵 객체로 반환합니다. 목록 key : list,   PageMaker key : pm
	// 책 목록 (books) : 매개변수가 null이면 해당 검색 옵션이 없이 출력합니다
	public Map<String, Object> bookList(String title, Integer genre, Integer page) {		
		Map<String, Object> map = new HashMap<>();
		
		Criteria cri = new Criteria();
		if (page != null) {
			cri.setPage(page);
		}
		int totalCount = bookRepository.findAllCount();
		PageMaker pageMaker = new PageMaker(cri, totalCount);
		
		map.put("list", bookRepository.findAll(title, genre, cri));
		map.put("pm", pageMaker);
		return map;
	}
	
	// 책 상세 정보
	public Book bookDetail(String code) {
		return bookRepository.bookDetail(code);
	}
	
	// 책 1개 싱글 + 정보
	public JBookSingle single(String code, Integer num) {
		return bookRepository.single(code, num);
	}
	
	// 한 도서의 재고 (대여 예약 미포함)	
	public int countExistByCode(String code) {
		return bookRepository.countExistByCode(code);
	}

	// 한 도서의 총 갯수 (대여 예약 포함)	
	public int countAllByCode(String code) {
		return bookRepository.countAllByCode(code);
	}
	
	// 도서 정보 등록
	public int bookRegister(BookBuyForm form) {
		Book book = form.createBook();
		return bookRepository.insert(book);
	}
		
	// 도서 정보 수정
	public int update(String targetCode, BookUpdateForm form) {	
		Book book = form.createBook();		
		return bookRepository.update(targetCode, book);
	}

	// 도서 재고 추가
	@Transactional
	public int insertWare(String code, String id, Integer count) {
		int result = 0;
		int iCount = count;
		while (iCount-- > 0) {
			int temp = bookRepository.insertWare(code, id);
			result += temp;
		}
		return result;
	}
	
	// 도서 폐기
	@Transactional
	public int deleteBook(List<BookDeleteForm> formList) {	// 두배의 결과가 나옵니다
		int result = 0;
		
		for (BookDeleteForm del : formList) {
			result += bookRepository.insertDump(del);
			result += bookRepository.delete(del);
		}
		return result;
	}
	
	// 도서 정보 + 도서 번호(개별책 전부 출력)
	public Map<String, Object> jBookList(Integer page) {
		Map<String, Object> map = new HashMap<>();
		Criteria cri = new Criteria();
		if(page != null) {
			cri.setPage(page);
		}
		int totalCount = bookRepository.jFindAllCount(); 
		PageMaker pageMaker = new PageMaker(cri, totalCount);
		map.put("list", bookRepository.jFindAll(cri));
		map.put("pm", pageMaker);
		return map;
	}
	
	// 도서 현황 검색 (여기서는 j가 붙었으나 조인하지 않습니다)
	// 대여 현황 검색 (singleTBL + rentalTBL)
	public Map<String, Object> bookSearch(BookSearchForm form, Integer page) {
		Map<String, Object> map = new HashMap<>();
		Criteria cri = new Criteria();
		if (page != null) {
			cri.setPage(page);
		}
		
		int totalCount = bookRepository.jSearchCount(form); 
		PageMaker pageMaker = new PageMaker(cri, totalCount); 
		
		map.put("list", bookRepository.jSearch(form, cri));
		map.put("pm", pageMaker);
		return map;
	}
	
	public int insertByCrawler(Book book) {
		return bookRepository.insertByCrawler(book);		
	}

}