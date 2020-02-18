package cn.appsys.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.appsys.pojo.backend_user;
import cn.appsys.pojo.dev_user;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		 if(request.getRequestURI().indexOf("login.do")>0){
			  return true;
		 }
		dev_user user=(dev_user)request.getSession().getAttribute("devUserSession");
		backend_user user2=(backend_user)request.getSession().getAttribute("userSession");
		 if(user!=null || user2!=null){
			 return true;
		 }
	response.sendRedirect(request.getContextPath()+"/index.jsp");
		return false;
	}

}
