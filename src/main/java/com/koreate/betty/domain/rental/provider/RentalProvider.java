package com.koreate.betty.domain.rental.provider;
import static com.koreate.betty.domain.model.TableConst.RENTAL_RESERVE_TBL;
import static com.koreate.betty.domain.model.TableConst.RENTAL_TBL;

import java.sql.Timestamp;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class RentalProvider {
	
	public String rentalByMemberId(String id) {
		return new SQL().SELECT("*").FROM(RENTAL_TBL)
				.WHERE("member_id = #{id}")
				.toString();
	}
	
	public String reserveByMemberId(String id) {
		return new SQL().SELECT("*").FROM(RENTAL_RESERVE_TBL)
				.WHERE("member_id = #{id}")
				.toString();
	}

	// num은 BookSingleProvider의 findExistNum 메소드 사용
	public String rentalBook(@Param("id")String id, @Param("code")String code, @Param("num")Integer num) {
		return new SQL().INSERT_INTO(RENTAL_TBL)
				.INTO_VALUES("#{code}, #{num}, #{id}, DATE_FORMAT(now(), '%Y-%m-%d'), DATE_FORMAT(DATE_ADD(now(), INTERVAL (SELECT lend_period FROM premium WHERE grade = (SELECT premium_grade FROM member_card WHERE member_id = #{id})) DAY), '%Y-%m-%d')")
				.toString();
	}
	
	// 위 쿼리가 작동하지 않을 시 반납일을 null로 변환한 뒤 작성
//	public String rentalUpdate(@Param("id")String id, @Param("code")String code) {
//		return "";
//	}
	
	public String reserveBook(@Param("id")String id, @Param("code")String code, @Param("date")Timestamp date, @Param("num")Integer num) {
		return new SQL().INSERT_INTO(RENTAL_RESERVE_TBL)
				.INTO_VALUES("#{code}, #{num}, #{id}, DATE_FORMAT(#{date}, '%Y-%m-%d')")
				.toString();
	}
	
	public String returnBook(@Param("id")String id, @Param("code")String code) {
		return new SQL().DELETE_FROM(RENTAL_TBL)
				.WHERE("member_ = #{id}")
				.WHERE("book_code = #{code}")
				.toString();
	}
	
}