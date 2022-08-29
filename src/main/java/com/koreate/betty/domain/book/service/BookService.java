package com.koreate.betty.domain.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koreate.betty.domain.book.dao.BookRepository;
import com.koreate.betty.domain.book.dto.form.BookBuyForm;
import com.koreate.betty.domain.book.dto.form.BookDeleteForm;
import com.koreate.betty.domain.book.dto.form.BookSearchForm;
import com.koreate.betty.domain.book.dto.form.BookUpdateForm;
import com.koreate.betty.domain.book.vo.Book;
import com.koreate.betty.global.util.Criteria;
import com.koreate.betty.global.util.PageMaker;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;
	
	// 이거 맵 객체로 반환할 것 (현재 미처리, 처리시 주석 지움)
	// 책 목록 (books) : 매개변수가 null이면 해당 검색 옵션이 없이 출력합니다
	public List<Book> bookList(String title, Integer genre, Integer page) {		
		
		Criteria cri = new Criteria();
		if (page != null) {
			cri.setPage(page);
		}
		int totalCount = bookRepository.findAllCount();
		PageMaker pageMaker = new PageMaker(cri, totalCount);
		List<Book> list = bookRepository.findAll(title, genre, cri);
		return list;
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
			result += bookRepository.delete(del.getBookCode());
		}
		return result;
	}
	
	// 도서 정보 + 도서 번호(개별책 전부 출력)
	public List<Book> jBookList() {
		return bookRepository.jFindAll();
	}
	
	// 도서 현황 검색 (여기서는 j가 붙었으나 조인하지 않습니다)
	public List<Book> bookSearch(BookSearchForm form, Integer page) {
		Criteria cri = new Criteria();
		if (page != null) {
			cri.setPage(page);
		}
		return bookRepository.jSearch(form, cri);
	}
	
	// 대여 현황 검색 (singleTBL + rentalTBL)
	public List<Book> rentalSearch(BookSearchForm form, Integer page) {
		Criteria cri = new Criteria();
		if (page != null) {
			cri.setPage(page);
		}
		return bookRepository.jSearch(form, cri);
	}
	

	public int insertByCrawler(Book book) {
		return bookRepository.insertByCrawler(book);		
	}

}
