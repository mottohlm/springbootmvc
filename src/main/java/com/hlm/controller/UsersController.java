package com.hlm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hlm.command.UsersCommand;

@Controller
public class UsersController {
	
	private Log log = LogFactory.getLog(UsersController.class);
	/**
	 * 保存用户登录信息
	 */
	public Map<String ,String> logonMap ;

	/**
	 * 用户登录	
	 * @param req
	 * @param mv
	 * @return
	 */
	@RequestMapping("/logon")                                                                
	public ModelAndView  logon(HttpServletRequest req ,HttpServletResponse resp ){ 
		ModelAndView mv = new ModelAndView();
		
		UsersCommand cmd = new UsersCommand("小明",0,"admin@hlm.com",1,"123456" );
		 mv.addObject("password", cmd.getPassword());
		 mv.addObject("userName", cmd.getUserName());
		 log.error("用户名为："+cmd.getUserName()+"密码为："+cmd.getPassword());
		 log.debug("我是DEBUG级别打印");
		 mv.setViewName("/login");
		 //设置Cookie 返回给浏览器保存
		 resp.addCookie(new Cookie("userName",cmd.getUserName()));
		 resp.addCookie(new Cookie("password",cmd.getPassword()));
		 
		 //后台保存对应的登录信息
		 if(logonMap==null){
			 logonMap = new HashMap<String ,String>();
		 }
		 //保存经过转换后的信息
		 logonMap.put(cmd.getUserName()+cmd.getPassword(), cmd.getPassword()+cmd.getUserName()+"123456789");
	   return mv;
	}
	
	/**
	 * 登录后其他操作
	 * @param req
	 * @param mv
	 * @return
	 */
	@RequestMapping("/welcome")                                                                
	public String   getOther(HttpServletRequest req ){ 
		
		 //从Cookie 中获取用户登录信息
		Cookie[] cookies =  req.getCookies();
		String userName ="";
		String password ="";
		if(cookies !=null && cookies.length>0){
			for(Cookie e : cookies){
				if("userName".equals(e.getName())){
					userName = e.getValue();
				}else if("password".equals(e.getName())){
					password = e.getValue();
				}			
			}
		}
		
		 //查询是否与后台保存的登录信息对应
		String token = logonMap.get(userName+password);
		if(token==null || token.trim().length()==0){
			log.error("用户未登录");
			throw new RuntimeErrorException(null, "用户未登录！");
		}
		if(!token.equals(password + userName + "123456789")){
			throw new RuntimeErrorException(null, "用户登录已失效！");
		}
		
	   return "welcome.html";
	}

	
}
