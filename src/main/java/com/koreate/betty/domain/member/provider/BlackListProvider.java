package com.koreate.betty.domain.member.provider;

import org.apache.ibatis.jdbc.SQL;
import static com.koreate.betty.domain.model.TableConst.*;

public class BlackListProvider {

	// 관리자가 블랙리스트에 회원을 추가
	public String blackMember(String id, String cause) {		
		return new SQL().INSERT_INTO(BLACK_LIST_TBL)
				.INTO_COLUMNS("member_id", "cause")
				.INTO_VALUES("#{id}, #{cause}")
				.toString();
	}
	
	// 관리자가 블랙리스트에서 회원을 삭제
	 
	///(점수 10점에 도달시 자동 등록)
}
