package com.lpp.spring.dao;

import org.springframework.stereotype.Repository;

@Repository
public class EmpExDao implements Dao{
	public void create() {
		System.out.println(this +  "EmpDaoµÄÉý¼¶Àà");
	}
}
