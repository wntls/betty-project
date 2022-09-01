package com.koreate.betty.domain.member.provider;

import static com.koreate.betty.domain.model.TableConst.MEMBER_TBL;
import static com.koreate.betty.domain.model.TableConst.MEMBER_CARD_TBL;
import static com.koreate.betty.domain.model.TableConst.CHK_LOG_TBL;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.koreate.betty.domain.member.vo.Member;

public class MemberProvider {
	
	// 비밀번호 재설정
	public String updatePw(@Param("id")String id, @Param("pw")String changePw) {
		return new SQL().UPDATE(MEMBER_TBL)
				.SET("pw = #{pw}")
				.WHERE("id = #{id}")
				.toString();
	}
	
	// 계정 전체 검색 (직원 -> 회원정보 조회)
	public String findAll() {
		return new SQL().SELECT("*")
				.FROM(MEMBER_TBL)
				.toString();
	}

	// 계정 한개 검색 (마이페이지/직원 정보)
	public String findOne(String id) {
		return new SQL().SELECT("*")
				.FROM(MEMBER_TBL)
				.WHERE("id = #{id}")
				.toString();
	}
	
	// 계정 삭제(회원 탈퇴)	// ## 주의 : UPDATE 쿼리를 사용합니다
	public String delete(String id) {
		return new SQL().UPDATE(MEMBER_TBL)
				.SET("del = 'y'")
				.WHERE("id = #{id}")
				.toString();
	}	
	
	// 회원 정보 수정 (이미지 수정도 이걸로 처리됩니다) // 본인 회원 수정, 스태프의 회원 수정
	public String update(Member member) {
		SQL sql = new SQL().UPDATE(MEMBER_TBL)
		.SET("id = #{id}, pw = #{pw}, nickname = #{nickname}, name = #{name}, gender = #{gender}, birth = #{birth}, addr = #{addr}");
		if(member.getImg() != null) {
			sql.SET("img = #{img}");
		}
		return sql.WHERE("id = #{id}").toString();
	}
	
	// 체크인
	
	// 체크아웃
	
	// 체크인 이력 (출결 이력 표기)
	public String findMyChkLog(String loginId) {
		return new SQL().SELECT("*").FROM(MEMBER_TBL)
				.JOIN(CHK_LOG_TBL)
				.WHERE("id = member_id")
				.WHERE("id = #{loginId}")
				.toString();
	}
		
}

// 사용하지 않을 듯 한 코드를 임시로 옮겼습니다. 완성 단계에 다다르면 지워주세요

// 프로필 이미지 업데이트 
//public String changeImg(@Param("id")String id, @Param("id")String img) {
//	return new SQL().UPDATE(MEMBER_TBL)
//			.SET("img = #{img}")
//			.WHERE("id = #{id}")
//			.toString();
//}

