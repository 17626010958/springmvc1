package cn.appsys.controller.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.appsys.dao.app_categoryMapper;
import cn.appsys.pojo.app_category;

@Controller
@RequestMapping("/fenlei")
public class categorymanager {
          
	@Autowired
    app_categoryMapper caMapper;
	
	@RequestMapping("/fenji")
	@ResponseBody
	public List<app_category> erji(Integer parentId){
		List<app_category> erji=caMapper.yiji(parentId);
		return erji;
	}
}
