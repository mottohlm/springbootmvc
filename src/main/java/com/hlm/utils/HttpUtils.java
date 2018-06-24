package com.hlm.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HttpUtils {

	public static String doGet(String url ,Map<String ,String> paramMap){
			
		//校验URL
		if(url==null || url.trim().length() == 0){
			throw new RuntimeException("URL is null !");			
		}
		//组装参数
		if(paramMap != null){
			StringBuffer sb = new StringBuffer("");
			Set<Entry<String, String>> set = paramMap.entrySet();
			Iterator<Entry<String, String>> it = set.iterator();
			while(it.hasNext()){
				Entry<String, String> ehtry = it.next();
				sb.append(ehtry.getKey()+"="+ehtry.getValue()+"&");
			}
			if(sb.toString().length()>2){
				url = url+"?"+sb.toString().substring(0, sb.toString().length()-2);
			}			
		}
		BufferedReader br = null;
		InputStream is = null;	
		try {
			URL u = new URL(url);
			URLConnection uc = u.openConnection();
			//设置请求属性
			uc.setRequestProperty("accept", "*/*");
            uc.setRequestProperty("connection", "Keep-Alive");
            uc.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            
			uc.connect();
			is = uc.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			String str ;
			StringBuffer resultsb = new StringBuffer("");
			while((str = br.readLine())!= null){
				resultsb.append(str);
			}
			return resultsb.toString();
		} catch (MalformedURLException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
				try {
					br.close();
					is.close();	
				} catch (IOException e) {
					e.printStackTrace();
				}
						
		}
		return null;
		
	}
}
