package com.koreate.betty.domain.book.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.koreate.betty.domain.book.dao.BookRepository;
import com.koreate.betty.domain.book.dto.RentalStatusDTO;
import com.koreate.betty.domain.book.dto.form.BookDeleteForm;
import com.koreate.betty.domain.book.dto.form.BookForm;
import com.koreate.betty.domain.book.dto.form.BookSearchForm;
import com.koreate.betty.domain.book.vo.Book;
import com.koreate.betty.domain.book.vo.JBookSingle;
import com.koreate.betty.global.util.BookCriteria;
import com.koreate.betty.global.util.Criteria;
import com.koreate.betty.global.util.PageMaker;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	// 페이징 처리가 필요한 뷰는 맵 객체로 반환합니다. 목록 key : list, PageMaker key : pm
	// 책 목록 (books) : 매개변수가 null이면 해당 검색 옵션이 없이 출력합니다
	public void bookList(BookCriteria cri, Model model) {
		int totalCount = bookRepository.findAllCount(cri);
		PageMaker pageMaker = new PageMaker(cri, totalCount);
		List<Book> list = bookRepository.findAll(cri);
		model.addAttribute("list", list);
		model.addAttribute("pm",pageMaker);
		
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
	public int bookRegister(BookForm form) {
		Book book = form.createBook();
		return bookRepository.insert(book);
	}

	// 도서 정보 수정
	public int update(String targetCode, BookForm form) {
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

	public List<JBookSingle> findBookSingleByCode(String code) { // 도서 폐기처리할 목록 불러오는 ajax 처리용
		return bookRepository.jFindByCode(code);
	}

	// 도서 폐기
	@Transactional
	public int deleteBook(List<BookDeleteForm> formList) { // 두배의 결과가 나옵니다
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
		if (page != null) {
			cri.setPage(page);
		}
		int totalCount = bookRepository.jFindAllCount();
		PageMaker pageMaker = new PageMaker(cri, totalCount);
		map.put("list", bookRepository.jFindAll(cri));
		map.put("pm", pageMaker);
		return map;
	}

	// 도서 현황 검색
	public Map<String, Object> bookSearch(BookSearchForm form, Integer page) {
		Map<String, Object> map = new HashMap<>();
		Criteria cri = new Criteria();
		if (page != null) {
			cri.setPage(page);
		}

		int totalCount = bookRepository.jSearchCount(form);
		PageMaker pageMaker = new PageMaker(cri, totalCount);
		List<Book> list = bookRepository.jSearch(form, cri);

		map.put("list", list);
		map.put("pm", pageMaker);

		if (list != null) { // 도서의 수를 알려주는 로직

			List<Integer> nowCount = new ArrayList<>(); // 타입 변경 자유(반환만 되면)
			List<Integer> allCount = new ArrayList<>();

			for (Book b : list) {
				nowCount.add(bookRepository.countExistByCode(b.getCode()));
				allCount.add(bookRepository.countAllByCode(b.getCode()));
			}

			map.put("nowCount", nowCount);
			map.put("allCount", allCount);
		}

		return map;
	}

	// 도서 현황 검색
	public Map<String, Object> rentalBookSearch(BookSearchForm form, Integer page) {
		Map<String, Object> map = new HashMap<>();
		Criteria cri = new Criteria();
		if (page != null) {
			cri.setPage(page);
		}

		int totalCount = bookRepository.jRentalSearchCount(form);
		PageMaker pageMaker = new PageMaker(cri, totalCount);
		List<RentalStatusDTO> list = bookRepository.jRentalSearch(form, cri);

		map.put("list", list);
		map.put("pm", pageMaker);

		return map;
	}
	
	public Integer findExistNum(String code) {	// 테스트 필요 (provider에서 Integer 반환이 가능한가?)
		Integer find = bookRepository.findExistNum(code);
		return find;
	}
	
	

	public int insertByCrawler(Book book) {
		return bookRepository.insertByCrawler(book);
	}

}