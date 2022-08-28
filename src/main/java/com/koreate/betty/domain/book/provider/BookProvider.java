package com.koreate.betty.domain.book.provider;
import static com.koreate.betty.domain.model.TableConst.RENTAL_TBL;
import static com.koreate.betty.domain.model.TableConst.BOOK_COMMENT_TBL;
import static com.koreate.betty.domain.model.TableConst.BOOK_SINGLE_TBL;
import static com.koreate.betty.domain.model.TableConst.BOOK_TBL;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.koreate.betty.domain.book.dto.form.BookSearchForm;
import com.koreate.betty.domain.book.vo.Book;
import com.koreate.betty.domain.book.vo.BookComment;
import com.koreate.betty.global.util.Criteria;

public class BookProvider {

	// 전체 책 목록
	public String findAll(@Param("title") String title, @Param("genre") Integer genre, @Param("cri") Criteria cri) {
		SQL sql = new SQL();
		sql.SELECT("*").FROM(BOOK_TBL);

		if (title != null) {
			sql.WHERE("title LIKE CONCAT('%','#{title}','%'");
		}

		if (genre != null) {
			sql.WHERE("title LIKE CONCAT('%','#{genre}','%'");
		}

		if (cri != null) {
			sql.OFFSET("#{cri.startRow}");
			sql.LIMIT("#{cri.perPageNum");
		}

		return sql.toString();
	}
	
	// 전체 책 목록 총계
	public String findAllCount() {
		return new SQL().SELECT("count(*)").FROM(BOOK_TBL)
				.toString();			
	}

	// 도서 상세 정보
	public String bookDetail(String code) {
		return new SQL().SELECT("*").FROM(BOOK_TBL).WHERE("code = #{code}").toString();
	}

	// 도서 상세 정보 페이지의 댓글 목록
	public String findCommentByCode(@Param("code") String code, @Param("cri") Criteria cri) {
		return new SQL().SELECT("*").FROM(BOOK_COMMENT_TBL).WHERE("code = #{code}").OFFSET("#{cri.startRow}")
				.LIMIT("#{cri.perPageNum}").toString();
	}

	// 신규 도서 등록
	public String insert(Book book) {
		return new SQL().INSERT_INTO(BOOK_TBL)
				.INTO_VALUES("#{code}, #{title}, #{auth}, #{pub}, #{pubDate}, #{page}, #{genre}, #{intro}").toString();
	}
	
	// 도서 상세 페이지 댓글 등록
	public String insertComment(BookComment bookComment) {
		return new SQL().INSERT_INTO(BOOK_COMMENT_TBL)
				.INTO_VALUES("null", "#{bookCode}", "#{memberId}", "#{nickname}", "#{comment}", "null")
				.toString();
	}
	
	// 도서 상세 페이지 댓글 삭제
	public String deleteComment(Integer num) {
		return new SQL().DELETE_FROM(BOOK_COMMENT_TBL)
				.WHERE("num = #{num}")
				.toString();
	}

	// 도서 정보 변경 (변경할 책 코드, 들어갈 정보) // 테스트 완료
	// 코드가 반드시 일치하는 한권이어야 하고, 모든 필수 정보가 들어있어야 합니다
	public String update(@Param("targetCode") String targetCode, @Param("book") Book book) {
		return new SQL().UPDATE(BOOK_TBL).SET("code = #{book.code}").SET("title = #{book.title}")
				.SET("auth = #{book.auth}").SET("pub = #{book.pub}").SET("pub_date = #{book.pubDate}")
				.SET("page = #{book.page}").SET("genre = #{book.genre}").SET("intro = #{book.intro}")
				.WHERE("code = #{targetCode}").toString();
	}

	/*
	 * jBooks : book + bookSingle 조인 이하의 코드는 Join을 사용하여 책의 정보와 책의 권수를 함께 다룸
	 */

