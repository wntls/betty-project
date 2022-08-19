package com.koreate.betty.domain.member.provider;

import static com.koreate.betty.domain.model.TableConst.*;

import org.apache.ibatis.jdbc.SQL;

import com.koreate.betty.domain.member.vo.Member;

public class MemberProvider {

	// 멤버 테이블의 CRUD를 전담

	// 회원가입
	public String register(Member member) {
		return new SQL().INSERT_INTO(MEMBER_TBL)
				.INTO_COLUMNS("id", "pw", "nickname", "name", "gender", "birth", "phone", "addr", "email")
				.INTO_VALUES("#{id}, #{pw}, #{nickname}, #{name}, #{gender}, #{birth}, #{phone}, #{addr}, #{email}")
				.toString();		
	}
	
	// 로그인
	public String login(String id, String pw) {
		return new SQL().SELECT("*")
				.FROM(MEMBER_TBL)
				.WHERE("id = #{id}")
				.toString();
	}
	
	// 아이디 찾기
	public String findId(String email) {
		return new SQL().SELECT("*")
				.FROM(MEMBER_TBL)
				.WHERE("email = #{email}")
				.toString();
	}
	
	// 비밀번호 재설정
	public String changePw(String id, String changePw) {
		return new SQL().UPDATE(MEMBER_TBL)
				.SET("pw = #{pw}")
				.WHERE("id = #{id}")
				.toString();
	}
	
	
	// 비밀번호 재설정 버튼 클릭 시 -> 사용자에게 아이디를 받음 (입력)
	// 아이디를 통해 이메일을 찾아서(findEmail) 코드를 전송하고 사용자의 코드 입력이 올바르면 
	// 위의 비밀번호 재설정을(changePw) 호출하여 비밀번호 변경
	
	
	// 아이디에 등록된 이메일 검색(비밀번호 찾기 용도로 검색정보(이메일)를 사용자에게 출력하지 않고 이메일로 인증을 받음)
	public String findEmail(String id) {
		return new SQL().SELECT("email")
				.FROM(MEMBER_TBL)
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
		
	// 프로필 이미지 업데이트
	public String changeImg(String id, String img) {
		return new SQL().UPDATE(MEMBER_TBL)
				.SET("img = #{img}")
				.WHERE("id = #{id}")
				.toString();
	}
	
	// 계정 삭제(회원 탈퇴)
	public String deleteMember(String id) {
		return new SQL().DELETE_FROM(MEMBER_TBL)
				.WHERE("id = #{id}")
				.toString();
	}
	
}
