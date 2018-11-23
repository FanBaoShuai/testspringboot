package com.fbs.auctionmvc.authinterceptor;

import com.fbs.auctionmvc.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author FanBS
 * 这是一个拦截器类
 * 作用：强制登录
 */
public class Authinterceptor implements HandlerInterceptor {

	/**
	 * 进入拦截器之后会进入到这个方法
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
								HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 在return之前进入到这个方法
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
						   Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 进入到拦截器之前会进入到这个方法
	 * 如果放行返回true如果不放行返回false
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
							 Object arg2) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = arg0.getSession();
		User user = (User)session.getAttribute("user");
		if(user!=null){
			return true;
		}else{
			//重定向到login.jsp中
			arg1.sendRedirect("login.jsp");
			return false;
		}
	}

}
