package com.spring.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	@Select("select NOW()")
	public String getTime();
	
	
	public String getTime2();
	
}
