package com.koreate.betty.domain.temp.repo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.koreate.betty.domain.temp.Temp;

@Mapper
public interface TempRepository {
	
	@Insert("INSERT INTO test_tbl(i_d,p_w) VALUES(#{iD},#{pW})")
	int insert(Temp temp);
	

}
