package com.lpp.spring.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lpp.spring.dao.Dao;


@Service
public class EmpService {
	// 自动将当前容器中的对象进行注入，不用再get、set
	/**
	 * 默认Resource使用属性名作为bean ID进行注入 或者指定name熟属性，按name进行加载
	 */
	@Resource(name="empDao")
	private Dao empdao;// 面向对象

	/*public Dao getEmpdao() {
		return empdao;
	}

	public void setEmpdao(Dao empdao) {
		this.empdao = empdao;
	}
*/
	public EmpService() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println(this + ": 正在创建");
	}

	public void entry() {
		System.out.println("入职方法：entry()" + empdao);
		empdao.create();
	}
}