	// 도서 전체 검색 // 테스트 완료
	public String jFindAll() {
		return new SQL().SELECT("*").FROM(BOOK_TBL).JOIN(BOOK_SINGLE_TBL).WHERE("code = book_code").ORDER_BY("code")
				.ORDER_BY("num").toString();
	}

	// code로 한 도서의 목록 검색 (isbn은 동일한 책이 여럿이 나옴)
	public String jFindByCode(String code) {
		return new SQL().SELECT("*").FROM(BOOK_TBL).JOIN(BOOK_SINGLE_TBL).WHERE("code = book_code").ORDER_BY("code")
				.WHERE("code = #{code}").ORDER_BY("num").toString();
	}

	// 개별 도서 검색(복합 검색) ex) 대여현황
	public String jSearch(BookSearchForm form, Criteria cri) {

		String search = form.getSearchText();
		String searchOption = form.getSearchOption();
		String rentOption = form.getRentOption();
		String pubDateOption = form.getPubDateOption();
		String submitPage = form.getSubmitPage();
		
		SQL sql = new SQL().SELECT("*");

		
		// View 페이지에서 input hidden 으로 name : submitPage 
		// value 값을 books, rentals로 보내야 합니다
		if (submitPage.equals("books"))	{ // 도서 현황 'staff/books'
			sql.FROM(BOOK_TBL);
		} else if (submitPage.equals("rentals")) { // 대여 현황 'staff/rentals'
			sql.FROM(BOOK_SINGLE_TBL).JOIN(RENTAL_TBL);
		} else {
			System.out.println("========================\n\n\n\n");
			System.out.println("jSearch : submitPage 값이 이상합니다.");
			System.out.println("========================\n\n\n\n");			
			return null;	// View 페이지 정상적으로 연결 시 else 삭제 (if문 전체 날리면 안됩니다)
		}

		switch (searchOption) {
		case "title":
			sql.WHERE("title = " + search);
			break;
		case "content":
			sql.WHERE("content = " + search);
			break;
		case "auth":
			sql.WHERE("auth = " + search);
			break;
		case "pub":
			sql.WHERE("pub = " + search);
			break;
		default:
			break;
		}
		if (rentOption != null) { // null일 경우 전체 검색이고, 옵션값을 rent 또는 reserve로 해주세요
			switch (rentOption) {
			case "able":
				sql.WHERE("rental = 'n'");
				break;
			case "rent":
				sql.WHERE("rental = 'y'");
				break;
			case "reserv":
				sql.WHERE("rental = 'r'");
				break;
			default:
				break;
			}
		}

		if (form.getPubDate() != null) { // 테스트 필요
			Timestamp pubDate = Timestamp.valueOf(form.getPubDate() + " 00:00:00");
			String date = new SimpleDateFormat("yyyy-MM-dd").format(pubDate);
			if (pubDateOption.equals("after")) {
				sql.WHERE("pub_date >= " + date);
			} else {
				sql.WHERE("pub_date <= " + date);
			}
		}

		String genre = form.getGenre();
		if (genre != null && !genre.equals("")) {
			sql.WHERE("genre = " + genre);
		}

		sql.ORDER_BY("code");
		sql.OFFSET(cri.getStartRow())
		.LIMIT(cri.getPerPageNum());
		
		return sql.toString();
	}

//	둘중 하나로 검색, 대시보드와 내 대여 현황에 사용(Rental 패키지로 이동하는게 좋을듯 함) 
//	Rental 패키지에 제대로 있으면 지워주세요

//	public String jRentalOrReserve(String rentOption, String id) {
//		return new SQL().SELECT("*").FROM(BOOK_TBL).JOIN(BOOK_SINGLE_TBL).WHERE("code = book_code")
//				.WHERE("rental = " + rentOption).toString();
//	}

	// 크롤링
	public String insertByCrawler(Book book) {
		return "INSERT IGNORE INTO book VALUES(#{code}, #{title}, #{auth}, #{pub}, #{pubDate}, #{page}, #{genre}, #{intro})";
	}

}