package com.koreate.betty.domain.member.provider;

import static com.koreate.betty.domain.model.TableConst.MEMBER_TBL;
import static com.koreate.betty.domain.model.TableConst.MEMBER_CARD_TBL;
import static com.koreate.betty.domain.model.TableConst.CHK_LOG_TBL;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.koreate.betty.domain.member.vo.Member;

public class MemberProvider {

	// 멤버 테이블의 CRUD를 전달
	
	// 회원가입
	public String join(Member member) {
		return new SQL().INSERT_INTO(MEMBER_TBL)
				.INTO_COLUMNS("id", "pw", "nickname", "name", "gender", "birth", "phone", "addr", "email", "rights")
				.INTO_VALUES("#{id}, #{pw}, #{nickname}, #{name}, #{gender}, #{birth}, #{phone}, #{addr}, #{email}, #{rights}")
				.toString();
	}
	
	// 아이디 중복 확인
	public String findIdForJoin(String id) {
		return new SQL().SELECT("id").FROM(MEMBER_TBL)
				.WHERE("id = #{id}")
				.toString();
	}
		
	// 닉네임 중복 확인
	public String findNickForJoin(String nick) {
		return new SQL().SELECT("nickname").FROM(MEMBER_TBL)
				.WHERE("nickname = #{nick}")
				.toString();
	}
	
	// 이메일 중복 확인
	public String findEmailForJoin(String email) {
		return new SQL().SELECT("email").FROM(MEMBER_TBL)
				.WHERE("email = #{email}")
				.toString();
	}
		
	// 로그인
	public String login(@Param("id")String id, @Param("pw")String pw) {
		return new SQL().SELECT("*")
				.FROM(MEMBER_TBL)
				.WHERE("id = #{id}").WHERE("pw = #{pw}")
				.toString();
	}
	
	// 아이디 찾기 (이름 + 전화로 회원의 계정 존재 확인)
	public String findId(@Param("name")String name, @Param("phone")String phone) {
		return new SQL().SELECT("id")
				.FROM(MEMBER_TBL)
				.WHERE("name = #{name}")
				.WHERE("phone = #{phone}")
				.toString();
	}
	
	// 비밀번호 변경 전 유저의 정보 확인  : 아이디 + 전화번호로 회원의 계정이 존재하는지 확인
	public String findForChangePw(@Param("id")String id, @Param("phone")String phone) {
		return new SQL().SELECT("count(*)")
				.FROM(MEMBER_TBL)
				.WHERE("id = #{id}")
				.WHERE("phone = #{phone}")
				.toString();
	}
	
	// 비밀번호 재설정
	public String changePw(@Param("id")String id, @Param("pw")String changePw) {
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
	public String fineOne(String id) {
		return new SQL().SELECT("*")
				.FROM(MEMBER_TBL)
				.WHERE("id = #{id}")
				.toString();
	}
	
	// 계정 삭제(회원 탈퇴)	// ## 주의 : UPDATE 쿼리를 사용합니다
	public String deleteMember(String id) {
		return new SQL().UPDATE(MEMBER_TBL)
				.SET("del = 'y'")
				.WHERE("id = #{id}")
				.toString();
	}	
	
	// 회원 정보 수정 (이미지 수정도 이걸로 처리됩니다) // 본인 회원 수정, 스태프의 회원 수정
	public String updateMember(@Param("id")String targetId, @Param("member")Member member) {
		return new SQL().UPDATE(MEMBER_TBL)
				.SET("id = #{member.id}, pw = #{member.pw}, nickname = #{member.nickname}, name = #{member.name}, gender = #{member.gender}, birth = #{member.birth}, addr = #{member.addr}, img = #{member.img}")
				.WHERE("id = #{id}")
				.toString();
	}
	
	
	// 포인트 충전
	public String addPoint(@Param("id")String id, @Param("point")int point) {
		return new SQL().UPDATE(MEMBER_CARD_TBL)
				.SET("point = point + #{point}")
				.WHERE("member_id = #{id}")
				.toString();
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