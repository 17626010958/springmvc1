package cn.appsys.controller.app;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.appsys.dao.app_categoryMapper;
import cn.appsys.dao.app_infoMapper;
import cn.appsys.dao.app_versionMapper;
import cn.appsys.dao.data_dictionaryMapper;
import cn.appsys.pojo.app_info;
import cn.appsys.pojo.app_version;

@Controller
@RequestMapping("/dev")
public class devAppManager {

	@Autowired
	app_infoMapper mapper;
	@Autowired
	data_dictionaryMapper dmapper;

	@Autowired
	app_categoryMapper caMapper;

	@Autowired
	app_versionMapper vMapper;

	@RequestMapping("/page")
	public String page(
			@RequestParam(required = true, defaultValue = "1") Integer pageIndex,
			app_info app_info, HttpServletRequest request, HttpSession session) {
		app_info = (cn.appsys.pojo.app_info) session.getAttribute("asd");
		PageHelper.startPage(pageIndex, 5);
		List<app_info> list = mapper.findlist(app_info);
		PageInfo<app_info> pageInfo = new PageInfo<app_info>(list);
		request.setAttribute("page", pageInfo);
		request.setAttribute("appInfoList", list);
		session.setAttribute("flatFormList", dmapper.findpt("APP_FLATFORM"));
		session.setAttribute("statusList", dmapper.findpt("APP_STATUS"));
		session.setAttribute("categoryLevel1List", caMapper.yiji(null));
		return "jsp/developer/appinfolist";
	}

	@RequestMapping("/findlist")
	public String findlist(app_info app_info, HttpServletRequest request,
			HttpSession session) {
		session.setAttribute("asd", app_info);
		return page(1, app_info, request, session);
	}

	@RequestMapping("/yanz")
	@ResponseBody
	public String yanz(String APKName) {
		int i = mapper.findName(APKName);
		if (i > 0) {
			return "false";
		}
		return "true";
	}

	@RequestMapping("/add")
	public String add(MultipartFile logo, HttpSession session,
			HttpServletRequest request, app_info app_info) {
		String name = logo.getOriginalFilename();
		String path = session.getServletContext()
				.getRealPath("/statics/images");
		File a = new File(path, name);
		try {
			logo.transferTo(a);
			app_info.setLogoPicPath("/AppInfoSystem/statics/uploadfiles/"
					+ name);
			app_info.setLogoLocPath(path);
			int i = mapper.insertSelective(app_info);
			if (i > 0) {

			}
		} catch (Exception e) {
		}
		return page(1, app_info, request, session);
	}

	@RequestMapping("/findByIdUp")
	public String findByIdUp(Long id, HttpServletRequest request,
			HttpSession session) {
		app_info app_info = mapper.findById(id);
		request.setAttribute("appInfo", app_info);
		return "/jsp/developer/appinfomodify";
	}

	@RequestMapping("/dellogo")
	@ResponseBody
	public String dellogo(Long id, HttpServletRequest request,
			HttpSession session) {
		int i = mapper.dellogo(id);
		if (i > 0) {
			return "success";
		}
		return "failed";
	}

	@RequestMapping("/update")
	public String update(app_info app_info, HttpServletRequest request,
			HttpSession session) {
		int a = mapper.updateByPrimaryKeySelective(app_info);
		if (a > 0) {
		}
		return page(1, app_info, request, session);
	}

	@RequestMapping("/addver")
	public String addver(Long id, HttpServletRequest request) {
		request.setAttribute("appVersionList", mapper.findban(id));
		request.setAttribute("appid", id);
		return "/jsp/developer/appversionadd";
	}

	@RequestMapping("/addversion")
	public String addversion(MultipartFile logo, app_version app_version,
			HttpServletRequest request,
			@RequestParam(required = false) app_info app_info,
			HttpSession session) {
		String name = logo.getOriginalFilename();
		String path = session.getServletContext().getRealPath(
				"/statics/uploadfiles");
		File a = new File(path, name);
		try {
			logo.transferTo(a);
			app_version.setDownloadLink("/AppInfoSystem/statics/uploadfiles/"
					+ name);
			app_version.setApkLocPath(path);
			app_version.setApkFileName(name);
			int i = vMapper.insertSelective(app_version);
			if (i > 0) {
             int c=vMapper.updatebb(app_version);
             if(c>0){
         		return page(1, app_info, request, session);
             }
			}
		} catch (Exception e) {
		}
		return page(1, app_info, request, session);
	}

	@RequestMapping("/upverByid")
	public String upverByid(Long id, HttpServletRequest request) {
		request.setAttribute("appVersionList", mapper.findban(id));
		request.setAttribute("appid", id);
		request.setAttribute("appVersion", vMapper.findver(id));
		return "/jsp/developer/appversionmodify";
	}

	@RequestMapping("/save")
	public String save(MultipartFile logo, app_version app_version,
			HttpServletRequest request,
			HttpSession session) {
		String name = logo.getOriginalFilename();
		String path = session.getServletContext().getRealPath(
				"/statics/uploadfiles");
		app_version.setDownloadLink("/AppInfoSystem/statics/uploadfiles/"
				+ name);
		app_version.setApkLocPath(path);
		app_version.setApkFileName(name);
		int i = vMapper.updateByPrimaryKeySelective(app_version);
		if (i > 0) {
			
		}else{
	
		}
		File a = new File(path, name);
		try {
			logo.transferTo(a);
			
		} catch (Exception e) {
		}
		return page(1, null, request, session);
	}

	@RequestMapping("/delapk")
	@ResponseBody
	public String delapk(Long id) {
		int i = vMapper.updateapk(id);
		if (i > 0) {
			return "success";
		}
		return "failed";
	}

	@RequestMapping("/findkan")
	public String findkan(Long id, HttpServletRequest request) {
		request.setAttribute("appInfo", mapper.findById(id));
		request.setAttribute("appVersionList", mapper.findban(id));
		return "/jsp/developer/appinfoview";
	}

	@RequestMapping("/deleteapp")
	@ResponseBody
	public String deleteapp(Long id, HttpServletRequest request) {
		int a = vMapper.deleteByPrimaryKey(id);
		int i = mapper.deleteByPrimaryKey(id);
		if (a > 0 || i > 0) {
			return "true";
		}
		return "false";
	}
	
	@RequestMapping("/sxjia")
	@ResponseBody
	public String sxjia(Long id,Long status,HttpServletRequest request,
			HttpSession session) {
		int i=mapper.sxjia(id, status);
		if(i>0){
			return "true";
		}
		return "false";
	}
}
