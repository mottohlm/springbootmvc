package com.hlm.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/connection") 
public class ConnectionController {
	

	/**
	 * 用户登录	
	 * @param req
	 * @param mv
	 * @return
	 * @throws URISyntaxException 
	 */
	@RequestMapping("/sendGet")                                                                
	public ResponseEntity<String>  sendGet(HttpServletRequest req ,HttpServletResponse resp ) throws URISyntaxException{
		String url = "https://blog.csdn.net/mottohlm/article/details/80672676";
		//String response = HttpUtils.doGet("https://www.hao123.com/", null);		
		//String response = HttpUtils.doGet(url, null);
		//System.out.println(response);
		String uc = UriComponentsBuilder.fromHttpUrl(url).build().toString();
		URI uri = new URI(uc);
		HttpHeaders hh = new HttpHeaders();
		hh.setLocation(uri);
		System.out.println(new ResponseEntity<String>(hh, HttpStatus.OK));
		return  new ResponseEntity<String>(hh, HttpStatus.OK) ;		
	}
	
	
}
