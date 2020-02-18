package cn.appsys.controller.app;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.appsys.dao.app_categoryMapper;
import cn.appsys.dao.app_infoMapper;
import cn.appsys.dao.data_dictionaryMapper;
import cn.appsys.pojo.app_info;

@Controller
@RequestMapping("/app")
public class appmanager {

	@Autowired
	app_infoMapper mapper;

	@Autowired
	data_dictionaryMapper dmapper;

	@Autowired
	app_categoryMapper caMapper;

	@RequestMapping("/page")
	public String page(@RequestParam(required = true, defaultValue = "1") Integer pageIndex,
		app_info app_info, HttpServletRequest request, HttpSession session){
		app_info=(cn.appsys.pojo.app_info) session.getAttribute("asd");
		PageHelper.startPage(pageIndex, 5);
		List<app_info> list = mapper.findAppList(app_info);
		PageInfo<app_info> pageInfo = new PageInfo<app_info>(list);
		request.setAttribute("page", pageInfo);
		request.setAttribute("appInfoList", list);
		session.setAttribute("flatFormList", dmapper.findpt("APP_FLATFORM"));
		session.setAttribute("categoryLevel1List", caMapper.yiji(null));
		return "jsp/backend/applist";
	}
	@RequestMapping("/findlist")
	public String findlist(app_info app_info,HttpServletRequest request, HttpSession session){
	     session.setAttribute("asd",app_info);
		return page(1,app_info,request,session);
	}
	
	@RequestMapping("/findById")
	public String findById(Long id,HttpServletRequest request, HttpSession session){
	   request.setAttribute("appInfo", mapper.findById(id));
	   request.setAttribute("appVersion", mapper.findbanben(id));
		return "jsp/backend/appcheck";
	}
	
	@RequestMapping("/shenhe")
	public String shenhe(Long id,Long status,HttpServletRequest request, HttpSession session,app_info a){
	       int  i=mapper.shenhe(id,status);
	       if(i>0){
	    	 
	       }
		return page(1,a,request,session);
	}
}
